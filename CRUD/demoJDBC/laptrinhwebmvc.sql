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

DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories`(
 `cate_id` int AUTO_INCREMENT NOT NULL PRIMARY KEY,
`cate_name` nvarchar(500) NOT NULL,
`status` int NOT NULL,
`images` nvarchar(5000) NULL
);

INSERT INTO `roles`(`roleid`, `rolename`)
VALUES (1, 'Admin');

INSERT INTO `roles`(`roleid`, `rolename`)
VALUES (2, 'User');

INSERT INTO `users`(`username`, `password`, `images`, `fullname`, `email`, `phone`, `roleid`, `createDate`) 
VALUES ('ThanhDi', '1234', 'null', 'Huynh Thanh Duy', 'thanhdi@gmail.com', '0325845489', 1, '2024-09-15');

INSERT INTO `users`(`username`, `password`, `images`, `fullname`, `email`, `phone`, `roleid`, `createDate`) 
VALUES ('huhu', '1234', 'null', 'HuHu', 'huhu@gmail.com', '0123456789', 2, '2024-09-26');

INSERT INTO `categories`(`cate_name`, `status`, `images`) 
VALUES ("Phim hanh dong", 1,  "2.jpg");

INSERT INTO `categories`(`cate_name`, `status`, `images`) 
VALUES ("Phim kinh di", 1, "https://www.elleman.vn/wp-content/uploads/2022/05/22/214340/phim-kinh-di-han-quoc-elleman-2022.jpg");