<%@include file="master.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Data Edit</title>
</head>
<body>
<h1>Welcome to Customer Data Edit Page</h1>

<form action="updatecust" method="post">
<pre>
Id: <input type="text" name="custId" value="${cust.custId}" readonly="readonly"/>
Code: <input type="text" name="custCode" value="${cust.custCode}"/>
Name: <input type="text" name="custName" value="${cust.custName}"/>
ContractTime:<input type="text" name="contrtime" value="${cust.contrtime}"/>
Percent:     <input type="text" name="percent" value="${cust.percent}"/>
Mode: <c:choose>
<c:when test="${cust.custMode eq 'Enabled'}">
<input type="radio" name="custMode" value="Enabled" checked="checked">Enabled
<input type="radio" name="custMode" vlaue="Disabled">Disabled
</c:when>
<c:otherwise>
<input type="radio" name="custMode" value="Enabled" >Enabled
<input type="radio" name="custMode" vlaue="Disabled" checked="checked">Disabled
</c:otherwise> 
</c:choose>
Email: <input type="text" name="custEmail" value="${cust.custEmail}"/>
CustomerType:<select name="custType">
<option value="--cust type--">cust_type</option>
<option value="Consumer">Consumer</option>
<option value="Seller">Seller</option>
</select>
CustomerAddress: <input type="text" name="custAddr" value="${cust.custAddr}"/>
CustomerDesc:    <input type="text" name="custDesc" value="${cust.custDesc}"/>
    
                     <input type="submit" name="update" />
</pre>
</form>
      <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>