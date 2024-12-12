package org.learn.mybatis;

import mybatis.domain.Student;
import mybatis.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * User: jimjian
 * Date: 16-4-8 下午4:24
 */
public class test_Mybatis {

    public static void main(String[] args) throws IOException {
        String resource = "mybatis/mybatis-configs.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = ssf.openSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        try {
//            insert(studentMapper);
//            query(studentMapper);
            selectOne(studentMapper);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void selectOne(StudentMapper studentMapper) {
//        Student student = studentMapper.queryName("441004fb-ecaf-42a1-947b-f0156d60625e");
        Student student = studentMapper.queryName("89a59fe3-1b7a-4214-b098-4ad09bf8b6c7 and id =11");
        System.out.println(student);
    }

    public static void query(StudentMapper studentMapper) {
        List<Student> list = studentMapper.listStudent(null);
        for (Student student : list)
            System.out.println(student);
    }

    public static void insert(StudentMapper studentMapper) {
        Student student = new Student();
        student.setName(UUID.randomUUID().toString());
        student.setAge(24);
        student.setDate(new Date());
        System.out.println("student插入前id = " + student.getId());
        studentMapper.insert(student);
        System.out.println("student插入后id = " + student.getId());
    }

}
