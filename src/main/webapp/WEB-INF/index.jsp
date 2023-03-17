<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp" />
    <title>Adlister</title>
</head>
<body>
<header>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" flush="true"/>
</header>
<main>
    <div class="container">
        <h1 class="my-2">Welcome to Adlister</h1>
        <hr>
        <c:forEach var="ad" items="${sessionScope.ads}">
            <div class="item">
                <h3>
                    <a href="./ad/${ad.id}" class="href">
                        <c:out value="${ad.title}"/>
                    </a>
                </h3>
                <p><c:out value="${ad.description}"/></p>
            </div>
        </c:forEach>
    </div>
</main>
<footer>
    <jsp:include page="/WEB-INF/partials/footer.jsp" flush="true"/>
</footer>
</body>
</html>
