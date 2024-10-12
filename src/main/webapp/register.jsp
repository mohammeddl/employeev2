<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link rel="stylesheet" href="./css/register.css">
</head>
<body>

<div class="container">
    <form action="/oauth" method="post" onsubmit="return validateForm()">
 <h1>Register</h1>
        <input type="hidden" name="action" value="register">
        
        <!-- First row: Name and Email -->
        <div class="row">
            <div class="column">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required>
            </div>
            <div class="column">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
            </div>
        </div>

        <!-- Second row: Password and Phone Number -->
        <div class="row">
            <div class="column">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div class="column">
                <label for="phoneNumber">Phone Number:</label>
                <input type="text" id="phoneNumber" name="phoneNumber" required>
            </div>
        </div>

        <!-- Third row: Address and Birth Date -->
        <div class="row">
            <div class="column">
                <label for="address">Address:</label>
                <input type="text" id="address" name="address" required>
            </div>
            <div class="column">
                <label for="birthDate">Birth Date:</label>
                <input type="date" id="birthDate" name="birthDate" required>
            </div>
        </div>

        <!-- Role Selection -->
        <label>Select your role:</label><br>
        <input type="radio" id="recruiter" name="role" value="RECRUITER">
        <label for="recruiter">Recruiter</label><br>
        <input type="radio" id="candidate" name="role" value="CANDIDATE">
        <label for="candidate">Candidate</label><br><br>

        <button type="submit">Register</button>
    </form>

    </div>

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
