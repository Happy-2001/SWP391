<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${sessionScope.userlogged eq null}">
    <c:redirect url="/login"></c:redirect>
</c:if>

<c:if test="${sessionScope.userlogged ne null}">
    <fmt:parseNumber var = "auid" type = "number" value = "${sessionScope.userlogged.authorityid}" />
    <c:if test="${auid > 2}">
        <c:redirect url="/HomeController"></c:redirect>
    </c:if>
</c:if>
