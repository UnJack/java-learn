package org.learn.mybatis.service;

import mybatis.domain.Student;

import java.util.List;
import java.util.Map;

/**
 * User: jimjian
 * Date: 16-5-17 下午6:35
 */
public interface StudentServer {
    void insert();

    Student query(String name);

    List<Student> listStudent(Map map);

    int update(Student student);
}
