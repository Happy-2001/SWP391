<%-- 
    Document   : checkuserconfirm
    Created on : May 19, 2022, 11:03:08 PM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${sessionScope.userlogged ne null && sessionScope.userlogged.status eq 2}">
    <c:redirect url="confirm"></c:redirect>
</c:if>
