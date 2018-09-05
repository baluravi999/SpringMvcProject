<%@include file="master.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vendor Data</title>
<style type="text/css">
table tr th{
color: white;
background-color: black;
}
</style>
</head>
<body>
<h1>Welcome to Vendor Data</h1>
<a href="venExcel">Excel Export</a> | <a href="venPdf">PDF Export</a>
<table border="1">
<tr>
<th>ID</th>
<th>code</th>
<th>name</th>
<th>type</th>
<th>email</th>
<th>contact</th>
<th>Address</th>
<th>operation</th>
</tr>

<c:forEach items="${vens}" var="ven">
<tr>
<td><c:out value="${ven.venId}"/>
<td><c:out value="${ven.venCode}"/>
<td><c:out value="${ven.venName}"/>
<td><c:out value="${ven.venType}"/>
<td><c:out value="${ven.venEmail}"/>
<td><c:out value="${ven.venContact}"/>
<td><c:out value="${ven.venAddr}"/>
<td><a href="delVendor?venId=${ven.venId}">
<img src="../images/delete.jfif" width="15" height="15"/>
</a>
<a href="editVendor?venId=${ven.venId}">
<img src="../images/edit.png" width="15" height="15"/>
</a>
</td>
</tr>
</c:forEach>
</table>
      <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>