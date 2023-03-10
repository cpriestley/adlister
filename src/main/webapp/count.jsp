<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp" />
    <title>Counter</title>
</head>
<body>
<header>
    <jsp:include page="partials/navbar.jsp" />
</header>
<main>
    <div class="container">
        <h1>Count: ${counter}</h1>
    </div>
</main>
<footer>
    <jsp:include page="partials/footer.jsp" />
</footer>
</body>
</html>
