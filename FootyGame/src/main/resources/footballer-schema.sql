DROP TABLE IF EXISTS `footballer` CASCADE;
create table `footballer` (
	`id` INTEGER UNIQUE PRIMARY KEY AUTO_INCREMENT,
	`age` INTEGER,
	`footballer_name` VARCHAR(255) NOT NULL, 
	`position` VARCHAR(255),
	`email` VARCHAR(255)
);