package com.myjava.servlet;

import com.myjava.bean.Student;
import com.myjava.bean.service.StudentService;
import com.myjava.bean.service.impl.StudentServiceImpl;
import com.myjava.dao.impl.StudentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: wufan
 * @Date: 2019/2/25 10:23
 * @Version 1.0
 */
@WebServlet(name = "StudentServlet")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Connection conn =

        try {
            //Student dao = new StudentDaoImpl()
            StudentService service = new StudentServiceImpl();
            List<Student> list = service.findall();
            System.out.println("here");
            request.setAttribute("list",list);
            request.getRequestDispatcher("list.jsp").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
