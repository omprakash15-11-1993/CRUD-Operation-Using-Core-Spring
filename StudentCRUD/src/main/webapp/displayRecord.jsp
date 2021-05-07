<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.abc.dto.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OutPut Page</title>
</head>
<body bgcolor="grey">
<br/><br/>
<%!Student student; %>
<% student=(Student) request.getAttribute("student"); %>
<marquee>Welcome Your Record is Coming</marquee>
 <center>
 <table border="3" style="color:blue;">

 <tr>
 <td>SID </td>
 <td>
 <%= student.getSid() %>
  </td>
 </tr>
 
 <tr>
 <td>SNAME </td>
 <td>
 <%=student.getSname() %>
  </td>
 </tr>
 
 <tr>
 <td> SAGE</td>
 <td>
 <%=student.getSage() %>
  </td>
 </tr>
 
 <tr>
 <td>SADDRESS </td>
 <td>
 <%=student.getSaddress() %>
  </td>
 </tr>
 
 </table>
  </center>

</body>
</html>