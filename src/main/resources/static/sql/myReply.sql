CREATE TABLE `my_reply` (
	`rno` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`created_date` TIMESTAMP NULL DEFAULT current_timestamp(),
	`text` VARCHAR(255) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	`updated_date` TIMESTAMP NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
	`writer` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_unicode_ci',
	`bno` BIGINT(20) NULL DEFAULT NULL,
	PRIMARY KEY (`rno`) USING BTREE,
	INDEX `FK_my_reply_my_board` (`bno`) USING BTREE,
	CONSTRAINT `FK_my_reply_my_board` FOREIGN KEY (`bno`) REFERENCES `my_board` (`bno`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COLLATE='utf8mb4_unicode_ci'
ENGINE=InnoDB
;