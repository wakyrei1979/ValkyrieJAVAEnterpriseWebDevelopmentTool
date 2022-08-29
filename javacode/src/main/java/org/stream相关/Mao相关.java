package org.stream相关;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.Data;
import org.checkerframework.checker.nullness.qual.Nullable;

public class Mao相关 {

    public static void main(String[] args) {
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(new Account());
        Map<Long, Account> accountMap = accounts.stream()
                .collect(Collectors.toMap(Account::getId, v -> v));
        accountMap = accounts.stream()
                .collect(Collectors.toMap(Account::getId, Function.identity()));
//避免主键冲突
        accountMap = accounts.stream()
                .collect(Collectors.toMap(Account::getId, v -> v, (v1, v2) -> v1));
        accountMap = accounts.stream()
                .collect(Collectors.toMap(Account::getId, Function.identity(), (v1, v2) -> v1));
//Map To List
        ArrayList<Apple> appleList = new ArrayList<>();
        appleList.add(new Apple());
        Map<Integer, List<Apple>> groupBy = appleList.stream()
                .collect(Collectors.groupingBy(Apple::getId));

//List To Map<key,hashSet>,相同排序的code在一个分组里
        Map<Integer, Set<String>> sortMapModule = Lists.newArrayList(new DictionaryRespDto()).stream()
                .collect(Collectors.groupingBy(DictionaryRespDto::getSort,
                        Collectors.mapping(DictionaryRespDto::getCode, Collectors.toSet())));
  /*
        Map<Long, BigDecimal> rebateIdMapAmount = new HashMap<>();
        BigDecimal finalWillRelease = calRelease;
        rebateIdMapAmount.compute(occupancy.getRebateId(), (k, v) -> {
            if (v == null) {
                return finalWillRelease;
            } else {
                return v.add(finalWillRelease);
            }
        });
        rebateIdMapAmount.forEach((rebateId, amount) -> {
            //循环处理
        });
        */
    }

    private static class Account {

        Long id;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }

    private static class Apple {

        Integer id;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

    }

    @Data
    private static class DictionaryRespDto {

        Integer sort;
        String code;
    }
}
