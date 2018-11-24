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
	<table id = "tab1">
	<tr>
	<td align="center" >SlNo</td>
	<td align="center" >ID</td> 
	<td align="center" >Name</td>
	<td align="center" >Price</td>
	<td align="center" >Discount</td>
	<td align="center" >Type</td>
	
	</tr>
	
		<% 	ArrayList<Product> productList = (ArrayList<Product>)session.getAttribute("productlist");
			String[] indexes = request.getParameterValues("select");
			for(String s : indexes)
				System.out.println(s);
			for(Product p: productList) {
				System.out.println(p.getProductname());
			}
			ArrayList<Product> selectedProducts = new ArrayList<>();
			for(String string : indexes) {
				int i = Integer.parseInt(string);
				selectedProducts.add(productList.get(i));
			}
			double price = 0.0; 
			for(Product p : selectedProducts) {
				double pp = Double.parseDouble(p.getPrice())-(0.01)*Double.parseDouble(p.getPrice())*Double.parseDouble(p.getDiscount());
				price +=pp;
			}
			int c=1;
			for(Product p : selectedProducts) { %>
				<tr>
			 <td> <%= String.valueOf(c) %>   </td> 
			 <td> <%=p.getProductId() %>   </td> 
		     <td> <%=p.getProductname() %>   </td> 
			 <td> <%=p.getPrice() %>   </td> 
			 <td> <%=p.getDiscount()%>%   </td>
			 <td> <%=p.getProductType() %> </td>
				</tr>
			<% c++;  } %>
		<tr>
			<td> Total Amount To be Paid : </td>
			<td> <%= String.valueOf(price) %>
		</tr>
	</table>
</body>
</html>