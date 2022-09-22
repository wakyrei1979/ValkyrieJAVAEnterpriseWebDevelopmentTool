package org.时间;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

public class HutoolTime {

    public static void main(String[] args) {
        //昨天的开始时间
        System.out.println(DateUtil.beginOfDay(DateUtil.yesterday()));
        //字符串
        System.out.println(DateUtil.date().toString("yyyy-MM-dd HH:mm:ss"));
        //sql查询
        System.out.println(DateUtil.date().toSqlDate());

    }
}
