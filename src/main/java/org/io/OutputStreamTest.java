package org.io;

import java.io.*;

/**
 * Created by LiChaojie on 2016/3/10.
 */
public class OutputStreamTest {
    public static void main(String[] args)throws IOException{

        long start = System.nanoTime();

        File file = new File("C:\\Users\\lich_\\Desktop\\experiment\\cpachecker\\allResult.txt");
        FileOutputStream outputStream = new FileOutputStream(file);
        PrintStream printStream = new PrintStream(outputStream);
        //FileWriter writer = new FileWriter(file);
        for (int i = 0 ; i < 1024; i ++){
            String s = toFixedLengthBinaryString(i,10);
            //System.out.println(s);
            //writer.write(s  + "\r\n");
            printStream.println(s);
        }

        long end = System.nanoTime();
        long difference = end - start;
        System.out.println("Total Time : " + difference * 1.0 * Math.pow(10,-9));

    }

    public static String toFixedLengthBinaryString(int i,int length){
        String rawString = Integer.toBinaryString(i);
        StringBuilder stringBuilder = new StringBuilder(rawString);
        stringBuilder.reverse();
        for (int x = 0 ; x < length - rawString.length(); x ++){
            stringBuilder.append("0");
        }
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    public static void test() throws IOException{
        FileInputStream inputStream = new FileInputStream("E:\\Java\\Code\\testFile.txt");

        //�������ڸ��ļ������½�һ���ļ�
        FileOutputStream outputStream = new FileOutputStream("E:\\Java\\Code\\newFile.txt");

        byte[] temp1 = new byte[1024];
        int length1 = 0;
        while((length1 = inputStream.read(temp1)) > 0){
            outputStream.write(temp1,0,length1);
        }

        //�ô�������PrintStream����װ�ڵ�����FileOutputStream��
        PrintStream printStream = new PrintStream(outputStream);
        String name = "Kristy";
        int age = 23;
        printStream.printf("\r\n\r\nName:%s,Age:%d",name,age);
        printStream.print("\r\nYou are my destiny!");

        inputStream.close();
        outputStream.close();

        //-------------------------------------------------------------------------------------
        FileWriter writer = new FileWriter("E:\\Java\\Code\\poem.txt");
        writer.write("��ɪ - ������ \r\n");
        writer.write("��ɪ�޶���ʮ�ң�һ��һ��˼���ꡣ\r\n");
        writer.write("ׯ�������Ժ��������۴����жž顣\r\n");
        writer.write("�������������ᣬ������ů�����̡�\r\n");
        writer.write("����ɴ���׷�䣬ֻ�ǵ�ʱ���Ȼ��\r\n");
        writer.close();
    }
}
