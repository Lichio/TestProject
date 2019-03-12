package org.io;

import java.io.File;
import java.io.IOException;

/**
 * Created by LiChaojie on 2016/3/10.
 */
public class FileTest {
    public static void main(String[] args)throws IOException{
        File file = new File("E:\\Java\\Code");
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());

        System.out.println(file.exists());
        System.out.println();

        String[] nameList1 = file.list();
        for(String fileName : nameList1){
            System.out.println(">>>" + fileName);
        }

        //ʹ��Lambda���ʽʵ���ļ�������
        String[] nameList2 = file.list((dir,name) -> name.endsWith(".java") || new File(file.getAbsolutePath() + "\\" + name).isDirectory());
        //String[] nameList2 = file.list((dir,name) -> dir.isDirectory());
        for(String fileName : nameList2){
            System.out.println("+>>" + fileName);
        }
    }
}
