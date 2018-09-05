<%@include file="master.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Data</title>
<style type="text/css">
table tr th{
color: white;
background-color: black;
}
</style>
</head>

<body>
<h1>Welcome to customer Data</h1>

<table border="1">
<tr>
<th>ID</th>
<th>code</th>
<th>name</th>
<th>ctime</th>
<th>perc</th>
<th>mode</th>
<th>email</th>
<th>type</th>
<th>address</th>
<th>description</th>
<th>items/orders</th>
<th>operation</th>
</tr>
<c:forEach items="${custs}" var="cust">
<tr>
<td><c:out value="${cust.custId}"/>
<td><c:out value="${cust.custCode}"/>
<td><c:out value="${cust.custName}"/>
<td><c:out value="${cust.contrtime}"/>
<td><c:out value="${cust.percent}"/>
<td><c:out value="${cust.custMode}"/>
<td><c:out value="${cust.custEmail}"/>
<td><c:out value="${cust.custType}"/>
<td><c:out value="${cust.custAddr}"/>
<td><c:out value="${cust.custDesc}"/>
<td>
<c:choose>
<c:when test="${'Seller' eq  cust.custType}">
<td>
<a href="getCustItems?custId=${cust.custId}">get all items</a>
</td>
</c:when>

<c:otherwise>
<td>
<a href="getCustOrders?custId=${cust.custId}">get all orders</a>
</td>
</c:otherwise>
</c:choose>

<td><a href="delCustomer?custId=${cust.custId}">
<img src="../images/delete.jfif" width="15" height="15"/>
</a>
<a href="editCustomer?custId=${cust.custId}">
<img src="../images/edit.png" width="15" height="15"/>
</a>
</td>
</tr>
</c:forEach>
</table>
      <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>