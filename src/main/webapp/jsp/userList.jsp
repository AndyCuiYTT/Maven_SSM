<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">

	td{
		width: 50px;
		text-align: center;
	}
</style>
</head>

<body>
	<table>
		<c:forEach items="${users }" var="user">
			<tr>
				<td><c:out value="${user.id }"/></td>
				<td><c:out value="${user.name }"/></td>
				<td><c:out value="${user.age }"/></td>
				<td><c:out value="${user.password }"/></td>
			</tr>
		</c:forEach>
	</table> 
</body>
</html>