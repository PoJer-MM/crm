package com.pojer.home.springcloud.entities.com.pojer.home.springcloud.defaultUtils;

import java.time.ZonedDateTime;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: pojer
 * @Date: 2021/04/24/上午 8:05
 * @Description:
 */
public class TimeUtils {

    //获取默认时区当前时间
    public static void main(String[] args) {
        ZonedDateTime zbj = ZonedDateTime.now();//默认时区
        System.out.println(zbj);
    }


}
