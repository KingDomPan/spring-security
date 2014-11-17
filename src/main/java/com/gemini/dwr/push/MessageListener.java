package com.gemini.dwr.push;

import java.util.Collection;

import javax.servlet.ServletContext;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ServerContext;
import org.directwebremoting.ServerContextFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import com.gemini.util.format.DateTimeFormat;

@SuppressWarnings("rawtypes")
@Component("messageListener")
public class MessageListener implements ApplicationListener,
        ServletContextAware {

    private ServletContext ctx;

    @SuppressWarnings("deprecation")
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        /** 监听是消息推送的事件类型 */
        if (event instanceof MessageEvent) {
            Message msg = (Message) event.getSource();
            ServerContext context = ServerContextFactory.get();
            /** 获取所有链接是该页面的script session **/
            Collection<ScriptSession> sessions = context
                    .getScriptSessionsByPage(this.ctx.getContextPath()
                            + "/front/chat/index");
            for (ScriptSession ss : sessions) {
                ScriptBuffer sb = new ScriptBuffer();
                String s = DateTimeFormat.getFormatDate(msg.getTime());
                sb.appendScript("showMessage({msg: '")
                        .appendScript(msg.getMsg()).appendScript("', time: '")
                        .appendScript(s).appendScript("'})");
                System.out.println(sb.toString());
                ss.addScript(sb);
            }
        }
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.ctx = servletContext;
    }

}
