<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin - Employee Management</title>
    <link rel="stylesheet" href="css/admin.css"> <!-- Link to the CSS file -->
</head>
<body>

    <div class="container">
        <h1>Employee Management</h1>
        
        <!-- Add Employee Button -->
        <button id="addEmployeeBtn" class="button">Add Employee</button>

        <!-- Employee List Table -->
        <table id="employeeTable">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Role</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <!-- Use JSTL to loop through employees -->
                <c:forEach var="employee" items="${employees}">
                    <tr>
                        <td>${employee.id}</td>
                        <td>${employee.name}</td>
                        <td>${employee.email}</td>
                        <td>${employee.phoneNumber}</td>
                        <td>${employee.role}</td>
                        <td>
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

        <!-- Add/Edit Employee Form Modal -->
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

    <script src="js/admin.js"></script> 
</body>
</html>
