<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Shop Online</title>
        <!-- Site Icons -->
        <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
        <link rel="apple-touch-icon" href="images/apple-touch-icon.png">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/HomePage.css">
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
            <div class="div-title">
                <h2>${post.content}</h2>
                
            </div>
            <div class="div-content-1">
                <div class="content-p">
                    <p>
                        ${post.noidung}
                    </p>
                </div>
                <div class="content-sidebar">
                    <form class="img-input" action="blogdetail" method="GET">
                        <input type="text" name="search"> <input type="submit" value="Search" />
                    </form>
                    <div class="content-img">
                        <c:forEach items="${postrecommend}" var="p">
                            <div class="div-img">
                                <a href="blogdetail?id=${p.id}">
                                    <img src="${p.image}" alt="">
                                </a>
                                <a href="blogdetail?id=${p.id}" class="small-title">${p.content}</a>
                            </div>     
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>



        
        <%@include file="footer.jsp" %>
    </body>
</html>
