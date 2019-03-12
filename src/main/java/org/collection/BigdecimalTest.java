package org.collection;

import java.math.BigDecimal;

/**
 * Created by LiChaojie on 2016/3/1.
 */
public class BigdecimalTest {
    public static void main(String[] args){
        BigDecimal bigDecimal1 = new BigDecimal("0.1");
        BigDecimal bigDecimal2 = BigDecimal.valueOf(0.2);
        BigDecimal bigDecimal3 = BigDecimal.valueOf(bigDecimal1.doubleValue() + bigDecimal2.doubleValue());
        System.out.println(bigDecimal1.add(bigDecimal2) + "\n" + bigDecimal3);
        System.out.println();
    }
}
