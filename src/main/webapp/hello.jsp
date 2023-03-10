<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <jsp:include page="partials/head.jsp" />
    <title>Hello World</title>
</head>
<body>
<header>
    <jsp:include page="partials/navbar.jsp" />
</header>
<main>
    <div class="container">
        <h1>Hello there, ${name}!</h1>
    </div>
</main>
<footer>
    <jsp:include page="partials/footer.jsp" />
</footer>
</body>
</html>