<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Portal</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
       		background: url(https://wallpapers.com/images/featured/dslr-blur-r11mojbz9mf7uwl6.webp);
            background-size: cover;
        }
    .container {
        	font-family: sans-seriff;
            margin-top: 50px;
            max-width: 800px;
            background-color: #fff;
            border: 1px solid #ccc;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            padding: 20px;
            border-radius:10px;
        }
        
    </style>
</head>
<body>
    <div class="container text-center">
        <p>${errorOne}</p>
        <p>${errorTwo}</p>
        <h1 class="display-4 font-weight-bold-italic" style="color: #000000; text-shadow: 2px 2px 4px #ffffff; font-family: Brush Script MT, Brush Script Std, cursive;">Registration Portal</h1>
        <br>
        <form action="register" method="post">
            <div class="form-group row">
                <label for="username" class="col-sm-4 col-form-label text-right">Username:</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="username" name="username" value="example@gmail.com" onfocus="this.value=''">
                </div>
            </div>
            <div class="form-group row">
                <label for="password" class="col-sm-4 col-form-label text-right">Password:</label>
                <div class="col-sm-8">
                    <input type="password" class="form-control" id="password" name="password" value="password" onfocus="this.value=''">
                </div>
            </div>
            <div class="form-group row">
                <label for="confirmation" class="col-sm-4 col-form-label text-right">Verify Password:</label>
                <div class="col-sm-8">
                    <input type="password" class="form-control" id="confirmation" name="confirmation" value="password" onfocus="this.value=''">
                </div>
            </div>
            <div class="form-group row">
                <label for="role" class="col-sm-4 col-form-label text-right">Role:</label>
                <div class="col-sm-8">
                    <select class="form-control" id="role" name="role" required>
                        <option value="David Smith">David Smith</option>
                        <option value="Client">Client</option>
                        <option value="Admin Root">Admin Root</option>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-12 text-center">
                    <input type="submit" class="btn btn-primary" value="Register">
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-12 text-center">
                    <a href="login.jsp" target="_self" class="btn btn-primary">Back</a>
                </div>
            </div>
        </form>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
