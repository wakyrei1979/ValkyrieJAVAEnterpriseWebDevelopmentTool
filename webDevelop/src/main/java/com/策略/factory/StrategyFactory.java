package com.策略.factory;


import com.策略.IStrategy;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StrategyFactory {
    private final Map<StrategyEnum, IStrategy> strategyMap;
    @Autowired
    public StrategyFactory(List<IStrategy> strategys) {
        this.strategyMap = strategys.stream()
                .collect(Collectors.toMap(v -> StrategyEnum.getImportDataTypeEnum(v.getClass()), v -> v, (v1, v2) -> v1));
        System.out.println();
    }
    public IStrategy get(StrategyEnum type){
        return strategyMap.get(type);
    }

}
