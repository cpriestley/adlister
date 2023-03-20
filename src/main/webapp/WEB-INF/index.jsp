<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp"/>
    <link rel="stylesheet" type="text/css"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.1/css/all.min.css">
    <title>Adlister</title>
</head>
<body>
<header>
    <div class="container">
        <jsp:include page="/WEB-INF/partials/navbar.jsp" flush="true"/>
        <h1 class="my-2">Welcome to Adlister</h1>
        <hr>
        <form action="${pageContext.request.contextPath}/ads/search" method="post" id="search" class="w-auto">
            <div class="input-group mb-3">
                <label>
                    <input type="text" name="searchTerms" class="form-control my-0 py-2">
                </label>
                <button class="btn btn-small btn-dark login" type="submit">Search</button>
            </div>
        </form>
        <hr>
    </div>
</header>
<main>
    <div class="container">
        <c:forEach var="ad" items="${sessionScope.ads}">
            <div class="item">
                <h3>
                    <a href="${pageContext.request.contextPath}/ads/${ad.id}" class="href">
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
<script src="https://kit.fontawesome.com/03567f1dd7.js" crossorigin="anonymous"></script>
</body>
</html>
