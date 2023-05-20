package com.ldx.web;

import com.ldx.info.OrderInfo;
import com.ldx.webfeign.OrderFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("order_api")
public class OrderController {

    @Autowired
    OrderFeignClient orderFeignClient; //我们一个接口有多个实现类了；导致我们不知道

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("addOrder")
    public String addOrder(String number){

        //需要调用另外一个服务里面的 得到他的信息

        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setNumber(number);

        OrderInfo result = orderFeignClient.add(orderInfo);
        System.out.println(result);
        return null == result ? "error" : String.valueOf(result.getId());
    }

    @RequestMapping("addOrderByRestTemplate")
    public Object addOrderByRestTemplate(String number){
        /*get请求：不带参数*/
        /*ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://ldx-order/order/add?number={number}", String.class);
        String body = responseEntity.getBody();
        System.out.println(body);*/

        /*get请求：带参数*/
        /*Map<String, String> params = new HashMap<>(16);
        params.put("number", "444");
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://ldx-order/order/add?number={number}", String.class, params);
        String body = responseEntity.getBody();
        System.out.println(body);*/

        /*post请求：带参数*/
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setNumber(number);
        ResponseEntity<Object> responseEntity = restTemplate.postForEntity("http://ldx-order/order/add", orderInfo, Object.class);
        Object body = responseEntity.getBody();
        System.out.println(body);

        /*put请求*/
        //restTemplate.put("http://demo-service/hello/{1}", "Tony");

        /*delete请求*/
        //restTemplate.delete("http://demo-service/hello/{1}", "Tony");
        return body;
    }

}
