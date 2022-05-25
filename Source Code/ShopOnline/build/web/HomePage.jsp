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

        <!-- Start Slider -->
        <div id="slides-shop" class="cover-slides">
            <ul class="slides-container">
                <c:forEach items="${slides}" var="s">
                    <c:if test="${s.status}">
                    <li class="text-left">
                        <img src="${s.img}" alt="">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-12">
                                    <h1 class="m-b-20"><strong>${s.heading}</strong></h1>
                                    <p class="m-b-40">${s.description}</p>
                                    <p><a class="btn hvr-hover" href="${s.url}">${s.namebutton}</a></p>
                                </div>
                            </div>
                        </div>
                    </li>
                    </c:if>
                </c:forEach>
            </ul>
            <div class="slides-navigation">
                <a href="#" class="next"><i class="fa fa-angle-right" aria-hidden="true"></i></a>
                <a href="#" class="prev"><i class="fa fa-angle-left" aria-hidden="true"></i></a>
            </div>
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
                            <div class="products-single fix">
                                <div class="box-img-hover">
                                    <div class="type-lb">
                                        <p class="sale">Sale</p>
                                    </div>
                                    <img src="${product.img}" class="img-fluid" alt="Image">
                                    <div class="mask-icon">
                                        <ul>
                                            <li><a href="productDetail?product_id=${product.id}" data-toggle="tooltip" data-placement="right" title="View"><i class="fas fa-eye"></i></a></li>
                                            <li><a href="#" data-toggle="tooltip" data-placement="right" title="Compare"><i class="fas fa-sync-alt"></i></a></li>
                                            <li><a href="#" data-toggle="tooltip" data-placement="right" title="Add to Wishlist"><i class="far fa-heart"></i></a></li>
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
                                            <li><a href="productDetail?product_id=${product.id}" data-toggle="tooltip" data-placement="right" title="View"><i class="fas fa-eye"></i></a></li>
                                            <li><a href="#" data-toggle="tooltip" data-placement="right" title="Compare"><i class="fas fa-sync-alt"></i></a></li>
                                            <li><a href="#" data-toggle="tooltip" data-placement="right" title="Add to Wishlist"><i class="far fa-heart"></i></a></li>
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
                                <ul class="option-blog">
                                    <li><a href="#" data-toggle="tooltip" data-placement="right" title="Likes"><i class="far fa-heart"></i></a></li>
                                    <li><a href="#" data-toggle="tooltip" data-placement="right" title="Views"><i class="fas fa-eye"></i></a></li>
                                    <li><a href="#" data-toggle="tooltip" data-placement="right" title="Comments"><i class="far fa-comments"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        <!-- End Blog  -->


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

                    <div class="col-md-6 col-lg-4 col-xl-4">
                        <div class="blog-box">
                            <div class="blog-img">
                                <img class="img-fluid" src="https://hoc11.vn/wp-content/uploads/2020/12/1BIKIP.jpg" alt="">
                            </div>
                            <div class="blog-content">
                                <div class="title-blog">
                                    <a href="blogdetail?id=1" class="h3"><b>Bí kíp săn deal 1đ, 1K</b></a>
                                    <p>Như mình có nói ở phần trước: “Săn sale là một nghệ thuật, người săn sale là một nghệ sĩ”. Để thành nghệ sĩ săn sale thực thụ thì bạn cần nắm vững các bước để săn sale. Sau đó bạn phải luyện tập thật nhiều để nhanh hơn 99% người còn lại và dành chiến thắng trong cuộc chiến săn sale này.</p>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-6 col-lg-4 col-xl-4">
                        <div class="blog-box">
                            <div class="blog-img">
                                <img class="img-fluid" src="https://anhdulichdep.com/wp-content/uploads/2019/01/chon-size-giay-1.jpg" alt="">
                            </div>
                            <div class="blog-content">
                                <div class="title-blog">
                                    <a href="blogdetail?id=2" class="h3"><b>Hướng dẫn chọn size giày và bảng quy đổi size giày</b></a>
                                    <p>Bạn muốn mua một đôi giày nhưng lại không biết cách đo size giày sao cho chuẩn? Hãy cùng Vina giày tìm hiểu các bước đo zise giày và bảng quy chuẩn size giày theo Việt Nam, US và UK dưới đây nhé</p>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-6 col-lg-4 col-xl-4">
                        <div class="blog-box">
                            <div class="blog-img">
                                <img class="img-fluid" src="https://product.hstatic.net/1000243581/product/upload_6c157bb8acaa44db90d13b4bbaf9c09b_1024x1024.jpg" alt="">
                            </div>
                            <div class="blog-content">
                                <div class="title-blog">
                                    <a href="blogdetail?id=3" class="h3"><b>Cập Nhật Ngay Top 2 Xu Hướng Giày Sneaker 2021</b></a>
                                    <p>Bạn là có niềm yêu thích đối với sneaker? Bạn muốn cập nhật nhanh chóng xu hướng giày sneaker 2021 để đón đầu xu thế? Nhưng làm cách nào để cập nhật nhanh chóng thông tin khi có quá nhiều mẫu mã khác nhau trên thị trường. Đừng lo đã có OnlineShop giúp bạn giải quyết nổi lo rồi…</p>
                                    <a href="#">More</a>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <!-- End Blog  -->
        
        <%@include file="footer.jsp" %>
    </body>
</html>
