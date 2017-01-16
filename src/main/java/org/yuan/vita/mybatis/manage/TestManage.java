package org.yuan.vita.mybatis.manage;

import org.yuan.vita.mybatis.entity.Test;
import org.yuan.vita.mybatis.mapper.TestMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class TestManage {
  
  public void insertTwoRecord(boolean exception) {
    Test t1 = new Test();
    t1.setInfo("The Second Message!");
    t1.setDate("");
    testMapper.insertSelective(t1);
   
    if(exception) {
      throw new RuntimeException();
    }

    Test t2 = new Test();
    t2.setInfo("The Third Message!");
    t2.setDate("");
    testMapper.insertSelective(t2);
  }

  public int selectTotalCount() {
    Integer count = testMapper.selectTotalCount();
    return count == null ? 0 : count.intValue();
  }

  @Autowired
  private TestMapper testMapper;
}
