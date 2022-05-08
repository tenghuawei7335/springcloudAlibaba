package com.example.controller;
import com.example.entity.User;
import com.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by IntelliJ IDEA2021.3
 * @Author: Tenghw
 * @Date: 2022/05/01  14:23
 * @Description:
 */

@Controller
@RefreshScope
@Slf4j
@SuppressWarnings("all")
public class UserController {
    @Autowired
    UserService userService;

    @Value("${user.name}")
    String name;


    @GetMapping(path = "/get/{id}")
    @ResponseBody
    public User get(@PathVariable("id") int id){

        log.warn("name>>>>"+name);
        return userService.getOneUserById(id);
    }

}
