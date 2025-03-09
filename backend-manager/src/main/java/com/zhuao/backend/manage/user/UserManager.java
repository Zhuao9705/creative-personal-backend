package com.zhuao.backend.manage.user;


import base.PageResult;
import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhuao.backend.dao.entity.UserEntity;
import com.zhuao.backend.dao.mapper.UserMapper;
import com.zhuao.backend.manage.converter.UserConvert;
import com.zhuao.backend.manage.data.UserDTO;
import org.springframework.stereotype.Component;
import utils.PageUtils;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserManager {

    @Resource
    private UserMapper userMapper;

    public UserDTO selectUserByUserName(String userName){
        return UserConvert.convertUserToUserDTO(userMapper.selectUserByUserName(userName));
    }

    public List<UserDTO> selectAllUserList(){
        return UserConvert.convertUserListToUserDTOList(userMapper.selectAllUserList());
    }

    public PageResult<UserDTO> selectByPage(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<UserEntity> userEntities = userMapper.selectByPage();
        PageInfo<UserEntity> tPageResult = new PageInfo<>(userEntities);
        PageInfo<UserDTO> res = new PageInfo<>();
        BeanUtil.copyProperties(tPageResult, res);
        return PageUtils.getPageResult(tPageResult);
    }

}
