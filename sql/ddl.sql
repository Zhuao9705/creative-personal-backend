CREATE TABLE `user` (
                        `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
                        `name` VARCHAR(50) NULL DEFAULT NULL COMMENT '用户名' ,
                        `status` VARCHAR(16) NULL DEFAULT NULL COMMENT '状态' ,
                        `creator` BIGINT(20) NOT NULL COMMENT 'creator',
                        `updater` BIGINT(20) NOT NULL COMMENT 'updater',
                        `deleted` TINYINT(1) NULL DEFAULT '0' COMMENT '删除状态 0正常；1删除',
                        `create_time` BIGINT(20) NOT NULL COMMENT 'create time',
                        `update_time` BIGINT(20) NOT NULL COMMENT 'update time',
                        PRIMARY KEY (`id`) USING BTREE
) COMMENT='用户表' ENGINE=InnoDB;