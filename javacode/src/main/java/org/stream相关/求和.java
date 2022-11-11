package org.stream相关;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class 求和 {

    public static void main(String[] args) {
        List<BigDecimal> nums = Arrays.asList(new BigDecimal("1"));
        BigDecimal unitPre = nums
                .stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
