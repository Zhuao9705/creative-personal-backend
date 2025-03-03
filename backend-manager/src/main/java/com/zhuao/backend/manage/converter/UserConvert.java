package com.zhuao.backend.manage.converter;

import com.zhuao.backend.dao.entity.UserEntity;
import com.zhuao.backend.manage.data.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class UserConvert {

    public static UserDTO convertUserToUserDTO(UserEntity user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        return userDTO;
    }

    public static List<UserDTO> convertUserListToUserDTOList(List<UserEntity> user) {
        List<UserDTO> userDTOList = new ArrayList<>();
        user.forEach(userEntity -> {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(userEntity.getId());
            userDTO.setName(userEntity.getName());
            userDTOList.add(userDTO);
        });
        return userDTOList;
    }
}
