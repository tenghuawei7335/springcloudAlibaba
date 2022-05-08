package com.example.controller;
import com.example.entity.CommenResult;
import com.example.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.math.BigDecimal;
@Controller
@Slf4j
public class AccountController {

    @Autowired
    AccountService accountService;

    /**
     * 扣减用户账户余额
     * @param userId 用户Id
     * @param money 扣减金额
     * @return CommenResult
     */
    @PostMapping(value = "/account/decrease")
    @ResponseBody
    public CommenResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money){
        log.info("seata-order-service2001通过feign调用seata-account-service2003");
        log.info("扣减用户userId={}, 扣减金额为money={}", userId, money);
        if(money.intValue() == 4){
            throw new IllegalArgumentException("money 不能为4");
        }
        accountService.decrease(userId, money);
        return new CommenResult(200, "扣减用户账户余额成功");
    }
}
