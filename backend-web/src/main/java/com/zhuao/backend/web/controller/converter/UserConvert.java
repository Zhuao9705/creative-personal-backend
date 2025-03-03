package com.zhuao.backend.web.controller.converter;

import com.zhuao.backend.manage.data.UserDTO;
import com.zhuao.backend.web.controller.data.vo.UserVO;

import java.util.ArrayList;
import java.util.List;

public class UserConvert {

    public static UserVO convertUserDTOToUserVO(UserDTO user) {
        UserVO userVO = new UserVO();
        userVO.setId(user.getId());
        userVO.setName(user.getName());
        return userVO;
    }

    public static List<UserVO> convertUserDTOListToUserVOList(List<UserDTO> userList) {
        List<UserVO> userVOList = new ArrayList<>();
        userList.forEach(user -> {
            UserVO userVO = new UserVO();
            userVO.setId(user.getId());
            userVO.setName(user.getName());
            userVOList.add(userVO);
        });
        return userVOList;
    }
}
