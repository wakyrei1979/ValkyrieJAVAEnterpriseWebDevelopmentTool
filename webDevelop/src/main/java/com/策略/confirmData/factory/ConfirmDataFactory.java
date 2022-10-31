package com.策略.confirmData.factory;


import com.策略.confirmData.DataTypeStrategyEnum;
import com.策略.confirmData.IConfirmDataStrategy;
import com.策略.confirmData.RebateImportDataTypeEnum;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConfirmDataFactory {
    private final Map<RebateImportDataTypeEnum, IConfirmDataStrategy> strategyMap;
    @Autowired
    public ConfirmDataFactory(List<IConfirmDataStrategy> strategys) {
        this.strategyMap = strategys.stream()
                .collect(Collectors.toMap(v -> DataTypeStrategyEnum.getImportDataTypeEnum(v.getClass()), v -> v, (v1, v2) -> v1));
        System.out.println();
    }
    public IConfirmDataStrategy get(RebateImportDataTypeEnum type){
        return strategyMap.get(type);
    }

}
