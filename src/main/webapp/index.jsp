<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to Employee Management System</title>
    <link rel="stylesheet" href="./css/index.css">
</head>
<body>
    <header>
        <div class="container">
            <h1>Employee Management System</h1>
            <nav>
                <ul>
                    <li><a href="#about">About</a></li>
                    <li><a href="/login.jsp">Login</a></li>
                    <li><a href="/register.jsp">Register</a></li>
                </ul>
            </nav>
        </div>
    </header>

    <section class="hero">
        <div class="container">
            <h2>Welcome to the Employee Management Platform</h2>
            <p>Manage job offers, leave requests, and more efficiently.</p>
            <div class="cta-buttons">
                <a href="/login.jsp" class="btn">Login</a>
                <a href="/register.jsp" class="btn">Register</a>
            </div>
        </div>
    </section>

    <section id="about">
        <div class="container">
            <h3>About Us</h3>
            <p>Our Employee Management System helps companies streamline their HR processes by managing job offers, leave requests, and family allowances.</p>
            <p>We provide an all-in-one solution that saves time and resources for employers, allowing them to focus on what matters most—their employees.</p>
        </div>
    </section>

    <footer>
        <div class="container">
            <p>&copy; 2024 Employee Management System. All rights reserved.</p>
        </div>
    </footer>
</body>
</html>
