package com.pojer.home.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
* @Author: pojer
* @Date: 2021/4/14 0014
*/

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8002 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002.class);
    }
}
