package org.buding.handler.order;

import org.buding.domain.OrderDto;

public abstract class AbstractOrderHandler {
    public abstract String handler(OrderDto dto);
}
