<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="model.Message"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Admin || Shop Online</title>
        <!-- Site Icons -->
        <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/Dashboard.css">
        <link rel="stylesheet" href="css/message.css">
        <script src="https://kit.fontawesome.com/a4edd5786f.js" crossorigin="anonymous"></script>

        <!-- Bootstrap 5 -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    </head>
    <body>
        <%@include file="Topbar.jsp" %>

        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-3 menu-bar">
                    <div class="menu">
                        <ul class="menu-links">
                            <li class="nav-link">
                                <a href="/ShopOnline/dashboard">
                                    <span class="nav-link-icon">
                                        <i class="fa-solid fa-chart-simple fa-xl"></i>
                                    </span>
                                    <span class="text nav-text">Dashboard</span>
                                </a>
                            </li>

                            <li class="nav-link">
                                <a href="#">
                                    <span class="nav-link-icon">
                                        <i class="fa-solid fa-receipt fa-xl"></i>
                                    </span>
                                    <span class="text nav-text">Orders</span>
                                </a>
                            </li>

                            <li class="nav-link">
                                <a href="#">
                                    <span class="nav-link-icon">
                                        <i class="fa-solid fa-box fa-xl"></i>
                                    </span>
                                    <span class="text nav-text">Products</span>
                                </a>
                            </li>

                            <li class="nav-link">
                                <a href="/ShopOnline/CusController">
                                    <span class="nav-link-icon">
                                        <i class="fa-solid fa-user-group fa-xl"></i>
                                    </span>
                                    <span class="text nav-text">Customers</span>
                                </a>
                            </li>

                            <li class="nav-link">
                                <a class="active" href="#">
                                    <span class="nav-link-icon">
                                        <i class="fa-solid fa-envelope"></i>
                                    </span>
                                    <span class="text nav-text">Chats</span>
                                    <span class="badge bg-success rounded-circle ms-auto">1</span>
                                </a>
                            </li>

                            <li class="nav-link">
                                <a href="#">
                                    <span class="nav-link-icon">
                                        <i class="fa-solid fa-bell fa-xl"></i>
                                    </span>
                                    <span class="text nav-text">Notifications</span>
                                </a>
                            </li>

                            <li class="nav-link">
                                <a href="#sub-list3">
                                    <span class="nav-link-icon">
                                        <i class="fa-solid fa-comment-dots fa-xl"></i>
                                    </span>
                                    <span class="text nav-text">Feedback</span>
                                </a>
                            </li>

                            <li class="nav-link">
                                <a href="account.html">
                                    <span class="nav-link-icon">
                                        <i class="fa-solid fa-circle-user fa-xl"></i>
                                    </span>
                                    <span class="text nav-text">Accounts</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-9 main">
                    <div class="content ">    
                        <div class="row chat-block">
                            <!-- begin::chat sidebar -->
                            <div class="col-lg-5 chat-sidebar">
                                <!-- begin::chat sidebar search -->
                                <div class="chat-sidebar-header">
                                    <ul class="nav nav-pills" id="pills-tab" role="tablist">
                                        <li class="nav-item">
                                            <a class="nav-link active" id="pills-home-tab" data-bs-toggle="pill" href="#pills-home" role="tab" aria-controls="pills-home" aria-selected="true">All Chats</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" id="pills-contact-tab" data-bs-toggle="pill" href="#pills-contact" role="tab" aria-controls="pills-contact" aria-selected="false">Setting</a>
                                        </li>
                                    </ul>
                                    <form class="my-4">
                                        <input type="text" class="form-control" placeholder="Search" spellcheck="false" data-ms-editor="true">
                                    </form>
                                </div>
                                <!-- begin::chat sidebar search -->

                                <!-- end::chat list -->
                                <div class="chat-sidebar-content">
                                    <div class="tab-content">
                                        <div class="tab-pane fade active show" id="pills-home">
                                            <div class="chat-lists p-2">
                                                <div class="list-group list-group-flush">
                                                    <c:set var="isNull" value=" " />
                                                    <c:forEach items="${listGroupChat}" var="listGroupChat">
                                                        <c:choose>
                                                            <c:when test="${listGroupChat.id eq mrID}">
                                                                <div class="list-group-item active">
                                                                    <div class="pe-3">
                                                                        <span class="avatar">
                                                                            <img class="avatar " src="RetrieveImg?eaID=${listGroupChat.eaID}" alt="avatar">
                                                                            <span class="online"></span>
                                                                        </span>
                                                                    </div>
                                                                    <div class="flex-grow- 1">
                                                                        <p class="mb-1">${listGroupChat.name}</p>
                                                                        <c:if test="${listGroupChat.creatorIDMessage eq listGroupChat.customerID}">
                                                                            <c:if test="${listGroupChat.isRead eq 0}">
                                                                                <span class="text-muted" style="color: blue !important">${listGroupChat.creatorMessage}${listGroupChat.content}
                                                                                </span>  <span class="text-muted">${listGroupChat.time}</span>
                                                                            </c:if>
                                                                            <c:if test="${listGroupChat.isRead eq 1}">
                                                                                <span class="text-muted">${listGroupChat.creatorMessage}${listGroupChat.content}  ${listGroupChat.time}
                                                                                </span>
                                                                            </c:if>
                                                                        </c:if>

                                                                        <c:if test="${listGroupChat.creatorIDMessage ne listGroupChat.customerID}">
                                                                            <c:if test="${listGroupChat.isRead eq 0}">
                                                                                <span class="text-muted" >${listGroupChat.creatorMessage}${listGroupChat.content}
                                                                                </span>  <span class="text-muted">${listGroupChat.time}</span>
                                                                            </c:if>
                                                                            <c:if test="${listGroupChat.isRead eq 1}">
                                                                                <span class="text-muted">${listGroupChat.creatorMessage}${listGroupChat.content}</span>  <span class="text-muted">${listGroupChat.time}
                                                                                </span>
                                                                            </c:if>
                                                                        </c:if>

                                                                    </div>
                                                                    <div class="text-end ms-auto d-flex flex-column">
                                                                        <div class="dropdown ms-auto">
                                                                            <a href="#" data-bs-toggle="dropdown">
                                                                                <i class="fa-solid fa-ellipsis"></i>
                                                                            </a>
                                                                            <div class="dropdown-menu dropdown-menu-end">
                                                                                <a href="ProfileUser?userid=${listGroupChat.customerID}" class="dropdown-item">Profile</a>
                                                                                <a href="#" class="dropdown-item">Mark as read</a>
                                                                                <a href="#" class="dropdown-item">Delete</a>
                                                                            </div>
                                                                        </div>
                                                                        <c:if test="${listGroupChat.creatorIDMessage ne listGroupChat.customerID}">

                                                                            <c:if test="${listGroupChat.isRead eq 0}">
                                                                                <span class="small text-muted "><i class="fa-solid fa-circle-check" style="color: #BBB"></i></span>
                                                                                </c:if>

                                                                            <c:if test="${listGroupChat.isRead eq 1}">
                                                                                <span class="small text-muted ">
                                                                                    <img class="avatar avatarSeen" src="RetrieveImg?eaID=${listGroupChat.eaID}" alt="avatar">
                                                                                </span>
                                                                            </c:if>

                                                                        </c:if>

                                                                        <c:if test="${listGroupChat.creatorIDMessage eq listGroupChat.customerID}">

                                                                        </c:if>

                                                                    </div>
                                                                </div>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <div class="list-group-item " onclick="changeGroupchat(${listGroupChat.id})">
                                                                    <div class="pe-3">
                                                                        <span class="avatar">
                                                                            <img class="avatar " src="RetrieveImg?eaID=${listGroupChat.eaID}" alt="avatar">
                                                                            <span class="online"></span>
                                                                        </span>
                                                                    </div>
                                                                    <div class="flex-grow- 1">
                                                                        <p class="mb-1">${listGroupChat.name}</p>
                                                                        <c:if test="${listGroupChat.creatorIDMessage eq listGroupChat.customerID}">
                                                                            <c:if test="${listGroupChat.isRead eq 0}">
                                                                                <span class="text-muted" style="color: blue !important">${listGroupChat.creatorMessage}${listGroupChat.content}
                                                                                </span>  <span class="text-muted">${listGroupChat.time}</span>
                                                                            </c:if>
                                                                            <c:if test="${listGroupChat.isRead eq 1}">
                                                                                <span class="text-muted">${listGroupChat.creatorMessage}${listGroupChat.content}</span>  <span class="text-muted">${listGroupChat.time}
                                                                                </span>
                                                                            </c:if>
                                                                        </c:if>

                                                                        <c:if test="${listGroupChat.creatorIDMessage ne listGroupChat.customerID}">
                                                                            <c:if test="${listGroupChat.isRead eq 0}">
                                                                                <span class="text-muted" >${listGroupChat.creatorMessage}${listGroupChat.content}
                                                                                </span>  <span class="text-muted">${listGroupChat.time}</span>
                                                                            </c:if>
                                                                            <c:if test="${listGroupChat.isRead eq 1}">
                                                                                <span class="text-muted">${listGroupChat.creatorMessage}${listGroupChat.content}</span>  <span class="text-muted">${listGroupChat.time}
                                                                                </span>
                                                                            </c:if>
                                                                        </c:if>

                                                                    </div>
                                                                    <div class="text-end ms-auto d-flex flex-column">
                                                                        <div class="dropdown ms-auto">
                                                                            <a href="#" data-bs-toggle="dropdown">
                                                                                <i class="fa-solid fa-ellipsis"></i>
                                                                            </a>
                                                                            <div class="dropdown-menu dropdown-menu-end">
                                                                                <a href="ProfileUser?userid=${listGroupChat.customerID}" class="dropdown-item">Profile</a>
                                                                                <a href="#" class="dropdown-item">Mark as read</a>
                                                                                <a href="#" class="dropdown-item">Delete</a>
                                                                            </div>
                                                                        </div>

                                                                        <c:if test="${listGroupChat.creatorIDMessage ne listGroupChat.customerID}">

                                                                            <c:if test="${listGroupChat.isRead eq 0}">
                                                                                <span class="small text-muted "><i class="fa-solid fa-circle-check" style="color: #BBB"></i></span>
                                                                                </c:if>

                                                                            <c:if test="${listGroupChat.isRead eq 1}">
                                                                                <span class="small text-muted ">
                                                                                    <img class="avatar avatarSeen" src="RetrieveImg?eaID=${listGroupChat.eaID}" alt="avatar">
                                                                                </span>
                                                                            </c:if>

                                                                        </c:if>

                                                                        <c:if test="${listGroupChat.creatorIDMessage eq listGroupChat.customerID}">

                                                                        </c:if>
                                                                    </div>
                                                                </div>
                                                            </c:otherwise>
                                                        </c:choose>

                                                    </c:forEach>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- end::chat list -->
                            </div>

                            <!-- begin::chat content -->
                            <div class="col-lg-7 chat-content">
                                <!-- begin::messages -->
                                <div class="messages card">
                                    <div id="scroll-to-bottom" class="card-body">
                                        <c:set var = "now" value = "<%= new java.util.Date()%>"  />
                                        <fmt:formatDate var="timeMess"  pattern="yyyy-MM-dd" value="${now}"/>

                                        <c:forEach items="${listMess}" var="mess">
                                            <div class="content_message">
                                                <c:set var = "timeMessOld2" value = "${mess.createDate}"/>
                                                <c:set var = "timeMess2" value = "${fn:substring(timeMessOld2, 0, 10)}" />
                                                <c:set var = "hourMessOld2" value = "${mess.createDate}"/>
                                                <c:set var = "hourMess2" value = "${fn:substring(timeMessOld2, 11, 16)}" />

                                                <c:choose>
                                                    <c:when test="${listUserAdminID.contains(mess.fromID)}">
                                                        <div  class="message-item message-divider">
                                                            <c:if test="${timeMess ne timeMess2}">
                                                                <c:set var = "timeMess" value = "${timeMess2}"  />
                                                                <span>${timeMess}</span>
                                                            </c:if>

                                                        </div>
                                                        
                                                        <div class="divMYS">
                                                            <c:if test="${mess.isread eq 0}">
                                                                <span class="small text-muted checkIsread"><i class="fa-solid fa-circle-check" style="color:#BBB "></i></span>
                                                                </c:if>

                                                            <c:if test="${mess.isread eq 1}">
                                                                 <span class="small text-muted checkIsread"><i class="fa-solid fa-circle-check" style="color: #50b5ba"></i></span>
                                                            </c:if>
                                                            <div class="MYS">
                                                                <p>${mess.content}</p>
                                                            </div>
                                                            
                                                            <span class="text-time">${hourMess2}</span>
                                                            
                                                        </div>
                                                        
                                                    </c:when>
                                                    <c:otherwise>
                                                        
                                                        <div  class="message-item message-divider">
                                                            <c:if test="${timeMess ne timeMess2}">
                                                                <c:set var = "timeMess" value = "${timeMess2}"  />
                                                                <span>${timeMess}</span>
                                                            </c:if>

                                                        </div>
                                                        
                                                        <div class="divMYR">
                                                                                                                    
                                                            <span class="text-time">${hourMess2}</span>
                                                            <div class="MYR">
                                                                <p>${mess.content}</p>
                                                            </div>
                                                            
                                                        </div>

                                                    </c:otherwise>

                                                </c:choose>
                                            </div>
                                        </c:forEach>
                                    </div>
                                    <div class="card-footer">
                                        <form class="d-flex" action="message" method="post">
                                            <div class="dropdown flex-shrink-0 me-3">
                                                <button class="btn btn-rounded" type="button">
                                                    <i class="fa-solid fa-paperclip"></i>
                                                </button>
                                            </div>
                                            <input name="contentsend" type="text" class="form-control" placeholder="Write message...">

                                            <button name="getFROMandTO" value="${sessionScope.userlogged.userid};${listMess.get(0).toID};${mrID};messageAdmin" type="submit" class="btn btn-rounded flex-shrink-0 ms-3">Send</button>
                                        </form>
                                    </div>
                                </div>
                                <!-- end::messages -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script>
            function changeGroupchat(id) {
                window.location.href = 'message?mrID=' + id;
            }
            let scroll_to_bottom = document.getElementById('scroll-to-bottom');
		scroll_to_bottom.scrollTop = scroll_to_bottom.scrollHeight;
        </script>
    </body>

</html>
