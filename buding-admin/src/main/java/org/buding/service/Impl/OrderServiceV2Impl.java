package org.buding.service.Impl;

import org.buding.context.OrderHanlderContext;
import org.buding.domain.OrderDto;
import org.buding.handler.order.AbstractOrderHandler;
import org.buding.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceV2Impl implements IOrderService {

    @Autowired
    private OrderHanlderContext hanlderContext;

    @Override
    public String handle(OrderDto dto) {
        AbstractOrderHandler handler=hanlderContext.getInstance(dto.getType());
        return handler.handler(dto);
    }
}
