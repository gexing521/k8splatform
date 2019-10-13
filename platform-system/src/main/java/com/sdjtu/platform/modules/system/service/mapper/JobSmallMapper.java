package com.sdjtu.platform.modules.system.service.mapper;

import com.sdjtu.platform.mapper.EntityMapper;
import com.sdjtu.platform.modules.system.domain.Job;
import com.sdjtu.platform.modules.system.service.dto.JobSmallDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 *
 * @Author: ytuan
 * @Date: 2019-10-12  15:33
 */
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JobSmallMapper extends EntityMapper<JobSmallDTO, Job> {

}