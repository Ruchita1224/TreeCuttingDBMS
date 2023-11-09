<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
String loginID = (String) session.getAttribute("loginID");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Activity page</title>
</head>

<center>
	<h1>Welcome Client! You have been successfully logged in</h1>
</center>


<body>
	<center>
		<button onclick="window.location.href='login.jsp'" style="padding: 10px 20px; background-color: #0074D9; color: white; border: none; cursor: pointer; border-radius: 5px;">Logout</button>
		<button onclick="showForm()" style="padding: 10px 20px; background-color: #0074D9; color: white; border: none; cursor: pointer; border-radius: 5px;">Open Form</button>
		<button type="button" onclick="showSubmittedQuotes()" style="margin-top: 20px; padding: 10px 20px; background-color: #4CAF50; color: white; border: none; cursor: pointer; border-radius: 5px;">View Submitted Quotes</button>
	</center>

	<form id="quoteForm" action="submitQuote" method="post" style="display: none; max-width: 500px; margin: auto; padding: 20px; border: 1px solid #ccc; border-radius: 5px; background-color: #f9f9f9; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);">
		<!-- Client Information -->
		<div style="margin-bottom: 15px;">
			<label for="clientID" style="color: #333; font-weight: bold;">Client
				ID:</label> <input type="text" id="clientID" name="clientID"
				placeholder=loginID required
				style="padding: 8px; border: 1px solid #ccc; border-radius: 3px;">
		</div>
		<div style="margin-bottom: 15px;">
			<label for="requestDate" style="color: #333; font-weight: bold;">Request
				Date:</label> <input type="date" id="requestDate" name="requestDate"
				required
				style="padding: 8px; border: 1px solid #ccc; border-radius: 3px;">
		</div>
		<div style="margin-bottom: 15px;">
			<label for="note" style="color: #333; font-weight: bold;">Note:</label>
			<textarea name="note" placeholder="Note"
				style="padding: 8px; border: 1px solid #ccc; border-radius: 3px;"></textarea>
		</div>
		<div style="margin-bottom: 15px;">
			<label for="price" style="color: #333; font-weight: bold;">Price:</label>
			<input type="text" id="price" name="price" placeholder="Price"
				required
				style="padding: 8px; border: 1px solid #ccc; border-radius: 3px;">
		</div>
		<div style="margin-bottom: 15px;">
			<label for="timeWindow" style="color: #333; font-weight: bold;">TimeWindow:</label>
			<input type="text" id="timeWindow" name="timeWindow"
				placeholder="8:00 AM - 12:00 PM" required
				style="padding: 8px; border: 1px solid #ccc; border-radius: 3px;">
		</div>
		<!-- Tree Information -->
		<div style="margin-bottom: 15px;">
			<label for="size" style="color: #333; font-weight: bold;">Size:</label>
			<input type="text" id="size" name="size" placeholder="Size"
				required
				style="padding: 8px; border: 1px solid #ccc; border-radius: 3px;">
		</div>
		<div style="margin-bottom: 15px;">
			<label for="height" style="color: #333; font-weight: bold;">Height:</label>
			<input type="text" id="height" name="height" placeholder="Height"
				required
				style="padding: 8px; border: 1px solid #ccc; border-radius: 3px;">
		</div>
		<div style="margin-bottom: 15px;">
			<label for="location" style="color: #333; font-weight: bold;">Location:</label>
			<input type="text" id="location" name="location"
				placeholder="Location" required
				style="padding: 8px; border: 1px solid #ccc; border-radius: 3px;">
		</div>
		<div style="margin-bottom: 15px;">
			<label for="nearHouse" style="color: #333; font-weight: bold;">Near
				House:</label> <input type="text" id="nearHouse" name="nearHouse"
				placeholder="Near House"
				style="padding: 8px; border: 1px solid #ccc; border-radius: 3px;">
		</div>

		<!-- Tree Picture Information -->
		<div style="margin-bottom: 15px;">
			<label for="pictureURL" style="color: #333; font-weight: bold;">Picture
				URL:</label> <input type="text" id="pictureURL" name="pictureURL"
				placeholder="Picture URL" required
				style="padding: 8px; border: 1px solid #ccc; border-radius: 3px;">
		</div>


		<button type="submit"
			style="padding: 10px 20px; background-color: #0074D9; color: white; border: none; cursor: pointer; border-radius: 5px;">Submit
			Request</button>
		
		<button type="button" onclick="hideForm()" style="margin-top: 20px; padding: 10px 20px; background-color: #ff0000; color: white; border: none; cursor: pointer; border-radius: 5px;">Close Form</button>
	</form>
	
	<form id="submittedQuotes" action="editQuote" method="post" style="display: none; max-width: 500px; margin: auto; padding: 20px; border: 1px solid #ccc; border-radius: 5px; background-color: #f9f9f9; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);">
    <!-- Section to display submitted quotes -->
    <!-- This can be filled in using JavaScript when showing the submitted quotes -->
    <div class="container">
        <table border="1" cellpadding="6">
            <caption>
                List of Quote
            </caption>
				<%
				String updateMessage = (String) session.getAttribute("updateMessage");
				if (updateMessage != null) {
				%>
				<div class="success-message">
					<%=updateMessage%>
				</div>
				<%
				// Clear the message from the session after displaying it
				session.removeAttribute("updateMessage");
				}
				%>

				<tr>
                <th>Quote ID</th>
                <th>Request ID</th>
                <th>Quote Date</th>
                <th>Price</th>
                <th>Time Window</th>
                <th>Status</th>
                <th>Note</th>
                <th>Action</th>
            </tr>
            <tr style="text-align: center">
                <td><c:out value="${listQuote.quoteID}" /></td>
                <td><c:out value="${listQuote.requestID}" /></td>
                <td><c:out value="${listQuote.quoteDate}" /></td>
                <td><input type="text" name="price" value="<c:out value="${listQuote.price}" />"></td>
                <td><c:out value="${listQuote.timeWindow}" /></td>
                <td><input type="text" name="status" value="<c:out value="${listQuote.status}" />"></td>
                <td><input type="text" name="note" value="<c:out value="${listQuote.note}" />"></td>
                <td>
                <input type="hidden" name="quoteID" value="<c:out value="${listQuote.quoteID}" />">
                   <button type="submit"
			style="padding: 10px 20px; background-color: #0074D9; color: white; border: none; cursor: pointer; border-radius: 5px;">Edit
			Request</button>
                </td>
            </tr>
        </table>
    </div>
    <button type="button" onclick="hideForm2()" style="margin-top: 20px; padding: 10px 20px; background-color: #ff0000; color: white; border: none; cursor: pointer; border-radius: 5px;">Close Form</button>
</form>


<script>
        function showForm() {
            var form = document.getElementById("quoteForm");
            form.style.display = "block";
        }
        
        function showSubmittedQuotes() {
            // Replace this alert with logic to fetch and display submitted quotes
            alert("Logic to fetch and display submitted quotes goes here");
            
            // Show the section where submitted quotes will be displayed
            var submittedQuotesSection = document.getElementById("submittedQuotes");
            submittedQuotesSection.style.display = "block";
        }
        
        function hideForm() {
            var form = document.getElementById("quoteForm");
            form.style.display = "none";
        }
        function hideForm2() {
            var submittedQuotes = document.getElementById("submittedQuotes");
            submittedQuotes.style.display = "none";
        }
        
        document.getElementById("clientID").setAttribute("placeholder", "<%= session.getAttribute("loginID") %>");
    </script>
</body>
</html>