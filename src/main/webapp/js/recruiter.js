// Modal logic for job offers
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


// Open modal for adding new job offer
addJobOfferBtn.onclick = function() {
    formTitle.innerText = "Create Job Offer";
    jobOfferForm.reset();
    jobIdField.value = '';
    modal.style.display = 'flex';
};

// Close modal
closeBtn.onclick = function() {
    modal.style.display = 'none';
};

// Close modal when clicking outside of it
window.onclick = function(event) {
    if (event.target === modal) {
        modal.style.display = 'none';
    }
};

// Submit the form for adding/editing job offer
jobOfferForm.onsubmit = function(event) {
    event.preventDefault();
    
    const jobData = {
        jobId: jobIdField.value,
        title: title.value,
        description: description.value,
        location: locations.value,
        date: date.value,
        action: "create"
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
        } else {
            console.log('Error occurred');
        }
    }).catch(error => {
        console.error('Error:', error);
    });
};


// Change candidate application status
document.querySelectorAll('.status-btn').forEach(btn => {
    btn.addEventListener('click', function() {
        const newStatus = btn.getAttribute('data-status');
        console.log('Changing status to:', newStatus);
        // Change candidate status logic
    });
});


