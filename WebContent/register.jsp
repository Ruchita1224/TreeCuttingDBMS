<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
        }
        div {
            background-color: #fff;
            border: 1px solid #ccc;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            padding: 20px;
            margin: 20px auto;
            width: 400px;
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
        select {
            width: 100%;
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
    <div align="center">
        <p>${errorOne}</p>
        <p>${errorTwo}</p>
        <form action="register" method="post">
            <table border="0" cellpadding="5">
                <tr>
                    <th>Username:</th>
                    <td colspan="3">
                        <input type="text" name="username" size="45" value="example@gmail.com" onfocus="this.value=''">
                    </td>
                </tr>
                <tr>
                    <th>Password:</th>
                    <td colspan="3">
                        <input type="password" name="password" size="45" value="password" onfocus="this.value=''">
                    </td>
                </tr>
                <tr>
                    <th>Password Confirmation:</th>
                    <td colspan="3">
                        <input type="password" name="confirmation" size="45" value="password" onfocus="this.value=''">
                    </td>
                </tr>
                <tr>
                    <th>Role:</th>
                    <td colspan="3">
                        <select name="role" id="role" required>
                            <option value="David Smith">David Smith</option>
                            <option value="Client">Client</option>
                            <option value="Admin Root">Admin Root</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="4" align="center">
                        <input type="submit" value="Register">
                    </td>
                </tr>
            </table>
            <a href="login.jsp" target="_self">Return to Login Page</a>
        </form>
    </div>
</body>
</html>
