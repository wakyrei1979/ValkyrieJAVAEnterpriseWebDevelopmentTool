package com.策略.confirmData;

import com.策略.confirmData.imp.BusinessExpensesConfirmDataStrategy;
import java.util.Arrays;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DataTypeStrategyEnum {
    BUSINESS_EXPENSES(RebateImportDataTypeEnum.BUSINESS_EXPENSES, BusinessExpensesConfirmDataStrategy.class);
    private final RebateImportDataTypeEnum rebateImportDataTypeEnum;
    private final Class<? extends IConfirmDataStrategy> strategyClass;

    public static RebateImportDataTypeEnum getImportDataTypeEnum(Class<? extends IConfirmDataStrategy> aClass) {
        DataTypeStrategyEnum dataTypeStrategyEnum = Arrays.stream(DataTypeStrategyEnum.values())
                .filter(s -> Objects.equals(s.getStrategyClass(), aClass))
                .findFirst().orElse(null);
        return dataTypeStrategyEnum != null ? dataTypeStrategyEnum.getRebateImportDataTypeEnum() : null;
    }
}
