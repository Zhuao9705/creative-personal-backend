package com.zhuao.backend.dao.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author zhuao01
 * @date 2023/02/02 23:59
 */
@Data
@Accessors(chain = true)
public class UserEntity {

    private Long id;

    private String userId;

    private String name;

    private String status;

    private Long creator;

    private Long updater;

    private Long createTime;

    private Long updateTime;

}
