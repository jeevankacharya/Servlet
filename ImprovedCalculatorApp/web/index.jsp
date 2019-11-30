<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<%--value=${addvalue}--%>

<body>
<h1 align="center">Improved Calculator</h1>
<form method="POST"
      action="SimpleCalculator.do">
    <p>
    <input type="number" name="add1" value="0"> +
    <input type="number" name="add2" value="0"> = <input value = "${addvalue}" readonly>
    <br>
    <br>
    <input type="number" name="mul1" value="1"> *
    <input type="number" name="mul2" value="1"> = <input value="${mulvalue}" readonly>
    <br>
    <br/>
    <br/>
        <input type="SUBMIT">
</form>
</body>
</html>

