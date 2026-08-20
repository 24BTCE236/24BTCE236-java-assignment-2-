<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"><meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Student Registration</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
</head>
<body>
<main class="page-shell">
    <section class="hero-panel">
        <span class="eyebrow">ADVANCED JAVA &amp; J2EE</span>
        <h1>Start your learning journey.</h1>
        <p>Register your student profile securely in a few simple steps.</p>
        <div class="feature"><span>✓</span><div><b>Validated details</b><small>Server-side validation keeps every submission accurate.</small></div></div>
        <div class="feature"><span>✓</span><div><b>Quick confirmation</b><small>Review the registered information immediately.</small></div></div>
    </section>

    <section class="form-panel">
        <div class="form-heading"><span class="step">01</span><div><h2>Student registration</h2><p>Enter your academic details below.</p></div></div>
        <form method="post" action="${pageContext.request.contextPath}/register" novalidate>
            <label for="name">Full name</label>
            <div class="input-wrap"><span>👤</span><input id="name" name="name" value="<c:out value='${name}'/>" placeholder="e.g. Nithish Kumar" maxlength="50" required></div>
            <c:if test="${not empty errors.name}"><p class="error"><c:out value="${errors.name}"/></p></c:if>

            <label for="email">Email ID</label>
            <div class="input-wrap"><span>✉</span><input type="email" id="email" name="email" value="<c:out value='${email}'/>" placeholder="student@example.com" maxlength="100" required></div>
            <c:if test="${not empty errors.email}"><p class="error"><c:out value="${errors.email}"/></p></c:if>

            <label for="course">Course</label>
            <div class="input-wrap"><span>🎓</span><select id="course" name="course" required><option value="">Select your course</option><c:forEach var="course" items="${courses}"><option value="<c:out value='${course}'/>" ${selectedCourse == course ? 'selected' : ''}><c:out value="${course}"/></option></c:forEach></select></div>
            <c:if test="${not empty errors.course}"><p class="error"><c:out value="${errors.course}"/></p></c:if>

            <button type="submit">Complete registration <span>→</span></button>
            <p class="privacy">🔒 Your details are used only for student registration.</p>
        </form>
    </section>
</main>
</body>
</html>
