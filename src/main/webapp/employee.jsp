<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Leave and Family Allowance Management</title>
    <link rel="stylesheet" href="css/employee.css">
</head>
<body>

    <div class="container">
        <h1>Leave and Family Allowance Management</h1>

        <!-- Leave Request Section -->
        <section id="leaveRequestSection">
            <h2>Request Leave</h2>

            <form id="leaveForm" enctype="multipart/form-data">
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

                <label for="supportingDocuments">Supporting Documents:</label>
                <input type="file" id="supportingDocuments" name="supportingDocuments" multiple>

                <button type="submit" class="button">Submit Leave Request</button>
            </form>
        </section>

        <!-- Leave History Section -->
        <section id="leaveHistorySection">
            <h2>Leave History</h2>

            <table id="leaveHistoryTable">
                <thead>
                    <tr>
                        <th>Leave Type</th>
                        <th>Start Date</th>
                        <th>End Date</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Example Leave History -->
                    <tr>
                        <td>Annual Leave</td>
                        <td>2024-01-01</td>
                        <td>2024-01-10</td>
                        <td>Approved</td>
                    </tr>
                    <!-- More rows will be dynamically added -->
                </tbody>
            </table>
        </section>

        <!-- Family Allowance Calculation Section -->
        <section id="familyAllowanceSection">
            <h2>Calculate Family Allowances</h2>

            <form id="familyAllowanceForm">
                <label for="numberOfChildren">Number of Children:</label>
                <input type="number" id="numberOfChildren" name="numberOfChildren" min="0" required>

                <label for="salary">Salary (Monthly):</label>
                <input type="number" id="salary" name="salary" min="0" required>

                <button type="submit" class="button">Calculate Allowance</button>
            </form>

            <div id="allowanceResult">
                <!-- The calculated allowance will be displayed here -->
            </div>
        </section>

        <!-- Payroll Reports Section -->
        <section id="payrollReportsSection">
            <h2>Generate Payroll Reports</h2>

            <button id="generateReportBtn" class="button">Generate Payroll Report</button>
        </section>
    </div>

    <script src="js/employee.js"></script>
</body>
</html>
