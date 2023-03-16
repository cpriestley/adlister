<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<c:forEach var="item" items="${requestScope.ads}">
    <div class="item">
        <h3>
            <a href="./ad/${item.id}" class="href">
                <c:out value="${item.title}"/>
            </a>
        </h3>
        <p><c:out value="${item.description}"/></p>
    </div>
</c:forEach>