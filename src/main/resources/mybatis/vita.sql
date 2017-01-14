# 数据库创建脚本

-- 测试连接数据库的表
DROP TABLE IF EXISTS TEST;

CREATE TABLE TEST(
  id INT NOT NULL AUTO_INCREMENT,
  info VARCHAR(100) NOT NULL,
  date VARCHAR(20) NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO TEST(info, date) VALUES("The First Message!", DATE_FORMAT(NOW(), '%Y-%m-%d %H:%i:%S'));
