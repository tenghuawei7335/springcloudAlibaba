package com.example.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//账户表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Long id;

    private Long userId;

    // 总额度
    private Integer total;

    // 已用余额
    private Integer used;

    // 剩余可用额度
    private Integer residue;
}
