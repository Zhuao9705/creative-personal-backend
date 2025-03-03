package com.zhuao.backend.service.user;

import com.zhuao.backend.manage.data.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO selectUserByUserName(String userName);

    List<UserDTO> selectAllUserList();
}
