<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/login.css">
    <title> login</title>

</head>
<body>


<div class="login">
  <h1>Login</h1>
    <form action="/oauth" method="post">
    <input type="hidden" name="action" value="login">
      <input type="text" name="email" placeholder="email" required="required" />
        <input type="password" name="password" placeholder="Password" required="required" />
        <button type="submit" class="btn btn-primary btn-block btn-large">Let me in.</button>
    </form>
<P>${message}</P>
<c:if test="${not empty errorMessage}">
    <p style="color: red">${errorMessage}</p>
</c:if>
</div>
</body>
</html>
