package org.guava;

import com.google.common.collect.Lists;
import java.util.List;

public class Listts {

    public static void main(String[] args) {
        //分批入库
        List<RebateOperateStatementEo> statementEos = Lists.newArrayList();
        List<List<RebateOperateStatementEo>> eoLists = Lists.partition(statementEos, 5000);
        eoLists.forEach(list -> System.out.println("rebateOperateStatementDas.insertBatch(list)"));
    }

    private static class RebateOperateStatementEo {

    }
}
