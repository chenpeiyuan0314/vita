package org.yuan.vita.mybatis.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;

import org.yuan.vita.SpringTest;
// import org.yuan.vita.mybatis.entity.Test;

//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:mybatis/spring-config.xml")
public class TestMapperTest extends SpringTest {
  @Autowired
  private TestMapper mapper;

  @Test
  public void testSelectByPrimaryKey() {
    org.yuan.vita.mybatis.entity.Test record = mapper.selectByPrimaryKey(1);
    //System.out.println(record.getInfo());
    Assert.assertEquals("The First Message!", record.getInfo());
    //Assert.assertEquals("", record.getInfo());
  }

}
