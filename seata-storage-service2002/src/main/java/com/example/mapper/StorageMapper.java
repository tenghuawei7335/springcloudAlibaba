package com.example.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@SuppressWarnings("all")
@Mapper
public interface StorageMapper {
        /**
         * 扣减库存
         * @param productId 产品id
         * @param count count 订单下单数量
         */
        void decrease(@Param("productId") Long productId, @Param("count") Integer count);

}
