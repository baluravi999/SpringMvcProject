<%@include file="master.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Location Data</title>
<style type="text/css">
table tr th{
color: white;
background-color: black;
}
</style>
</head>
<body>
<h1>Welcome to Location Data</h1>
<a href="locExcel">Excel Export</a> | <a href="locPdf">PDF Export</a>
<table border="1">
<tr>
<th>ID</th>
<th>code</th>
<th>name</th>
<th>type</th>
<th>operation</th>
</tr>
<c:forEach items="${locs}" var="loc">
<tr>
<td><c:out value="${loc.locId}"/>
<td><c:out value="${loc.locCode}"/>
<td><c:out value="${loc.locName}"/>
<td><c:out value="${loc.locType}"/>
<td><a href="delLocation?locId=${loc.locId}">
<img src="../images/delete.jfif" width="15" height="15"/>
</a>
<a href="editLocation?locId=${loc.locId}">
<img src="../images/edit.png" width="15" height="15"/>
</a>
</td>
</tr>
</c:forEach>
</table>

      <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>