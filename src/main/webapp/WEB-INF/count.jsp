<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp" />
    <title>Counter</title>
</head>
<body>
<header>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
</header>
<main>
    <div class="container">
        <h1>Count: ${requestScope.counter}</h1>
    </div>
</main>
<footer>
    <jsp:include page="/WEB-INF/partials/footer.jsp" />
</footer>
</body>
</html>
