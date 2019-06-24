package org.buding.processor;

import org.buding.context.OrderHanlderContext;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@SuppressWarnings("unchecked")
public class OrderHandlerProcessor implements BeanFactoryPostProcessor {

    private static final String HANDLER_PACKAGE="org.buding.handler.order";

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String ,Class> handlerMap=null;
        //扫handler包，添加
        OrderHanlderContext context=new OrderHanlderContext(handlerMap);
        beanFactory.registerSingleton(OrderHanlderContext.class.getName(),context);
    }
}
