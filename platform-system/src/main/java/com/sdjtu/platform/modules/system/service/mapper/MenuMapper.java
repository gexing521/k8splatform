package com.sdjtu.platform.modules.system.service.mapper;

import com.sdjtu.platform.mapper.EntityMapper;
import com.sdjtu.platform.modules.system.domain.Menu;
import com.sdjtu.platform.modules.system.service.dto.MenuDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 *
 * @Author: ytuan
 * @Date: 2019-10-12  15:34
 */
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MenuMapper extends EntityMapper<MenuDTO, Menu> {

}
