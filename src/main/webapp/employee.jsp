<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Leave and Family Allowance Management</title>
    <link rel="stylesheet" href="css/employee.css">
    <style>
        /* General Styles */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f7f6;
            margin: 0;
            padding: 0;
        }

        /* Navbar Styles */
        .navbar {
            width: 100%;
            background-color: #2c3e50;
            color: #fff;
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px 20px;
            position: fixed;
            top: 0;
            left: 0;
            z-index: 100;
        }

        .navbar-logo {
            display: flex;
            align-items: center;
        }

        .navbar-logo img {
            height: 40px;
            margin-right: 10px;
        }

        .navbar-logo h1 {
            font-size: 20px;
            color: #fff;
            margin: 0;
        }

        .logout-btn {
            background-color: #e74c3c;
            color: #fff;
            border: none;
            padding: 8px 20px;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            font-size: 14px;
        }

        .logout-btn:hover {
            background-color: #c0392b;
        }

        /* Main Container */
        .container {
            max-width: 1200px;
            width: 100%;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            padding: 40px;
            margin-top: 80px;
        }

        h1, h2 {
            text-align: center;
            color: #2c3e50;
        }

        h3 {
            color: red;
            text-align: center;
        }

        /* Form Styles */
        form {
            margin-bottom: 40px;
            padding: 20px;
            background-color: #ecf0f1;
            border-radius: 8px;
        }

        label {
            font-size: 16px;
            margin-bottom: 8px;
            display: block;
            color: #34495e;
        }

        input, select, textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #bdc3c7;
            border-radius: 4px;
            font-size: 14px;
            background-color: #fff;
            box-sizing: border-box;
        }

        .button {
            background-color: #3498db;
            color: white;
            border: none;
            padding: 12px 20px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            display: block;
            margin: 0 auto;
            width: 50%;
        }

        .button:hover {
            background-color: #2980b9;
        }

        /* Table Styles */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 40px;
        }

        table th, table td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: left;
        }

        table th {
            background-color: #3498db;
            color: white;
            font-weight: bold;
        }

        table tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        /* Section Headings */
        section h2 {
            font-size: 22px;
            color: #2980b9;
            margin-bottom: 20px;
            text-align: left;
        }

        /* Family Allowance Section */
        #allowanceResult p {
            font-size: 18px;
            color: #27ae60;
        }

        /* Responsive Styles */
        @media (max-width: 768px) {
            .button {
                width: 100%;
            }

            input, select, textarea {
                font-size: 14px;
            }

            table th, table td {
                font-size: 12px;
            }
        }
    </style>
    
</head>
<body>

    <div class="navbar">
        <div class="navbar-logo">
            <img src="https://via.placeholder.com/40" alt="Company Logo">
            <h1>ManagerPro</h1>
        </div>
        <a href="/oauth" class="logout-btn">Logout</a>
    </div>

    <div class="container">
        <h1>Leave and Family Allowance Management</h1>

        <!-- Leave Request Section -->
        <section id="leaveRequestSection">
            <h2>Request Leave</h2>
            <h3>${errorMessage} </h3>

            <form action="leave" method="post">
                <input type="hidden" name="action" value="apply">
                
                <label for="leaveType">Leave Type:</label>
                <select id="leaveType" name="leaveType" required>
                    <option value="Annual Leave">Annual Leave</option>
                    <option value="Sick Leave">Sick Leave</option>
                    <option value="Maternity Leave">Maternity Leave</option>
                </select>

                <label for="startDate">Start Date:</label>
                <input type="date" id="startDate" name="startDate" required>

                <label for="endDate">End Date:</label>
                <input type="date" id="endDate" name="endDate" required>

                <label for="justification">Justification (Optional):</label>
                <textarea id="justification" name="justification"></textarea>

                <button type="submit" class="button">Submit Leave Request</button>
            </form>
        </section>

        <!-- Leave History Section -->
        <section id="leaveHistorySection">
            <h2>Leave History</h2>
            <table id="leaveHistoryTable">
                <thead>
                    <tr>
                        <th>Start Date</th>
                        <th>End Date</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="leave" items="${leaves}">
                        <tr>
                            <td>${leave.startDate}</td>
                            <td>${leave.endDate}</td>
                            <td>${leave.status}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </section>

        <!-- Family Allowance Calculation Section -->
        <section id="familyAllowanceSection">
            <h2>Calculate Family Allowances</h2>

            <form id="familyAllowanceForm" action="calculate_allowance" method="post">
                <label for="numberOfChildren">Number of Children:</label>
                <input type="number" id="numberOfChildren" name="numberOfChildren" min="0" required>

                <button type="submit" class="button">Calculate Allowance</button>
            </form>

            <div id="allowanceResult">
                <c:if test="${not empty allowance}">
                    <p>Family Allowance: ${allowance} DH</p>
                </c:if>
            </div>
        </section>

        <!-- Payroll Reports Section -->
        <section id="payrollReportsSection">
            <h2>Generate Payroll Reports</h2>
            <a href="/calculate_allowance" class="button">Generate Payroll Report</a>
        </section>

        <c:if test="${not empty familyRaport}">
            <section id="familyRaportSection">
                <h2>Family Report</h2>
                <table id="familyRaportTable">
                    <thead>
                        <tr>
                            <th>Number of Children</th>
                            <th>Family Allowance</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>${familyRaport.numberOfChildren}</td>
                            <td>${familyRaport.totalSalary}</td>
                        </tr>
                    </tbody>
                </table>
            </section>
        </c:if>
    </div>

</body>
</html>
