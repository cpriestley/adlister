<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp" flush="true" />
    <title>Create Ad</title>
</head>
<body>
<header>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" flush="true" />
</header>
<main>
<div class="container">
    <h1>Create a new Ad</h1>
    <form action="${pageContext.request.contextPath}/ads/create" method="post">
        <div class="form-group">
            <label for="title">Title</label>
            <input id="title" name="title" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea id="description" name="description" class="form-control"></textarea>
        </div>
        <input type="submit" class="btn btn-block btn-primary">
    </form>
</div>
</main>
<footer>
    <jsp:include page="/WEB-INF/partials/footer.jsp" flush="true" />
</footer>
</body>
</html>