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
        //创建简体中文对应的Charset
        Charset charset = Charset.forName("GBK");
        //获得charset对象对应的编码器和解码器
        CharsetEncoder charsetEncoder = charset.newEncoder();
        CharsetDecoder charsetDecoder = charset.newDecoder();
        //创建一charBuffer对象
        CharBuffer charBuffer = CharBuffer.allocate(8);
        charBuffer.put('K');
        charBuffer.put('r');
        charBuffer.put('i');
        charBuffer.flip();
        //将charBuffer里的字符序列转化成字节序列
        ByteBuffer byteBuffer = charsetEncoder.encode(charBuffer);
        for(int i = 0; i < byteBuffer.capacity(); i ++){
            System.out.print(byteBuffer.get(i) + " ");
        }
        System.out.println("\n" + charsetDecoder.decode(byteBuffer));
    }
}
