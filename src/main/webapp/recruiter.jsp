<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Recruitment Management</title>
    <link rel="stylesheet" href="css/recruiter.css">
</head>
<body>

    <div class="container">
        <h1>Recruitment Management</h1>

        <section id="jobOfferSection">
            <h2>Job Offers</h2>
            <h1>${message}</h1>

            <button id="addJobOfferBtn" class="button">Create Job Offer</button>

            <table id="jobOfferTable">
                <thead>
                    <tr>
                        <th>Job ID</th>
                        <th>Title</th>
                        <th>Description</th>
                        <th>Location</th>
                        <th>Status</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                     <c:forEach items="${jobOffers}" var="jobOffer">
                    <tr>
                        <td>${jobOffer.id}</td>
                        <td>${jobOffer.title}</td>
                        <td>${jobOffer.description}</td>
                        <td>${jobOffer.location}</td>
                        <td>${jobOffer.endDate}</td>
                        <td>
                            <button class="edit-btn">Edit</button>
                            <form action="/recruiter" method="post">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="id" value="${jobOffer.id}">
                            <input type="submit" class="delete-btn" value="Delete">
                            </form>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </section>

        <section id="candidateSection">
            <h2>Candidate Applications</h2>

            <table id="candidateTable">
                <thead>
                    <tr>
                        <th>Candidate ID</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Job Applied</th>
                        <th>Status</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                   
                    <tr>
                        <td>1</td>
                        <td>John Doe</td>
                        <td>john.doe@example.com</td>
                        <td>Software Developer</td>
                        <td>Received</td>
                        <td>
                            <button class="status-btn" data-status="In Progress">In Progress</button>
                            <button class="status-btn" data-status="Accepted">Accept</button>
                            <button class="status-btn" data-status="Rejected">Reject</button>
                        </td>
                    </tr>

                    <!-- More rows can be added dynamically -->
                </tbody>
            </table>
        </section>

        <!-- Add/Edit Job Offer Modal -->
        <div id="jobOfferFormContainer" class="modal">
            <div class="modal-content">
                <span class="close">&times;</span>
                <form id="jobOfferForm" method="post" action="/recruiter">
                    <h2 id="formTitle">Create Job Offer</h2>
                    <input type="hidden" id="jobId" name="jobId">

                    <label for="title">Job Title:</label>
                    <input type="text" id="title" name="title" required>

                    <label for="description">Job Description:</label>
                    <textarea id="description" name="description" required></textarea>

                    <label for="location">Location:</label>
                    <input type="text" id="location" name="location" required>

                    <label for="date">End Date:</label>
                    <input type="date" id="date" name="date" required>
                    <button type="submit" class="button">Save</button>
                </form>
            </div>
        </div>
    </div>

    <script src="js/recruiter.js"></script>
</body>
</html>
