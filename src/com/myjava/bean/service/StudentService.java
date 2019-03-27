package com.myjava.bean.service;

import com.myjava.bean.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: wufan
 * @Date: 2019/2/25 11:25
 * @Version 1.0
 */
public interface StudentService {
    public List<Student> findall() throws SQLException;

    void insert(Student student) throws SQLException;

    void delete(int sid) throws SQLException;

    List<Student> notfindall(String sname, String sgender) throws SQLException;
}
