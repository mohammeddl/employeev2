<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> register</title>
    <link rel="stylesheet" href="./css/index.css">
    <link rel="stylesheet" href="./css/form.css">
</head>
<body>

<h2>Register</h2>
    <form action="/oauth" method="post" onsubmit="return validateForm()">
        <input type="hidden" name="action" value="register">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>

        <label for="phoneNumber">Phone Number:</label>
        <input type="text" id="phoneNumber" name="phoneNumber" required><br><br>

        <label for="address">Address:</label>
        <input type="text" id="address" name="address" required><br><br>

        <label for="birthDate">Birth Date:</label>
        <input type="date" id="birthDate" name="birthDate" required><br><br>

        <label>Select your role:</label><br>

        <input type="radio" id="recruiter" name="role" value="RECRUITER">
        <label for="recruiter">Recruiter</label><br>

        <input type="radio" id="candidate" name="role" value="CANDIDATE">
        <label for="candidate">Candidate</label><br><br>

        <button type="submit">Register</button>
    </form>


</body>
 <script>
        function validateForm() {
            var roleChecked = document.querySelector('input[name="role"]:checked');
            if (!roleChecked) {
                alert("Please select a role: Employee, Recruiter, or Candidate.");
                return false;
            }
            return true;
        }
    </script>
</html>
