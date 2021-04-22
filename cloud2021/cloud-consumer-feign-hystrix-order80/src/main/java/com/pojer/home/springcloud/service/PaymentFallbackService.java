package com.pojer.home.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: pojer
 * @Date: 2021/04/22/下午 8:13
 * @Description:
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {


    @Override
    public String paymentInfo_OK(Integer id) {
        return "************PaymentFallbackService hahahha  ε=(´ο｀*)))唉";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "************PaymentFallbackService hahahha  ε=(´ο｀*)))唉";
    }
}
