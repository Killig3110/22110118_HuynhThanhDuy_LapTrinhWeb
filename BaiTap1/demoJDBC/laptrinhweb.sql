DROP TABLE IF EXISTS `laptrinhweb`.`users`;
CREATE TABLE `laptrinhweb`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(50) NULL UNIQUE,
  `password` VARCHAR(50) NULL,
  `images` VARCHAR(500) NULL,
  `fullname` VARCHAR(100) NULL,
  `email` VARCHAR(50) NULL,
  `rollid` VARCHAR(30) NOT NULL,
  `phone` VARCHAR(10) NULL,
  `createDate` DATE NOT NULL,
  PRIMARY KEY (`id`));