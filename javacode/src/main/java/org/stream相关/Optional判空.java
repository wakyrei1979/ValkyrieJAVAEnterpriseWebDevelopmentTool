package org.stream相关;

import java.math.BigDecimal;
import java.util.Optional;

public class Optional判空 {

    public static void main(String[] args) {
        BigDecimal i = BigDecimal.TEN;
        BigDecimal bigDecimal = Optional.ofNullable(i).orElse(BigDecimal.ZERO);
    }

}
