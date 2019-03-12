package org.collection;

import java.util.Calendar;

/**
 * Created by LiChaojie on 2016/3/1.
 */
public class CalenderTest {
    public static void main(String[] args){
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.HOUR));
        System.out.println(calendar.toInstant());
    }
}
