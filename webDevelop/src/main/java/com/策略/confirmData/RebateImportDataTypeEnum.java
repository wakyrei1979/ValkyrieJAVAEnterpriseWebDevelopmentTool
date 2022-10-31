package com.策略.confirmData;

import java.util.Arrays;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 总表确认列表状态
 * @author sunjingang
 * @date 2022-09-14
 */
@Getter
@AllArgsConstructor
public enum RebateImportDataTypeEnum {

    BUSINESS_EXPENSES(0, "商业费用");
    private final Integer value;
    private final String description;

    public static RebateImportDataTypeEnum getByValue(Integer value) {
        return Arrays.stream(RebateImportDataTypeEnum.values()).filter(s -> Objects.equals(s.getValue(), value)).findFirst().orElse(null);
    }
}
