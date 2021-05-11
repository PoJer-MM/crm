package com.pojer.home.springcloud.controller;

import com.pojer.home.springcloud.entities.CommonResult;
import com.pojer.home.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: pojer
 * @Date: 2021/04/28/下午 7:49
 * @Description:
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();
    static {
        hashMap.put(1L, new Payment(1L, "wqejoqweoi12o312312kl3o211111"));
        hashMap.put(2L, new Payment(2L, "wqejoqweoi12o312312kl3o222222"));
        hashMap.put(3L, new Payment(3L, "wqejoqweoi12o312312kl3o233333"));
    }

    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        Payment payment = hashMap.get(id);
        CommonResult<Payment> result = new CommonResult<>(200, "from mysql,serverPort:" + serverPort, payment);
        return result;

    }


}
