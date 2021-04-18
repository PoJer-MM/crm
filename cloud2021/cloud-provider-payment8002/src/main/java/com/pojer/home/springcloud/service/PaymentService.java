package com.pojer.home.springcloud.service;

import com.pojer.home.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: pojer
 * @Date: 2021/04/14/下午 9:46
 * @Description:
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);


}
