package org.nio;

import java.nio.Buffer;

/**
 * Created by LiChaojie on 2016/8/15.
 */
public class NIOTest {
    // Java NIO 引入了缓冲区(Buffer)、通道(Channel)、选择器(Selector)等一些抽象概念；
    // 缓冲区 ：
    //      Buffer 为所有的原始类型提供 (Buffer) 缓存支持。
    //      在NIO库中，所有数据都是用缓冲区处理的。在读取数据时，它是直接读到缓冲区中的；
    //      在写入数据时，它也是写入到缓冲区中的；任何时候访问 NIO 中的数据，都是将它放到缓冲区中。
    // 通道：
    //      一个新的原始 I/O 抽象，用于读写Buffer类型，通道可以认为是一种连接，可以是到特定设备，程序或者是网络的连接
    // 选择器 ：
    //      NIO中实现非阻塞I/O的核心对象就是Selector，Selector就是注册各种I/O事件的地方，而且当那些事件发生时，就是这个对象告诉我们所发生的事件，
    //      当有读或写等任何注册的事件发生时，可以从Selector中获得相应的SelectionKey，
    //      同时从 SelectionKey中可以找到发生的事件和该事件所发生的具体的SelectableChannel，以获得客户端发送过来的数据。
    //      Java NIO的选择器允许一个单独的线程来监视多个输入通道，你可以注册多个通道使用一个选择器，然后使用一个单独的线程来“选择”通道：
    //      这些通道里已经有可以处理的输入，或者选择已准备写入的通道。这种选择机制，使得一个单独的线程很容易来管理多个通道。

    public static void main(String[] args){
        System.out.println("NIO Simple information.");

        Buffer buffer;
    }
}
