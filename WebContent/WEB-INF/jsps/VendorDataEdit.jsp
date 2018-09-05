<%@include file="master.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vendor Data Edit</title>
</head>
<body>
<h1>Welcome to vendor data edit page</h1>
<form action="updateVen" method="post">
<pre>
Id: <input type="text" name="venId" value="${ven.venId}" readonly="readonly"/>
Code: <input type="text" name="venCode" value="${ven.venCode}"/>
Name: <input type="text" name="venName" value="${ven.venName}"/>
Type:<c:choose>
     <c:when test="${ven.venType eq 'regular'}">
     <input type="radio" name="venType" value="regular" checked="checked">Regular
     <input type="radio" name="venType" value="contract">Contract
     </c:when>
     <c:otherwise>
     <input type="radio" name="venType" value="regular">Regular
     <input type="radio" name="venType" value="contract" checked="checked">Contract
     </c:otherwise>
     </c:choose>
Email: <input type="text" name="venEmail" value="${ven.venEmail}"/>
Contact: <input type="text" name="venContact" value="${ven.venContact}"/>
Address: <input type="text" name="venAddr" value="${ven.venAddr}"/>
<input type="submit" value="update" />
</pre>

</form>
      <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>