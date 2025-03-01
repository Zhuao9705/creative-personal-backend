package com.zhuao.backend.service.user.impl;

import com.zhuao.backend.manage.data.UserDTO;
import com.zhuao.backend.manage.user.UserManager;
import com.zhuao.backend.service.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserManager userManager;

    @Override
    public UserDTO selectUserByUserName(String userName) {
        return userManager.selectUserByUserName(userName);
    }
}
