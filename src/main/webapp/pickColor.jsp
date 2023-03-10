<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
    <jsp:include page="partials/head.jsp" flush="true"/>
    <title>Pick Color</title>
</head>
<body>
<header>
    <jsp:include page="partials/navbar.jsp" flush="true"/>
</header>
<main>
    <div class="container">
        <form action="./viewcolor" method="get" id="color-picker-form">
            <div class="mb-3">
                <label for="color" class="form-label">Enter Your Favorite Color</label>
                <input type="text" class="form-control" id="color" name="color">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</main>
<footer>
    <jsp:include page="partials/footer.jsp" flush="true"/>
</footer>
</body>
</html>
