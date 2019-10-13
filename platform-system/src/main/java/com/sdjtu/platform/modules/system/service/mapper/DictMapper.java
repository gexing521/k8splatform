package com.sdjtu.platform.modules.system.service.mapper;

import com.sdjtu.platform.mapper.EntityMapper;
import com.sdjtu.platform.modules.system.domain.Dict;
import com.sdjtu.platform.modules.system.service.dto.DictDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @Author: ytuan
 * @Date: 2019-10-12  15:32
 */
@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictMapper extends EntityMapper<DictDTO, Dict> {

}