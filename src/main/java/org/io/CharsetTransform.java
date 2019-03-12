package org.io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * Created by LiChaojie on 2016/3/11.
 */
public class CharsetTransform {
    public static void main(String[] args)throws Exception{
        //�����������Ķ�Ӧ��Charset
        Charset charset = Charset.forName("GBK");
        //���charset�����Ӧ�ı������ͽ�����
        CharsetEncoder charsetEncoder = charset.newEncoder();
        CharsetDecoder charsetDecoder = charset.newDecoder();
        //����һcharBuffer����
        CharBuffer charBuffer = CharBuffer.allocate(8);
        charBuffer.put('K');
        charBuffer.put('r');
        charBuffer.put('i');
        charBuffer.flip();
        //��charBuffer����ַ�����ת�����ֽ�����
        ByteBuffer byteBuffer = charsetEncoder.encode(charBuffer);
        for(int i = 0; i < byteBuffer.capacity(); i ++){
            System.out.print(byteBuffer.get(i) + " ");
        }
        System.out.println("\n" + charsetDecoder.decode(byteBuffer));
    }
}
