package org.buding.handler.order;

import org.buding.annotation.OrderHandlerType;
import org.buding.domain.OrderDto;
import org.springframework.stereotype.Component;

@Component
@OrderHandlerType("3")
public class PromotionHandler extends AbstractOrderHandler {
    @Override
    public String handler(OrderDto dto) {
        return "处理促销订单";
    }
}
