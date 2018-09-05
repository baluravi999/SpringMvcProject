<%@include file="master.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RegisterLocation</title>
</head>
<body>
<form action="saveLoc" method ="post">
<pre>
ID:  <input type="text" name="locId" />
Code:<input type="text" name="locCode"/>
Name:<input type="text" name="locName"/>
Type:<input type="radio" name ="locType" value="Rural" >Rural<input type="radio" name ="locType" value="Urban" >Urban

     <input type="submit" value="Insert" /> <input type= "reset" value="clear" />
</form>
      <jsp:include page="footer.jsp"></jsp:include>
${msg}
</body>
</html>