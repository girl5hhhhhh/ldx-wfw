package com.ldx.service;


import com.ldx.info.OrderInfo;
import com.ldx.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//作为微服务的一个给别人去使用
@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    //生成一个订单
    public int createOrder(OrderInfo orderInfo){

        com.ldx.repository.info.OrderInfo o = new com.ldx.repository.info.OrderInfo();
        o.setNumber(orderInfo.getNumber());

        try {
            return orderRepository.save(o).getId();
        }catch (Exception ex){
            System.out.println(ex);
            return -1;//代表我这个接口调用失败
        }
    }

}
