<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="master.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Documents</title>
</head>
<body>
<h1>Welcome to Documents Page</h1>
<form action="uploadDoc" method="post" enctype="multipart/form-data">
<pre>
Id:<input type="text" name="fileId"/>
Doc:<input type="file" name="fileOb"/>
<input type="submit" value="UPLOAD">
</pre>
</form>
<hr/>
<table border="1">
<tr><th>ID</th><th>NAME</th><th>LINK</th></tr>
<c:forEach items="${list}" var="ob">
<tr>
<td><c:out value="${ob[0]}"/></td>
<td><c:out value="${ob[1]}"/></td>
<td><a href="downloadDoc?docId=${ob[0]}">Download</a></td>
</tr>
</c:forEach>
</table>
      <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>