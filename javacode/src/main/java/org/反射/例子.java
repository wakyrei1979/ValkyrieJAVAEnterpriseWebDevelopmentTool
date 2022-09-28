package org.反射;

import com.google.common.collect.Lists;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import org.springframework.util.ReflectionUtils;

public class 例子 {

    public static void main(String[] args) {
        //处理所有的BigDecimal对象
        List<Tmptt> list = Lists.newArrayList();
        list.forEach(v-> ReflectionUtils.doWithFields(Tmptt.class,f->{
            f.setAccessible(true);
            if (BigDecimal.class.equals(f.getType())) {
                BigDecimal o = (BigDecimal)f.get(v);
                if (o != null) {
                    f.set(v,o.setScale(2, RoundingMode.HALF_UP));
                }
            }
        }));
    }

    private static class Tmptt {

    }
}
