package com.sdjtu.platform.modules.system.service.impl;

import com.sdjtu.platform.exception.handler.BadRequestException;
import com.sdjtu.platform.exception.handler.EntityExistException;
import com.sdjtu.platform.utils.QueryHelp;
import com.sdjtu.platform.utils.ValidationUtil;
import com.sdjtu.platform.modules.system.domain.Permission;
import com.sdjtu.platform.modules.system.repository.PermissionRepository;
import com.sdjtu.platform.modules.system.service.PermissionService;
import com.sdjtu.platform.modules.system.service.RoleService;
import com.sdjtu.platform.modules.system.service.dto.PermissionDTO;
import com.sdjtu.platform.modules.system.service.dto.PermissionQueryCriteria;
import com.sdjtu.platform.modules.system.service.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 *
 * @Author: ytuan
 * @Date: 2019-10-12  15:53
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private RoleService roleService;

    @Override
    public List<PermissionDTO> queryAll(PermissionQueryCriteria criteria) {
        return permissionMapper.toDto(permissionRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public PermissionDTO findById(long id) {
        Optional<Permission> permission = permissionRepository.findById(id);
        ValidationUtil.isNull(permission,"Permission","id",id);
        return permissionMapper.toDto(permission.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PermissionDTO create(Permission resources) {
        if(permissionRepository.findByName(resources.getName()) != null){
            throw new EntityExistException(Permission.class,"name",resources.getName());
        }
        return permissionMapper.toDto(permissionRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Permission resources) {
        Optional<Permission> optionalPermission = permissionRepository.findById(resources.getId());
        if(resources.getId().equals(resources.getPid())) {
            throw new BadRequestException("上级不能为自己");
        }
        ValidationUtil.isNull(optionalPermission,"Permission","id",resources.getId());

        Permission permission = optionalPermission.get();

        Permission permission1 = permissionRepository.findByName(resources.getName());

        if(permission1 != null && !permission1.getId().equals(permission.getId())){
            throw new EntityExistException(Permission.class,"name",resources.getName());
        }

        permission.setName(resources.getName());
        permission.setAlias(resources.getAlias());
        permission.setPid(resources.getPid());
        permissionRepository.save(permission);
    }

    @Override
    public Set<Permission> getDeletePermission(List<Permission> permissions, Set<Permission> permissionSet) {
        // 递归找出待删除的菜单
        for (Permission permission : permissions) {
            permissionSet.add(permission);
            List<Permission> permissionList = permissionRepository.findByPid(permission.getId());
            if(permissionList!=null && permissionList.size()!=0){
                getDeletePermission(permissionList, permissionSet);
            }
        }
        return permissionSet;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Set<Permission> permissions) {
        for (Permission permission : permissions) {
            roleService.untiedPermission(permission.getId());
            permissionRepository.delete(permission);
        }
    }

    @Override
    public Object getPermissionTree(List<Permission> permissions) {
        List<Map<String,Object>> list = new LinkedList<>();
        permissions.forEach(permission -> {
                    if (permission!=null){
                        List<Permission> permissionList = permissionRepository.findByPid(permission.getId());
                        Map<String,Object> map = new HashMap<>();
                        map.put("id",permission.getId());
                        map.put("label",permission.getAlias());
                        if(permissionList!=null && permissionList.size()!=0){
                            map.put("children",getPermissionTree(permissionList));
                        }
                        list.add(map);
                    }
                }
        );
        return list;
    }

    @Override
    public List<Permission> findByPid(long pid) {
        return permissionRepository.findByPid(pid);
    }

    @Override
    public Object buildTree(List<PermissionDTO> permissionDTOS) {

        List<PermissionDTO> trees = new ArrayList<PermissionDTO>();

        for (PermissionDTO permissionDTO : permissionDTOS) {

            if ("0".equals(permissionDTO.getPid().toString())) {
                trees.add(permissionDTO);
            }

            for (PermissionDTO it : permissionDTOS) {
                if (it.getPid().equals(permissionDTO.getId())) {
                    if (permissionDTO.getChildren() == null) {
                        permissionDTO.setChildren(new ArrayList<PermissionDTO>());
                    }
                    permissionDTO.getChildren().add(it);
                }
            }
        }

        Integer totalElements = permissionDTOS!=null?permissionDTOS.size():0;

        Map map = new HashMap();
        map.put("content",trees.size() == 0?permissionDTOS:trees);
        map.put("totalElements",totalElements);
        return map;
    }
}
