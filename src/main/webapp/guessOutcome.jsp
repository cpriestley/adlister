<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
    <jsp:include page="partials/head.jsp" flush="true"/>
    <title>Guessing Game</title>
</head>
<body>
<header>
    <jsp:include page="partials/navbar.jsp" flush="true"/>
</header>
<main>
    <div class="container text-center py-5">
        <h1>${requestScope.outcome}</h1>
    </div>
</main>
<footer>
    <jsp:include page="partials/footer.jsp" flush="true"/>
</footer>
</body>
</html>
