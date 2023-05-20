package com.ldx.fallback;

import com.ldx.info.OrderInfo;
import com.ldx.webfeign.OrderFeignClient;
import org.springframework.stereotype.Component;

@Component
public class OrderApiClientFallBack implements OrderFeignClient {

    //如果这个类；需要执行方法；执行接口里面的同名方法
    @Override
    public OrderInfo add(OrderInfo orderInfo) {
        System.out.println("发生了服务降级");
        return null;
    }
}
