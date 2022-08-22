

/*========= AliPaySuccessMsg ==========*/
DROP TABLE IF EXISTS `AliPaySuccessMsg`; 
CREATE TABLE `AliPaySuccessMsg` ( 
`notify_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`notify_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`notify_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`app_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`charset` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`version` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`sign_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`sign` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`trade_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`out_trade_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`out_biz_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`buyer_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`buyer_logon_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`seller_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`seller_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`trade_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`total_amount` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`receipt_amount` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`invoice_amount` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`buyer_pay_amount` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`point_amount` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`refund_fee` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`subject` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`body` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`gmt_create` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`gmt_payment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`gmt_refund` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`gmt_close` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`fund_bill_list` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`passback_params` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`auth_app_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
PRIMARY KEY (`notify_time`) USING BTREE,
INDEX `notify_time`(`notify_time`) USING BTREE ) 
ENGINE = INNODB DEFAULT CHARSET= utf8;

/*========= Order ==========*/
DROP TABLE IF EXISTS `Order`; 
CREATE TABLE `Order` ( 
`oid` bigint,
`uid` int,
`username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`pid` int,
`pname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`pprice` double precision not null,
`number` int,
PRIMARY KEY (`oid`) USING BTREE,
INDEX `oid`(`oid`) USING BTREE ) 
ENGINE = INNODB DEFAULT CHARSET= utf8;

/*========= Product ==========*/
DROP TABLE IF EXISTS `Product`; 
CREATE TABLE `Product` ( 
`pid` int,
`pname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`pprice` double precision not null,
`stock` int,
PRIMARY KEY (`pid`) USING BTREE,
INDEX `pid`(`pid`) USING BTREE ) 
ENGINE = INNODB DEFAULT CHARSET= utf8;

/*========= Share ==========*/
DROP TABLE IF EXISTS `Share`; 
CREATE TABLE `Share` ( 
`id` int,
`user_id` int,
`title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`create_time` datetime,
`update_time` datetime,
`is_original` bit(1),
`author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`cover` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`summary` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`price` int,
`download_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`buy_count` int,
`show_flag` bit(1),
`audit_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
PRIMARY KEY (`id`) USING BTREE,
INDEX `id`(`id`) USING BTREE ) 
ENGINE = INNODB DEFAULT CHARSET= utf8;

/*========= User ==========*/
DROP TABLE IF EXISTS `User`; 
CREATE TABLE `User` ( 
`uid` int,
`username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
PRIMARY KEY (`uid`) USING BTREE,
INDEX `uid`(`uid`) USING BTREE ) 
ENGINE = INNODB DEFAULT CHARSET= utf8;

/*========= UserCenter ==========*/
DROP TABLE IF EXISTS `UserCenter`; 
CREATE TABLE `UserCenter` ( 
`id` int,
`wx_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`wx_nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`roles` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`avatar_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`create_time` datetime,
`update_time` datetime,
`bonus` int,
PRIMARY KEY (`id`) USING BTREE,
INDEX `id`(`id`) USING BTREE ) 
ENGINE = INNODB DEFAULT CHARSET= utf8;