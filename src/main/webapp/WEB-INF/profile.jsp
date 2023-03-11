<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp" />
    <title>Profile</title>
</head>
<body>
<header>
    <jsp:include page="/WEB-INF/partials/navbar.jsp"/>
</header>
<main>
    <div class="container text-center py-5">
        <h1 class="my-5">User Profile</h1>
        <hr>
        <form action="./logout" method="get">
            <fieldset class="width-80">
                <p>Welcome, ${sessionScope.user}</p>
                <button class="btn btn-block">Logout</button>
            </fieldset>
        </form>
    </div>
</main>
<footer>
    <jsp:include page="/WEB-INF/partials/footer.jsp"/>
</footer>
</body>
</html>
