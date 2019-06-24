package org.buding.context;

import org.buding.handler.order.AbstractOrderHandler;

import java.util.Map;

public class OrderHanlderContext {

    private Map<String,Class> handlerMap;

    public OrderHanlderContext(Map<String, Class> handlerMap) {
        this.handlerMap = handlerMap;
    }

    public AbstractOrderHandler getInstance(String type){
        Class clazz=handlerMap.get(type);
        if(clazz==null){
            throw new IllegalArgumentException("not found handler for type:"+type);
        }
        return null;
    }
}
