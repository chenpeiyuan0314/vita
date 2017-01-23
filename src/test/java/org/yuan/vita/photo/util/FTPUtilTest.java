package org.yuan.vita.photo.util;

import java.io.File;

import org.junit.Test;
import org.junit.Assert;

public class FTPUtilTest {

  @Test
  public void testFile() throws Exception {
    System.out.println(new File("demo.txt").getCanonicalPath());
    // ==> E:\java\vita\demo.txt
  }

  @Test
  public void testUpload() {
    String filePath = "pom.xml";
    String dirPath = "/test";
    String fileName = "pom.xml";

    boolean exists = false;

    FTPUtil.upload(filePath, dirPath, fileName);
    exists = FTPUtil.exists(dirPath, fileName);
    Assert.assertTrue(exists);

    FTPUtil.delete(dirPath, fileName);
    exists = FTPUtil.exists(dirPath, fileName);
    Assert.assertFalse(exists);

    FTPUtil.delete(dirPath);
    exists = FTPUtil.exists(dirPath);
    Assert.assertFalse(exists);
  }

  @Test
  public void testExists() {
    boolean exists = false;
    String dirPath = "test1";

    exists = FTPUtil.exists(dirPath);
    Assert.assertFalse(exists);

    FTPUtil.create(dirPath);

    exists = FTPUtil.exists(dirPath);
    Assert.assertTrue(exists);

    FTPUtil.delete(dirPath);

    exists = FTPUtil.exists(dirPath);
    Assert.assertFalse(exists);
  }

}
