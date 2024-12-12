package org.learn.mybatis;

import mybatis.domain.Student;
import mybatis.service.StudentServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * User: jimjian
 * Date: 16-1-21 下午3:42
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:mybatis/spring_mybatis/spring-mybatis.xml"})
public class test_MyTransactionService {

    @Autowired
    private StudentServer studentServer;

    @Test
    public void test1() {
        studentServer.insert();
    }

    @Test
    public void test2() {
        System.out.println("result:" + studentServer.query("66cc22146d204c38abcea5f2ef659c0e"));
    }

    @Test
    public void test3() {
        Map<String, String> map = new HashMap();
//        map.put("name", "c6e667e14f2649abad61eb47623b7e6a");
//        map.put("age", "1");
        map.put("dateBegin", "2016-12-12 18:05:50");
        map.put("dateEnd", " 2016-12-12 18:06:58");
        System.out.println(studentServer.listStudent(map));
    }

    @Test
    public void test4() {
//        UPDATE student SET
//        name = #{name, jdbcType=VARCHAR} ,
//        age = #{age, jdbcType=INTEGER} ,
//        date = #{date, jdbcType=TIMESTAMP} ,
//        version=version+1
//        WHERE
//        id = #{id} AND version = #{version}
        // 乐观锁： 提交版本大于记录版本
        Student student1 = studentServer.query("57407e6d-be72-4016-a670-613fe8200550");
        Student student2 = studentServer.query("57407e6d-be72-4016-a670-613fe8200550");
        System.out.println(student1);
        System.out.println(student2);
        int i1 = studentServer.update(student1);
        int i2 = studentServer.update(student2);
        System.out.println("修改1:" + (i1 == 1 ? "成功" : "失败"));
        System.out.println("修改2:" + (i2 == 1 ? "成功" : "失败"));
    }
}
