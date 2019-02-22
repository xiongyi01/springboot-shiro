package com.lx.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @ClassName DruidConfig
 * @Description TODO
 * @Author xiongyi
 * @Date 2019/2/21 13:03
 */
@Configuration
public class DruidConfig {

    /**
     *
     * @return
     */
    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource druid(){
        return new DruidDataSource();
    }

}
