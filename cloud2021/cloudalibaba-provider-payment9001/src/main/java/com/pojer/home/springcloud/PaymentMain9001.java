package com.pojer.home.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: pojer
 * @Date: 2021/04/24/下午 4:19
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain9001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain9001.class);
    }
}
