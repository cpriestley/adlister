<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp" flush="true" />
    <title>New User Registration</title>
</head>
<body>
<header>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" flush="true" />
</header>
<main>
    <div class="container m-auto">
        <h1 class="my-2">New User Registration</h1>
        <hr>
        <form action="./register" method="post" class="needs-validation" novalidate>
            <fieldset class="width-80">
                <div class="form-group">
                    <label for="username" class="form-label">Username</label>
                    <input type="text" id="username" name="username" class="form-control">
                </div>
                <div class="form-group">
                    <label for="email" class="form-label">Email</label>
                    <input type="email" id="email" name="email" class="form-control">
                </div>
                <div class="form-group">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" id="password" name="password" class="form-control">
                </div>
                <div class="form-group">
                    <label for="passwordConfirmation" class="form-label">Password Confirmation</label>
                    <input type="password" id="passwordConfirmation" name="passwordConfirmation" class="form-control">
                </div>
                <button class="btn btn-block" type="submit">Register</button>
            </fieldset>
        </form>
    </div>
</main>
<footer>
    <jsp:include page="/WEB-INF/partials/footer.jsp" flush="true" />
</footer>
</body>
</html>