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
        <script src="js/message.js" ></script>

        <!-- Bootstrap 5 -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
        <style>
            .checkIsread{
                transition: ease-in 0.3s;
                display: none;
            }
            .divMYS:hover .checkIsread,.divMYS:hover .fa-reply{
                display: block;
            }
            .divMYR:hover .checkIsread,.divMYR:hover .fa-reply{
                display: block;
            }
            .fa-reply{
                color: #ced4da;
                margin-left: 5px;
                margin-right: 5px;
                display: none;
                transition: ease-in 0.3s;
            }
            .replyMess{
                height: 0;
                width: 0;

                display: inline;
                overflow-x: hidden;

            }
            .replyMess-left{
                width: 90%;
                float: left;
            }
            .replyMess-right{
                width: 10%;
                float: right;
            }

        </style>
    </head>
    <body>
        <c:set var="ChatsActive" value="active"/>
        <%@include file="Topbar.jsp" %>

        <div class="container-fluid">
            <div class="row">
                <%@include file="menuDashBoard.jsp" %>
                <div class="col-lg-9 main" style="padding-bottom: 0">
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
                                                        <c:if test="${listGroupChat.status eq 0}">
                                                            <c:choose>
                                                                <c:when test="${listGroupChat.id eq mrID}">
                                                                    <div class="list-group-item active">
                                                                        <div class="pe-3">
                                                                            <span class="avatar">
                                                                                <img class="avatar " src="RetrieveImg?eaID=${listGroupChat.eaID}" alt="avatar"><!--RetrieveImg?eaID=${listGroupChat.eaID}-->
                                                                                <span class="online"></span>
                                                                            </span>
                                                                        </div>
                                                                        <div class="flex-grow- 1">
                                                                            <p class="mb-1">${listGroupChat.name}</p>
                                                                            <c:choose>
                                                                                <c:when test="${!listUserAdminID.contains(listGroupChat.creatorIDMessage)}"> <!--check tin nhan cuoi la cua admin hay customer-->
                                                                                    <c:if test="${listGroupChat.isRead eq 0}">
                                                                                        <span class="text-muted" style="color: blue !important">${listGroupChat.creatorMessage}${listGroupChat.content}
                                                                                        </span>  <span class="text-muted">${listGroupChat.time}</span>
                                                                                    </c:if>
                                                                                    <c:if test="${listGroupChat.isRead eq 1}">
                                                                                        <span class="text-muted">${listGroupChat.creatorMessage}${listGroupChat.content}
                                                                                        </span> <span class="text-muted">${listGroupChat.time}</span>
                                                                                    </c:if>

                                                                                </c:when>
                                                                                <c:otherwise>
                                                                                    <c:if test="${listGroupChat.isRead eq 0}">
                                                                                        <span class="text-muted" >${listGroupChat.creatorMessage}${listGroupChat.content}
                                                                                        </span>  <span class="text-muted">${listGroupChat.time}</span>
                                                                                    </c:if>
                                                                                    <c:if test="${listGroupChat.isRead eq 1}">
                                                                                        <span class="text-muted">${listGroupChat.creatorMessage}${listGroupChat.content}</span>  <span class="text-muted">${listGroupChat.time}
                                                                                        </span>
                                                                                    </c:if>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                        </div>
                                                                        <div class="text-end ms-auto d-flex flex-column">
                                                                            <div class="dropdown ms-auto">
                                                                                <a href="#" data-bs-toggle="dropdown">
                                                                                    <i class="fa-solid fa-ellipsis"></i>
                                                                                </a>
                                                                                <div class="dropdown-menu dropdown-menu-end">
                                                                                    <a href="ProfileUser?userid=${listGroupChat.customerID}" class="dropdown-item">Profile</a>
                                                                                    <a href="asread?mrID=${mrID}&&messID=${listGroupChat.messageID}&&groupID=${listGroupChat.groupID}" class="dropdown-item">Mark as read</a>
                                                                                    <a id="delete" href="#"  onclick="deleteGroup('${listGroupChat.groupID}', '${listGroupChat.name}')" class="dropdown-item">Hind box chat</a>
                                                                                </div>
                                                                            </div>
                                                                            <c:choose>
                                                                                <c:when test="${listUserAdminID.contains(listGroupChat.creatorIDMessage)}"> <!--check tin nhan cuoi la cua admin hay customer-->
                                                                                    <c:if test="${listGroupChat.isRead eq 0}">
                                                                                        <span class="small text-muted "><i class="fa-solid fa-circle-check" style="color: #BBB"></i></span>
                                                                                        </c:if>

                                                                                    <c:if test="${listGroupChat.isRead eq 1}">
                                                                                        <span class="small text-muted ">
                                                                                            <img style="height: 1rem !important;
                                                                                                 width: 1rem !important;" class="avatar avatarSeen" src="RetrieveImg?eaID=${listGroupChat.eaID}" alt="avatar">
                                                                                        </span>
                                                                                    </c:if>

                                                                                </c:when>

                                                                            </c:choose>

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
                                                                            <c:choose>
                                                                                <c:when test="${!listUserAdminID.contains(listGroupChat.creatorIDMessage)}"> <!--check tin nhan cuoi la cua admin hay customer-->
                                                                                    <c:if test="${listGroupChat.isRead eq 0}">
                                                                                        <span class="text-muted" style="color: blue !important">${listGroupChat.creatorMessage}${listGroupChat.content}
                                                                                        </span>  <span class="text-muted">${listGroupChat.time}</span>
                                                                                    </c:if>
                                                                                    <c:if test="${listGroupChat.isRead eq 1}">
                                                                                        <span class="text-muted">${listGroupChat.creatorMessage}${listGroupChat.content}
                                                                                        </span> <span class="text-muted">${listGroupChat.time}</span>
                                                                                    </c:if>

                                                                                </c:when>
                                                                                <c:otherwise>
                                                                                    <c:if test="${listGroupChat.isRead eq 0}">
                                                                                        <span class="text-muted" >${listGroupChat.creatorMessage}${listGroupChat.content}
                                                                                        </span>  <span class="text-muted">${listGroupChat.time}</span>
                                                                                    </c:if>
                                                                                    <c:if test="${listGroupChat.isRead eq 1}">
                                                                                        <span class="text-muted">${listGroupChat.creatorMessage}${listGroupChat.content}</span>  <span class="text-muted">${listGroupChat.time}
                                                                                        </span>
                                                                                    </c:if>
                                                                                </c:otherwise>
                                                                            </c:choose>

                                                                        </div>
                                                                        <div class="text-end ms-auto d-flex flex-column">
                                                                            <div class="dropdown ms-auto">
                                                                                <a href="#" data-bs-toggle="dropdown">
                                                                                    <i class="fa-solid fa-ellipsis"></i>
                                                                                </a>
                                                                                <div class="dropdown-menu dropdown-menu-end">
                                                                                    <a href="ProfileUser?userid=${listGroupChat.customerID}" class="dropdown-item">Profile</a>
                                                                                    <a href="asread?mrID=${mrID}&&messID=${listGroupChat.messageID}&&groupID=${listGroupChat.groupID}" class="dropdown-item">Mark as read</a>
                                                                                    <a href="#" onclick="deleteGroup('${listGroupChat.groupID}', '${listGroupChat.name}')" class="dropdown-item">Hind box chat</a>
                                                                                </div>
                                                                            </div>
                                                                            <c:choose>
                                                                                <c:when test="${listUserAdminID.contains(listGroupChat.creatorIDMessage)}"> <!--check tin nhan cuoi la cua admin hay customer-->
                                                                                    <c:if test="${listGroupChat.isRead eq 0}">
                                                                                        <span class="small text-muted "><i class="fa-solid fa-circle-check" style="color: #BBB"></i></span>
                                                                                        </c:if>

                                                                                    <c:if test="${listGroupChat.isRead eq 1}">
                                                                                        <span class="small text-muted ">
                                                                                            <img style="height: 1rem !important;
                                                                                                 width: 1rem !important;" class="avatar avatarSeen" src="RetrieveImg?eaID=${listGroupChat.eaID}" alt="avatar">
                                                                                        </span>
                                                                                    </c:if>

                                                                                </c:when>

                                                                            </c:choose>

                                                                        </div>
                                                                    </div>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </c:if>

                                                    </c:forEach>

                                                </div>
                                            </div>
                                        </div>
                                        <div class="tab-pane fade active" id="pills-contact">
                                            <div class="chat-lists p-2">
                                                <div class="list-group list-group-flush">
                                                    <c:set var="isNull" value=" " />
                                                    <c:forEach items="${listGroupChat}" var="listGroupChat">
                                                        <c:if test="${listGroupChat.status eq 1}">
                                                            <c:choose>
                                                                <c:when test="${listGroupChat.id eq mrID}">
                                                                    <div class="list-group-item ">
                                                                        <div class="pe-3">
                                                                            <span class="avatar">
                                                                                <img class="avatar " src="RetrieveImg?eaID=${listGroupChat.eaID}" alt="avatar"><!--RetrieveImg?eaID=${listGroupChat.eaID}-->
                                                                                <span class="online"></span>
                                                                            </span>
                                                                        </div>
                                                                        <div class="flex-grow- 1">
                                                                            <p class="mb-1">${listGroupChat.name}</p>
                                                                            <c:choose>
                                                                                <c:when test="${!listUserAdminID.contains(listGroupChat.creatorIDMessage)}"> <!--check tin nhan cuoi la cua admin hay customer-->
                                                                                    <c:if test="${listGroupChat.isRead eq 0}">
                                                                                        <span class="text-muted" style="color: blue !important">${listGroupChat.creatorMessage}${listGroupChat.content}
                                                                                        </span>  <span class="text-muted">${listGroupChat.time}</span>
                                                                                    </c:if>
                                                                                    <c:if test="${listGroupChat.isRead eq 1}">
                                                                                        <span class="text-muted">${listGroupChat.creatorMessage}${listGroupChat.content}
                                                                                        </span> <span class="text-muted">${listGroupChat.time}</span>
                                                                                    </c:if>

                                                                                </c:when>
                                                                                <c:otherwise>
                                                                                    <c:if test="${listGroupChat.isRead eq 0}">
                                                                                        <span class="text-muted" >${listGroupChat.creatorMessage}${listGroupChat.content}
                                                                                        </span>  <span class="text-muted">${listGroupChat.time}</span>
                                                                                    </c:if>
                                                                                    <c:if test="${listGroupChat.isRead eq 1}">
                                                                                        <span class="text-muted">${listGroupChat.creatorMessage}${listGroupChat.content}</span>  <span class="text-muted">${listGroupChat.time}
                                                                                        </span>
                                                                                    </c:if>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                        </div>
                                                                        <div class="text-end ms-auto d-flex flex-column">
                                                                            <div class="dropdown ms-auto">
                                                                                <a href="#" data-bs-toggle="dropdown">
                                                                                    <i class="fa-solid fa-ellipsis"></i>
                                                                                </a>
                                                                                <div class="dropdown-menu dropdown-menu-end">
                                                                                    <a href="ProfileUser?userid=${listGroupChat.customerID}" class="dropdown-item">Profile</a>
                                                                                    <a href="asread?mrID=${mrID}&&messID=${listGroupChat.messageID}&&groupID=${listGroupChat.groupID}" class="dropdown-item">Mark as read</a>
                                                                                    <a id="delete" href="#"  onclick="showGroup('${listGroupChat.groupID}', '${listGroupChat.name}')" class="dropdown-item">Show box chat</a>
                                                                                </div>
                                                                            </div>
                                                                            <c:choose>
                                                                                <c:when test="${listUserAdminID.contains(listGroupChat.creatorIDMessage)}"> <!--check tin nhan cuoi la cua admin hay customer-->
                                                                                    <c:if test="${listGroupChat.isRead eq 0}">
                                                                                        <span class="small text-muted "><i class="fa-solid fa-circle-check" style="color: #BBB"></i></span>
                                                                                        </c:if>

                                                                                    <c:if test="${listGroupChat.isRead eq 1}">
                                                                                        <span class="small text-muted ">
                                                                                            <img style="height: 1rem !important;
                                                                                                 width: 1rem !important;" class="avatar avatarSeen" src="RetrieveImg?eaID=${listGroupChat.eaID}" alt="avatar">
                                                                                        </span>
                                                                                    </c:if>

                                                                                </c:when>

                                                                            </c:choose>

                                                                        </div>
                                                                    </div>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <div class="list-group-item " >
                                                                        <div class="pe-3">
                                                                            <span class="avatar">
                                                                                <img class="avatar " src="RetrieveImg?eaID=${listGroupChat.eaID}" alt="avatar">
                                                                                <span class="online"></span>
                                                                            </span>
                                                                        </div>
                                                                        <div class="flex-grow- 1">
                                                                            <p class="mb-1">${listGroupChat.name}</p>
                                                                            <c:choose>
                                                                                <c:when test="${!listUserAdminID.contains(listGroupChat.creatorIDMessage)}"> <!--check tin nhan cuoi la cua admin hay customer-->
                                                                                    <c:if test="${listGroupChat.isRead eq 0}">
                                                                                        <span class="text-muted" style="color: blue !important">${listGroupChat.creatorMessage}${listGroupChat.content}
                                                                                        </span>  <span class="text-muted">${listGroupChat.time}</span>
                                                                                    </c:if>
                                                                                    <c:if test="${listGroupChat.isRead eq 1}">
                                                                                        <span class="text-muted">${listGroupChat.creatorMessage}${listGroupChat.content}
                                                                                        </span> <span class="text-muted">${listGroupChat.time}</span>
                                                                                    </c:if>

                                                                                </c:when>
                                                                                <c:otherwise>
                                                                                    <c:if test="${listGroupChat.isRead eq 0}">
                                                                                        <span class="text-muted" >${listGroupChat.creatorMessage}${listGroupChat.content}
                                                                                        </span>  <span class="text-muted">${listGroupChat.time}</span>
                                                                                    </c:if>
                                                                                    <c:if test="${listGroupChat.isRead eq 1}">
                                                                                        <span class="text-muted">${listGroupChat.creatorMessage}${listGroupChat.content}</span>  <span class="text-muted">${listGroupChat.time}
                                                                                        </span>
                                                                                    </c:if>
                                                                                </c:otherwise>
                                                                            </c:choose>

                                                                        </div>
                                                                        <div class="text-end ms-auto d-flex flex-column">
                                                                            <div class="dropdown ms-auto">
                                                                                <a href="#" data-bs-toggle="dropdown">
                                                                                    <i class="fa-solid fa-ellipsis"></i>
                                                                                </a>
                                                                                <div class="dropdown-menu dropdown-menu-end">
                                                                                    <a href="ProfileUser?userid=${listGroupChat.customerID}" class="dropdown-item">Profile</a>
                                                                                    <a href="asread?mrID=${mrID}&&messID=${listGroupChat.messageID}&&groupID=${listGroupChat.groupID}" class="dropdown-item">Mark as read</a>
                                                                                    <a href="#" onclick="showGroup('${listGroupChat.groupID}', '${listGroupChat.name}')" class="dropdown-item">Show box chat</a>
                                                                                </div>
                                                                            </div>
                                                                            <c:choose>
                                                                                <c:when test="${listUserAdminID.contains(listGroupChat.creatorIDMessage)}"> <!--check tin nhan cuoi la cua admin hay customer-->
                                                                                    <c:if test="${listGroupChat.isRead eq 0}">
                                                                                        <span class="small text-muted "><i class="fa-solid fa-circle-check" style="color: #BBB"></i></span>
                                                                                        </c:if>

                                                                                    <c:if test="${listGroupChat.isRead eq 1}">
                                                                                        <span class="small text-muted ">
                                                                                            <img style="height: 1rem !important;
                                                                                                 width: 1rem !important;" class="avatar avatarSeen" src="RetrieveImg?eaID=${listGroupChat.eaID}" alt="avatar">
                                                                                        </span>
                                                                                    </c:if>

                                                                                </c:when>

                                                                            </c:choose>

                                                                        </div>
                                                                    </div>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </c:if>

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

                                                        <c:if test="${mess.parentMessageID ne null}">                        <!--Xác nhận parent message-->



                                                            <c:forEach items="${listMess}" var="messParent">
                                                                <c:if test="${messParent.id eq mess.parentMessageID}">
                                                                    <c:set var="parentContent" value="${messParent.content}"/>
                                                                    <c:set var="creatorParentContent" value="${messParent.fromID}"/>
                                                                </c:if>
                                                            </c:forEach>

                                                            <c:choose>
                                                                <c:when test="${listUserAdminID.contains(creatorParentContent)}">   <!--nếu creatorParentContent do admin tạo -->
                                                                    <div class="divMYS parent-message-title" >
                                                                        <div class="MYS" style="background-color: inherit;font-size: 10px;color: #CCCCCC;margin-bottom: -20px;">
                                                                            <i class="fa-solid fa-reply" style="display: block;"><span style="font-family: monospace"> Relying to myself</span></i> 
                                                                        </div>
                                                                    </div>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <div class="divMYS parent-message-title" >
                                                                        <div class="MYS" style="background-color: inherit;font-size: 10px;color: #CCCCCC;margin-bottom: -20px;">
                                                                            <i class="fa-solid fa-reply" style="display: block;"><span style="font-family: monospace"> You replying</span></i> 
                                                                        </div>
                                                                    </div>
                                                                </c:otherwise>
                                                            </c:choose>

                                                            <div class="divMYS parent-message" >
                                                                <div class="MYS" style="background-color: #f6f9fa;color: #CCCCCC;margin-bottom: -25px">
                                                                    ${parentContent}
                                                                </div>
                                                            </div>
                                                        </c:if>

                                                        <div class="divMYS">
                                                            <c:if test="${mess.isread eq 0}">
                                                                <span class="small text-muted checkIsread"><i class="fa-solid fa-circle-check" style="color:#BBB "></i></span>
                                                                </c:if>

                                                            <c:if test="${mess.isread eq 1}">
                                                                <span class="small text-muted checkIsread"><i class="fa-solid fa-circle-check" style="color: #50b5ba"></i></span>
                                                                </c:if>
                                                                <c:if test="${mess.content ne null}">
                                                                <div class="MYS" title="${mess.createDate}">
                                                                    <p>${mess.content}</p>
                                                                </div>
                                                                <span class="text-time">${hourMess2}</span>
                                                                <i onclick="replyMessageS('${mess.content}',${mess.id})" class="fa-solid fa-reply" title="reply"></i>
                                                                <div class="dropdown dropdown-option-reply ">
                                                                    <a href="#" class="dropdown-toggle" data-bs-toggle="dropdown">
                                                                        <i class="fa-solid fa-ellipsis-vertical"></i>
                                                                    </a>

                                                                    <ul class="dropdown-menu">

                                                                        <li><a class="dropdown-item" href="messageedits?type=deleteAll&&messid=${mess.id}&&r=admin&&mrID=${mrID}">Delete All</a></li>
                                                                        <li><a class="dropdown-item" href="messageedits?type=delete&&messid=${mess.id}&&r=admin&&mrID=${mrID}">Delete</a></li>
                                                                    </ul>
                                                                </div>
                                                            </c:if>

                                                            <c:if test="${mess.content eq null}">
                                                                <div class="MYS mess-removed" >
                                                                    This messages is removed
                                                                </div>
                                                                <span class="text-time">${hourMess2}</span>
                                                                <div class="dropdown dropdown-option-reply ">
                                                                    <a href="#" class="dropdown-toggle" data-bs-toggle="dropdown">
                                                                        <i class="fa-solid fa-ellipsis-vertical"></i>
                                                                    </a>

                                                                    <ul class="dropdown-menu">

                                                                        <li><a class="dropdown-item" href="messageedits?type=deleteAll&&messid=${mess.id}&&r=admin&&mrID=${mrID}">Delete All</a></li>

                                                                    </ul>
                                                                </div>
                                                            </c:if>
                                                        </div>

                                                    </c:when>
                                                    <c:otherwise>

                                                        <div  class="message-item message-divider">
                                                            <c:if test="${timeMess ne timeMess2}">
                                                                <c:set var = "timeMess" value = "${timeMess2}"  />
                                                                <span>${timeMess}</span>
                                                            </c:if>

                                                        </div>

                                                        <c:if test="${mess.parentMessageID ne null}">                           <!--Xác nhận parent message-->
                                                            <c:forEach items="${listMess}" var="messParent">
                                                                <c:if test="${messParent.id eq mess.parentMessageID}">
                                                                    <c:set var="parentContent" value="${messParent.content}"/>
                                                                    <c:set var="creatorParentContent" value="${messParent.fromID}"/>
                                                                </c:if>
                                                            </c:forEach>

                                                            <c:choose>
                                                                <c:when test="${listUserAdminID.contains(creatorParentContent)}">   <!--nếu creatorParentContent do admin tạo -->
                                                                    <div class="divMYR parent-message-title" >
                                                                        <div class="MYR" style="background-color: inherit;font-size: 10px;color: #CCCCCC;margin-bottom: -20px;">
                                                                            <i class="fa-solid fa-reply" style="display: block;"><span style="font-family: monospace"> Relying to you</span></i> 
                                                                        </div>
                                                                    </div>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <div class="divMYR parent-message-title" >
                                                                        <div class="MYR" style="background-color: inherit;font-size: 10px;color: #CCCCCC;margin-bottom: -20px;">
                                                                            <i class="fa-solid fa-reply" style="display: block;"><span style="font-family: monospace"> Relying to theirself</span></i> 
                                                                        </div>
                                                                    </div>
                                                                </c:otherwise>
                                                            </c:choose>

                                                            <div class="divMYR parent-message" >
                                                                <div class="MYR" style="background-color: #f6f9fa;color: #CCCCCC;margin-bottom: -25px">
                                                                    ${parentContent}
                                                                </div>
                                                            </div>
                                                        </c:if>

                                                        <div class="divMYR">
                                                            <c:if test="${mess.content ne null}">
                                                                <div class="dropdown dropdown-option-reply ">
                                                                    <a href="#" class="dropdown-toggle" data-bs-toggle="dropdown">
                                                                        <i class="fa-solid fa-ellipsis-vertical"></i>
                                                                    </a>

                                                                    <ul class="dropdown-menu">

                                                                        <li><a class="dropdown-item" href="messageedits?type=deleteAll&&messid=${mess.id}&&r=admin&&mrID=${mrID}">Delete All</a></li>
                                                                        <li><a class="dropdown-item" href="messageedits?type=delete&&messid=${mess.id}&&r=admin&&mrID=${mrID}">Delete</a></li>
                                                                    </ul>
                                                                </div>
                                                                <i onclick="replyMessageR('${mess.content}',${mess.id})" class="fa-solid fa-reply" title="reply"></i>
                                                                <span class="text-time">${hourMess2}</span>
                                                                <div class="MYR" title="${mess.createDate}" onmouseover="readMess(${mess.id})">
                                                                    <p>${mess.content}</p>
                                                                </div>
                                                            </c:if>

                                                            <c:if test="${mess.content eq null}">
                                                                <div class="dropdown dropdown-option-reply ">
                                                                    <a href="#" class="dropdown-toggle" data-bs-toggle="dropdown">
                                                                        <i class="fa-solid fa-ellipsis-vertical"></i>
                                                                    </a>

                                                                    <ul class="dropdown-menu">

                                                                        <li><a class="dropdown-item" href="messageedits?type=deleteAll&&messid=${mess.id}&&r=admin&&mrID=${mrID}">Delete All</a></li>

                                                                    </ul>
                                                                </div>
                                                                <div class="MYR mess-removed">
                                                                    This messages is removed
                                                                </div>



                                                            </c:if>
                                                        </div>

                                                    </c:otherwise>

                                                </c:choose>
                                            </div>
                                        </c:forEach>

                                    </div>
                                    <div id="replyMessS" class="replyMess" >
                                        <div class="replyMess-left ">
                                            Answering yourself<br>
                                            <h8 id="contentParentS" style="font-size: 13px;color: gray" ></h8>
                                        </div>

                                        <div class="replyMess-right">
                                            <i onclick="removeReplyS()" class="fa-solid fa-xmark"></i>
                                        </div>
                                    </div>
                                    <br>
                                    <div id="replyMessR" class="replyMess" >
                                        <div class="replyMess-left">
                                            Replying<br>
                                            <h8 id="contentParentR" style="font-size: 13px;color: gray" ></h8>
                                        </div>

                                        <div class="replyMess-right">
                                            <i onclick="removeReplyR()" class="fa-solid fa-xmark"></i>
                                        </div>
                                    </div>
                                    <div class="card-footer">
                                        <form class="d-flex" action="message" method="post">



                                            <div class="dropdown flex-shrink-0 me-3">
                                                <button class="btn btn-rounded" type="button">
                                                    <i class="fa-solid fa-paperclip"></i>
                                                </button>
                                            </div>
                                            <input name="contentsend" type="text" class="form-control" placeholder="Write message...">
                                            <input id="parentMessageID" name="parentMessageID" type="hidden"/>
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
            function deleteGroup(id, name) {
                var option = confirm("Hind box chat " + name + " ?");
                if (option === true) {
                    window.location.href = 'delete?groupID=' + id + '&&type=hind';
                }
            }
            function showGroup(id, name) {
                var option = confirm("Show box chat " + name + " ?");
                if (option === true) {
                    window.location.href = 'delete?groupID=' + id + '&&type=show';
                }
            }
        </script>
    </body>

</html>
