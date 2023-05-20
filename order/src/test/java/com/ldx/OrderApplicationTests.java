package com.ldx;

import com.ldx.info.OrderInfo;
import com.ldx.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderApplicationTests {

    @Autowired
    OrderService orderService;

    @Test
    void contextLoads() {
    }

    @Test
    void test(){

        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setNumber("1234567");
        int order = orderService.createOrder(orderInfo);
        System.out.println(order);

    }

}
