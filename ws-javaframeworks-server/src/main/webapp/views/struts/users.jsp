<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%-- Using Struts2 Tags in JSP --%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Benutzer</title>
</head>
<body>
	<h1>Benutzer editieren</h1>
	<c:url var="addAction" value="users"></c:url>

	<s:form action="createUser">
		<table>
			<c:if test="${!empty user.id}">
				<tr>
					<td><s:hidden key="user.id" name="user.id"/></td>
				</tr>
			</c:if>
			<tr>
				<td><s:textfield key="user.name" name="user.name" label="Name">
					</s:textfield></td>
			</tr>
			<tr>
				<td><s:textfield key="user.firstname" name="user.firstname"
						label="Vorname">
					</s:textfield></td>
			</tr>
			<tr>
				<td><s:textfield key="user.email" name="user.email"
						label="E-Mail">
					</s:textfield></td>
			</tr>
			<tr>
				<td><s:password showPassword="true" key="user.password"
						name="user.password" label="Passwort">
					</s:password></td>
			</tr>
			<tr>
				<td><s:checkbox showPassword="true" key="user.active"
						name="user.active" label="Aktiv" labelposition="left">
					</s:checkbox></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty user.id}">
						<input type="submit" value="Ändern" />
					</c:if> <c:if test="${empty user.id}">
						<input type="submit" value="Erstellen" />
					</c:if></td>
			</tr>
		</table>
	</s:form>
	<br>
	<h3>Users List</h3>
	<c:if test="${!empty users}">
		<table class="tg">
			<tr align="left">
				<th width="%APP.VERSION%">Name</th>
				<th width="%APP.VERSION%">Vorname</th>
				<th width="60">E-Mail</th>
				<th width="60">Aktiv</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.name}</td>
					<td>${user.firstname}</td>
					<td>${user.email}</td>
					<td>${user.active}</td>
					<s:url action="editUser.action" var="userId">
						<s:param name="userId" >${user.id}</s:param>
					</s:url>
					<td><a href="<s:property value="#userId" />" >Edit</a></td>
					<s:url action="deleteUser.action" var="userId">
						<s:param name="userId" >${user.id}</s:param>
					</s:url>
					<td><a href="<s:property value="#userId" />" >Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>