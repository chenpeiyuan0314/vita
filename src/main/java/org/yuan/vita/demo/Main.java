package org.yuan.vita.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
  
  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml"); 
    Hello hello = ctx.getBean("hello", Hello.class);
    hello.println();
  }

}
