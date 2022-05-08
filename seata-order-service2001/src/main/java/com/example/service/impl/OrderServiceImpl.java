package com.example.service.impl;
import com.example.entity.Order;
import com.example.mapper.OrderMapper;
import com.example.service.AccountService;
import com.example.service.OrderService;
import com.example.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service("orderService")
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    private StorageService storageService;

    @Autowired
    private AccountService accountService;

    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     * 简单说：下订单->扣库存->减余额->改状态
     * 只需要在创建订单添加@GlobalTransactional就可以了，库存服务、账号服务不需要@GlobalTransactional
     */
    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void create(Order order) throws Exception {
        try {
            // 创建订单
            log.info("------1创建订单 order : {}------", order);
            orderMapper.create(order);
            log.info("------创建订单完成-------");

            // 扣减库存
            log.info("------2扣减库存数量 count = {}------", order.getCount());
            storageService.decrease(order.getProductId(), order.getCount());
            log.info("------扣减库存完成-------");

            // 扣减账户余额
            log.info("------3扣减账户余额 momey = {}------", order.getMoney());
            accountService.decrease(order.getUserId(), order.getMoney());
            log.info("------扣减账户余额完成-------");

            // 修改订单状态
            log.info("------4修改订单状态before-------");
            orderMapper.update(order.getUserId(), 0);
            log.info("------修改订单状态status=1,订单完成-------");
           }catch (Exception e){
            e.printStackTrace();
            throw  new SQLException("下订单->扣库存->减余额->改状态， 失败......");
           }
}
}
