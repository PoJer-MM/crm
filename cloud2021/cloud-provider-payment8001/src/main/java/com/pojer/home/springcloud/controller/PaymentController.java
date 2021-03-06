package com.pojer.home.springcloud.controller;

import com.pojer.home.springcloud.entities.CommonResult;
import com.pojer.home.springcloud.entities.Payment;
import com.pojer.home.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: pojer
 * @Date: 2021/04/14/下午 9:50
 * @Description:
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    private Logger log = LoggerFactory.getLogger(PaymentController.class);

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("******插入结果："+result);

        if (result>0){
            return new CommonResult(200,"插入数据成功,serverPort:"+serverPort);
        }else {
            return new CommonResult(400, "插入失败");
        }
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment result = paymentService.getPaymentById(id);
        log.info("******查询结果："+result);

        if (result != null){
            return new CommonResult(200,"查询数据成功，ServerPort："+serverPort,result);
        }else {
            return new CommonResult(400, "查询失败,查询Id:"+id);
        }
    }

    @GetMapping("/lb")
    public String getServerPort(){
        return serverPort;
    }

    @GetMapping("/feign/timeout")
    public String getFeignTimeOut(){
        //暂停几秒线程
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
