<%@page import="model.user"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Books</title>
</head>
<body>

<%
user user =(user) session.getAttribute("Logged_In_User");
%>

<h3> Order Books</h3>

<form action= OrderBookServlet>
UserId:<input type="number" name="userid"  value="<%=user.getId() %>" readonly required />
<br/>

Select Book:
<select name="bookid" required>
<option value="1">Core Java</option>
<option value="2">MySQL</option>
</select>
<br/>

Quantity:<input type="number" name="quantity" min="1" required />
<br/>


<button type ="submit">Submit</button>

</form>
</body>
</html>