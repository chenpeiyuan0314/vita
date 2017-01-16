# 数据库创建脚本

-- 创建数据库
DROP DATABASE IF EXISTS vita;

CREATE DATABASE vita DEFAULT CHARSET UTF8;

USE vita;

-- 测试连接数据库的表
DROP TABLE IF EXISTS test;

CREATE TABLE test (
  id INT NOT NULL AUTO_INCREMENT,
  info VARCHAR(100) NOT NULL,
  date VARCHAR(20) NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO test(info, date) VALUES("The First Message!", DATE_FORMAT(NOW(), '%Y-%m-%d %H:%i:%S'));
