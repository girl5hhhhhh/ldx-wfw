package com.ldx.webfeign;

import com.ldx.fallback.OrderApiClientFallBack;
import com.ldx.info.OrderInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "ldx-order",fallback = OrderApiClientFallBack.class)
public interface OrderFeignClient {

    @PostMapping("/order/add")
    public OrderInfo add(OrderInfo orderInfo);

}
