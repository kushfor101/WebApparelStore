<%@page import="java.awt.print.Printable"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="register">
		<table>
			<tr>
				<td>UserName</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Sex</td>
				<td><select name="sex">
						<option value="male">Male</option>
						<option value="female">Female</option>
				</select></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>Preference</td>
				<td><select name="preference">
						<option value="no_pref">No Preference</option>
						<option value="new_pref">New Arrivals</option>
						<option value="disc_pref">Discounted Items</option>
				</select></td>
			</tr>
			<tr>
			<td>      </td>
			</tr>
			<tr>
				<td>     </td>
				<td><input type="submit" value="Register"></td>
			</tr>
			<tr>
				<td> <%	 if(request.getAttribute("regerror")!=null){
					out.println("User Already Exists");
					request.setAttribute("regerror",null);
					} %> </td>
			</tr>
		</table>
	</form>
</body>
</html>