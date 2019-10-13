package com.sdjtu.platform.service.mapper;

import com.sdjtu.platform.mapper.EntityMapper;
import com.sdjtu.platform.domain.LocalStorage;
import com.sdjtu.platform.service.dto.LocalStorageDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * <p>
 * comment:
 * </p>
 *
 * @author: ytuan
 * @Date 2019-10-12 14:27
 */
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LocalStorageMapper extends EntityMapper<LocalStorageDTO, LocalStorage> {

}