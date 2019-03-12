package org.io;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by LiChaojie on 2016/3/10.
 */
public class InputStreamTest {
    // �ڵ��������Դӻ���һ���ض��ĵط�(�ڵ�)��д���ݡ�
    // �ֽ���--FileInputStream��FileOutputStream
    // �ַ���--FileReader��FileWriter

    // ���������Ƕ�һ���Ѵ��ڵ��������Ӻͷ�װ��ͨ������װ�����Ĺ��ܵ���ʵ�����ݶ�д��
    // �ֽ���--
    //   DataInputStream��DataOutputStream
    //   BufferInputStream��BufferOutputStream
    //   ObjectInputStream��ObjectOutputStream
    // �ַ���--
    //   BufferReader��BufferWriter
    //   InputStreamReader��outputStreamWriter


    public static void main(String[] args)throws IOException{
        //�ֽ���
        FileInputStream inputStream = new FileInputStream("E:\\Java\\Code\\testFile.txt");
        byte[] temp1 = new byte[1024];
        int length1 = 0;
        while((length1 = inputStream.read(temp1)) > 0){
            System.out.println(new String(temp1,0,length1));
        }
        inputStream.close();

        //-------------------------------------------------------------------------------------

        //�ַ���
        FileReader reader = new FileReader("E:\\Java\\Code\\testFile.txt");
        char[] temp2 = new char[64];
        int length2 = 0;
        while((length2 = reader.read(temp2)) > 0){
            System.out.println(new String(temp2,0,length2));
        }
        reader.close();

    }
}
