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
                <!-- Example Employee Data -->
                <tr>
                    <td>1</td>
                    <td>John Doe</td>
                    <td>john@example.com</td>
                    <td>555-1234</td>
                    <td>Employee</td>
                    <td>
                        <button class="edit-btn">Edit</button>
                        <button class="delete-btn">Delete</button>
                    </td>
                </tr>
                <!-- More rows of employees will be added dynamically -->
            </tbody>
        </table>

        <!-- Add/Edit Employee Form -->
        <div id="employeeFormContainer" class="modal">
            <div class="modal-content">
                <span class="close">&times;</span>
                <form id="employeeForm">
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
                        <option value="Employee">Employee</option>
                        <option value="Recruiter">Recruiter</option>
                        <option value="Admin">Admin</option>
                    </select>

                    <label for="adminDocuments">Administrative Documents:</label>
                    <input type="file" id="adminDocuments" name="adminDocuments" multiple>

                    <button type="submit" class="button">Save</button>
                </form>
            </div>
        </div>
    </div>

    <script src="js/admin.js"></script> 
</body>
</html>
