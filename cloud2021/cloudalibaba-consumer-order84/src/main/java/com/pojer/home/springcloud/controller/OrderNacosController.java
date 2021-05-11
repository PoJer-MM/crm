package com.pojer.home.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: pojer
 * @Date: 2021/04/24/下午 4:46
 * @Description:
 */
@RestController
@Slf4j
public class OrderNacosController {

    @Value("${service-url.nacos-user-service}")
    private String nacosServerURL;

    @Resource
    private RestTemplate restTemplate;








    @GetMapping("consumer/paymentSQL/{id}")
    public String paymentInfo(@PathVariable("id")Integer id){
        return restTemplate.getForObject(nacosServerURL + "/paymentSQL/" + id, String.class);
    }
}
