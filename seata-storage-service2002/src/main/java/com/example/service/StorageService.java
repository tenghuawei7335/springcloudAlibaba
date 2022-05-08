package com.example.service;

public interface StorageService {
    /**
     * 扣减库存
     * @param productId 产品id
     * @param count count 订单下单数量
     */
    void decrease(Long productId, Integer count);
}
