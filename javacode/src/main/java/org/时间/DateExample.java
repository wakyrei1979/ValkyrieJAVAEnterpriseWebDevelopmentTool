package org.时间;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExample {

    public static void main(String[] args) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            // 将字符串转化为日期
            Date date = sdf.parse("2000-11-11 11:11:11");
            System.out.println(date);

            Date date1 = new Date();
            // 将日期转化为字符串
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String str = sdf1.format(date1);
            System.out.println(str);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
