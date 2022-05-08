package com.example.service;
import java.math.BigDecimal;

/**
 * 账户服务类
 */
public interface AccountService {

    /**
     * 扣减账户余额
     * @param userId 用户Id
     * @param money 扣减金额
     */
    void decrease(Long userId, BigDecimal money);
}
