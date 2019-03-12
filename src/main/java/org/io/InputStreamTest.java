package org.io;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by LiChaojie on 2016/3/10.
 */
public class InputStreamTest {
    // 节点流：可以从或向一个特定的地方(节点)读写数据。
    // 字节流--FileInputStream、FileOutputStream
    // 字符流--FileReader、FileWriter

    // 处理流：是对一个已存在的流的连接和封装，通过所封装的流的功能调用实现数据读写。
    // 字节流--
    //   DataInputStream、DataOutputStream
    //   BufferInputStream、BufferOutputStream
    //   ObjectInputStream、ObjectOutputStream
    // 字符流--
    //   BufferReader、BufferWriter
    //   InputStreamReader、outputStreamWriter


    public static void main(String[] args)throws IOException{
        //字节流
        FileInputStream inputStream = new FileInputStream("E:\\Java\\Code\\testFile.txt");
        byte[] temp1 = new byte[1024];
        int length1 = 0;
        while((length1 = inputStream.read(temp1)) > 0){
            System.out.println(new String(temp1,0,length1));
        }
        inputStream.close();

        //-------------------------------------------------------------------------------------

        //字符流
        FileReader reader = new FileReader("E:\\Java\\Code\\testFile.txt");
        char[] temp2 = new char[64];
        int length2 = 0;
        while((length2 = reader.read(temp2)) > 0){
            System.out.println(new String(temp2,0,length2));
        }
        reader.close();

    }
}
