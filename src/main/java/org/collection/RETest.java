package org.collection;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by LiChaojie on 2016/3/1.
 */
public class RETest {
    public static void main(String[] args){
        Pattern pattern = Pattern.compile("(\\d)+(ab)*");
        Matcher matcher = pattern.matcher("33abababab");
        System.out.println(matcher.matches());
        System.out.println(matcher.start());
        System.out.println(matcher.end());
        matcher.reset("ababab");
        System.out.println(matcher.matches());
        System.out.println();

        //String类的matches方法。
        String string = new String("ababababd");
        System.out.println(string.matches("(ab)*"));
        System.out.println();

        //整个字符串是不匹配所给模式的，但能找到匹配模式的字串
        String str = "我想求购一本《疯狂Java讲义》 我的电话13398003219"
                + "交朋友 电话13290753408"
                + "出售二手电脑 联系方式：15678032218";
        Matcher mat = Pattern.compile("((13)|(15))\\d{9}").matcher(str);
        while (mat.find()){
            System.out.println(mat.group() + "子串的起始位置是：" + mat.start() + "结束位置是：" + mat.end());
        }
        System.out.println(mat.matches());
    }
}
