package com.example.service.impl;
import com.example.mapper.StorageMapper;
import com.example.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 库存服务,扣减库存
 */
@Service
@SuppressWarnings("all")
public class StorageServiceImpl implements StorageService {

    @Autowired
    StorageMapper storageMapper;

    /**
     * 扣减库存
     * @param productId 产品id
     * @param count count 订单下单数量
     */
    @Override
    @Transactional(rollbackFor = Exception.class)//这里不使用全局事务注解
    public void decrease(Long productId, Integer count) {
        // 实际中需要判断库存是否充足
        storageMapper.decrease(productId, count);
    }
}
