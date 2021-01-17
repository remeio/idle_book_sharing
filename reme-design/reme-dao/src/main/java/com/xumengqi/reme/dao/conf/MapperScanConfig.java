package com.xumengqi.reme.dao.conf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

/**
 * @author xumengqi
 * @date 2021/1/17 14:39
 */
@Component
@MapperScan("com.xumengqi.reme.dao.mapper")
public class MapperScanConfig {
}
