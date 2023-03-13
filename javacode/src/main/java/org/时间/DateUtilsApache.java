package org.时间;

import java.util.Date;
import org.apache.commons.lang3.time.DateUtils;

public class DateUtilsApache {

    public static void main(String[] args) {
        //前一天时间
        DateUtils.addDays(new Date(), -1);
    }
}
