package com.zhuao.backend.manage.user;


import com.zhuao.backend.dao.mapper.UserMapper;
import com.zhuao.backend.manage.converter.UserConvert;
import com.zhuao.backend.manage.data.UserDTO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserManager {

    @Resource
    private UserMapper userMapper;

    public UserDTO selectUserByUserName(String userName){
        return UserConvert.convertUserToUserDTO(userMapper.selectUserByUserName(userName));
    }

    public List<UserDTO> selectAllUserList(){
        return UserConvert.convertUserListToUserDTOList(userMapper.selectAllUserList());
    }

}
