package com.example.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//库存表
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("all")
public class Storage {

    private Long id;

    // 产品id
    private Long productId;

    // 总库存
    private Integer total;

    // 已用库存
    private Integer used;

    // 剩余库存
    private Integer residue;

}
