<%--
  Created by IntelliJ IDEA.
  User: devil
  Date: 11/30/2019
  Time: 10:13 PM
  To change this template use File | Settings | File Templates.
--%>

<%--
  Created by IntelliJ IDEA.
  User: devil
  Date: 11/30/2019
  Time: 8:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>

<html>
<head>
    <title>Quiz App</title>
</head>
<body>
<form method="post" action="Quiz">
    <h2><b>The Number Quiz</b></h2>
    <p>Your current score is ${score}</p>
    <p>Guess the next number in the sequence</p>
    ${question1},${question2},${question3},${question4},${question5}
    <br/>
    <br/>
    Your Answer: <input type="text" name="answer">
    <br/>
    <br/>
    <input type="SUBMIT">
</form>
</body>
</html>

