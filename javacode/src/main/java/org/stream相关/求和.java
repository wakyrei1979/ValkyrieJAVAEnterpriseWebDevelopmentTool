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
//        Integer sum = scores.stream().reduce(Integer::sum).orElse(0);
//        Long sum = scores.stream().reduce(Long::sum).orElse(0L);
//        Double sum = scores.stream().reduce(Double::sum).orElse(0.00);
//        BigDecimal sum = scores.stream().reduce(BigDecimal::add).orElse(new BigDecimal(0.00));
    }
}
