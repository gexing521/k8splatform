package com.sdjtu.platform.modules.system.rest;

import com.sdjtu.platform.exception.handler.BadRequestException;
import com.sdjtu.platform.utils.ThrowableUtil;
import com.sdjtu.platform.aop.log.Log;
import com.sdjtu.platform.config.DataScope;
import com.sdjtu.platform.modules.system.domain.Job;
import com.sdjtu.platform.modules.system.service.JobService;
import com.sdjtu.platform.modules.system.service.dto.JobQueryCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: ytuan
 * @Date: 2019-10-12  19:36
 */
@RestController
@RequestMapping("api")
public class JobController {

    @Autowired
    private JobService jobService;

    @Autowired
    private DataScope dataScope;

    private static final String ENTITY_NAME = "job";

    @Log("查询岗位")
    @GetMapping(value = "/job")
    @PreAuthorize("hasAnyRole('ADMIN','USERJOB_ALL','USERJOB_SELECT','USER_ALL','USER_SELECT')")
    public ResponseEntity getJobs(JobQueryCriteria criteria,
                                  Pageable pageable) {
        // 数据权限
        criteria.setDeptIds(dataScope.getDeptIds());
        return new ResponseEntity(jobService.queryAll(criteria, pageable), HttpStatus.OK);
    }

    @Log("新增岗位")
    @PostMapping(value = "/job")
    @PreAuthorize("hasAnyRole('ADMIN','USERJOB_ALL','USERJOB_CREATE')")
    public ResponseEntity create(@Validated @RequestBody Job resources) {
        if (resources.getId() != null) {
            throw new BadRequestException("A new " + ENTITY_NAME + " cannot already have an ID");
        }
        return new ResponseEntity(jobService.create(resources), HttpStatus.CREATED);
    }

    @Log("修改岗位")
    @PutMapping(value = "/job")
    @PreAuthorize("hasAnyRole('ADMIN','USERJOB_ALL','USERJOB_EDIT')")
    public ResponseEntity update(@Validated(Job.Update.class) @RequestBody Job resources) {
        jobService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除岗位")
    @DeleteMapping(value = "/job/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USERJOB_ALL','USERJOB_DELETE')")
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            jobService.delete(id);
        } catch (Throwable e) {
            ThrowableUtil.throwForeignKeyException(e, "该岗位存在用户关联，请取消关联后再试");
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}