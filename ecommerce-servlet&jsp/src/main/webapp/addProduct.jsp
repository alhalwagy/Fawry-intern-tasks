<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
<h1>Add Product</h1>
<form action="products" method="post">
    <label for="name">Name:</label><br>
    <input type="text" id="name" name="name"><br>
    <label for="price">Price:</label><br>
    <input type="number" id="price" name="price"><br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
