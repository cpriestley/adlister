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
                <form action="${pageContext.request.contextPath}/user/update" method="post">
                    <jsp:include page="/WEB-INF/partials/profileEditFields.jsp" flush="true" />
                </form>
            </c:when>
            <c:otherwise>
                <form action="${pageContext.request.contextPath}/user/update" method="get">
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
        <c:forEach var="ad" items="${sessionScope.userAds}">
            <div class="item">
                <form id="ad-update-${ad.id}" action="/ad/update/${ad.id}" method="get" class="d-inline p-0 m-0">
                    <a href="javascript:document.getElementById('ad-update-${ad.id}').submit();">edit</a>
                </form>
                <form id="ad-delete-${ad.id}" action="/ad/delete/${ad.id}" method="post" class="d-inline p-0 m-0">
                    <a href="javascript:document.getElementById('ad-delete-${ad.id}').submit();">delete</a>
                </form>
                <a href="/ad/${ad.id}"><c:out value="${ad.title}"/></a>
            </div>
        </c:forEach>
    </div>
</main>
<footer>
    <jsp:include page="/WEB-INF/partials/footer.jsp"/>
</footer>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
</body>
</html>
