const modal = document.getElementById('jobOfferFormContainer');
const formTitle = document.getElementById('formTitle');
const addJobOfferBtn = document.getElementById('addJobOfferBtn');
const closeBtn = document.getElementsByClassName('close')[0];
const jobOfferForm = document.getElementById('jobOfferForm');
const jobIdField = document.getElementById('jobId');
const title = document.getElementById('title');
const description = document.getElementById('description');
const locations = document.getElementById('location');
const date = document.getElementById('date'); 
const errorMessage = document.createElement('p'); 

// Append error message placeholder after the date input
date.insertAdjacentElement('afterend', errorMessage);
errorMessage.style.color = 'red';
errorMessage.style.display = 'none'; // Hide it by default

addJobOfferBtn.onclick = function() {
    formTitle.innerText = "Create Job Offer";
    jobOfferForm.reset();
    jobIdField.value = '';
    modal.style.display = 'flex';
    errorMessage.style.display = 'none'; // Hide error when opening the form
};

closeBtn.onclick = function() {
    modal.style.display = 'none';
};

window.onclick = function(event) {
    if (event.target === modal) {
        modal.style.display = 'none';
    }
};

document.querySelectorAll('.edit-btn').forEach(btn => {
    btn.addEventListener('click', function(event) {
        const row = event.target.closest('tr');
        jobIdField.value = row.querySelector('td:nth-child(1)').innerText;
        title.value = row.querySelector('td:nth-child(2)').innerText;
        description.value = row.querySelector('td:nth-child(3)').innerText;
        locations.value = row.querySelector('td:nth-child(4)').innerText;
        date.value = row.querySelector('td:nth-child(5)').innerText;
        formTitle.innerText = "Update Job Offer";
        modal.style.display = 'flex';
        errorMessage.style.display = 'none'; // Hide error when opening the form for editing
    });
});

// Function to validate date
function isValidDate(selectedDate) {
    const currentDate = new Date().toISOString().split('T')[0]; // Get current date in YYYY-MM-DD format
    return selectedDate >= currentDate; // Returns true if selected date is today or in the future
}

// Add validation when the form is submitted
jobOfferForm.onsubmit = function(event) {
    const selectedEndDate = date.value; // Get the selected date from the form

    if (!isValidDate(selectedEndDate)) {
        event.preventDefault(); // Prevent form submission if the date is invalid
        errorMessage.textContent = 'End date cannot be before today.';
        errorMessage.style.display = 'block'; // Show error message
        return;
    }

    // If date is valid, proceed with the form submission logic
    const jobData = {
        jobId: jobIdField.value,
        title: title.value,
        description: description.value,
        location: locations.value,
        date: selectedEndDate,
        action: jobIdField.value ? "update" : "create"
    };

    fetch('/recruiter', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: new URLSearchParams(jobData).toString()
    }).then(response => {
        if (response.ok) {
            console.log('Job offer created/updated successfully');
            modal.style.display = 'none';
            window.location.reload(); 
        } else {
            console.log('Error occurred');
        }
    }).catch(error => {
        console.error('Error:', error);
    });
};
