<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ManagerPro - Admin Dashboard</title>
    <link rel="stylesheet" href="css/admin.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>

<body>
    <div class="dashboard">
        <!-- Sidebar -->
        <div class="sidebar">
            <div class="logo-container">
                <h2 class="logo">ManagerPro</h2>
            </div>
            <ul class="nav-links">
                <li><a href="#"><i class="fas fa-home"></i>Dashboard</a></li>
                <li><a href="#"><i class="fas fa-users"></i>Employees</a></li>
                <li><a href="#"><i class="fas fa-chart-pie"></i>Reports</a></li>
                <li><a href="/oauth" class="logout-link"><i class="fas fa-sign-out-alt"></i>Logout</a></li>
            </ul>
        </div>

        <!-- Main content -->
        <div class="main-content">
            <div class="header">
                <h1>Welcome, Admin</h1>
                <div class="header-right">
                    <div class="user-info">
                        <img src="https://img.freepik.com/vecteurs-premium/illustration-icone-vectorielle-gestion-du-jeu-icones-business-analytics_904970-117820.jpg" alt="User" class="user-avatar">
                        <span>Admin Name</span>
                    </div>
                </div>
            </div>

            <div class="dashboard-content">
                <h2>Employee Management</h2>
                <button id="addEmployeeBtn" class="button">Add Employee</button>

                <table id="employeeTable">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th>Role</th>
                            <th>Salary</th>
                            <th>Department</th>
                            <th>Position</th>
                            <th>Date of Joining</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="employee" items="${employees}">
                        <tr>
                        <td>${employee.id}</td>
                        <td>${employee.name}</td>
                        <td>${employee.email}</td>
                        <td>${employee.phoneNumber}</td>
                        <td>${employee.role}</td>
                        <td>${employee.salary}</td>
                        <td>${employee.department}</td>
                        <td>${employee.position}</td>
                        <td>${employee.hireDate}</td>
                            <td class="buttonPosition">
                            <button class="edit-btn" data-id="${employee.id}">Edit</button>
                            <form action="/admin" method="post" style="display:inline-block;">
                                <input type="hidden" name="action" value="delete">
                                <input type="hidden" name="employeeId" value="${employee.id}">
                                <input type="submit" class="delete-btn" value="Delete">
                            </form>
                        </td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <div id="employeeFormContainer" class="modal">
            <div class="modal-content">
                <span class="close">&times;</span>
                <form id="employeeForm" method="post" action="/admin">
                    <h2 id="formTitle">Add Employee</h2>
                    <input type="hidden" id="employeeId" name="employeeId">

                    <label for="name">Name:</label>
                    <input type="text" id="name" name="name" required>

                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" required>

                    <label for="phone">Phone:</label>
                    <input type="text" id="phone" name="phone" required>

                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" required>

                    <label for="salary">Salary:</label>
                    <input type="number" id="salary" name="salary" required>

                    <label for="department">Department:</label>
                    <input type="text" id="department" name="department" required>

                    <label for="position">Position:</label>
                    <input type="text" id="position" name="position" required>

                    <label for="role">Role:</label>
                    <select id="role" name="role" required>
                        <option value="EMPLOYEE">Employee</option>
                        <option value="RECRUITER">Recruiter</option>
                    </select>

                    <input type="hidden" name="action" id="actionField">
                    <button type="submit" class="button">Save</button>
                </form>
            </div>
        </div>
            </div>
        </div>
    </div>

    <script src="js/admin.js"></script>
</body>

</html>
