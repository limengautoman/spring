package com.mengli.mina;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class MinaServer {
	private static final int PORT = 22222;// 定义监听端口  
    public static void main(String[] args) throws IOException {  
        //创建一个非阻塞的Server端socket，用NIO  
        IoAcceptor acceptor = new NioSocketAcceptor();  
        //创建接受数据的过滤器  
        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();  
        //设定这个过滤器将一行一行的读取数据  
        chain.addLast("codec",new ProtocolCodecFilter(new TextLineCodecFactory()));// 指定编码过滤器  
        // 指定业务逻辑处理器  
        acceptor.setHandler(new Handler());  
        // 设置端口号  
        acceptor.setDefaultLocalAddress(new InetSocketAddress(PORT));  
        acceptor.bind(); //启动监听  
        System.out.println("Mina Server is Listen on:"+PORT);  
    }  

}
