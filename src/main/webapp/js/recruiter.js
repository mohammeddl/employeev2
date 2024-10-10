// Existing code
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

addJobOfferBtn.onclick = function() {
    formTitle.innerText = "Create Job Offer";
    jobOfferForm.reset();
    jobIdField.value = '';
    modal.style.display = 'flex';
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
    });
});

jobOfferForm.onsubmit = function(event) {
    event.preventDefault();
    const jobData = {
        jobId: jobIdField.value,
        title: title.value,
        description: description.value,
        location: locations.value,
        date: date.value,
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
            // You may want to refresh the job offers list here
        } else {
            console.log('Error occurred');
        }
    }).catch(error => {
        console.error('Error:', error);
    });
};
