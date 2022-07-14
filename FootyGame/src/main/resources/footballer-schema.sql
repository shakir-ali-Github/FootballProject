DROP TABLE IF EXISTS `footballer` CASCADE;
create table `fish` (
	`id` INTEGER UNIQUE PRIMARY KEY AUTO_INCREMENT,
	`age` INTEGER,
	`phonenumber` LONG,
	`footballer_firstname` VARCHAR(255) NOT NULL, 
	`footballer_surname` VARCHAR(255) NOT NULL,
	`position` VARCHAR(255)
);