package com.myjava.dao.impl;

import com.myjava.bean.Student;
import com.myjava.dao.StudentDao;
import com.myjava.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wufan
 * @Date: 2019/2/25 10:29
 * @Version 1.0
 */
public class StudentDaoImpl implements StudentDao {

    /*查询所有学生*/
    @Override
    public List<Student> findall() throws SQLException {
        System.out.println("running StudentDaoImpl-findall()");
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "SELECT * FROM stu";
        List<Student> list = runner.query(sql,new BeanListHandler<>(Student.class));
        return list;
    }

    @Override
    public void insert(Student student) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());

        runner.update("insert into stu values(null , ?,?,?,?,?,?)" ,
                student.getSname(),
                student.getGender(),
                student.getPhone(),
                student.getBirthday(),
                student.getHobby(),
                student.getInfo()
        );
    }

    @Override
    public void delete(int sid) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        runner.update("delete from stu where sid=?" ,sid);
    }

    @Override
    public List<Student> notfindall(String sname, String sgender) throws SQLException {
        System.out.println("现在要执行模糊查询了，收到的name ="+sname + "==genser=="+sgender);

        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());

        //String sql = "select * from stu where sname=? or sgender=?";

        /*
         * 这里要分析一下：
         * 	如果只有姓名 ，select * from stu where sname like ? ;
         * 	如果只有性别 ， select * from stu where gender = ?
         *
         * 如果两个都有 select * from stu where sname like ? and gender=?
         *
         * 如果两个都没有就查询所有。
         *
         */
        String sql = "select * from stu where 1=1 ";
        List<String> list = new ArrayList<String>();

        //判断有没有姓名， 如果有，就组拼到sql语句里面
        if(!isEmpty(sname)){
            sql = sql + "  and sname like ?";
            list.add("%"+sname+"%");
        }

        //判断有没有性别，有的话，就组拼到sql语句里面。
        if(!isEmpty(sgender)){
            sql = sql + " and gender = ?";
            list.add(sgender);
        }


        return runner.query(sql , new BeanListHandler<Student>(Student.class) ,list.toArray() );
    }
    public static boolean isEmpty(CharSequence s){
        return s==null || s.length() == 0;
    }
}
