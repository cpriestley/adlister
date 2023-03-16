<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp"/>
    <title>Login</title>
</head>
<body>
<header>
    <jsp:include page="/WEB-INF/partials/navbar.jsp"/>
    <title>Login</title>
</header>
<main>
    <div class="container m-auto">
        <h1 class="my-2">Login</h1>
        <hr>
        <form action="./login" method="post" id="login" class="p-1 my-1 mx-auto w-50">
            <fieldset class="width-80">
                <div class="form-group">
                    <label for="username" class="form-label">Username</label>
                    <input type="text" id="username" name="username" class="form-control" required>
                </div>
                <div class="form-group">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" id="password" name="password" class="form-control" required>
                </div>
                <button class="btn btn-small btn-dark mt-2 login">Login</button>
            </fieldset>
        </form>
        <p class="text-center fst-italic fs-5 my-3">or</p>
        <form action="./register" method="post" id="register" class="p-1 my-1 mx-auto w-50">
            <fieldset class="width-80">
                <div class="form-group">
                    <label for="email" class="form-label">Email</label>
                    <input type="text" id="email" name="email" class="form-control" required>
                </div>
                <button class="btn btn-small btn-dark mt-2 login">Create Account</button>
            </fieldset>
        </form>
    </div>
</main>
<footer>
    <%@include file="partials/footer.jsp" %>
</footer>
</body>
</html>
