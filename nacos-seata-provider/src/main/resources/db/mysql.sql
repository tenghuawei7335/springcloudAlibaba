-- #undo_log表结构，每个业务数据库下都需要有此表
-- 1.收到 TC 的回滚请求后，开始本地事务，执行如下操作。
-- 2.通过 XID 和分支 ID 检索 UNDO LOG。
-- 3.验证数据：将UNDO LOG中更新后的图像数据与当前数据进行比较，如果有差异，说明数据被当前事务外的操作改变了，应该在不同的策略中处理。
-- 4.根据UNDO LOG中的before image和业务SQL的相关信息生成回滚SQL语句

CREATE TABLE `undo_log` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `branch_id` bigint NOT NULL,
                            `xid` varchar(100) NOT NULL,
                            `context` varchar(128) NOT NULL,
                            `rollback_info` longblob NOT NULL,
                            `log_status` int NOT NULL,
                            `log_created` datetime NOT NULL,
                            `log_modified` datetime NOT NULL,
                            `ext` varchar(100) DEFAULT NULL,
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '回滚日志表'
