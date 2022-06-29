<%-- 
    Document   : Messenger
    Created on : May 30, 2022, 4:39:20 PM
    Author     : Administrator
--%>
<%@page import="model.Message"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/message.css">

<c:if test="${sessionScope.role ne sessionScope.roleadmin or sessionScope.role eq null }">
    <!-- mess -->
    <div style="" class="collapse show" id="mess">
        <div class="card message">
            <div class="card-header">
                <div class="row">
                    <div class="col-lg-10 col-md-10">            
                        <img src="images/logo.png" class="logo" width="50%">
                    </div>
                    <div class="col-lg-2 col-md-2 text-center">
                        <a href="#mess" data-bs-toggle="collapse">
                            <i class="fa-solid fa-minus"></i>
                        </a>
                    </div>
                </div>
            </div>
            <div class="card-body">
                <div class="content_message">
                    <div class="slogans">
                        <img src="images/logo.png" width="60%">
                            <h6>Wear your Best - A Moments of Your Style</h6>
                    </div>
                    <c:choose>
                        <c:when test="${listMess eq null}">
                            <div class="autochat">
                                <div>
                                    <input type="text" name="checkMess" hidden="" value="nullMessage" />
                                    <span class="title">Let us help you</span>
                                    <div class="basicBox">
                                        <a href="autochat">Start
                                            <svg viewBox="0 0 120 40" xmlns="http://www.w3.org/2000/svg">
                                                <rect x='0' y='0' fill='none' width='120' height='40'/>
                                            </svg>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <c:forEach items="${listMess}" var="mess">
                                <c:choose>
                                    <c:when test="${listUserAdminID.contains(mess.fromID)}">
                                        <div class="divMYR">
                                            <div class="MYR">
                                                ${mess.content} ${listUserAdminID[0]}
                                            </div>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="divMYS">
                                            <div class="MYS">
                                                ${mess.content}
                                            </div>
                                        </div>
                                    </c:otherwise>

                                </c:choose>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
            <div class="card-footer">
                <div class="menu_message">
                    <form action="message" method="post">
                        <div class="row align-items-center">
                            <div class="send col-md-10">
                                <input name="contentsend" type="text" placeholder="Viết gì đó...">
                            </div>
                            <div class="send_button col-md-2">
                                <button name="getFROMandTO" value="${listMess.get(0).fromID};${listMess.get(0).toID}" type="submit"><i class="fa-solid fa-paper-plane fa-lg"></i></button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- end mess -->
</c:if>
    
<button id="messenger-btn" data-bs-toggle="collapse" data-bs-target="#mess"><i class="fa-brands fa-facebook-messenger"></i></button>
