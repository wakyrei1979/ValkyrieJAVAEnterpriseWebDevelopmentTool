package org.时间;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalCalendar {

    public static void main(String[] args) {
//上个月第一天
        Calendar calBegin = Calendar.getInstance();
        calBegin.add(Calendar.MONTH, -1);
        calBegin.set(Calendar.DATE, 1);
        calBegin.set(Calendar.HOUR_OF_DAY, 0);
        calBegin.set(Calendar.MINUTE, 0);
        calBegin.set(Calendar.SECOND, 0);
        System.out.println(calBegin.getTime());
//上个月最后一天
        Calendar calEnd = Calendar.getInstance();
        calEnd.add(Calendar.MONTH, -1);
        calEnd.set(Calendar.DATE, calEnd.getActualMaximum(Calendar.DATE));
        calEnd.set(Calendar.HOUR_OF_DAY, 23);
        calEnd.set(Calendar.MINUTE, 59);
        calEnd.set(Calendar.SECOND, 59);
        System.out.println(calEnd.getTime());

//获取某年最后一天
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, 2020);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        System.out.println(calendar.getTime());
    }
}
