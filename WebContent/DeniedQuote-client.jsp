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
    <title>Quote Denial Dashboard for Client</title>
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
        background: url(https://images.unsplash.com/photo-1473773508845-188df298d2d1?q=80&w=3174&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D);
        background-size: cover;
        }
        #client {
        	font-family: sans-seriff;
            margin-top: 50px;
            max-width: 1400px;
            background-color: #fff;
            border: 1px solid #ccc;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            padding: 20px;
            border-radius:10px;
        }
    </style>
</head>
<body>
    <div class="container" id="client">
        <div class="text-center mt-5">
            <h1 class="display-4">Welcome, David!</h1>
        </div>

        <div class="text-center mt-3">
            <a href="client_dashboard.jsp" class="btn btn-primary">Back</a>
        </div>
        <br>
        <form action="DenyQuoteClient" method="post" id="QuoteTab">
    <input type="hidden" name="quoteID" value="${param.quoteID}" />
    <div class="container">
        <div id="AqT">
            <br>
            <br>
            <c:if test="${quoteDenied}">
                <!-- Display success message when quote is updated -->
                <div class="alert alert-success" role="alert">
                    Quote Denied Successfully
                </div>
            </c:if>
            <table id="quotesTable" class="table table-bordered table-striped">
           	 <c:if test="${param.quoteID != null}">
                <thead>
                    <tr>
                        <th>Quote ID</th>
                        <th>Price</th>
                        <th>Status</th>
                        <!-- Add more table headers as needed for additional fields -->
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><c:out value="${param.quoteID}" /></td>
                        <td><c:out value="${param.price}" /></td>
                        <td><c:out value="${param.status}" /></td>
                        <!-- Add more table data cells as needed for additional fields -->
                    </tr>
                </tbody>
                </c:if>
            </table>
            <br>
            <br>
        </div>
    </div>
    <div class="text-center mt-3">
        <button type="submit" class="btn btn-danger">Deny Quote</button>
    </div>
</form>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.min.js"></script>
	<script>
	$(document).ready(function() {
        $("#AqT").click(function(e) {
            // Check if the click target is not an input field
            if (!$(e.target).is("input")) {
                $("#quotesTable").toggle();
            }
        });
    });

    </script>
</body>
</html>
