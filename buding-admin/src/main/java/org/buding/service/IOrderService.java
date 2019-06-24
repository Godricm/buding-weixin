package org.buding.service;

import org.buding.domain.OrderDto;

public interface IOrderService {

    /**
     * 根据订单的不同类型作出不同处理
     * @param 订单实体
     * @return 字符串
     */
    String handle(OrderDto dto);
}
