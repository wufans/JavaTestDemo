package com.myjava.servlet;

import com.myjava.bean.service.StudentService;
import com.myjava.bean.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Author: wufan
 * @Date: 2019/3/26 23:47
 * @Version 1.0
 */
@WebServlet(name = "DeleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收id
        int sid = Integer.parseInt(request.getParameter("sid"));

        //2. 执行删除
        StudentService service = new StudentServiceImpl();
        try {
            service.delete(sid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //3. 跳转到列表页。
        request.getRequestDispatcher("StudentServlet").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
