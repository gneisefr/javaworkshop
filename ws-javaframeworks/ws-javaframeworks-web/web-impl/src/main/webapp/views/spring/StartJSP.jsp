<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3> Hallo, meine erste JSP-Seite meldet sich. </h3>
    <p> <%= request.getLocalAddr() %> </p>
    <p> <%= (new SimpleDateFormat("yyyy-MM-dd, HH:mm:ss")).format(new Date()) + " h" %> </p>
    <p> <a href='<%=request.getContextPath()%>/spring/'>zur&uuml;ck</a> </p>
</body>
</html>