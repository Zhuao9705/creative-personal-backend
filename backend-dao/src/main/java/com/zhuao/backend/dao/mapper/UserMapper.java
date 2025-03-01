package com.zhuao.backend.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhuao.backend.dao.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhuao
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

    UserEntity selectUserByUserName(@Param("userName") String userName);


}
