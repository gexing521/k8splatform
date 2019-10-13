package com.sdjtu.platform.modules.quartz.task;

import com.sdjtu.platform.modules.monitor.service.VisitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @Author: ytuan
 * @Date: 2019-10-12  19:19
 */
@Component
public class VisitsTask {

    @Autowired
    private VisitsService visitsService;

    public void run(){
        visitsService.save();
    }
}
