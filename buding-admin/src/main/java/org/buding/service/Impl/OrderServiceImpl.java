package org.buding.service.Impl;

import org.buding.domain.OrderDto;
import org.buding.service.IOrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements IOrderService {
    @Override
    public String handle(OrderDto dto) {
        String type=dto.getType();
        if("1".equals(type)){
            return "处理普通订单";
        }
        else if("2".equals(type)){
            return "处理团购订单";
        }else if("3".equals(type)){
            return "处理促销订单";
        }
        return null;
    }
}
