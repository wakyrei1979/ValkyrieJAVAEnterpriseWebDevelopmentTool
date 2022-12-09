package org;

import java.math.BigDecimal;

public class BigBigDecimal {

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("-1000");
        BigDecimal negate = bigDecimal.negate();
        System.out.println(negate);
    }
}
