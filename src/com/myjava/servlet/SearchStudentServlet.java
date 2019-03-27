package com.myjava.servlet;

import com.myjava.bean.Student;
import com.myjava.bean.service.StudentService;
import com.myjava.bean.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: wufan
 * @Date: 2019/3/27 10:19
 * @Version 1.0
 */
@WebServlet(name = "SearchStudentServlet")
public class SearchStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            String sname=  request.getParameter("sname");
            String sgender=  request.getParameter("sgender");
            System.out.println("接受到的数据为sgender："+sgender);
            //Student dao = new StudentDaoImpl()
            StudentService service = new StudentServiceImpl();
            List<Student> list = service.notfindall(sname,sgender);
            System.out.println("searching student ");
            request.setAttribute("list",list);
            request.getRequestDispatcher("list.jsp").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
