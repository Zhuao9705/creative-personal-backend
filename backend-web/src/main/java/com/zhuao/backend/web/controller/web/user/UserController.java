package com.zhuao.backend.web.controller.web.user;

import base.PageResult;
import cn.hutool.core.bean.BeanUtil;
import com.zhuao.backend.manage.data.UserDTO;
import com.zhuao.backend.service.user.UserService;
import com.zhuao.backend.web.controller.converter.UserConvert;
import com.zhuao.backend.web.controller.data.vo.UserVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    public UserVO getUserInfo(String userName) {
        UserDTO userDTO = userService.selectUserByUserName(userName);
        return UserConvert.convertUserDTOToUserVO(userDTO);
    }

    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    public PageResult<UserVO> getUserList(Integer pageNum, Integer pageSize) {
        PageResult<UserDTO> userDTOPageResult = userService.selectByPage(pageNum, pageSize);
        PageResult<UserVO> userVOPageResult = new PageResult<>();
        BeanUtil.copyProperties(userDTOPageResult, userVOPageResult);
        return userVOPageResult;
    }

    @RequestMapping(value = "/say", method = RequestMethod.GET)
    public String say() {
       return "hello";
    }

}
