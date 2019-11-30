<%--
  Created by IntelliJ IDEA.
  User: 610556
  Date: 11/29/2019
  Time: 2:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--  <head>--%>
<%--    <title>$Title$</title>--%>
<%--  </head>--%>
<%--  <body>--%>
<%--  $END$--%>
<%--  </body>--%>
<%--</html>--%>
<html>

<body>
<h1 align="center">Beer Selection Page</h1>
<form method="POST"
      action="SelectBeer.do">
  Select beer characteristics<p>
  Color:
  <select name="color" size="1">
    <option value="light">light</option>
    <option value="amber">amber</option>
    <option value="brown">brown</option>
    <option value="dark">dark</option>
  </select>
  <br/>
  <br/>
  <center>
    <input type="SUBMIT">
  </center>
</form>
</body>
</html>