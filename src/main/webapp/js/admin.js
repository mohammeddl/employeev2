
const modal = document.getElementById('employeeFormContainer');
const formTitle = document.getElementById('formTitle');
const addEmployeeBtn = document.getElementById('addEmployeeBtn');
const closeBtn = document.getElementsByClassName('close')[0];
const employeeForm = document.getElementById('employeeForm');
const employeeIdField = document.getElementById('employeeId');

addEmployeeBtn.onclick = function() {
    formTitle.innerText = "Add Employee";
    employeeForm.reset();
    employeeIdField.value = '';
    modal.style.display = 'flex';
};

// Close the form modal
closeBtn.onclick = function() {
    modal.style.display = 'none';
};


window.onclick = function(event) {
    if (event.target === modal) {
        modal.style.display = 'none';
    }
};

employeeForm.onsubmit = function(event) {
    event.preventDefault();
    const employeeId = employeeIdField.value;
    if (employeeId) {
        console.log('Updating employee:', employeeId);
    } else {
        console.log('Adding new employee');
    }
    modal.style.display = 'none';
};

// Delete and edit buttons (for demo purposes, you would replace these with actual logic)
document.querySelectorAll('.edit-btn').forEach(btn => {
    btn.addEventListener('click', function() {
        formTitle.innerText = "Edit Employee";
        modal.style.display = 'flex';
    });
});

document.querySelectorAll('.delete-btn').forEach(btn => {
    btn.addEventListener('click', function() {
        console.log('Deleting employee');
    });
});
