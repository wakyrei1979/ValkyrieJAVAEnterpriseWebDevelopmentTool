package org.时间;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

public class 时间相关 {

    public static void main(String[] args) {
        Date d = new Date();
        System.out.println("Date:" + d);//Wed Aug 26 10:04:38 NOVT 2020
        System.out.println("Date秒:" + d.getTime() / 1000);//1598411078
        //获得系统时区的时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("LocalDateTime:"+localDateTime);//2020-08-26T10:04:38.752
        //获得中时区的时间
        Instant instant = Instant.now();
        System.out.println("中时区:"+instant);//2020-08-26T03:04:38.753Z
        //获取秒数 如果localDateTime是UTC时区的情况下
        long l = localDateTime.toEpochSecond(ZoneOffset.UTC);
        System.out.println("中时区秒"+l);//1598436278
        //获取秒数 如果localDateTime是+8时区的情况下
        Long second = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        System.out.println(second);
        //获取秒数 如果localDateTime是+8时区的情况下
        Long milliSecond = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println(milliSecond);
    }
}
