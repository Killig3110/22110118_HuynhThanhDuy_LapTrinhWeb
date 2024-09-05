DROP TABLE IF EXISTS `laptrinhweb`.`users`;
CREATE TABLE `laptrinhweb`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(50) NULL UNIQUE,
  `password` VARCHAR(50) NULL,
  `email` VARCHAR(50) NULL,
  `fullname` VARCHAR(100) NULL,
  `images` VARCHAR(500) NULL,
  PRIMARY KEY (`id`));