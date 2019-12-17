package mybatis.service.impl;

import mybatis.domain.Student;
import mybatis.mapper.StudentMapper;
import mybatis.service.StudentServer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * User: jianjie
 * Date: 16-5-17 下午6:35
 */
@Service("studentServer")
public class StudentServerImpl implements StudentServer {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public void insert() {
        Student student = new Student();
        student.setName(UUID.randomUUID().toString());
        student.setAge(new Random().nextInt(22));
        student.setVersion(new Random().nextInt(22));
        studentMapper.insert(student);
        System.out.println("insert student success! id = " + student.getId());
        studentMapper.delete("a");
    }

    @Override
    public Student query(String name) {
        return studentMapper.queryName(name);
    }

    @Override
    public List<Student> listStudent(Map map) {
        return studentMapper.listStudent(map);
    }

    @Override
    public int update(Student student) {
        return studentMapper.update(student);
    }

}
