<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp"/>
    <title>Profile</title>
</head>
<body>
<header>
    <jsp:include page="/WEB-INF/partials/navbar.jsp"/>
</header>
<main>
    <div class="container">
        <h1 class="my-2">${sessionScope.user.getUsername()}</h1>
        <hr>
        <c:choose>
            <c:when test="${requestScope.edit eq true}">
                <form action="./save" method="post">
                    <jsp:include page="/WEB-INF/partials/profileEditFields.jsp" flush="true" />
                </form>
            </c:when>
            <c:otherwise>
                <form action="./edit" method="get">
                    <fieldset class="width-80">
                        <p class="lead">Profile Information:</p>
                        <dl>
                            <dt>Username</dt>
                            <dd>${sessionScope.user.getUsername()}</dd>
                        </dl>
                        <dl>
                            <dt>Email</dt>
                            <dd>${sessionScope.user.getEmail()}</dd>
                        </dl>
                        <button class="btn btn-small btn-dark mt-2 logout">Edit</button>
                    </fieldset>
                </form>
            </c:otherwise>
        </c:choose>
    </div>
    <div class="container">
        <jsp:include page="/WEB-INF/partials/ads.jsp" flush="true"/>
    </div>
</main>
<footer>
    <jsp:include page="/WEB-INF/partials/footer.jsp"/>
</footer>
</body>
</html>
