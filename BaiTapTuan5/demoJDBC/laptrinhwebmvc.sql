DROP DATABASE IF EXISTS `laptrinhweb_mvc`;
CREATE DATABASE `laptrinhweb_mvc`;

USE `laptrinhweb_mvc`;

DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
	`roleid` INT NOT NULL,
    `rolename` VARCHAR(500) NOT NULL,
    PRIMARY KEY (`roleid`)
);

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(50) NULL UNIQUE,
  `password` VARCHAR(50) NULL,
  `images` VARCHAR(500) NULL,
  `fullname` VARCHAR(100) NULL,
  `email` VARCHAR(50) NULL,
  `roleid` INT NOT NULL,
  `phone` VARCHAR(10) NULL,
  `createDate` DATE NOT NULL,
  CONSTRAINT `roleid` FOREIGN KEY (`roleid`) REFERENCES `roles` (`roleid`),
  PRIMARY KEY (`id`)
);

INSERT INTO `roles`(`roleid`, `rolename`)
VALUES (1, 'Admin');

INSERT INTO `roles`(`roleid`, `rolename`)
VALUES (2, 'User');

INSERT INTO `users`(`username`, `password`, `images`, `fullname`, `email`, `phone`, `roleid`, `createDate`) 
VALUES ('thanhdi', '1234', 'null', 'Huynh Thanh Duy', 'thanhdi@gmail.com', '0325845489', 1, '2024-09-15');

INSERT INTO `users`(`username`, `password`, `images`, `fullname`, `email`, `phone`, `roleid`, `createDate`) 
VALUES ('huhu', '1234', 'null', 'Khoc thet cung lap trinh WEB', 'huhu@gmail.com', '1234567890', 2, '2024-09-20');
