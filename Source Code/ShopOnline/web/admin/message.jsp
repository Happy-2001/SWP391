<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                            <a href="dashboard">
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
                            <a href="admin/Customers.jsp">
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
                        <div class="col-lg-4 chat-sidebar">
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
                                                <div class="list-group-item active">
                                                    <div class="pe-3">
                                                        <span class="avatar">
                                                            <img src="images/default-avatar.jpg" class="rounded-circle" alt="image">
                                                            <span class="online"></span>
                                                        </span>
                                                    </div>
                                                    <div class="flex-grow- 1">
                                                        <p class="mb-1">Cyril Ralston</p>
                                                        <span class="text-muted">
                                                            <i class="fa-regular fa-image"></i> Photo
                                                        </span>
                                                    </div>
                                                    <div class="text-end ms-auto d-flex flex-column">
                                                        <div class="dropdown ms-auto">
                                                            <a href="#" data-bs-toggle="dropdown">
                                                                <i class="fa-solid fa-ellipsis"></i>
                                                            </a>
                                                            <div class="dropdown-menu dropdown-menu-end">
                                                                <a href="#" class="dropdown-item">Profile</a>
                                                                <a href="#" class="dropdown-item">Mark as read</a>
                                                                <a href="#" class="dropdown-item">Delete</a>
                                                            </div>
                                                        </div>
                                                        <span class="small text-muted">Yesterday</span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- end::chat list -->
                        </div>
                
                        <!-- begin::chat content -->
                        <div class="col-lg-8 chat-content">
                            <!-- begin::messages -->
                            <div class="messages card">
                                <div class="card-body">
                                    <c:forEach items="${listMess}" var="mess">
                                        <c:choose>
                                            <c:when test="${listUserAdminID.contains(mess.fromID)}">
                                                <div class="message-item message-divider">
                                                    <span>Today</span>
                                                </div>
                                                <div class="content_message">
                                                    <div class="divMYS">
                                                        <div class="MYS">
                                                            <p>${mess.content}</p>
                                                        </div>
                                                        <span class="text-time">02:30 PM</span>
                                                    </div>
                                                </c:when>
                                                <c:otherwise>
                                                    <div class="divMYR">
                                                        <span class="text-time">02:30 PM</span>
                                                        <div class="MYR">
                                                            <p>${mess.content}</p>
                                                        </div>
                                                    </div>
                                                </div>
                                            </c:otherwise>

                                        </c:choose>
                                    </c:forEach>
                                </div>
                                <div class="card-footer">
                                    <form class="d-flex" action="message" method="post">
                                        <div class="dropdown flex-shrink-0 me-3">
                                            <button class="btn btn-rounded" type="button">
                                                <i class="fa-solid fa-paperclip"></i>
                                            </button>
                                        </div>
                                        <input type="text" class="form-control" placeholder="Write message...">
                                        <button name="getFROMandTO" value="${listMess.get(0).fromID};${listMess.get(0).toID}" type="submit" class="btn btn-rounded flex-shrink-0 ms-3">Send</button>
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
</body>
</html>
