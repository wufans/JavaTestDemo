package com.myjava.bean.service.impl;

import com.myjava.bean.Student;
import com.myjava.bean.service.StudentService;
import com.myjava.dao.StudentDao;
import com.myjava.dao.impl.StudentDaoImpl;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: wufan
 * @Date: 2019/2/25 11:26
 * @Version 1.0
 */
/*学生类业务实现*/
public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> findall() throws SQLException {
        StudentDao dao = new StudentDaoImpl();
        return dao.findall();
    }

    @Override
    public void insert(Student student) throws SQLException {
        StudentDao dao= new StudentDaoImpl();
        dao.insert(student);
    }

    @Override
    public void delete(int sid) throws SQLException {
        StudentDao dao= new StudentDaoImpl();
        dao.delete(sid);
    }

    @Override
    public List<Student> notfindall(String sname, String sgender) throws SQLException {
        StudentDao dao = new StudentDaoImpl();
        return dao.notfindall(sname,sgender);
    }
}
