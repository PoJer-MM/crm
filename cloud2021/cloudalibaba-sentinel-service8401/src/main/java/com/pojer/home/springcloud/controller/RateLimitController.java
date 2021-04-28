package com.pojer.home.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.pojer.home.springcloud.entities.CommonResult;
import com.pojer.home.springcloud.entities.Payment;
import com.pojer.home.springcloud.handler.ConsumerHandler;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: pojer
 * @Date: 2021/04/28/下午 6:56
 * @Description:
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource(){
        return new CommonResult(200, "按资源名限流测试", new Payment(2020L, "serial001"));
    }

    public CommonResult handleException(BlockException exception) {
        return new CommonResult(444, exception.getClass().getCanonicalName() + "\t 服务不可以用");
    }

    @GetMapping("/byDefault")
    @SentinelResource(value = "byDefault")
    public CommonResult byDefault(){
        return new CommonResult(200, "按资源名限流测试", new Payment(2020L, "默认sentinel自己拦截"));
    }

    @GetMapping("byMine")
    @SentinelResource(value = "byMine",blockHandlerClass = ConsumerHandler.class,blockHandler = "ExceptionHandler2")
    public CommonResult byMine(){
        return new CommonResult(200, "按自定义测试", new Payment(2020L, "DIY test"));
    }

}
