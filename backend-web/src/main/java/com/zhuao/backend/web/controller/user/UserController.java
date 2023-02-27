package com.zhuao.backend.web.controller.user;

import com.zhuao.backend.dao.entity.UserEntity;
import com.zhuao.backend.dao.mapper.UserMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserMapper userMapper;

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    public UserEntity getOrganizationAuthProcess() {
        UserEntity select = userMapper.selectUser();
        return select;
    }

    @RequestMapping(value = "/say", method = RequestMethod.GET)
    public String say() {
       return "hello";
    }

}
