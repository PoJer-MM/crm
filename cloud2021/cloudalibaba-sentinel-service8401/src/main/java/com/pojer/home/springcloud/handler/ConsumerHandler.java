package com.pojer.home.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.pojer.home.springcloud.entities.CommonResult;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: pojer
 * @Date: 2021/04/28/下午 7:24
 * @Description:
 */
public class ConsumerHandler {

    public static CommonResult ExceptionHandler1(BlockException exception){
        return new CommonResult(444, "handler1发起报错提示，服务不可用！ExceptionHandler1");
    }


    public static CommonResult ExceptionHandler2(BlockException exception){
        return new CommonResult(444, "handler2发起报错提示，服务不可用！ExceptionHandler2");
    }

}
