package org.returnM;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;

public class ReturnM {

    public static void main(String[] args) {
        Pair<Boolean, String> pair = new ImmutablePair<>(true, "张三");
        System.out.println(pair.getKey());
        System.out.println(pair.getValue());
        System.out.println(pair.getLeft());
        System.out.println(pair.getRight());
        Triple triple = new ImmutableTriple("张三", 11,"男");
        System.out.println(triple.getLeft());
        System.out.println(triple.getMiddle());
        System.out.println(triple.getRight());

    }
}
