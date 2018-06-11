package com.mengli.mina;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Handler extends IoHandlerAdapter{
	//当一个客户端连接进入时  
    @Override  
    public void sessionOpened(IoSession session)throws Exception {  
        System.out.println("incoming client:"+session.getRemoteAddress());  
    }  
    //当客户端发送消息到达时  
    @Override  
    public void messageReceived(IoSession session, Object message)throws Exception {  
        String s = message.toString();  
        System.out.println("client send message is:"+s);  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd mm:hh:ss");  
        Date date = new Date();  
        session.write(sdf.format(date));// 返回当前时间的字符串  
        System.out.println("message written...");  
    }  
    //当一个客户端连接关闭时  
    @Override  
    public void sessionClosed(IoSession session)throws Exception {  
        System.out.println("one client closed");  
    }  

}
