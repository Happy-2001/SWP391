<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<div id="header" class="bg-light">
    <header>
        <!-- Start Navigation -->
        <div class="container">
            <nav class="navbar navbar-expand-lg navbar-light bootsnav">
                <!-- Start Header Navigation -->
                <div class="navbar-header">
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbar-menu">
                        <i class="fa fa-bars"></i>
                    </button>
                    <a class="navbar-brand" href="home"><img src="images/logo.png" class="logo" alt=""></a>
                </div>
                <div class="collapse navbar-collapse" id="navbar-menu">
                    <!-- Start Top Search -->
                    <div class="top-search">
                        <form action="Search" method="POST">
                            <div class="input-group">
                                <span class="input-group-text close-search"><i class="fa fa-times"></i></span>
                                <input type="search" class="form-control" value="${txtS}" name="txt"  placeholder="Search...">
                                <button type="submit" class="input-group-text">
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </form>
                    </div>
                    <!-- End Top Search -->
                    <ul id="page-header" class="nav navbar-nav ms-auto">
                        <li class="nav-item active"><a class="nav-link" href="home" title="Home">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="blog" title="Blogs">Blogs</a></li>                       
                        <li class="nav-item"><a class="nav-link" href="ProductController" title="Products">Product</a></li>
                        <li class="nav-item"><a class="nav-link" href="blog" title="Blogs">Post</a></li>   
                    </ul>
                </div>

                <div class="account-header">
                    <ul class="nav navbar-nav">
                        <li class="search">
                            <a href="#"><i class="fa fa-search"></i></a>
                        </li>
                            
                        <li class="side-menu">
                            <c:choose>
                                <c:when test="${sessionScope.userlogged eq null}">
                                    <a href="login" title="Login"><i class="fa fa-shopping-bag"></i></a>
                                </c:when>
                                <c:when test="${sessionScope.userlogged ne null}">
                                    <sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver"
                                        url="jdbc:mysql://localhost:3306/shop2"
                                        user="root"  password=""/>
 
                                    <sql:query dataSource="${db}" var="rs">
                                        SELECT * FROM `cart_items` 
                                        WHERE cart_items.cartID = ${sessionScope.userlogged.userid};
                                    </sql:query>
                                    
                                    <c:set var="linkToRedirect">
                                       <c:choose>
                                            <c:when test="${rs.rowCount != 0}">
                                                CartController?userID=${sessionScope.userlogged.userid}
                                            </c:when>
                                            <c:otherwise>
                                                CartEmpty.jsp
                                            </c:otherwise>
                                        </c:choose>
                                    </c:set>
                                    <a href="${linkToRedirect}" title="Cart"
                                        <i class="fa fa-shopping-bag"></i>
                                    </a>
                                    <span class="badge-num"><c:out value="${rs.rowCount}"/></span>
                                </c:when>
                            </c:choose>
                        </li>
                        <li class="account dropdown">
                            <c:choose>
                                <c:when test="${sessionScope.userlogged eq null}">
                                    <a href="login" title="Login"><i class="fa fa-user"></i></a>
                                </c:when>
                                <c:when test="${sessionScope.userlogged ne null}">
                                    <c:choose>
                                        <c:when test="${sessionScope.Arole.authority.id == 1}">
                                            <a href="admin/dashboard" style="border-left: 2px solid #d33b33;">
                                                <i class="fa-solid fa-circle-user"></i> ${sessionScope.userlogged.username}
                                            </a>
                                        </c:when>
                                        <c:otherwise>
                                            <a href="#" data-bs-toggle="dropdown" style="border-left: 2px solid #d33b33;">
                                                <i class="fa-solid fa-circle-user"></i> ${sessionScope.userlogged.username}
                                            </a>
                                            <div class="dropdown-menu">
                                                <a href="ProfileUser?userid=${sessionScope.userlogged.userid}" class="dropdown-item">
                                                    <i class="fa-regular fa-circle-user pe-2"></i> Profile
                                                </a>
                                                <a href="CusOrderController?cid=${sessionScope.userlogged.userid}" class="dropdown-item">
                                                    <i class="fa-solid fa-box pe-2"></i> My order
                                                </a>
                                                <a href="CusFavouriteController" class="dropdown-item">
                                                    <i class="fa-regular fa-heart pe-2"></i> Favorites
                                                </a>
                                                 <a href="Notification?userID=${sessionScope.userlogged.userid}" class="dropdown-item">
                                                    <i class="fa-regular fa-bell pe-2"></i> Notification
                                                </a>
                                            </div>
                                        </c:otherwise>
                                    </c:choose>
                                    
                                    <a href="logout" style="border-left: 2px solid #d33b33;" title="Logout"><i class="fa-solid fa-power-off"></i></a>
                                </c:when>
                            </c:choose>
                        </li>
                    </ul>
                </div>
                
            </nav>
        </div>
        <!-- End Navigation -->
    </header>
</div>
<script>
    const navMenu = document.getElementById("navbar-menu"),
            searchBtn = document.querySelector(".search"),
            closeBtn = document.querySelector(".close-search"),
            headSpan = document.getElementById("page-header"),
            searchSpan = document.querySelector(".top-search");

    searchBtn.onclick = function () {
        navMenu.removeChild(headSpan);
        navMenu.appendChild(searchSpan);
        searchSpan.style.display = "block";
        searchBtn.style.display = "none";
    };
    closeBtn.onclick = function () {
        navMenu.appendChild(headSpan);
        navMenu.removeChild(searchSpan);
        searchBtn.style.display = "block";
    };

    var prevScrollpos = window.pageYOffset;

    window.onscroll = function () {
        var currentScrollPos = window.pageYOffset;
        if (currentScrollPos === 0) {
            document.getElementById("header").style.top = "37px";
        } else if (prevScrollpos > currentScrollPos) {
            document.getElementById("header").style.top = "0px";
        } else {
            document.getElementById("header").style.top = "-60px";
        }
        prevScrollpos = currentScrollPos;
    };
</script>