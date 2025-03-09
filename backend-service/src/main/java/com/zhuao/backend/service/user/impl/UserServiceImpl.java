package com.zhuao.backend.service.user.impl;

import base.PageResult;
import com.zhuao.backend.manage.data.UserDTO;
import com.zhuao.backend.manage.user.UserManager;
import com.zhuao.backend.service.user.UserService;
import exception.BackendException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static exception.BackendExceptionType.PARAMETER_VERIFY_FAILURE;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserManager userManager;

    @Override
    public UserDTO selectUserByUserName(String userName) {
        return userManager.selectUserByUserName(userName);
    }

    @Override
    public List<UserDTO> selectAllUserList() {
        return userManager.selectAllUserList();
    }

    @Override
    public PageResult<UserDTO> selectByPage(int pageNum, int pageSize) {
        if (pageNum < 1) {
            throw new BackendException(PARAMETER_VERIFY_FAILURE);
        }
        return userManager.selectByPage(pageNum, pageSize);
    }
}
