<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin - Employee Management</title>
    <link rel="stylesheet" href="css/admin.css"> 
</head>
<body>

    <div class="container">
        <h1>Employee Management</h1>
        
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

    <script src="js/admin.js"></script> 
</body>
</html>
