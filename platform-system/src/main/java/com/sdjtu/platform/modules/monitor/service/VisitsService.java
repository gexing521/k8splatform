package com.sdjtu.platform.modules.monitor.service;

import org.springframework.scheduling.annotation.Async;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @Author: ytuan
 * @Date: 2019-10-12  19:24
 */
public interface VisitsService {

    /**
     * 提供给定时任务，每天0点执行
     */
    void save();

    /**
     * 新增记录
     * @param request
     */
    @Async
    void count(HttpServletRequest request);

    /**
     * 获取数据
     * @return
     */
    Object get();

    /**
     * getChartData
     * @return
     */
    Object getChartData();
}
