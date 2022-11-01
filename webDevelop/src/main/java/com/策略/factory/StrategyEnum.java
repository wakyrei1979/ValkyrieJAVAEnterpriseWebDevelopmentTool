package com.策略.factory;

import com.策略.IStrategy;
import com.策略.imp.AStrategy;
import java.util.Arrays;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StrategyEnum {
    BUSINESS_EXPENSES(AStrategy.class);
    private final Class<? extends IStrategy> strategyClass;

    public static StrategyEnum getImportDataTypeEnum(Class<? extends IStrategy> aClass) {
        return Arrays.stream(StrategyEnum.values()).filter(s -> Objects.equals(s.getStrategyClass(), aClass))
                .findFirst().orElse(null);
    }
}
