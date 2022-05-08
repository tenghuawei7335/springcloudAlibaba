package com.example.mapper;
import com.example.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
/**
 * Created by IntelliJ IDEA2021.3
 * @Author: Tenghw
 * @Date: 2022/05/01  14:15
 * @Description:
 */
@SuppressWarnings("all")
public interface UserMapper {
    @Select(value={"select * from user where id=#{id}"})
    User getOne(@Param("id") int id);
}
