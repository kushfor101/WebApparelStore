<%@ page import="java.util.ArrayList" %>
<%@ page import="products.Product" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="billpage.jsp" >
	<table id = "tab1">
	<tr>
	<td align="center" >ID</td> 
	<td align="center" >Name</td>
	<td align="center" >Price</td>
	<td align="center" >Discount</td>
	<td align="center" >Type</td>
	
	</tr>
	
		<%  ArrayList<Product> list = (ArrayList<Product>)request.getAttribute("productlist");
			System.out.println("inin");
			int c=0;
			for(Product p : list) { %>
				<tr>
			 <td> <%=p.getProductId() %>   </td> 
		     <td> <%=p.getProductname() %>   </td> 
			 <td> <%=p.getPrice() %>   </td> 
			 <td> <%=p.getDiscount()%>%   </td>
			 <td> <%=p.getProductType() %> </td>
			 <td> <input type="checkbox" value=<%= String.valueOf(c) %> name="select" > </td>
				</tr>
			<% c++;  }
			   session.setAttribute("productlist",list);  %>
	</table>
	<tr>
	<td><input type="submit" value="PLACE ORDER"></td>
	</tr>
	</form>
	

</body>
</html>