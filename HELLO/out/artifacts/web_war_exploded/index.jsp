<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta http-equiv="content-type" content="text/html" charset="UTF-8">
  <title>login</title>
</head>
<body>
<div align="center"><h1>login in</h1>

  <form  method="post" action="MaServlet" name="login form" align="center">
    <table align="center" width="232" border="2">
      <tr>
        <td>Username</td>
        <td><input type="text" name="username"></td>
      </tr>
      <tr>
        <td>Password</td>
        <td><input type="text" name="password"></td>
      </tr>
    </table>
    <input type="submit" value="Submit" name="Submit">

  </form>

</div>

</body>
</html>