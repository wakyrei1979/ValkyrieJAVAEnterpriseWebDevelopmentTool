package org.时间;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import java.util.Date;
import org.apache.commons.lang3.time.DateUtils;

public class HutoolTime {

    public static void main(String[] args) {
        //昨天的开始时间
        System.out.println(DateUtil.beginOfDay(DateUtil.yesterday()));
        //字符串
        System.out.println(DateUtil.date().toString("yyyy-MM-dd HH:mm:ss"));
        //sql查询
        System.out.println(DateUtil.date().toSqlDate());
        //获得前一天年月
        Date date = DateUtils.addDays(new Date(), -1);
        DateUtil.year(date);
        DateUtil.month(date);
    }
}
