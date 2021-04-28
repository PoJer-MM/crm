package com.pojer.home.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: pojer
 * @Date: 2021/04/26/下午 9:00
 * @Description:
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "**********testA";
    }


    @GetMapping("/testB")
    public String testB(){
        return "**********testB";
    }

}
