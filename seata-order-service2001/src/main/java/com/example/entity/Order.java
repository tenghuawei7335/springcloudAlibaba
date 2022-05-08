package com.example.entity;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
//订单表
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("all")
public class Order {

    private Long id;
    //用户id
    private Long userId;
    //产品id
    private Long productId;
    //数量
    private Integer count;
    //金额
    private BigDecimal money;
    //订单状态：0：创建中；1：已完成
    private Integer status;

}
