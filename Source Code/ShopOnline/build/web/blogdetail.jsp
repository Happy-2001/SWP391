<%@page import="model.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shop Online</title>
    <!-- Site Icons -->
    <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
    <link rel="apple-touch-icon" href="images/apple-touch-icon.png">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/BlogStyle.css">
    <link rel="stylesheet" href="css/responsive.css">
    <script src="js/fontAwesome.js"></script>

    <!-- Bootstrap 5 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</head>
<body> 
    <%@include file="topbar.jsp" %>
        <%@include file="header.jsp" %>
    <div class="div-content">
        <img class="img-fluid" src="${post.image}">
        <div class="div-title">
            <h2>${post.content}</h2>
        </div>
        <div class="main-content">
            <h3 class="divider"></h3>
            <h3 class="cont">
                <div class="date-left"><span class="date">06.06.2021 |</span> admin</div>
                <div class="date-right">
                    <a href="#"><i class="fa-solid fa-heart"></i> Like</a>
                </div>
            </h3>
            <h3 class="divider-1"></h3>

            <div class="detail-cont">
                <div class="des">
            ${post.description}
                </div>
                <h3 class="divider-1"></h3>
                ${post.noidung}
            </div>

            <h3 class="divider-1"></h3>
            <h3 class="cont">
                <div class="date-left"><span class="date">06.06.2021 |</span> admin</div>
                <div class="date-right">
                    <a href="#"><i class="fa-solid fa-heart"></i> Like</a>
                </div>
            </h3>
            <h3 class="divider"></h3>
        </div>
    </div>

    <!-- other blogs -->
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="title-all text-center">
                    <h2>BÀI VIẾT KHÁC</h2>
                </div>
            </div>
        </div>
        <div class="row">
            <c:forEach items="${postrecommend}" var="p">
                <div class="col-md-6 col-lg-4 col-xl-4">
                <div class="blog-box">
                    <div class="blog-img">
                        <img class="img-fluid" src="${p.image}" alt="">
                    </div>
                    <div class="blog-content">
                        <div class="title-blog">
                            <a href="blogdetail?id=${p.id}" class="h3">                                
                                 ${p.content}
                            </a>    
                                 <p>${post.description}</p>
                        </div>
                    </div>
                </div>
            </div>

            </c:forEach>
                        
             
        </div>
    </div>
 <%@include file="footer.jsp" %>

</body>
</html>