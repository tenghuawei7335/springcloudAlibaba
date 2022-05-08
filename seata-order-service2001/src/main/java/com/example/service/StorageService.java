package com.example.service;
import com.example.entity.CommenResult;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * 库存服务
 */
@Component
@FeignClient(value = "seata-storage-service2002")
public interface StorageService {

    /**
     * 扣减产品库存
     * @param productId 产品Id
     * @param count 订单下单数量
     * @return CommenResult
     */
    @PostMapping(value = "/storage/decrease")
    CommenResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);

}
