package com.zhuao.backend.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhuao.backend.dao.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhuao
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */
    UserEntity selectUserByUserName(@Param("userName") String userName);

    /**
     * 查询所有用户信息
     * @return
     */
    List<UserEntity> selectAllUserList();
}
