package org.stream相关;

import com.google.common.collect.Lists;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.Data;

public class Map相关 {

    public static void main(String[] args) {

        //普通Map
        Map<Long, Apple> collect = Lists.newArrayList(new Apple()).stream()
                .collect(Collectors.toMap(Apple::getId, v -> v, (v1, v2) -> v1));
        System.out.println(collect);
        Map<Long, Apple> collect1 = Lists.newArrayList(new Apple()).stream()
                .collect(Collectors.toMap(Apple::getId, Function.identity(), (v1, v2) -> v1));
        System.out.println(collect1);

        //Map List
        Map<Long, List<Apple>> collect2 = Lists.newArrayList(new Apple()).stream()
                .collect(Collectors.groupingBy(Apple::getId));
        System.out.println(collect2);

        //相同颜色的苹果编码
        Map<Integer, Set<String>> sortMapModule = Lists.newArrayList(new Apple()).stream()
                .collect(Collectors.groupingBy(Apple::getColor,
                        Collectors.mapping(Apple::getCode, Collectors.toSet())));

        //分组求和
        Map<Integer, BigDecimal> collect3 = Lists.newArrayList(new Apple()).stream()
                .collect(Collectors.groupingBy(Apple::getColor,
                        Collectors.reducing(BigDecimal.ZERO, Apple::getPrice, BigDecimal::add)));

        //分组最大值
        Map<Integer, Optional<Apple>> collect4 = Lists.newArrayList(new Apple()).stream()
                .collect(Collectors.groupingBy(Apple::getColor,
                        Collectors.maxBy(Comparator.comparing(Apple::getPrice))));
        Map<Integer, BigDecimal> collect5 = Lists.newArrayList(new Apple()).stream()
                .collect(
                        Collectors.collectingAndThen(
                                Collectors.groupingBy(Apple::getColor,
                                        Collectors.maxBy(Comparator.comparing(Apple::getPrice))),
                                map -> map.entrySet().stream()
                                        .collect(Collectors.toMap(Entry::getKey, e -> e.getValue().get().getPrice()))
                        )
                );
    }


    @Data
    private static class Apple {

        Long id;
        Integer color;
        String code;
        BigDecimal price;

    }

}
