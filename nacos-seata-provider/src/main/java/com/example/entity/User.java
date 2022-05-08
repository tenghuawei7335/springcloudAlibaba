package com.example.entity;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;
/**
 * Created by IntelliJ IDEA2021.3
 * @Author: Tenghw
 * @Date: 2022/05/01  14:12
 * @Description:
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -5706175459982292859L;

    private  int id;
    private  String name;
    private  String password;
    private  String role;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createtime;
    private  String remarks;
}
