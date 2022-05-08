package com.example.service.impl;
import com.example.mapper.AccountMapper;
import com.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
@Service
@SuppressWarnings("all")
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;

    @Override
    @Transactional(rollbackFor = Exception.class) //这里不使用全局事务注解
    public void decrease(Long userId, BigDecimal money) {
        // 实际中需要判断可用余额是否充足
        accountMapper.decrease(userId, money);
    }
}
