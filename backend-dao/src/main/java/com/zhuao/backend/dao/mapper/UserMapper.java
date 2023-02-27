package com.zhuao.backend.dao.mapper;

import com.zhuao.backend.dao.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhuao
 */
@Mapper
public interface UserMapper {

    UserEntity selectUser();


}
