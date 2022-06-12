<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                            <form action="#">
                                <div class="input-group" style="margin-bottom: 16px;">
                                    <input type="text" placeholder="Search" class="form-control">
                                </div>
                            </form>
                            <div id="category" class="filter-category">
                                <div class="sub-men">
                                    <div class="title-ls">
                                        <a class="title" data-bs-toggle="collapse" href="#sub-men1">Style</a>
                                    </div>
                                    <ul class="collapse show" id="sub-men1">
                                        <li>
                                            <i class="fa-solid fa-caret-right"></i>
                                            <a href="#">Low <small class="text-muted">(50)</small></a>
                                        </li>
                                        <li>
                                            <i class="fa-solid fa-caret-right"></i>
                                            <a href="#">High <small class="text-muted">(10)</small></a>
                                        </li>
                                        <li>
                                            <i class="fa-solid fa-caret-right"></i>
                                            <a href="#">Mid <small class="text-muted">(10)</small></a>
                                        </li>
                                        <li>
                                            <i class="fa-solid fa-caret-right"></i>
                                            <a href="#">Slip-on <small class="text-muted">(10)</small></a>
                                        </li>
                                        <li>
                                            <i class="fa-solid fa-caret-right"></i>
                                            <a href="#">Platform <small class="text-muted">(20)</small></a>
                                        </li>
                                    </ul>
                                </div>
                                <div class="sub-men">
                                    <div class="title-ls">
                                        <a class="title" data-bs-toggle="collapse" href="#sub-men2">Color</a>
                                    </div>
                                    <div class="collapse show filter-color" id="sub-men2">
                                        <a href="#">
                                            <i class="fa-solid fa-square fa-2x" style="color: #000;"></i>
                                        </a>
                                        <a href="#">
                                            <i class="fa-solid fa-square fa-2x" style="color: #F1778A;"></i>
                                        </a>
                                        <a href="#">
                                            <i class="fa-solid fa-square fa-2x" style="color: #8A5CA0;"></i>
                                        </a>
                                        <a href="#">
                                            <i class="fa-solid fa-square fa-2x" style="color: #008000;"></i>
                                        </a>
                                        <a href="#">
                                            <i class="fa-solid fa-square fa-2x" style="color: #F5D255;"></i>
                                        </a>
                                        <a href="#">
                                            <i class="fa-solid fa-square fa-2x" style="color: #ffa600;"></i>
                                        </a>
                                        <a href="#">
                                            <i class="fa-solid fa-square fa-2x" style="color: #ff0000;"></i>
                                        </a>
                                        <a href="#">
                                            <i class="fa-solid fa-square fa-2x" style="color: #808080;"></i>
                                        </a>
                                        <a href="#">
                                            <i class="fa-regular fa-square fa-2x" style="color: #f2f2f2;"></i>
                                        </a>
                                        <a href="#">
                                            <i class="fa-solid fa-square fa-2x" style="color: #c0c0c0;"></i>
                                        </a>
                                        <a href="#">
                                            <i class="fa-solid fa-square fa-2x" style="color: #c10013;"></i>
                                        </a>
                                        <a href="#">
                                            <i class="fa-solid fa-square fa-2x" style="color: #ebd0a2;"></i>
                                        </a>
                                        <a href="#">
                                            <i class="fa-solid fa-square fa-2x" style="color: #865439;"></i>
                                        </a>
                                        <a href="#">
                                            <i class="fa-solid fa-square fa-2x" style="color: #1C487C;"></i>
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
                            <!-- <div class="filter-price">
                                <div class="title-left">
                                    <h3>Price</h3>
                                </div>
                                <div class="price-box-slider">
                                    <div id="slider-range"></div>
                                    <p>
                                        <input type="text" id="amount" readonly style="border:0; color:#fbb714; font-weight:bold;">
                                        <button class="btn hvr-hover" type="submit">Filter</button>
                                    </p>
                                </div>
                            </div>
                            <div class="filter-brand">
                                <div class="title-left">
                                    <h3>Brand</h3>
                                </div>
                                <div class="brand-box">
                                    <ul>
                                        <li>
                                            <div class="radio radio-danger">
                                                <input name="survey" id="Radios1" value="Yes" type="radio">
                                                <label for="Radios1"> Supreme </label>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="radio radio-danger">
                                                <input name="survey" id="Radios2" value="No" type="radio">
                                                <label for="Radios2"> A Bathing Ape </label>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="radio radio-danger">
                                                <input name="survey" id="Radios3" value="declater" type="radio">
                                                <label for="Radios3"> The Hundreds </label>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="radio radio-danger">
                                                <input name="survey" id="Radios4" value="declater" type="radio">
                                                <label for="Radios4"> Alife </label>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="radio radio-danger">
                                                <input name="survey" id="Radios5" value="declater" type="radio">
                                                <label for="Radios5"> Neighborhood </label>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="radio radio-danger">
                                                <input name="survey" id="Radios6" value="declater" type="radio">
                                                <label for="Radios6"> CLOT </label>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="radio radio-danger">
                                                <input name="survey" id="Radios7" value="declater" type="radio">
                                                <label for="Radios7"> Acapulco Gold </label>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="radio radio-danger">
                                                <input name="survey" id="Radios8" value="declater" type="radio">
                                                <label for="Radios8"> UNDFTD </label>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="radio radio-danger">
                                                <input name="survey" id="Radios9" value="declater" type="radio">
                                                <label for="Radios9"> Mighty Healthy </label>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="radio radio-danger">
                                                <input name="survey" id="Radios10" value="declater" type="radio">
                                                <label for="Radios10"> Fiberops </label>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div> -->
                        </div>
                    </div>

                    <div class="col-xl-9 col-lg-9 col-sm-12 shop-right">
                        <div class="product-item-filter row">
                            <div class="col-12 col-sm-8 text-ms-start">
                                <div class="filter-button-group">
                                    <span>Sort by </span>
                                    <select id="basic" class="form-select">
                                        <option selected>Nothing</option>
                                        <option value="1">Popularity</option>
                                        <option value="2">High Price → High Price</option>
                                        <option value="3">Low Price → High Price</option>
                                        <option value="4">Best Selling</option>
                                    </select>
                                </div>
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
                                        <a class="cart" href="#">Add to Cart</a>
                                    </div>
                                </div>
                                <div class="why-text">
                                    <h4>${product.name}</h4>
                                    <h5>${product.price} VND</h5>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                         <c:if test="${countPage != null}">
                                                <nav aria-label="Page navigation example">
                                                    <ul class="pagination">
                                                        <c:forEach begin="1" end="${countPage}" var="p">
                                                            <li class="page-item ${p == PAGE ? "active":""}"><a class="page-link" href="?page=${p}">${p}</a></li>
                                                            </c:forEach>
                                                    </ul>
                                                </nav>
                                                <!--END PAGING-->
                                            </c:if>
<!--                                    <ul class="pagination justify-content-end">
                                        <li class="page-item"><a class="page-link" href="#"><i class="fa-solid fa-angles-left"></i></a></li>
                                        <li class="page-item active"><a class="page-link" href="#">1</a></li>
                                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                                        <li class="page-item"><a class="page-link" href="#"><i class="fa-solid fa-angles-right"></i></a></li>
                                    </ul>-->
                                </div>
                            </div>
                            
                            
                                </div>
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