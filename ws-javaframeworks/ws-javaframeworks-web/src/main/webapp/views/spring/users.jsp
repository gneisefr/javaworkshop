<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Benutzer</title>
</head>
<body>
	<h1>Benutzer editieren</h1>
	<c:url var="addAction" value="/spring/users/
create/"></c:url>

	<form:form action="${addAction}" commandName="user">
		<table>
			<c:if test="${!empty user.id}">
				<tr>
					<td><form:hidden path="id" /></td>
				</tr>
			</c:if>
			<tr>
				<td><form:label path="name">
						<spring:message text="Name" />
					</form:label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="firstname">
						<spring:message text="Vorname" />
					</form:label></td>
				<td><form:input path="firstname" /></td>
			</tr>
			<tr>
				<td><form:label path="email">
						<spring:message text="E-Mail" />
					</form:label></td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td><form:label path="password">
						<spring:message text="Password" />
					</form:label></td>
				<td><form:password path="password" showPassword="true" /></td>
			</tr>
			<tr>
				<td><form:label path="active">
						<spring:message text="Aktiv" />
					</form:label></td>
				<td><form:checkbox path="active" /></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty user.id}">
						<input type="submit" value="<spring:message text="Ändern"/>" />
					</c:if> <c:if test="${empty user.id}">
						<input type="submit" value="<spring:message text="Erstellen"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
	<br>
	<h3>Liste der Benutzer</h3>
	<c:if test="${!empty listUsers}">
		<table class="tg">
			<tr align="left">
				<th width="%APP.VERSION%">Name</th>
				<th width="%APP.VERSION%">Vorname</th>
				<th width="60">E-Mail</th>
				<th width="60">Aktiv</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${listUsers}" var="user">
				<tr>
					<td>${user.name}</td>
					<td>${user.firstname}</td>
					<td>${user.email}</td>
					<td>${user.active}</td>
					<td><a href="<c:url value='/spring/edit/${user.id}' />">Edit</a></td>
					<td><a href="<c:url value='/spring/remove/${user.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<p>
		<a href='<%=request.getContextPath()%>/spring/'>zur&uuml;ck</a>
	</p>
</body>
</html>