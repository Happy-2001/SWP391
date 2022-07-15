<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<div class="topbar">
    <div class="container-fluid">
        <div class="row align-items-center">
            <div class="col-lg-3">
                <nav class="navbar">
                    <!-- <i class="fa-solid fa-bars fa-lg toggle-switch"></i> -->
                    <a href="/ShopOnline/home" class="navbar-brand ms-4"><img src="../images/logo.png" class="logo"></a>
                </nav>
            </div>
            <div class="col-lg-7">
                <div class="notify-area">
                    <div class="page-title">Dashboard</div>
                    <div class="t-search">
                        <form action="action">
                            <div class="search-box">
                                <input type="text" placeholder="Search...">
                                <i class="fa-solid fa-magnifying-glass fa-sm icon"></i>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-lg-2">
                <div class="user-head">
                    <div class="dropdown">
                        <sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver"
                                           url="jdbc:mysql://localhost:3306/shop2"
                                           user="root"  password=""/>

                        <sql:query dataSource="${db}" var="rs">
                            SELECT * FROM `orders`
                            WHERE `orders`.`status` = 'pending'
                            ORDER BY order_date DESC
                        </sql:query>
                        <div class="notifications" data-bs-toggle="dropdown">
                            <a href="#"><i class="fa-regular fa-bell icon"></i></a>
                            <span class="badge-num"><c:out value="${rs.rowCount}"/></span>
                        </div>
                        <div class="dropdown-menu dropdown-menu-end">
                            <c:forEach var="tb" items="${rs.rows}">
                                <a href="OrderDetailController?id=${tb.order_id}" class="dropdown-item d-flex flex-column">
                                    <div class="d-flex align-items-center">
                                        <i class="fa-solid fa-circle fa-2xs" style="color: #0099c6;"></i>
                                        <span class="ps-3" style="font-size: 16px;">New order No. <strong>#${tb.order_id}</strong></span>
                                    </div>
                                    <p class="small ps-4" style="color: #0099c6;">${tb.order_date}</p>
                                </a>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="messages">
                        <a href="#"><i class="fa-regular fa-envelope icon"></i></a>
                        <span class="badge-num">1</span>
                    </div>
                    <div class="admin">
                        <div class="admin-avatar" data-bs-toggle="collapse" data-bs-target="#setting">
                            <img src="../RetrieveImg?eaID=${sessionScope.userlogged.userid}" onError="this.onerror=null;this.src='../images/default-avatar.jpg';">
                            <span class="online"></span> 
                        </div>
                    </div>
                    <div class="dropdown-ls collapse" id="setting">
                        <ul class="menu-links">
                            <li class="nav-link">
                                <a href="ProfileUser?userid=${sessionScope.userlogged.userid}">
                                    <span class="nav-link-icon">
                                        <i class="fa fa-eyedropper"></i>
                                    </span>
                                    <span class="text nav-text">Edit Profile</span>
                                </a> 
                            </li>
                            <li class="nav-link">
                                <a href="#">
                                    <span class="nav-link-icon">
                                        <i class="fa fa-envelope-o"></i>
                                    </span>
                                    <span class="text nav-text">My Inbox</span>
                                </a> 
                            </li>
                            <li class="nav-link">
                                <a href="#">
                                    <span class="nav-link-icon">
                                        <i class="fa fa-adjust"></i>
                                    </span>
                                    <span class="text nav-text">Task</span>
                                </a> 
                            </li>
                            <li class="nav-link">
                                <a href="#">
                                    <span class="nav-link-icon">
                                        <i class="fa fa-calendar"></i>
                                    </span>
                                    <span class="text nav-text">Calender</span>
                                </a> 
                            </li>
                            <li class="nav-link">
                                <a href="#">
                                    <span class="nav-link-icon">
                                        <i class="fa fa-align-right"></i>
                                    </span>
                                    <span class="text nav-text">Balance Report</span>
                                </a>
                                <hr style="margin: 0;"></hr>
                            </li>
                            <li class="nav-link">
                                <a href="/ShopOnline/logout">
                                    <span class="nav-link-icon">
                                        <i class="fa fa-sign-out"></i>
                                    </span>
                                    <span class="text nav-text">Log Out</span>
                                </a> 
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
