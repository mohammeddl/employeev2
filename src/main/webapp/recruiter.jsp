<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ManagerPro - Recruiter Dashboard</title>
    <link rel="stylesheet" href="css/recruiter.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>

<body>
    <div class="dashboard">
        <!-- Sidebar -->
        <div class="sidebar">
            <div class="logo-container">
                <h2 class="logo">ManagerPro</h2>
            </div>
            <ul class="nav-links">
                <li><a href="#"><i class="fas fa-home"></i>Dashboard</a></li>
                <li><a href="#"><i class="fas fa-briefcase"></i>Job Offers</a></li>
                <li><a href="#"><i class="fas fa-users"></i>Candidates</a></li>
                <li><a href="#"><i class="fas fa-chart-pie"></i>Reports</a></li>
                <li><a href="/oauth" class="logout-link"><i class="fas fa-sign-out-alt"></i>Logout</a></li>
            </ul>
        </div>

        <!-- Main content -->
        <div class="main-content">
            <div class="header">
                <h1>Welcome, Recruiter</h1>
                <div class="header-right">
                    <div class="user-info">
                        <img src="https://img.freepik.com/vecteurs-premium/illustration-icone-vectorielle-gestion-du-jeu-icones-business-analytics_904970-117820.jpg" alt="User" class="user-avatar">
                        <span>Recruiter Name</span>
                    </div>
                </div>
            </div>

            <div class="dashboard-content">
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
                                <td class="possionButton">
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
                           <c:forEach items="${candidates}" var="candidate">
                            <tr>
                                <td>1</td>
                                <td>${candidate.candidate.name}</td>
                                <td>${candidate.candidate.email}</td>
                                <td>${candidate.candidate.phoneNumber}</td>
                                <td>${candidate.status}</td>
                                <td>
                                    <a href="/recruiter?action=accepted&id=${candidate.id}" class="status-btn" data-status="Accepted">Accept</a>
                                    <a href="/recruiter?action=rejected&id=${candidate.id}" data-status="Rejected">Reject</a>
                                </td>
                            </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </section>

                <!-- Add/Edit Job Offer Modal -->
                <div id="jobOfferFormContainer" class="modal">
                    <div class="modal-content">
                        <span class="close">&times;</span>
                        <form id="jobOfferForm">

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
                            <input type="hidden" name="action" id="actionField">
                            <button type="submit" class="button">Save</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>

    <script src="js/recruiter.js"></script>
</body>

</html>
