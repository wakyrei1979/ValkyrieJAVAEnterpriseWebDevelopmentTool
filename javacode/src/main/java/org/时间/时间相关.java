package org.时间;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

public class 时间相关 {

    public static void main(String[] args) {
//        Date d = new Date();
//        System.out.println("Date:" + d);//Tue Sep 06 10:46:02 CST 2022
//        System.out.println("Date秒:" + d.getTime() / 1000);//1662432362
//        //获得系统时区的时间
//        LocalDateTime localDateTime = LocalDateTime.now();
//        System.out.println("LocalDateTime:"+localDateTime);//2022-09-06T10:46:02.739
//        //获得中时区的时间
//        Instant instant = Instant.now();
//        System.out.println("中时区:"+instant);//2022-09-06T02:46:02.740Z
//        //获取秒数 如果localDateTime是UTC时区的情况下
//        long l = localDateTime.toEpochSecond(ZoneOffset.UTC);
//        System.out.println("中时区秒"+l);//1662461162
//        //获取秒数 如果localDateTime是+8时区的情况下
//        Long second = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
//        System.out.println("+8H秒"+second);//1662432362
//        //获取秒数 如果localDateTime是+8时区的情况下
//        Long milliSecond = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
//        System.out.println("+8H毫秒"+milliSecond);//1662432362778

        //主要区别 date带时区，LocalDateTime不带时区
        Date d = new Date();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("            Date：" + d);//Tue Sep 06 10:46:02 CST 2022        CST时区
        System.out.println("   LocalDateTime："+localDateTime);//2022-09-06T10:46:02.739   T是分隔符

        System.out.println("         Date毫秒：" + d.getTime());//1662434270524
        System.out.println("localDateTime毫秒：" + LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());//1662434270524

        //其它有用没有的函数
        Instant instant = Instant.now();
        System.out.println("中时区:"+instant);//2022-09-06T02:46:02.740Z
        long l = localDateTime.toEpochSecond(ZoneOffset.UTC);
        System.out.println("中时区秒"+l);//1662461162
        Long second = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        System.out.println("+8H秒"+second);//1662432362
        Long milliSecond = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println("+8H毫秒"+milliSecond);//1662432362778
        //门特使用的
        //获取当天的最小时间
        LocalDateTime min = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        //to Date
        Date date = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
    }
}
