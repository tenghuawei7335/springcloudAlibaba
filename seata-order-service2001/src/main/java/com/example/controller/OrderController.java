package com.example.controller;
import com.example.entity.CommenResult;
import com.example.entity.Order;
import com.example.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author ZARD
 */
@Controller
@Slf4j
@SuppressWarnings("all")
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/test")
    @ResponseBody
    public void test() throws Exception {
        log.info("测试能否从nacos注册中心拿到实例");
        List<ServiceInstance> instances = discoveryClient.getInstances("seata-storage-service2002");
        instances.forEach(instance->{
            System.out.println("======"+instance.getUri()+"======");
            System.out.println("======"+instance.getInstanceId()+"======");
            System.out.println("======"+instance.getServiceId()+"======");
            System.out.println("======"+instance.getPort()+"======");
            //======http://192.168.204.1:2002======
            //======null======
            //======seata-storage-service2002======
            //======2002======
        });

    }
    @PostMapping("/order/create")
    @ResponseBody
    public CommenResult create(@RequestBody Order order) throws Exception {
        log.info("创建订单order : {}", order);
        CommenResult result;
        if(order.getCount() <=0 ){
            result = new CommenResult(600, "下单数量应该大于0");
        }else{
            orderService.create(order);
            result = new CommenResult(200, "创建成功");
        }
        return result;
    }
}
