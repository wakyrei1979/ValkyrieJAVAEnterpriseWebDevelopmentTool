package org.stream相关;


import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

public class Set相关 {

    public static void main(String[] args) {
        Set<String> collect = Lists.newArrayList(new DictData()).stream()
                .map(DictData::getDictValue)
                .collect(Collectors.toSet());
        System.out.println(collect.contains("1017"));
    }

    private static class DictData {

        private String dictValue;

        public String getDictValue() {
            return dictValue;
        }

        public void setDictValue(String dictValue) {
            this.dictValue = dictValue;
        }
    }
}
