<%@include file="master.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vendor Register</title>
</head>
<body>
<form action="saveVendor" method="post" enctype="multipart/form-data">
<pre>
VendorId:     <input type="text" name="venId"/>
VendorCode:   <input type="text" name="venCode"/>
VendorName:   <input type="text" name="venName"/>
VendorType:   <input type="radio" name="venType" value="regualar"/>Regular<input type="radio" name="venType" value="contract"/>Contract
VendorEmail:  <input type="text" name="venEmail"/>
VendorContact:<input type="text" name="venContact"/>
VendorAddress:<input type="text" name="venAddr"/>
Select:<input type="file" name="fObj"/>
              <input type="submit" name="save"/><input type="reset" name="clear"/>           
</pre>
</form>
      <jsp:include page="footer.jsp"></jsp:include>
${msg}
</body>
</html>