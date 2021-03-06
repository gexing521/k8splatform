package com.sdjtu.platform.modules.quartz.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 测试使用
 *
 * @Author: ytuan
 * @Date: 2019-10-12  19:19
 */
@Slf4j
@Component
public class TestTask {

    public void run() {
        log.info("执行成功");
    }

    public void run1(String str) {
        log.info("执行成功，参数为： {}" + str);
    }
}
