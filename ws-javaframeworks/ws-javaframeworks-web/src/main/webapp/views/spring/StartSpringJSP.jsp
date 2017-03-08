<%@page import="de.pentasys.ws.javaframeworks.web.servlets.StartBeanJSP"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="StartBeanJSP"
		class="de.pentasys.ws.javaframeworks.web.MySpringApp">
	</jsp:useBean>
	<h3>Hallo, meine JSP-Seite mit JavaBean meldet sich.</h3>
	<jsp:getProperty property="dateString" name="StartBeanJSP" />
	<p>
		<a href='<%=request.getContextPath()%>/spring/'>zur&uuml;ck</a>
	</p>
</body>
</html>