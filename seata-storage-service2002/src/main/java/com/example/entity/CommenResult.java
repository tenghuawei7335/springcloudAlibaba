package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pan
 * @create 2021/12/5 21:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommenResult<T> {

    private Integer code;
    private String message;
    private T data;

    public CommenResult(Integer code, String message){
        this(code, message, null);
    }
}