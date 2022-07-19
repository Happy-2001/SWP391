<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sneaker Store</title>
        <!-- Site Icons -->
        <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
        <link rel="apple-touch-icon" href="images/apple-touch-icon.png">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/shop.css">
        <link rel="stylesheet" href="css/responsive.css">
        <script src="js/fontAwesome.js"></script>

        <!-- Bootstrap 5 -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    </head>
    <body>
        <c:set var="ProductActive" value="active"/>
        <%@include file="topbar.jsp" %>
        <%@include file="header.jsp" %>

        <!-- Start Shop Page  -->
        <div class="shop-box-inner">
            <div class="container">
                <div class="all-title-box" style="margin-top: 60px;">
                    <div aria-label="breadcrumb">
                        <ul class="breadcrumb">
                            <li class="breadcrumb-item"><a href="home">Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Product</li>
                        </ul>
                    </div>
                </div>
                <div class="container">
                    <div class="row">
                        <div class="col-xl-3 col-lg-3 col-sm-12 shop-left">
                            <div class="product-filter">
                                <form action="Search" method="post">
                                    <div class="input-group" style="margin-bottom: 16px;">
                                        <input type="text" value="${txtS}" name="txt" placeholder="Search" class="form-control">
                                    </div>
                                </form>
                                <div id="category" class="filter-category">
                                    <div class="sub-men">
                                        <div class="title-ls">
                                            <a class="title" data-bs-toggle="collapse" href="#sub-men1">Style</a>
                                        </div>
                                        <ul class="collapse show" id="sub-men1">
                                            <c:forEach items="${listC}" var="o">

                                                <li>
                                                    <i class="fa-solid fa-caret-right"></i>
                                                    <a href="CategoryController?cid=${o.id}">${o.name}</a>
                                                </li>
                                            </c:forEach>
                                        </ul>
                                    </div>
                                    <div class="sub-men">
                                        <div class="title-ls">
                                            <a class="title" data-bs-toggle="collapse" href="#sub-men2">Color</a>
                                        </div>
                                        <div class="collapse show filter-color" id="sub-men2">
                                            <a href="ColorController?id=9">
                                                <i class="fa-solid fa-square fa-2x" style="color: #000;"></i>
                                            </a>
                                            <a href="ColorController?id=8">
                                                <i class="fa-solid fa-square fa-2x" style="color: #F1778A;"></i>
                                            </a>
                                            <a href="ColorController?id=10">
                                                <i class="fa-solid fa-square fa-2x" style="color: #8A5CA0;"></i>
                                            </a>
                                            <a href="ColorController?id=11">
                                                <i class="fa-solid fa-square fa-2x" style="color: #008000;"></i>
                                            </a>
                                            <a href="ColorController?id=12">
                                                <i class="fa-solid fa-square fa-2x" style="color: #F5D255;"></i>
                                            </a>
                                            <a href="ColorController?id=13">
                                                <i class="fa-solid fa-square fa-2x" style="color: #ffa600;"></i>
                                            </a>
                                            <a href="ColorController?id=14">
                                                <i class="fa-solid fa-square fa-2x" style="color: #ff0000;"></i>
                                            </a>
                                            <a href="ColorController?id=15">
                                                <i class="fa-solid fa-square fa-2x" style="color: #808080;"></i>
                                            </a>
                                            <a href="ColorController?id=16">
                                                <i class="fa-regular fa-square fa-2x" style="color: #f2f2f2;"></i>
                                            </a>
                                            <a href="ColorController?id=17">
                                                <i class="fa-solid fa-square fa-2x" style="color: #c0c0c0;"></i>
                                            </a>

                                        </div>
                                    </div>
                                    <div class="sub-men">
                                        <div class="title-ls">
                                            <a class="title" data-bs-toggle="collapse" href="#sub-men3">Size <small class="text-muted">( VN / EU )</small></a>
                                        </div>
                                        <div class="collapse show" id="sub-men3">
                                            <div class="container">
                                                <div class="ls-size">
                                                    <h4>Man Size</h4>
                                                    <div class="d-flex flex-wrap">
                                                        <div class="py-2 px-3 border">
                                                            <a href="#">
                                                                <span>37</span>
                                                            </a>
                                                        </div>
                                                        <div class="py-2 px-3 border">
                                                            <a href="#" >
                                                                <span>38</span>
                                                            </a>
                                                        </div>
                                                        <div class="py-2 px-3 border">
                                                            <a href="#" >
                                                                <span>39</span>
                                                            </a>
                                                        </div>
                                                        <div class="py-2 px-3 border">
                                                            <a href="#" >
                                                                <span>40</span>
                                                            </a>
                                                        </div>
                                                        <div class="py-2 px-3 border">
                                                            <a href="#" >
                                                                <span>41</span>
                                                            </a>
                                                        </div>
                                                        <div class="py-2 px-3 border">
                                                            <a href="#" >
                                                                <span>42</span>
                                                            </a>
                                                        </div>
                                                        <div class="py-2 px-3 border">
                                                            <a href="#" >
                                                                <span>43</span>
                                                            </a>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="ls-size" style="margin-top: 20px;">
                                                    <h4>Woman Size</h4>
                                                    <div class="d-flex flex-wrap">
                                                        <div class="py-2 px-3 border">
                                                            <a href="#">
                                                                <span>35</span>
                                                            </a>
                                                        </div>
                                                        <div class="py-2 px-3 border">
                                                            <a href="#" >
                                                                <span>36</span>
                                                            </a>
                                                        </div>
                                                        <div class="py-2 px-3 border">
                                                            <a href="#" >
                                                                <span>37</span>
                                                            </a>
                                                        </div>
                                                        <div class="py-2 px-3 border">
                                                            <a href="#" >
                                                                <span>38</span>
                                                            </a>
                                                        </div>
                                                        <div class="py-2 px-3 border">
                                                            <a href="#" >
                                                                <span>39</span>
                                                            </a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="sub-men">
                                        <div class="title-ls">
                                            <a class="title" data-bs-toggle="collapse" href="#sub-men4">Material</a>
                                        </div>
                                        <div class="collapse show filter-color" id="sub-men4">
                                            <ul class="d-flex flex-column tree">
                                                <li>
                                                    <label class="cb-checked">
                                                        <input name="cbStatus" class="cb-item" type="checkbox" value="canvas" hidden>Canvas<i class="fa-solid fa-xmark glyphicon"></i>
                                                    </label>
                                                </li>
                                                <li>
                                                    <label>
                                                        <input name="cbStatus" class="cb-item" type="checkbox" value="canvas" hidden>Suede<i class="fa-solid fa-xmark glyphicon"></i>
                                                    </label>
                                                </li>
                                                <li>
                                                    <label>
                                                        <input name="cbStatus" class="cb-item" type="checkbox" value="canvas" hidden>Synthetic Leather<i class="fa-solid fa-xmark glyphicon"></i>
                                                    </label>
                                                </li>
                                                <li>
                                                    <label>
                                                        <input name="cbStatus" class="cb-item" type="checkbox" value="canvas" hidden>Leather<i class="fa-solid fa-xmark glyphicon"></i>
                                                    </label>
                                                </li>
                                                <li>
                                                    <label>
                                                        <input name="cbStatus" class="cb-item" type="checkbox" value="canvas" hidden>Cotton<i class="fa-solid fa-xmark glyphicon"></i>
                                                    </label>
                                                </li>
                                                <li>
                                                    <label>
                                                        <input name="cbStatus" class="cb-item" type="checkbox" value="canvas" hidden>Flannel<i class="fa-solid fa-xmark glyphicon"></i>
                                                    </label>
                                                </li>
                                                <li>
                                                    <label>
                                                        <input name="cbStatus" class="cb-item" type="checkbox" value="canvas" hidden>Acrylic<i class="fa-solid fa-xmark glyphicon"></i>
                                                    </label>
                                                </li>
                                                <li>
                                                    <label>
                                                        <input name="cbStatus" class="cb-item" type="checkbox" value="canvas" hidden>Corduroy<i class="fa-solid fa-xmark glyphicon"></i>
                                                    </label>
                                                </li>
                                                <li>
                                                    <label>
                                                        <input name="cbStatus" class="cb-item" type="checkbox" value="canvas" hidden>Polyester<i class="fa-solid fa-xmark glyphicon"></i>
                                                    </label>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="filter-sidebar">
                                </div>

                            </div>
                        </div>

                        <div class="col-xl-9 col-lg-9 col-sm-12 shop-right">
                            <div class="product-item-filter row">
                                <div class="col-12 col-sm-8 text-ms-start">
                                    <form action="SettingList" method="POST">
                                        <div class="filter-button-group">
                                            <span>Sort by </span>
                                            <select id="basic" class="form-select" name="filter">
                                                <option value="-2" ${param.filter==-2 ? 'selected' : ''} selected>Nothing</option>
                                                <option value="-1" ${param.filter==-1 ? 'selected' : ''}>High Price → High Price</option>
                                                <option value="0" ${param.filter==0 ? 'selected' : ''}>Low Price → High Price</option>
                                            </select>
                                            <div class="why-text py-0">
                                                <button type="submit" class="btn m-0">Sort</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="col-12 col-sm-4 text-sm-end">
                                    <ul class="nav nav-pills ms-auto">
                                        <li class="nav-item">
                                            <a class="nav-link active" href="#grid-view" data-bs-toggle="tab"><i class="fa-solid fa-table-cells-large fa-lg"></i></a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="#list-view" data-bs-toggle="tab"><i class="fa-solid fa-list-ul fa-lg"></i></a>
                                        </li>
                                    </ul>
                                </div>
                            </div>

                            <div class="row product-categorie-box">
                                <div class="products-box active" id="grid-view">
                                    <div class="container">
                                        <div class="row">
                                            <c:forEach items="${productsForEachPage}" var="product">
                                                <div class="col-sm-6 col-md-6 col-lg-4 col-xl-4">
                                                    <div class="products-single">
                                                        <div class="type-lb">
                                                            <p class="sale">Sale</p>
                                                        </div>
                                                        <div class="box-img-hover">
                                                            <a href="productDetail?product_id=${product.id}"><img src="${product.img}" class="img-fluid" alt="Image"></a>>
                                                        </div>
                                                        <div class="why-text">
                                                            <a href="productDetail?product_id=${product.id}">${product.name}</a>
                                                            <p class="text-muted">${product.brief_information}</p>
                                                            <span>${product.price} VND</span>
                                                            <c:choose>
                                                                <c:when test="${sessionScope.userlogged eq null}">
                                                                    <a class="btn" href="login" title="Login">Add to Cart</a>
                                                                </c:when>
                                                                <c:when test="${sessionScope.userlogged ne null}">
                                                                    <a class="btn" href="AddToCart?cid=${sessionScope.userlogged.userid}&pid=${product.id}">Add to Cart</a>
                                                                </c:when>
                                                            </c:choose>
                                                            <a href="favouriteController?id=${product.id}" class="btn"><i class="fa-regular fa-heart"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>

                                <div class="products-box" id="list-view">
                                    <div class="container">
                                        <c:forEach items="${listByPage}" var="product">
                                            <div class="products-single">
                                                <div class="row">
                                                    <div class="col-sm-6 col-md-6 col-lg-4 col-xl-4">
                                                        <div class="box-img-hover">
                                                            <img src="${product.img}" class="img-fluid" alt="Image">
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-6 col-md-6 col-lg-8 col-xl-8">
                                                        <div class="why-text">
                                                            <a href="productDetail?product_id=${product.id}">${product.name}</a>
                                                            <p class="text-muted">${product.brief_information}</p>
                                                            <span>${product.price} VND</span>
                                                            <p>${product.description}</p>
                                                            <a href="#" class="btn">Add to Card</a>
                                                            <a href="#" class="btn"><i class="fa-regular fa-heart"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>

                                <div class="paging">
                                    <c:if test="${countPage != null}">
                                        <ul class="pagination justify-content-end">
                                            <li class="page-item"><a class="page-link" href="?page=1"><i class="fa-solid fa-angles-left"></i></a></li>
                                                    <c:forEach begin="1" end="${countPage}" var="p">
                                                <li class="page-item ${p == PAGE ? "active":""}"><a class="page-link" href="?page=${p}">${p}</a></li>
                                                </c:forEach>
                                            <li class="page-item"><a class="page-link" href="#"><i class="fa-solid fa-angles-right"></i></a></li>
                                        </ul>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Shop Page -->


        <%@include file="footer.jsp" %>

    </body>
</html>