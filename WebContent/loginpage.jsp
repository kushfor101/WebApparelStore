<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="login">
		<table>
			<tr>
				<td>UserName</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form>
	<form method="post" action="registerpage.jsp">
		<table>
			<tr>
				<td><input type="submit" value="New User Register"></td>
			</tr>
			<tr>
				<td> <%	 if(request.getAttribute("loginerror")!=null){
					out.println("User Does Not Exist");
					request.setAttribute("loginerror",null);
					} %> </td>
			</tr>
		</table>
	</form>
</body>
</html>