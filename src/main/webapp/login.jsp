<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> login</title>
    <link rel="stylesheet" href="./css/index.css">
    <link rel="stylesheet" href="./css/form.css">
</head>
<body>

<h2>Login</h2>
<form action="/oauth" method="post">
    <input type="hidden" name="action" value="login">
    <label for="email">Email:</label>
    <input type="text" id="email" name="email" required><br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br>

    <button type="submit">Login</button>
</form>

<c:if test="${not empty errorMessage}">
    <p style="color: red">${errorMessage}</p>
</c:if>
</body>
</html>
