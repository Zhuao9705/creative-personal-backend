package com.zhuao.backend.web.controller.converter;

import com.zhuao.backend.manage.data.UserDTO;
import com.zhuao.backend.web.controller.data.vo.UserVO;

public class UserConvert {

    public static UserVO convertUserDTOToUserVO(UserDTO user) {
        UserVO userVO = new UserVO();
        userVO.setId(user.getId());
        userVO.setName(user.getName());
        return userVO;
    }
}
