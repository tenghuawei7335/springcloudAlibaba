package com.example.mapper;
import com.example.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
/**
 * Created by IntelliJ IDEA2021.3
 * @Author: Tenghw
 * @Date: 2022/05/04  20:59
 * @Description:
 */
@Mapper
public interface OrderMapper{
//    //1 新建订单
    void create(Order order);

    //2 修改订单状态，订单完成后，status从0改为1;订单状态：0：创建中；1：已完成
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
