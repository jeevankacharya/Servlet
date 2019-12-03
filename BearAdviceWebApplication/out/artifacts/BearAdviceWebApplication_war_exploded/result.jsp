<%--
  Created by IntelliJ IDEA.
  User: 610556
  Date: 12/3/2019
  Time: 1:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 align="center">Beer Recommendation JSP</h1>
<p>


    <%--    <% styles = (List) request.getAttribute("styles");--%>
    <%--//        Iterator it = styles.iterator();--%>
    <%--//        while (it.hasNext()) {--%>
    <%--//            out.println("<br> try: " + it.next());--%>
    <%--//        }--%>


    <%--    %>--%>
    <c:forEach var="item" items="${styles}">
        try:  ${item} <br>
    </c:forEach>


</p>
</body>
</html>
