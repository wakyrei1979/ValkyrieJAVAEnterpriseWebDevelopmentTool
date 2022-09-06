package org.stream相关;

import com.google.common.collect.Lists;
import java.util.Map;
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
        System.out.println(Lists.newArrayList(new Apple()).stream()
                .collect(Collectors.groupingBy(Apple::getId)));

        //相同颜色的苹果编码
        Map<Integer, Set<String>> sortMapModule = Lists.newArrayList(new Apple()).stream()
                .collect(Collectors.groupingBy(Apple::getColor,
                        Collectors.mapping(Apple::getCode, Collectors.toSet())));
    }


    @Data
    private static class Apple {

        Long id;
        Integer color;
        String code;

    }

}
