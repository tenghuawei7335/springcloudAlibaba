package com.example.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.math.BigDecimal;

@Mapper//将其标记为一个mapper接口
public interface AccountMapper {
    /**
     * 扣减账户余额
     * @param userId 用户Id
     * @param money 扣减金额
     */
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
