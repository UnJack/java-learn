package org.learn.mybatis.mapper;

import mybatis.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * User: jimjian
 * Date: 16-6-23 下午5:11
 */
public interface StudentMapper {

    int insert(Student student);

    //@Param与#{}中的对应
    Student queryName(@Param("name") String name);
    Student getName(@Param("name") String name);

    List<Student> queryList();

    void delete(@Param("name") String name);

    List<Student> listStudent(Map<String, String> map);

    int update(Student student);
}
