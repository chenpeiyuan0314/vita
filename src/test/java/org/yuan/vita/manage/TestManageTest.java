package org.yuan.vita.mybatis.manage;

import org.yuan.vita.SpringTest;
import org.junit.Test;
import org.junit.Assert;

import org.springframework.beans.factory.annotation.Autowired;

public class TestManageTest extends SpringTest {
  @Autowired
  private TestManage manage;

  @Test
  public void testInsertTwoRecord() {
    int expect = manage.selectTotalCount();
    
    try {
      manage.insertTwoRecord(true);
      Assert.fail();
    } catch(RuntimeException e) {}

    int actual = manage.selectTotalCount();
    Assert.assertEquals(expect, actual);
  }

  @Test
  public void testInsertTwoRecord2() {
    int expect = manage.selectTotalCount();
    
    manage.insertTwoRecord(false);

    int actual = manage.selectTotalCount();
    Assert.assertEquals(expect, actual-2);
  }

}
