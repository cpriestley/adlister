<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
        <h1 class="my-2">Create a new Ad</h1>
        <hr>
        <form action="${pageContext.request.contextPath}/ads/create" method="post">
            <fieldset class="width-80">
                <div class="form-group">
                    <label for="title" class="form-label">Title</label>
                    <input id="title" name="title" class="form-control" type="text" value="${param.title}">
                </div>
                <div class="form-group">
                    <label for="description" class="form-label">Description</label>
                    <textarea id="description" name="description" class="form-control">${param.description}</textarea>
                </div>
                <div class="form-group">
                    <label class="form-label">What type of posting will this be?</label>
                    <br>
                    <c:forEach items="${sessionScope.categories}" var="category">
                        <c:set var="categoryId" value="${fn:replace(category, ' ', '-')}" />
                        <input type="radio" id="${categoryId}" name="category" value="${category}">
                        <label for="${categoryId}">${category}</label>
                        <br>
                    </c:forEach>
                </div>
                <div class="form-group">
                    <label class="form-label">What categories apply to this post?</label>
                    <br>
                    <c:forEach var="entry" items="${sessionScope.subCategoryMap}">
                        <c:set var="categoryId" value="${fn:replace(entry.key, ' ', '-')}-sc" />
                        <div class="sc-div d-none" id="${categoryId}">
                            <c:forEach var="subcategory" items="${entry.value}">
                                <input type="checkbox" id="${subcategory}" name="subcategory" value="${subcategory}">
                                <label for="${subcategory}">${subcategory}</label>
                            </c:forEach>
                        </div>
                    </c:forEach>
                </div>
                <input type="submit" class="btn btn-small btn-dark mt-2 login">
            </fieldset>
        </form>
    </div>
</main>
<footer>
    <jsp:include page="/WEB-INF/partials/footer.jsp" flush="true"/>
</footer>
<script src="https://code.jquery.com/jquery-3.6.3.js" integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM="
        crossorigin="anonymous"></script>
<script>
    $(document).ready(function () {
        $('input[type=radio][name=category]').change(function () {
            let active = $('input[type=radio][name=category]:checked').val();
            active = '#' + active.replace(/\s+/g, '-') + '-sc';
            $('.sc-div').addClass('d-none');
            console.log(active);
            $(active).removeClass('d-none');
        });
    });
</script>
</body>
</html>