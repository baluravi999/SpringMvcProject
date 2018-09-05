<%@include file="master.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Item Register</title>
</head>
<body>
<form action="saveItem" method="post">
<pre>
ID: <input type="text" name="itemId"/>
Name:<input type="text" name="itemName"/>
Cost:<input type="text" name="baseCost"/>
<!-- Code:<input type="text" name="itemCode"/>
BarCode:<input type="text" name="barCode"/>
Discount:<input type="text" name="maxDiscount"/>
Mfg:<input type="text" name="mfg"/>
 -->
<input type="submit" value="register"/>

</pre>
</form>
      <jsp:include page="footer.jsp"></jsp:include>
${msg}
</body>
</html>