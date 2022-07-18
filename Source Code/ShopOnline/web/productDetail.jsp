<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <link rel="stylesheet" href="css/HomePage.css">
        <link rel="stylesheet" href="css/responsive.css">
        <link rel="stylesheet" href="css/product.css">
        <script src="js/fontAwesome.js"></script>
        <link rel="stylesheet" href="css/style.css">

        <!-- Bootstrap 5 -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>

    </head>
    <body>
        <%@include file="topbar.jsp" %>
        <%@include file="header.jsp" %>

        <!-- Start Top Search -->
        <div class="top-search">
            <div class="container">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-search"></i></span>
                    <input type="text" class="form-control" placeholder="Search">
                    <span class="input-group-addon close-search"><i class="fa fa-times"></i></span>
                </div>
            </div>
        </div>
        <!-- End Top Search -->

        <!-- Start All Title Box -->
        <div class="all-title-box">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <h2>Product Detail</h2>
                        <ul class="breadcrumb">
                            <li class="breadcrumb-item"><a href="home">Home</a></li>
                            <li class="breadcrumb-item active">Product Detail </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- End All Title Box -->

        <!-- Start Shop Detail  -->
        <div class="shop-detail-box-main">
            <div class="container">
                <div class="row">
                    <div class="col-xl-5 col-lg-5 col-md-6">
                        <div id="carousel-example-1" class="single-product-slider carousel slide" data-ride="carousel">
                            <div class="carousel-inner" role="listbox">
                                <div class="carousel-item active"> <img class="d-block w-100" src="${productDetail.img}" alt="Image"></div>
                                <div class="carousel-item"> <img class="d-block w-100" src="${productDetail.img}" alt="Image"> </div>
                                <div class="carousel-item"> <img class="d-block w-100" src="${productDetail.img}" alt="Image"> </div>
                            </div>
                            <a class="carousel-control-prev" href="#carousel-example-1" role="button" data-slide="prev"> 
                                <i class="fa fa-angle-left" aria-hidden="true"></i>
                                <span class="sr-only">Previous</span> 
                            </a>
                            <a class="carousel-control-next" href="#carousel-example-1" role="button" data-slide="next"> 
                                <i class="fa fa-angle-right" aria-hidden="true"></i> 
                                <span class="sr-only">Next</span> 
                            </a>
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-1" data-slide-to="0" class="active">
                                    <img class="d-block w-100 img-fluid" src="${productDetail.img}" alt="Image" />
                                </li>
                                <li data-target="#carousel-example-1" data-slide-to="1">
                                    <img class="d-block w-100 img-fluid" src="${productDetail.img}" alt="Image" />
                                </li>
                                <li data-target="#carousel-example-1" data-slide-to="2">
                                    <img class="d-block w-100 img-fluid" src="${productDetail.img}" alt="Image" />
                                </li>
                            </ol>
                        </div>
                    </div>
                    <div class="col-xl-7 col-lg-7 col-md-6">
                        <div class="single-product-details">
                            <h2>${productDetail.name}</h2>
                            <h5> <del>${productDetail.price}</del> ${productDetail.salePrice}</h5>
                            <p class="available-stock"><span> More than ${productDetail.stock} available</span>
                            <p>
                            <h4>Brief Information:</h4>
                            <p>${productDetail.brief_information}</p>
                            <h4>Short Description:</h4>
                            <p>${productDetail.description}</p>
                            <ul>
                                <li>
                                    <div class="form-group quantity-box">
                                        <label class="control-label">Size</label>
                                        <input class="form-control" value="36" min="36" max="50" type="number">
                                    </div>
                                </li>
                                <li>
                                    <div class="form-group quantity-box">
                                        <label class="control-label">Quantity</label>
                                        <input class="form-control" value="1" min="1" max="20" type="number">
                                    </div>
                                </li>
                            </ul>

                            <div class="">
                                <div class="add-comp add-comp1">
                                    <button><a href="AddToCart?cid=${sessionScope.userlogged.userid}&pid=${productDetail.id}"></i> Buy now</button>
                                    <button><a href="AddToCart?cid=${sessionScope.userlogged.userid}&pid=${productDetail.id}"><i class="fa-solid fa-cart-plus"></i> Add to cart</a></button>
                                </div>
                            </div>

                            <div class="">
                                <div class="add-comp add-comp2">
                                    <button><a href="favouriteController?id=${productDetail.id}"><i class="fas fa-heart"></i> Add to wishlist</a></button>
                                    <button><a href="#"><i class="fas fa-sync-alt"></i> Add to Compare</a></button>
                                </div>
                            </div>

                            

                        </div>
                    </div>
                </div>

                <div class="row my-5">
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
                                                    <c:choose>
                                                        <c:when test="${sessionScope.userlogged eq null}">
                                                            <a class="cart" href="login" title="Login">Add to Cart</a>
                                                        </c:when>
                                                        <c:when test="${sessionScope.userlogged ne null}">
                                                            <a class="cart" href="AddToCart?cid=${sessionScope.userlogged.userid}&pid=${product.id}">Add to Cart</a>
                                                        </c:when>
                                                    </c:choose>
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
                </div>
            </div>
        </div>



        <%@include file="footer.jsp" %>

    </body>
</html>
