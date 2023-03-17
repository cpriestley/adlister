<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<c:forEach var="ad" items="${sessionScope.ads}">
    <div class="item">
        <h3>
            <a href="./ad/${ad.id}" class="href">
                <c:out value="${ad.title}"/>
            </a>
        </h3>
        <p><c:out value="${ad.description}"/></p>
    </div>
</c:forEach>