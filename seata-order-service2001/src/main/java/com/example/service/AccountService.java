package com.example.service;
import com.example.entity.CommenResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.math.BigDecimal;
/**
 * 账户服务
 */
@Component
@FeignClient(value = "seata-account-service2003")
public interface AccountService {

    /**
     * 扣减用户账户余额
     * @param userId 用户Id
     * @param money 扣减金额
     * @return CommenResult
     */
    @PostMapping(value = "/account/decrease")
    CommenResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
