<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Locale" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>David Smith Dashboard</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<style>
        table {
            width: 100%;
        }
        th {
            background-color: #0074D9;
            color: #fff;
        }
        th, td {
            text-align: center;
            padding: 10px;
        }
        .hidden {
            display: none;
        }
        body
        {
        background: url(https://wallpapercave.com/wp/wp10042368.jpg);
        background-size: cover;
        }
        #David {
        	font-family: sans-seriff;
            margin-top: 50px;
            max-width: 1600px;
            background-color: #fff;
            border: 1px solid #ccc;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            padding: 20px;
            border-radius:10px;
        }
    </style>
</head>
<body>
    <div class="container" id="David">
        <div class="text-center mt-5">
            <h1 class="display-4">Welcome, David!</h1>
            <p class="lead">You have successfully logged in!</p>
        </div>

        <div class="text-center mt-3">
            <a href="login.jsp" class="btn btn-danger">Logout</a>
        </div>

        <br>
        <form action="QuoteListforDavid" method="post" id="QuoteTab">
        <div class="container">
        <div class="text-center">
            <button id="showQuotes" class="btn btn-primary" onclick="toggleTable()">List of Quotes</button>
        </div>
        <div id="AqT">
       	<br>
       	<br>
       <table id="quotesTable" class="table table-bordered table-striped">
        <c:if test="${listQuoteDavid != null}">
            <thead>
                <tr>
                    <th>Quote ID</th>
                    <th>Request ID</th>
                    <th>Quote Date</th>
                    <th>Price</th>
                    <th>Time Window</th>
                    <th>Status</th>
                    <th>Note</th>
                    <th>Treeinfo ID</th>
                    <th>Size</th>
                    <th>Height</th>
                    <th>Location</th>
                    <th>Near House</th>
                    <th>Picture URL</th>
                    <th>Edit Option</th>
                    <th>Approve or Deny</th>
                    <!-- Add more table headers as needed for additional fields -->
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listQuoteDavid}" var="quote">
                    <tr>
                        <td><c:out value="${quote.quoteID}" /></td>
                        <td><c:out value="${quote.requestID}" /></td>
                        <td><c:out value="${quote.quoteDate}" /></td>
                        <td><c:out value="${quote.price}" /></td>
                        <td><c:out value="${quote.timeWindow}" /></td>
                        <td><c:out value="${quote.status}" /></td>
                        <td><c:out value="${quote.note}" /></td>
                        <td><c:out value="${quote.treeinfoID}" /></td>
                        <td><c:out value="${quote.size}" /></td>
                        <td><c:out value="${quote.height}" /></td>
                        <td><c:out value="${quote.location}" /></td>
                        <td><c:out value="${quote.nearHouse}" /></td>
                        <td><c:out value="${quote.pictureURL}" /></td>
                        <!-- Add more table data cells as needed for additional fields -->
                        <td><a href="Negotiate.jsp?quoteID=${quote.quoteID}&price=${quote.price}" class="btn btn-primary editQuotes">Edit</a></td>
    					<td>
    					<a href="ApprovedQuote.jsp?quoteID=${quote.quoteID}&price=${quote.price}&status=${quote.status}" class="btn btn-success ApproveQuote">Approve</a>
    					<br>
    					<a href="DeniedQuote.jsp?quoteID=${quote.quoteID}&price=${quote.price}&status=${quote.status}" class="btn btn-danger DenyQuote" style="margin-top:10px">Deny</a>
    					</td>
                    </tr>
                </c:forEach>
            </tbody>
            </c:if>
        </table>
        <br>
        <br>
        </div>
    </div>
</form>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.min.js"></script>
	<script>
	$(document).ready(function() {
	        $("#AqT").click(function() {
	            $("#quotesTable").toggle();
	        });

	        $("button.editQuotes").click(function() {
	            // Redirect to Negotiate.jsp
	            window.location.href = "Negotiate.jsp";
	        });
	        
	        $("button.ApproveQuote").click(function () {
	        	window.location.href = "ApprovedQuote.jsp";
	        });
	        
	        $("button.DenyQuote").click(function () {
	        	window.location.href = "DeniedQuote.jsp";
	        });
	    });
    
    </script>
</body>
</html>
