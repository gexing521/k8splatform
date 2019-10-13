package com.sdjtu.platform.modules.system.service.mapper;

import com.sdjtu.platform.mapper.EntityMapper;
import com.sdjtu.platform.modules.system.domain.User;
import com.sdjtu.platform.modules.system.service.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

/**
 * @Author: ytuan
 * @Date: 2019-10-12  15:35
 */
@Mapper(componentModel = "spring", uses = {RoleMapper.class, DeptMapper.class, JobMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends EntityMapper<UserDTO, User> {

    @Mapping(source = "user.userAvatar.realName", target = "avatar")
    UserDTO toDto(User user);
}
