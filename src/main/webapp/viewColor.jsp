<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
    <jsp:include page="partials/headNoCss.jsp" flush="true"/>
    <title>View Color</title>
</head>
<body style="background-color:${requestScope.bgColor};">
<header>
    <jsp:include page="partials/navbar.jsp" flush="true"/>
</header>
<main>
    <div class="container">
        <h1>The Background Is "${requestScope.bgColor}"</h1>
    </div>
</main>
<footer>
    <jsp:include page="partials/footer.jsp" flush="true"/>
</footer>
</body>
</html>
