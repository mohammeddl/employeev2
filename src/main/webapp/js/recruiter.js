// Modal logic for job offers
const modal = document.getElementById('jobOfferFormContainer');
const formTitle = document.getElementById('formTitle');
const addJobOfferBtn = document.getElementById('addJobOfferBtn');
const closeBtn = document.getElementsByClassName('close')[0];
const jobOfferForm = document.getElementById('jobOfferForm');
const jobIdField = document.getElementById('jobId');

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
    const jobId = jobIdField.value;
    if (jobId) {
        console.log('Updating job offer:', jobId);
        // Update job offer logic
    } else {
        console.log('Creating new job offer');
        // Add job offer logic
    }
    modal.style.display = 'none';
};

// Change candidate application status
document.querySelectorAll('.status-btn').forEach(btn => {
    btn.addEventListener('click', function() {
        const newStatus = btn.getAttribute('data-status');
        console.log('Changing status to:', newStatus);
        // Change candidate status logic
    });
});
