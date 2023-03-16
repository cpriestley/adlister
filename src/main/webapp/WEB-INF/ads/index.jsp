<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp" flush="true"/>
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
        <c:forEach var="item" items="${requestScope.ads}">
            <div class="item">
                <h3>
                    <a href="./ad/${item.id}" class="href">
                        <c:out value="${item.title}"/>
                    </a>
                </h3>
                <p><c:out value="${item.description}"/></p>
            </div>
        </c:forEach>
    </div>
</main>
<footer>
    <jsp:include page="/WEB-INF/partials/footer.jsp" flush="true"/>
</footer>
</body>
</html>
