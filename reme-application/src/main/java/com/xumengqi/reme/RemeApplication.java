package com.xumengqi.reme;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 服务启动类
 * @author xumengqi
 */
@SpringBootApplication
public class RemeApplication {
    private static final Logger log = Logger.getLogger(RemeApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RemeApplication.class, args);
        log.info("********************************* Server Started *********************************");
    }

}
