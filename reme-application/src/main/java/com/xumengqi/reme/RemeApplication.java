package com.xumengqi.reme;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 服务启动类
 * @author xumengqi
 */
@EnableSwagger2
@SpringBootApplication
public class RemeApplication {
    private static final Logger log = Logger.getLogger(RemeApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RemeApplication.class, args);
        log.info("Service started successfully");
    }

}
