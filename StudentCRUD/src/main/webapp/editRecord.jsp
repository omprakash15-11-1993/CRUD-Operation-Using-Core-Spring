<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ page import="com.abc.dto.*" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Record Page</title>
</head>
<body bgcolor="green">
<br><br>
<%! Student student; %>
<%  student=(Student) request.getAttribute("student"); %>

<center>
<form action="./controller" method="post">
<table>

<tr>
<td>SID </td>
<td><%=student.getSid() %> </td>
<td><input type="hidden" name="sid" value=<%=student.getSid() %>> </td>
</tr>

<tr>
<td>SNAME </td>
<td> <input type="text" name="snane" value=<%=student.getSname() %>></td>
</tr>

<tr>
<td>SAGE </td>
<td><input type="text" name="sage" value=<%=student.getSage() %>> </td>
</tr>

 <tr>
<td>SADDRESS </td>
<td><input type="text" name="saddress" value=<%=student.getSaddress() %>> </td>
 </tr>
 
 <tr>
<td> </td>
<td><input type="Submit" value="edit" name="action"> </td>
 </tr>
 
 
 
</table>
</form>

</center>

</body>
</html>