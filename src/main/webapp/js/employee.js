// Handle leave form submission
document.getElementById('leaveForm').onsubmit = function(event) {
    event.preventDefault();
    console.log('Leave request submitted');
    // Add logic to submit the leave request
};

Family allowance calculation
document.getElementById('familyAllowanceForm').onsubmit = function(event) {
    event.preventDefault();
    const numberOfChildren = document.getElementById('numberOfChildren').value;
    const salary = document.getElementById('salary').value;

    // Simple calculation for family allowance (adjust this formula as needed)
    const allowance = numberOfChildren * salary * 0.05; // 5% of salary per child

    document.getElementById('allowanceResult').innerText = `Calculated Family Allowance: $${allowance.toFixed(2)}`;
};


document.getElementById('generateReportBtn').onclick = function() {
    console.log('Generating payroll report...');
    alert('Payroll report generated!');
};
