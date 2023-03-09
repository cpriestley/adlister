<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    if ("post".equalsIgnoreCase(request.getMethod())) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if ("admin".equals(username) && "password".equals(password)) {
            response.sendRedirect("profile.jsp");
        }
    }
%>
<!doctype html>
<html>
<head>
    <jsp:include page="partials/head.jsp" />
    <title>Login</title>
</head>
<body>
<header>
    <jsp:include page="partials/navbar.jsp" />
    <title>Login</title>
</header>
<main>
    <div class="container m-auto">
        <form action="login.jsp" method="post">
            <fieldset class="width-80">
                <div class="form-group">
                    <label for="username" class="form-label">Username</label>
                    <input type="text" id="username" name="username" class="form-control">
                </div>
                <div class="form-group">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" id="password" name="password" class="form-control">
                </div>
                <button class="btn btn-block">Login</button>
            </fieldset>
        </form>
    </div>
</main>
<footer>
    <%@include file="partials/footer.jsp"%>
</footer>
</body>
</html>
