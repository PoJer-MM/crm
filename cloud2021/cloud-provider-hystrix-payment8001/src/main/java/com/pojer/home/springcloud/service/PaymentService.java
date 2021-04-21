package com.pojer.home.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: pojer
 * @Date: 2021/04/21/下午 8:34
 * @Description:
 */
@Service
public class PaymentService {

    //正常方法
    public String paymentInfo_OK(Integer id){
        return "线程池：  " + Thread.currentThread().getName() + "  paymentInfo_OK,id:   " + id + "\t" + "O(∩_∩)O哈哈~";
    }

    //异常方法，报错
    public String paymentInfo_TimeOut(Integer id){
        int TimeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(TimeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：  " + Thread.currentThread().getName() + "  paymentInfo_TimeOut,id:   " + id + "\t" + "干他大巴！"+"  耗时（s）："+TimeNumber;
    }

}
