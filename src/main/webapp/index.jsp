<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>插入信息</title>
</head>
<body>
	<form action="user/insertUser">
		<label>姓名</label><input type="text" name="userName"><br>
		<label>年龄</label><input type="text" name="age"><br>
		<label>密码</label><input type="password" name="password"><br>
		<input type="submit" value="提交">	
	</form>

<a href="user/getAllUsers">获取全部信息</a>


</body>
</html>