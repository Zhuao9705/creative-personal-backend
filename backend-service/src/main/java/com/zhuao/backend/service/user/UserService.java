package com.zhuao.backend.service.user;

import com.zhuao.backend.manage.data.UserDTO;

public interface UserService {

    UserDTO selectUserByUserName(String userName);
}
