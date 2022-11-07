CREATE TABLE `my_board` (
	`bno` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`title` VARCHAR(255) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	`content` LONGTEXT NOT NULL COLLATE 'utf8mb4_unicode_ci',
	`read_count` INT(11) NOT NULL,
	`writer` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	`created_date` TIMESTAMP NOT NULL DEFAULT current_timestamp(),
	`updated_date` TIMESTAMP NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
	PRIMARY KEY (`bno`) USING BTREE
)
COLLATE='utf8mb4_unicode_ci'
ENGINE=InnoDB
;