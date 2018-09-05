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
<!-- <th>code</th>
<th>barCode</th>
<th>discount</th>
<th>mfg</th>
<th>CustId</th>
<th>operation</th> -->
</tr>

<c:forEach items="${items}" var="item">
<tr>
<td><c:out value="${item.itemId}"/>
<td><c:out value="${item.itemName}"/>
<td><c:out value="${item.baseCost}"/>
<%-- <td><c:out value="${item.itemCode}"/>
<td><c:out value="${item.barCode}"/>
<td><c:out value="${item.maxDiscount}"/>
<td><c:out value="${item.mfg}"/>
<td><c:out value="${item.custId}"/> --%>

</tr>
</c:forEach>
</table>
      <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>