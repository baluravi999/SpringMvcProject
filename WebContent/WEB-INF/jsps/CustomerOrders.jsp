<%@include file="master.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Item Data</title>
<style type="text/css">
table tr th{
color: white;
background-color: black;
}
</style>
</head>
<body>
<h1>Welcome to Item Data</h1>
<table border="1">
<tr>
<th>ID</th>
<th>name</th>
<th>cost</th>
</tr>

<c:forEach items="${orders}" var="order">
<tr>
<td><c:out value="${order.ordId}"/>
<td><c:out value="${order.ordName}"/>
<td><c:out value="${order.ordCost}"/>

</tr>
</c:forEach>
</table>
      <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>