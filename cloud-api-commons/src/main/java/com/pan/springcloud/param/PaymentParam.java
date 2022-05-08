package com.pan.springcloud.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author pan
 * @create 2021/12/30 19:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentParam implements Serializable {
    private Long id;
    private String serial;
    private Date startTime;
    private Date entTime;
}
