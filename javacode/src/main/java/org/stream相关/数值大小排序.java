package org.stream相关;

import com.sun.xml.internal.messaging.saaj.util.SAAJUtil;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 数值大小排序 {
    public static void main(String[] args) {
        List<A> numbers = Arrays.asList(new A(3,2), new A(1,3), new A(2,4));
        List<Integer> nums = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
//        求和
//        BigDecimal unitPre = numbers
//                .stream()
//                .map(A::getB)
//                .reduce(BigDecimal.ZERO, BigDecimal::add);

//        最大值
        A a = numbers.stream().max(Comparator.comparing(A::getI)).get();

//        limit
        Random random = new Random();
        IntStream ints = random.ints();
        ints.limit(10).forEach(System.out::println);

//        排序1
        random.ints().limit(10).sorted().forEach(System.out::println);

//        排序再排序
        List<A> collect = numbers.stream()
                .sorted(Comparator
                        .comparing(A::getI)
                        .thenComparing(A::getJ))
                .collect(Collectors.toList());

//        统计
        IntSummaryStatistics stats = nums.stream()
                .mapToInt((x) -> x)
                .summaryStatistics();
        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());



//        排序再排序
        List<A> collect2 = numbers.stream()
                .sorted(Comparator
                        .comparing(A::getI))
                .collect(Collectors.toList());
        System.out.println();
    }

    static class A {
        public Integer i;
        public Integer j;
        public BigDecimal b;

        public A(Integer i, Integer j) {
            this.i = i;
            this.j = j;
        }

        public Integer getI() {
            return i;
        }

        public Integer getJ() {
            return j;
        }

        public BigDecimal getB() {
            return b;
        }
    }
}
