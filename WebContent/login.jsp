<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login to Database</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
        }
        center h1 {
            color: #0074D9;
        }
        div {
            background-color: #fff;
            border: 1px solid #ccc;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            padding: 20px;
            margin: 20px auto;
            width: 400px;
        }
        p {
            color: red;
        }
        form table {
            width: 100%;
        }
        th {
            text-align: right;
            padding-right: 10px;
        }
        td {
            padding: 5px;
        }
        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 5px;
        }
        input[type="submit"] {
            background-color: #0074D9;
            color: #fff;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        a {
            text-decoration: none;
            color: #0074D9;
        }
    </style>
</head>
<body>
    <center><h1>Welcome to Login page</h1></center>
    <div align="center">
        <p>${loginFailedStr}</p>
        <form action="login" method="post">
            <table border="0" cellpadding="5">
                <tr>
                    <th>Username:</th>
                    <td>
                        <input type="text" name="username" size="45" autofocus>
                    </td>
                </tr>
                <tr>
                    <th>Password:</th>
                    <td>
                        <input type="password" name="password" size="45">
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Login">
                    </td>
                </tr>
            </table>
            <a href="register.jsp" target="_self">Register Here</a>
        </form>
    </div>
</body>
</html>
