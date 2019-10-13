package com.sdjtu.platform;

import com.sdjtu.platform.utils.SpringContextHolder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author: ytuan
 * @Date: 2019-10-12  19:44
 */
@EnableAsync
@SpringBootApplication
@EnableTransactionManagement
public class PlatformSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlatformSystemApplication.class, args);
    }

    @Bean
    public SpringContextHolder springContextHolder() {
        return new SpringContextHolder();
    }

}
