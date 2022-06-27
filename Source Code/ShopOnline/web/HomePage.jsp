<%@page import="java.util.List"%>
<%@page import="model.Slide"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        <link rel="stylesheet" href="css/message.css">

        <script src="js/fontAwesome.js"></script>
        <script src="js/messenger.js"></script>


        <!-- Bootstrap 5 -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>

    </head>
    <body>
        <%@include file="topbar.jsp" %>
        <%@include file="header.jsp" %>
        <%@include file="Messenger.jsp" %>   
        <!-- Start Slider -->
        <div id="slides-shop" class="carousel slide" data-bs-ride="carousel" style="margin-top: 60px;">
            <div class="carousel-inner">
                <c:forEach items="${slides}" var="s">
                    <c:if test="${s.status}">
                        <div class="cover-slides carousel-item">
                            <img src="${s.img}">
                            <div class="carousel-caption">
                                <h1><strong>${s.heading}</strong></h1>
                                <p>
                                    <i>${s.description}</i>
                                </p>
                                <p>
                                    <a class="hvr-hover" href="${s.url}">${s.namebutton}</a>
                                </p>
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
            <div class="slides-navigation">
                <button class="carousel-control-prev" type="button" data-bs-target="#slides-shop" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon"></span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#slides-shop" data-bs-slide="next">
                    <span class="carousel-control-next-icon"></span>
                </button>
            </div>
            <script src="js/slide-show.js"></script>
        </div>
        <!-- End Slider -->

        <!-- Start Products  -->
        <div class="products-box">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="title-all text-center">
                            <h1>FEATURED PRODUCTS</h1>
                            <p>Exclusive products, limited quantity</p>
                        </div>
                    </div>
                </div>
                <div class="row special-list">
                    <c:forEach items="${products}" var="product">
                        <div class="col-lg-3 col-md-6 special-grid best-seller">
                            <div class="products-single">
                                <div class="box-img-hover">
                                    <div class="type-lb">
                                        <p class="sale">Sale</p>
                                    </div>
                                    <img src="${product.img}" class="img-fluid" alt="Image">
                                    <div class="mask-icon">
                                        <ul>
                                            <li><a href="productDetail?product_id=${product.id}" data-bs-toggle="tooltip" data-bs-placement="right" title="View"><i class="fas fa-eye"></i></a></li>
                                            <li><a href="#" data-bs-toggle="tooltip" data-bs-placement="right" title="Compare"><i class="fas fa-sync-alt"></i></a></li>
                                            <li><a href="#" data-bs-toggle="tooltip" data-bs-placement="right" title="Add to Wishlist"><i class="far fa-heart"></i></a></li>
                                        </ul>
                                        <a class="cart" href="AddToCart?pid=${product.id}">Add to Cart</a>
                                    </div>
                                </div>
                                <div class="why-text">
                                    <h4>${product.name}</h4>
                                    <h5>${product.price} VND</h5>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        <!-- End Products  -->


        <!-- Start Products  -->
        <div class="products-box">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="title-all text-center">
                            <h1>NEW PRODUCTS</h1>
                            <p>Our newest products </p>
                        </div>
                    </div>
                </div>
                <div class="row special-list">
                    <c:forEach items="${newproducts}" var="product">
                        <div class="col-lg-3 col-md-6 special-grid best-seller">
                            <div class="products-single fix">
                                <div class="box-img-hover">
                                    <div class="type-lb">
                                        <p class="sale">Sale</p>
                                    </div>
                                    <img src="${product.img}" class="img-fluid" alt="Image">
                                    <div class="mask-icon">
                                        <ul>
                                            <li><a href="productDetail?product_id=${product.id}" data-bs-toggle="tooltip" data-bs-placement="right" title="View"><i class="fas fa-eye"></i></a></li>
                                            <li><a href="#" data-bs-toggle="tooltip" data-bs-placement="right" title="Compare"><i class="fas fa-sync-alt"></i></a></li>
                                            <li><a href="#" data-bs-toggle="tooltip" data-bs-placement="right" title="Add to Wishlist"><i class="far fa-heart"></i></a></li>
                                        </ul>
                                        <a class="cart" href="AddToCart?pid=${product.id}">Add to Cart</a>
                                    </div>
                                </div>
                                <div class="why-text">
                                    <h4>${product.name}</h4>
                                    <h5>${product.price} VND</h5>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        <!-- End Products  -->


        <!-- Start Blog  -->
        <div class="latest-blog">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="title-all text-center">
                            <h1>LATEST BLOG</h1>
                            <p>A place to share experiences </p>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <c:forEach begin="0" end="2" items="${blogs}" var="b">
                        <div class="col-md-6 col-lg-4 col-xl-4">
                            <div class="blog-box">
                                <div class="blog-img">
                                    <img class="img-fluid" src="${b.image}" alt="" />
                                </div>
                                <div class="blog-content">
                                    <div class="title-blog">
                                        <a href="blogdetail?id=${b.id}" class="h3">${b.content}</a>
                                        <p>${b.description}</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        <!-- End Blog  -->


        <%@include file="footer.jsp" %>
    </body>
</html>
