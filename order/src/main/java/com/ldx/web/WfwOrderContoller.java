package com.ldx.web;

import com.ldx.info.OrderInfo;
import com.ldx.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/order")
public class WfwOrderContoller {

    @Autowired
    OrderService orderService;

    //这个只是 order微服务 提供给别人去访问的;
    @RequestMapping("/add")
    public OrderInfo addOrder(@RequestBody OrderInfo orderInfo){
        System.out.println("order" + orderInfo);
        int order = orderService.createOrder(orderInfo);

        orderInfo.setId(order);
        return orderInfo;
    }

}
