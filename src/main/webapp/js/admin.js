const modal = document.getElementById("employeeFormContainer");
const formTitle = document.getElementById("formTitle");
const addEmployeeBtn = document.getElementById("addEmployeeBtn");
const closeBtn = document.getElementsByClassName("close")[0];
const employeeForm = document.getElementById("employeeForm");
const employeeIdField = document.getElementById("employeeId");
const nameField = document.getElementById("name");
const emailField = document.getElementById("email");
const phoneField = document.getElementById("phone");
const passwordField = document.getElementById("password");
const salaryField = document.getElementById("salary");
const departmentField = document.getElementById("department");
const positionField = document.getElementById("position");
const roleField = document.getElementById("role");
const actionField = document.getElementById("actionField");

addEmployeeBtn.onclick = function () {
  formTitle.innerText = "Add Employee";
  employeeForm.reset();
  employeeIdField.value = "";
  actionField.value = "create";
  modal.style.display = "flex";
};

closeBtn.onclick = function () {
  modal.style.display = "none";
};

window.onclick = function (event) {
  if (event.target === modal) {
    modal.style.display = "none";
  }
};

document.querySelectorAll(".edit-btn").forEach((btn) => {
  btn.addEventListener("click", function () {
    const employeeId = this.getAttribute("data-id");

    const row = this.closest("tr");
    const name = row.querySelector("td:nth-child(2)").innerText;
    const email = row.querySelector("td:nth-child(3)").innerText;
    const phone = row.querySelector("td:nth-child(4)").innerText;
    const role = row.querySelector("td:nth-child(5)").innerText;
    const salary = row.querySelector("td:nth-child(6)").innerText;
    const department = row.querySelector("td:nth-child(7)").innerText;
    const position = row.querySelector("td:nth-child(8)").innerText;
    

    employeeIdField.value = employee.id;
    nameField.value = employee.name;
    emailField.value = employee.email;
    phoneField.value = employee.phoneNumber;
    salaryField.value = employee.salary;
    departmentField.value = employee.department;
    positionField.value = employee.position;
    roleField.value = employee.role;

    passwordField.value = "";
    salaryField.value = "";
    departmentField.value = "";
    positionField.value = "";
    roleField.value = role;

    formTitle.innerText = "Edit Employee";
    actionField.value = "update";
    modal.style.display = "flex";
  });
});
