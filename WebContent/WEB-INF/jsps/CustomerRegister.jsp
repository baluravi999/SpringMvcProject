<%@include file="master.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Register</title>
</head>
<body>

<form action="saveCustomer" method="post">
<pre>
CustomerId:          <input type="text" name="custId"/>
CustomerCode:        <input type="text" name="custCode"/>
CustomerName:        <input type="text" name="custName"/>
CustomerContractTime:<input type="text" name="contrtime"/>
CustomerPercent:     <input type="text" name="percent"/>
CustomerMode:        <input type="radio" name="custMode" value="Enabled" />Enabled<input type="radio" name="custMode" value="Disabled" />Disabled
CustomerEmail:       <input type="text" name="custEmail"/>
CustomerType:        <select name="custType">
<option value="custType">cust_type</option>
<option value="Consumer">Consumer</option>
<option value="Seller">Seller</option>
</select>
CustomerAddress:     <input type="text" name="custAddr"/>
CustomerDesc:        <input type="text" name="custDesc"/>
    
                     <input type="submit" name="save" /> <input type="reset" name="clear"/>

</pre>
</form>
      <jsp:include page="footer.jsp"></jsp:include>
${msg}
</body>
</html>