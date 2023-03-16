<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp" flush="true" />
    <title>Ad</title>
</head>
<body>
<header>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" flush="true" />
</header>
<main>
    <div class="container">
        <h1 class="my-2">${requestScope.ad.title}</h1>
        <hr>
        <p>${requestScope.ad.description}</p>
    </div>
</main>
<footer>
    <jsp:include page="/WEB-INF/partials/footer.jsp" flush="true" />
</footer>
</body>
</html>