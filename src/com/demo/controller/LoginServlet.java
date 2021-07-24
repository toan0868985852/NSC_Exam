package com.demo.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (Exception e) {}
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        boolean success = false;
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String query = "SELECT * FROM user WHERE username = '" + username +"' and password = " + password;
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/t1908a_security","root","") ;
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                success = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                stmt.close();
                conn.close();
            }catch (Exception e){}
        }
        if (success){
            response.sendRedirect("home.jsp");
        }else{
            response.sendRedirect("index.jsp");
        }
    }
}
