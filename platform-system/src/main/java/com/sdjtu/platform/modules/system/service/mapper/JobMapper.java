package com.sdjtu.platform.modules.system.service.mapper;

import com.sdjtu.platform.mapper.EntityMapper;
import com.sdjtu.platform.modules.system.domain.Job;
import com.sdjtu.platform.modules.system.service.dto.JobDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

/**
 * @Author: ytuan
 * @Date: 2019-10-12  15:33
 */
@Mapper(componentModel = "spring", uses = {DeptMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JobMapper extends EntityMapper<JobDTO, Job> {

    @Mapping(source = "deptSuperiorName", target = "deptSuperiorName")
    JobDTO toDto(Job job, String deptSuperiorName);
}