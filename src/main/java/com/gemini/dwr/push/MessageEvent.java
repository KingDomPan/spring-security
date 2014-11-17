package com.gemini.dwr.push;

import org.springframework.context.ApplicationEvent;

@SuppressWarnings("serial")
public class MessageEvent extends ApplicationEvent {
    public MessageEvent(Object source) {
        super(source);
    }
}
