<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp" flush="true" />
    <title>New User Registration</title>
</head>
<body>
<header>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" flush="true" />
</header>
<main>
    <div class="container m-auto">
        <h1 class="my-2">New User Registration</h1>
        <hr>
        <form action="${pageContext.request.contextPath}/user/register" method="post" class="needs-validation" novalidate>
            <jsp:include page="/WEB-INF/partials/profileEditFields.jsp" flush="true" />
        </form>
    </div>
</main>
<footer>
    <jsp:include page="/WEB-INF/partials/footer.jsp" flush="true" />
</footer>
</body>
</html>