package com.zhuao.backend.service.user;

import base.PageResult;
import com.zhuao.backend.manage.data.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO selectUserByUserName(String userName);

    List<UserDTO> selectAllUserList();

    PageResult<UserDTO> selectByPage(int pageNum, int pageSize);
}
