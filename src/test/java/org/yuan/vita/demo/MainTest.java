package org.yuan.vita.demo;

import org.junit.Test;
import java.net.URL;

public class MainTest {
  
  @Test
  public void testMain() {
    Main.main(new String[0]);
  }
  
  @Test
  public void testResource() throws Exception {
    URL url = ClassLoader.getSystemResource("spring.xml");
    System.out.println(url.toURI().getPath());
  }

}
