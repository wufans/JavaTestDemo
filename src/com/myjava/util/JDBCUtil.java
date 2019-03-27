package com.myjava.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author: wufan
 * @Date: 2019/2/25 10:43
 * @Version 1.0
 */
public class JDBCUtil {
    static ComboPooledDataSource dataSource = null;
    static{
        dataSource = new ComboPooledDataSource();
    }
    public static DataSource getDataSource(){
        return dataSource;
    }
    /*
    * 获取连接
    **/
    public static Connection getCoun() throws SQLException {
        return dataSource.getConnection();
    }
    /*
    * 释放连接*/
    public static void release(Connection conn, Statement st, ResultSet rs){
        try{
            if(conn!=null){
                conn.close();
            }
            if(st!=null) {
                st.close();
            }
            if(rs != null){
                rs.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            conn = null;
            st = null;
            rs = null;
        }
    }

}
