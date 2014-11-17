package com.gemini.dwr.push;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@RemoteProxy(name = "MessageService")
public class MessageService implements ApplicationContextAware  {

    private ApplicationContext ctx;
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        this.ctx = applicationContext;
    }
    
    /**
     * 暴露给客户端的接口, 让客户端让服务端发送消息
     * 有事件触发就像客户端发送消息
     * @param msg
     */
    @RemoteMethod
    public void sendMessage(Message msg) {
        this.ctx.publishEvent(new MessageEvent(msg));
    }

}
