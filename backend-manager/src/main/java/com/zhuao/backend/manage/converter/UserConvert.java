package com.zhuao.backend.manage.converter;

import com.zhuao.backend.dao.entity.UserEntity;
import com.zhuao.backend.manage.data.UserDTO;

public class UserConvert {

    public static UserDTO convertUserToUserDTO(UserEntity user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        return userDTO;
    }
}
