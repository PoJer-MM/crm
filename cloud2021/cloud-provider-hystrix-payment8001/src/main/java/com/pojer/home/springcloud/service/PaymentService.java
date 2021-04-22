package com.pojer.home.springcloud.service;

import ch.qos.logback.core.boolex.EvaluationException;
import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.aspectj.weaver.tools.AbstractTrace;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id){
        int TimeNumber = 3;
//        int age = 10/0;
        try {
            TimeUnit.SECONDS.sleep(TimeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：  " + Thread.currentThread().getName() + "  paymentInfo_TimeOut,id:   " + id + "\t" + "干他大巴！"+"  耗时（s）："+TimeNumber;
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池：  " + Thread.currentThread().getName() + "  8001系统繁忙,id:   " + id + "\t" + "(灬ꈍ ꈍ灬)";
    }

    //=================服务熔断CircuitBreaker
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间范围
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到多少后跳闸
    })
    public String CircuitBreaker(@PathVariable("id") Integer id){

        if (id<0){
            throw new RuntimeException("id 不能为负数！");
        }
        String serialNumber = IdUtil.fastSimpleUUID();

        return Thread.currentThread().getName() + "\t" + "调用成功；流水号：" + serialNumber;

    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能为负数，请稍后重试，、、ε=(´ο｀*)))唉   ----id:" + id;
    }

}
