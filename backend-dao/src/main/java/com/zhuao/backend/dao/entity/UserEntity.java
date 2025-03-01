package com.zhuao.backend.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author zhuao01
 * @date 2023/02/02 23:59
 */
@Data
@Accessors(chain = true)
@TableName(value ="user")
public class UserEntity {

    private Long id;

    private String name;

    private String status;

    private Long creator;

    private Long updater;

    private Boolean deleted;

    private Long createTime;

    private Long updateTime;

}
