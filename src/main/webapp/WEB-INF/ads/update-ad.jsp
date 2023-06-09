<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp" flush="true"/>
    <title>Create Ad</title>
</head>
<body>
<header>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" flush="true"/>
</header>
<main>
    <div class="container">
        <h1 class="my-2">Edit Ad</h1>
        <hr>
        <form action="${pageContext.request.contextPath}/ads/update/${sessionScope.ad.id}" method="post">
            <fieldset class="width-80">
                <div class="form-group">
                    <label for="title" class="form-label">Title</label>
                    <input id="title" name="title" class="form-control" type="text" value="${sessionScope.ad.title}">
                </div>
                <div class="form-group">
                    <label for="description" class="form-label">Description</label>
                    <textarea id="description" name="description" class="form-control">${sessionScope.ad.description}</textarea>
                </div>
                <input type="submit" class="btn btn-small btn-dark mt-2 login" value="save">
            </fieldset>
        </form>
    </div>
</main>
<footer>
    <jsp:include page="/WEB-INF/partials/footer.jsp" flush="true"/>
</footer>
</body>
</html>