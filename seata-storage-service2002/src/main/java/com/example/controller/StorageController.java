package com.example.controller;
import com.example.entity.CommenResult;
import com.example.service.StorageService;



import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Slf4j
@SuppressWarnings("all")
public class StorageController {

    @Autowired
    StorageService storageService;

    /**
     * 扣减库存
     * @param productId 产品id
     * @param count 下单数量
     * @return CommenResult
     */
    @PostMapping(value = "/storage/decrease")
    @ResponseBody
    public CommenResult decrease(@RequestParam("productId") Long productId, @RequestParam("count")Integer count){
        log.info("seata-order-service2001通过feign调用seata-storage-service2002");
        log.info("扣减库存中产品productId={}, 扣减数量count={}", productId, count);
        storageService.decrease(productId, count);
        return new CommenResult(200, "扣减库存成功");
    }
}
