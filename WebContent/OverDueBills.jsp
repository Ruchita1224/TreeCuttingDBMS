<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f5f5f5;
	margin: 0;
	padding: 0;
}

.container {
	max-width: 1200px;
	margin: 20px auto;
	padding: 20px;
	background-color: #fff;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
	border-radius: 10px;
}

.action-btn {
	display: block;
	width: 100%;
	padding: 10px;
	background-color: #0074D9;
	color: #fff;
	text-align: center;
	text-decoration: none;
	border-radius: 5px;
}

.action-btn:hover {
	background-color: #0056b3;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
}

th, td {
	padding: 10px;
	text-align: center;
	border: 1px solid #ccc;
}

th {
	background-color: #0074D9;
	color: #fff;
}

</style>
</head>
<body>
		
	<div class="container">
		<table border="1" cellpadding="6">
			<h1 class="display-4 font-weight-bold-italic text-center" style="color: #000000; text-shadow: 2px 2px 4px #ffffff; font-family: Brush Script MT, Brush Script Std, cursive;">List of Over Due Bill Details</h1>
			<br>
			<tr>
				<th>Bill ID</th>
				<th>Order ID</th>
				<th>Billed Date</th>
				<th>Amount</th>
				<th>Status</th>
				<th>Note</th>
			</tr>
			<c:forEach var="bill" items="${listOverDueBills}">
				<tr style="text-align: center">
					<td><c:out value="${bill.billID}" /></td>
					<td><c:out value="${bill.orderID}" /></td>
					<td><c:out value="${bill.billedDate}" /></td>
					<td><c:out value="${bill.amount}" /></td>
					<td><c:out value="${bill.status}" /></td>
					<td><c:out value="${bill.note}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
