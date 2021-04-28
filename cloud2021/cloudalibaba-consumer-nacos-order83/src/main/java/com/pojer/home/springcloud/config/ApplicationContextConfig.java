package com.pojer.home.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: pojer
 * @Date: 2021/04/24/下午 4:45
 * @Description:
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTeplate(){
        return new RestTemplate();
    }

}
