<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Item Data Edit</title>
</head>
<body>

<h1>Welcome to Item Data Edit page</h1>
<form action="updateItem" method="post">
<pre>
Id: <input type="text" name="itemId" value="${item.itemId}" readonly="readonly"/>
Name: <input type="text" name="itemName" value="${item.itemName}"/>
Cost: <input type="text" name="baseCost" value="${item.baseCost}"/>
<%-- Code: <input type="text" name="itemCode" value="${item.itemCode}"/>
Barcode: <input type="text" name="barCode" value="${item.barCode}"/>
Discount: <input type="text" name="maxDiscount" value="${item.maxDiscount}"/>
Mfg: <input type="text" name="mfg" value="${item.mfg}"/> --%>
<input type="submit" value="update" />
</pre>

</form> 
      <jsp:include page="footer.jsp"></jsp:include>

</body>
</html>