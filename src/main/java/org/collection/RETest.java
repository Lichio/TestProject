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

        //String���matches������
        String string = new String("ababababd");
        System.out.println(string.matches("(ab)*"));
        System.out.println();

        //�����ַ����ǲ�ƥ������ģʽ�ģ������ҵ�ƥ��ģʽ���ִ�
        String str = "������һ�������Java���塷 �ҵĵ绰13398003219"
                + "������ �绰13290753408"
                + "���۶��ֵ��� ��ϵ��ʽ��15678032218";
        Matcher mat = Pattern.compile("((13)|(15))\\d{9}").matcher(str);
        while (mat.find()){
            System.out.println(mat.group() + "�Ӵ�����ʼλ���ǣ�" + mat.start() + "����λ���ǣ�" + mat.end());
        }
        System.out.println(mat.matches());
    }
}
