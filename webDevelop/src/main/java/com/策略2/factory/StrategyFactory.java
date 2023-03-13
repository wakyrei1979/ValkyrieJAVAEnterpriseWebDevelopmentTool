package com.策略2.factory;


import com.策略2.Strategy;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StrategyFactory {
    private final Map<StrategyEnum, Strategy> strategyMap;
    @Autowired
    public StrategyFactory(List<Strategy> strategys) {
        this.strategyMap = strategys.stream()
                .collect(Collectors.toMap(v -> StrategyEnum.getImportDataTypeEnum(v.getClass()), v -> v, (v1, v2) -> v1));
        System.out.println();
    }
    public Strategy get(StrategyEnum type){
        return strategyMap.get(type);
    }

}
