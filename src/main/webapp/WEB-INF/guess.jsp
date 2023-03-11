<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp" flush="true"/>
    <title>Guessing Game</title>
</head>
<body>
<header>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" flush="true"/>
</header>
<main>
    <div class="container">
        <form action="./guess" method="post" id="guessing-game-form">
            <div class="mb-3">
                <label class="form-label">Pick A Number Between 1 and 3</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="guess" id="radio1" value="1">
                <label class="form-check-label" for="radio1">
                    1
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="guess" id="radio2" value="2">
                <label class="form-check-label" for="radio2">
                    2
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="guess" id="radio3" value="3">
                <label class="form-check-label" for="radio3">
                    3
                </label>
            </div>
            <button type="submit" class="btn btn-primary mt-3">Submit</button>
        </form>
    </div>
</main>
<footer>
    <jsp:include page="/WEB-INF/partials/footer.jsp" flush="true"/>
</footer>
</body>
</html>
