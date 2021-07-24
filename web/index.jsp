<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 4/24/2021
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Home</title>
  </head>
  <body>
  <form name="frmLogin" method="POST" action="http://localhost:8080/connect_mysql_war_exploded/LoginServlet">
    <table>
      <tr>
        <td>Username</td>
        <td><input type="text" name="username"></td>
      </tr>
      <tr>
        <td>Password</td>
        <td><input type="text" name="password"></td>
      </tr>
      <tr>
        <td colspan="2"><button type="submit">Login</button></td>
      </tr>
    </table>
  </form>
  </body>
</html>
