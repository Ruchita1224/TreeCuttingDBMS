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
		<br>
		<h1 class="display-4 font-weight-bold-italic text-center" style="color: #000000; text-shadow: 2px 2px 4px #ffffff; font-family: Brush Script MT, Brush Script Std, cursive;">Welcome, Admin!</h1>
		<br>
		<br>
		<a class="btn btn-primary action-btn" href="initialize">Initialize the Database</a> 
		<br>
		<a class="btn btn-secondary" href="login.jsp">Logout</a>
		<br>
		<br>
		<h1 class="display-4 font-weight-bold-italic text-center" style="color: #000000; text-shadow: 2px 2px 4px #ffffff; font-family: Brush Script MT, Brush Script Std, cursive;">List of Admins</h1>
		<table class="table">
			<tr>
				<th>loginID</th>
				<th>ActionPerformed</th>
				<th>Timestamp</th>
			</tr>
			<c:forEach var="admins" items="${listAdmin}">
				<tr style="text-align: center">
					<td><c:out value="${admins.loginID}" /></td>
					<td><c:out value="${admins.actionPerformed}" /></td>
					<td><c:out value="${admins.timestamp}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="container">
		<table border="1" cellpadding="6">
			<h1 class="display-4 font-weight-bold-italic text-center" style="color: #000000; text-shadow: 2px 2px 4px #ffffff; font-family: Brush Script MT, Brush Script Std, cursive;">List of Bill Details</h1>
			<br>
			<tr>
				<th>Bill ID</th>
				<th>Order ID</th>
				<th>Billed Date</th>
				<th>Amount</th>
				<th>Status</th>
				<th>Note</th>
			</tr>
			<c:forEach var="bill" items="${listBillDetails}">
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
	<div class="container">
		<table border="1" cellpadding="6">
			<h1 class="display-4 font-weight-bold-italic text-center" style="color: #000000; text-shadow: 2px 2px 4px #ffffff; font-family: Brush Script MT, Brush Script Std, cursive;">List of Clients</h1>
			<br>
			<tr>
				<th>Client ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Address</th>
				<th>Credit Card Info</th>
				<th>Phone Number</th>
				<th>Email</th>
			</tr>
			<c:forEach var="client" items="${listClient}">
				<tr style="text-align: center">
					<td><c:out value="${client.clientID}" /></td>
					<td><c:out value="${client.firstName}" /></td>
					<td><c:out value="${client.lastName}" /></td>
					<td><c:out value="${client.address}" /></td>
					<td><c:out value="${client.creditCardInfo}" /></td>
					<td><c:out value="${client.phoneNumber}" /></td>
					<td><c:out value="${client.email}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="container">
		<table border="1" cellpadding="6">
			<h1 class="display-4 font-weight-bold-italic text-center" style="color: #000000; text-shadow: 2px 2px 4px #ffffff; font-family: Brush Script MT, Brush Script Std, cursive;">List of Order Details</h1>
			<br>
			<tr>
				<th>Order ID</th>
				<th>Quote ID</th>
				<th>Order Date</th>
				<th>Status</th>
			</tr>
			<c:forEach var="order" items="${listOrderDetails}">
				<tr style="text-align: center">
					<td><c:out value="${order.orderID}" /></td>
					<td><c:out value="${order.quoteID}" /></td>
					<td><c:out value="${order.orderDate}" /></td>
					<td><c:out value="${order.status}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="container">
		<table border="1" cellpadding="6">
			<h1 class="display-4 font-weight-bold-italic text-center" style="color: #000000; text-shadow: 2px 2px 4px #ffffff; font-family: Brush Script MT, Brush Script Std, cursive;">List of Quotes</h1>
			<br>
			<tr>
				<th>Quote ID</th>
				<th>Request ID</th>
				<th>Quote Date</th>
				<th>Price</th>
				<th>Time Window</th>
				<th>Status</th>
				<th>Note</th>
			</tr>
			<c:forEach var="quote" items="${listQuote}">
				<tr style="text-align: center">
					<td><c:out value="${quote.quoteID}" /></td>
					<td><c:out value="${quote.requestID}" /></td>
					<td><c:out value="${quote.quoteDate}" /></td>
					<td><c:out value="${quote.price}" /></td>
					<td><c:out value="${quote.timeWindow}" /></td>
					<td><c:out value="${quote.status}" /></td>
					<td><c:out value="${quote.note}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	 <div class="container">
		<table border="1" cellpadding="6">
			<h1 class="display-4 font-weight-bold-italic text-center" style="color: #000000; text-shadow: 2px 2px 4px #ffffff; font-family: Brush Script MT, Brush Script Std, cursive;">List of Tree Information</h1>
			<br>
			<tr>
				<th>Tree Info ID</th>
				<th>Request ID</th>
				<th>Size</th>
				<th>Height</th>
				<th>Location</th>
				<th>Near House</th>
			</tr>
			<c:forEach var="treeInfo" items="${listTreeInformation}">
				<tr style="text-align: center">
					<td><c:out value="${treeInfo.treeInfoID}" /></td>
					<td><c:out value="${treeInfo.requestID}" /></td>
					<td><c:out value="${treeInfo.size}" /></td>
					<td><c:out value="${treeInfo.height}" /></td>
					<td><c:out value="${treeInfo.location}" /></td>
					<td><c:out value="${treeInfo.nearHouse}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="container">
		<table border="1" cellpadding="6">
			<h1 class="display-4 font-weight-bold-italic text-center" style="color: #000000; text-shadow: 2px 2px 4px #ffffff; font-family: Brush Script MT, Brush Script Std, cursive;">List of Tree Pictures</h1>
			<br>
			<tr>
				<th>Picture ID</th>
				<th>Picture URL</th>
				<th>Tree Info ID</th>
			</tr>
			<c:forEach var="treePic" items="${listTreePicture}">
				<tr style="text-align: center">
					<td><c:out value="${treePic.pictureID}" /></td>
					<td><c:out value="${treePic.pictureURL}" /></td>
					<td><c:out value="${treePic.treeInfoID}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="container">
		<table border="1" cellpadding="6">
			<h1 class="display-4 font-weight-bold-italic text-center" style="color: #000000; text-shadow: 2px 2px 4px #ffffff; font-family: Brush Script MT, Brush Script Std, cursive;">List of Tree Requests</h1>
			<br>
			<tr>
				<th>Request ID</th>
				<th>Client ID</th>
				<th>Request Date</th>
				<th>Status</th>
				<th>Note</th>
			</tr>
			<c:forEach var="request" items="${listTreeRequest}">
				<tr style="text-align: center">
					<td><c:out value="${request.requestID}" /></td>
					<td><c:out value="${request.clientID}" /></td>
					<td><c:out value="${request.requestDate}" /></td>
					<td><c:out value="${request.status}" /></td>
					<td><c:out value="${request.note}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
