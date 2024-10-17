<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Candidate Dashboard - Job Offers</title>
    <link rel="stylesheet" href="css/candidate.css">
</head>
<body>
    <header>
        <section class="relative-section">
    <div class="navbar-container">
        <a href="/candidate" class="logo">ManagePro</a>

        <nav class="main-nav">
            <a href="/candidate" class="nav-link">Home</a>
            <div class="separator"></div>
            <a href="/oauth" class="signup-button">logout</a>
        </nav>

        <!-- Mobile Button -->
        <div class="mobile-menu-icon">
            <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 8h16M4 16h16"></path>
            </svg>
        </div>
    </div>
</section>
    </header>

    <h1>Available Job Offers</h1>

    <c:if test="${not empty message}">
        <p>${message}</p>
    </c:if>

    <table border="1">
        <thead>
            <tr>
                <th>Job Title</th>
                <th>Description</th>
                <th>Location</th>
                <th>End Date</th>
                <th>Apply</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="jobOffer" items="${jobOffers}">
                <tr>
                    <td>${jobOffer.title}</td>
                    <td>${jobOffer.description}</td>
                    <td>${jobOffer.location}</td>
                    <td>${jobOffer.endDate}</td>
                    <td>
                        <form action="candidate" method="post">
                            <input type="hidden" name="action" value="apply">
                            <input type="hidden" name="jobOfferId" value="${jobOffer.id}">
                            <button type="submit">Apply</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>


</body>
</html>
