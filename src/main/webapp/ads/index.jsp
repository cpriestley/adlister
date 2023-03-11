<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp" flush="true" />
    <title>Adlister</title>
</head>
<body>
<header>
    <jsp:include page="../partials/navbar.jsp" flush="true" />
</header>
<main>
  <div class="container">
      <c:forEach var="item" items="${requestScope.ads}">
          <div class="item">
              <h3>${item.title}</h3>
              <p>${item.description}</p>
          </div>
      </c:forEach>
  </div>
</main>
<footer>
    <jsp:include page="../partials/footer.jsp" flush="true" />
</footer>
</body>
</html>
