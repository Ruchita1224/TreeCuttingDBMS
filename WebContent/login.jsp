<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>David Smith's Tree Cutting - User Login Portal</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: Brush Script MT, Brush Script Std, cursive	;
            background-color: ##f0f0f0;
            background: url(https://get.pxhere.com/photo/pine-pine-forest-forest-jungle-blur-bokeh-blurry-green-wood-focus-mountain-hill-mount-leaves-leaf-grass-dark-dark-green-peace-tree-nature-woodland-ecosystem-woody-plant-trunk-old-growth-forest-spruce-fir-forest-grove-wilderness-temperate-coniferous-forest-branch-biome-deciduous-sunlight-temperate-broadleaf-and-mixed-forest-birch-plant-sky-1451539.jpg);
            background-size: cover;
        }
        .container {
        	font-family: sans-seriff;
            margin-top: 50px;
            max-width: 400px;
            background-color: #fff;
            border: 1px solid #ccc;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            padding: 20px;
            border-radius:10px;
        }
        
    </style>
</head>
<body>
	<br>
	<br>
	<div class="text-center">
    	<br>
    	<br>
    	<h1 class="display-4 font-weight-bold-italic" style="color: #ffffff; text-shadow: 2px 2px 4px #000000;">Welcome to David-Smith's Tree Cutting Service!</h1>
	</div>
	<br>
    <div class="container">
        <p class="text-danger">${loginFailedStr}</p>
        <form action="login" method="post">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" class="form-control" id="username" name="username" autofocus required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
		<button type="submit" class="btn btn-primary btn-lg mx-auto d-block" value="Login">Login</button>
        </form>
        <p class="mt-3"><a href="register.jsp">Register Here</a></p>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
