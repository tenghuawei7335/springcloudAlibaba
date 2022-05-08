package com.example.service;
import com.example.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单服务，创建订单
 */

public interface OrderService {
    void create(Order order) throws Exception;
}
