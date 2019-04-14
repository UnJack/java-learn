package com.java.base.spring;

import com.java.base.mybatis.domain.Student;
import com.java.base.mybatis.service.StudentServer;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @create by jianjie on 2017/11/05 11:17
 **/
public class test {
//    public static void main(String[] args) {
//        ClassPathXmlApplicationContext classPathXmlApplicationContext=new ClassPathXmlApplicationContext("classpath:mybatis/spring_mybatis/spring-mybatis.xml");
//        StudentServer studentServer= (StudentServer) classPathXmlApplicationContext.getBean("studentServer");
//        for(Student student:studentServer.listStudent(null)){
//            System.out.println("student = " + student);
//        }
////        ClassPathResource classPathResource = new ClassPathResource("./spring-mybatis.xml");
////        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
////        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
////        xmlBeanDefinitionReader.loadBeanDefinitions(classPathResource);
//
//    }
//



    public static void main(String[] args) {
//        a a1 = new a();
//        a1.say();
    }
}

class a {
    public void say() {
        System.out.println("asdasdasd");
    }
}