package com.pan.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author pan
 * @create 2021/12/5 21:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private static final long serialVersionUID = -141472613442105353L;
    private Long id;
    private String serial;
}