<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set var="context"><%=request.getContextPath()%></c:set>
<c:set var="springcontext">${context}/spring</c:set>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Workshop Java Frameworks %APP.VERSION%</title>
</head>
<body>
	<p>
		<a href="${springcontext}/StartServlet">${springcontext}/StartServlet</a>
	</p>
	<p>
		<a href="${springcontext}/SpringServlet">${springcontext}/SpringServlet</a>
	</p>
	<p>
		<a href="${springcontext}/StartJSP">${springcontext}/StartJSP</a>
	</p>
	<p>
		<a href="${springcontext}/StartJavaBeanJSP">${springcontext}/StartJavaBeanJSP</a>
	</p>
	<p>
		<a href="${springcontext}/users">${springcontext}/users</a>
	</p>
</body>
</html>