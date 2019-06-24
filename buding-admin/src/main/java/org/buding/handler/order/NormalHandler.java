package org.buding.handler.order;

import org.buding.annotation.OrderHandlerType;
import org.buding.domain.OrderDto;
import org.springframework.stereotype.Component;

@Component
@OrderHandlerType("1")
public class NormalHandler extends AbstractOrderHandler {
    @Override
    public String handler(OrderDto dto) {
        return "处理普通订单";
    }
}
