package com.pojer.home.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: pojer
 * @Date: 2021/04/24/下午 4:40
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderMain83 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain83.class);
    }
}
