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

        <!-- Start Slider -->
        <div id="slides-shop" class="carousel slide" data-bs-ride="carousel" style="margin-top: 91px;">
            <div class="carousel-inner">
                <div class="cover-slides carousel-item">
                    <img src="https://theme.hstatic.net/200000238513/1000665981/14/slider_1.jpg?v=23">
                    <div class="carousel-caption">
                        <h1><strong>3 Mẫu giày hot nhất</strong></h1>
                        <p>
                            <i>Đây là những mẫu bán chạy của shop,<br>Chiều chuộng những khách hàng khó tính nhất</i>
                        </p>
                        <p>
                            <a class="hvr-hover" href="ProductController">Click me!</a>
                        </p>
                    </div>
                    <!-- <div class="container">
                        <div class="row">
                        </div>
                    </div> -->
                </div>
                <div class="cover-slides carousel-item">
                    <img src="https://cdn.dribbble.com/users/2317528/screenshots/5332010/nike-adidas_shoe_slider.png" alt="">
                    <div class="carousel-caption">
                        <h1><strong>3 Mẫu giày hot nhất</strong></h1>
                        <p>
                            <i>Đây là những mẫu bán chạy của shop,<br>Chiều chuộng những khách hàng khó tính nhất</i>
                        </p>
                        <p>
                            <a class="hvr-hover" href="ProductController">Click me!</a>
                        </p>
                    </div>
                    <!-- <div class="container">
                        <div class="row">
                        </div>
                    </div> -->
                </div>
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
                    <div class="col-lg-3 col-md-6 special-grid best-seller">
                        <div class="products-single">
                            <div class="box-img-hover">
                                <div class="type-lb">
                                    <p class="sale">Sale</p>
                                </div>
                                <img src="images/2.jpg" class="img-fluid" alt="Image">
                                <div class="mask-icon">
                                    <ul>
                                        <li><a href="productDetail?product_id=2" data-bs-toggle="tooltip" data-bs-placement="right" title="View"><i class="fas fa-eye"></i></a></li>
                                        <li><a href="#" data-bs-toggle="tooltip" data-bs-placement="right" title="Compare"><i class="fas fa-sync-alt"></i></a></li>
                                        <li><a href="#" data-bs-toggle="tooltip" data-bs-placement="right" title="Add to Wishlist"><i class="far fa-heart"></i></a></li>
                                    </ul>
                                    <a class="cart" href="#">Add to Cart</a>
                                </div>
                            </div>
                            <div class="why-text">
                                <h4>Chuck Taylor</h4>
                                <h5>2350000.0 VND</h5>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-3 col-md-6 special-grid best-seller">
                        <div class="products-single">
                            <div class="box-img-hover">
                                <div class="type-lb">
                                    <p class="sale">Sale</p>
                                </div>
                                <img src="images/3.jpg" class="img-fluid" alt="Image">
                                <div class="mask-icon">
                                    <ul>
                                        <li><a href="productDetail?product_id=3" data-bs-toggle="tooltip" data-bs-placement="right" title="View"><i class="fas fa-eye"></i></a></li>
                                        <li><a href="#" data-bs-toggle="tooltip" data-bs-placement="right" title="Compare"><i class="fas fa-sync-alt"></i></a></li>
                                        <li><a href="#" data-bs-toggle="tooltip" data-bs-placement="right" title="Add to Wishlist"><i class="far fa-heart"></i></a></li>
                                    </ul>
                                    <a class="cart" href="#">Add to Cart</a>
                                </div>
                            </div>
                            <div class="why-text">
                                <h4>Air Force 1</h4>
                                <h5>2650000.0 VND</h5>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-3 col-md-6 special-grid best-seller">
                        <div class="products-single">
                            <div class="box-img-hover">
                                <div class="type-lb">
                                    <p class="sale">Sale</p>
                                </div>
                                <img src="images/4.jpg" class="img-fluid" alt="Image">
                                <div class="mask-icon">
                                    <ul>
                                        <li><a href="productDetail?product_id=4" data-bs-toggle="tooltip" data-bs-placement="right" title="View"><i class="fas fa-eye"></i></a></li>
                                        <li><a href="#" data-bs-toggle="tooltip" data-bs-placement="right" title="Compare"><i class="fas fa-sync-alt"></i></a></li>
                                        <li><a href="#" data-bs-toggle="tooltip" data-bs-placement="right" title="Add to Wishlist"><i class="far fa-heart"></i></a></li>
                                    </ul>
                                    <a class="cart" href="#">Add to Cart</a>
                                </div>
                            </div>
                            <div class="why-text">
                                <h4>SlipOn</h4>
                                <h5>1750000.0 VND</h5>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-3 col-md-6 special-grid best-seller">
                        <div class="products-single">
                            <div class="box-img-hover">
                                <div class="type-lb">
                                    <p class="sale">Sale</p>
                                </div>
                                <img src="images/5.jpg" class="img-fluid" alt="Image">
                                <div class="mask-icon">
                                    <ul>
                                        <li><a href="productDetail?product_id=5" data-bs-toggle="tooltip" data-bs-placement="right" title="View"><i class="fas fa-eye"></i></a></li>
                                        <li><a href="#" data-bs-toggle="tooltip" data-bs-placement="right" title="Compare"><i class="fas fa-sync-alt"></i></a></li>
                                        <li><a href="#" data-bs-toggle="tooltip" data-bs-placement="right" title="Add to Wishlist"><i class="far fa-heart"></i></a></li>
                                    </ul>
                                    <a class="cart" href="#">Add to Cart</a>
                                </div>
                            </div>
                            <div class="why-text">
                                <h4>Blazer</h4>
                                <h5>3200000.0 VND</h5>
                            </div>
                        </div>
                    </div> 
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
                    <div class="col-lg-3 col-md-6 special-grid best-seller">
                        <div class="products-single fix">
                            <div class="box-img-hover">
                                <div class="type-lb">
                                    <p class="sale">Sale</p>
                                </div>
                                <img src="images/15.jpg" alt="Image">
                                <div class="mask-icon">
                                    <ul>
                                        <li><a href="productDetail?product_id=15" data-bs-toggle="tooltip" data-bs-placement="right" title="View"><i class="fas fa-eye"></i></a></li>
                                        <li><a href="#" data-bs-toggle="tooltip" data-bs-placement="right" title="Compare"><i class="fas fa-sync-alt"></i></a></li>
                                        <li><a href="#" data-bs-toggle="tooltip" data-bs-placement="right" title="Add to Wishlist"><i class="far fa-heart"></i></a></li>
                                    </ul>
                                    <a class="cart" href="#">Add to Cart</a>
                                </div>
                            </div>
                            <div class="why-text">
                                <h4>Wmns Air Jordan 1</h4>
                                <h5>5900000.0 VND</h5>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-3 col-md-6 special-grid best-seller">
                        <div class="products-single fix">
                            <div class="box-img-hover">
                                <div class="type-lb">
                                    <p class="sale">Sale</p>
                                </div>
                                <img src="images/14.jpg" class="img-fluid" alt="Image">
                                <div class="mask-icon">
                                    <ul>
                                        <li><a href="productDetail?product_id=14" data-bs-toggle="tooltip" data-bs-placement="right" title="View"><i class="fas fa-eye"></i></a></li>
                                        <li><a href="#" data-bs-toggle="tooltip" data-bs-placement="right" title="Compare"><i class="fas fa-sync-alt"></i></a></li>
                                        <li><a href="#" data-bs-toggle="tooltip" data-bs-placement="right" title="Add to Wishlist"><i class="far fa-heart"></i></a></li>
                                    </ul>
                                    <a class="cart" href="#">Add to Cart</a>
                                </div>
                            </div>
                            <div class="why-text">
                                <h4>NMD_R1 V2</h4>
                                <h5>1700000.0 VND</h5>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-3 col-md-6 special-grid best-seller">
                        <div class="products-single fix">
                            <div class="box-img-hover">
                                <div class="type-lb">
                                    <p class="sale">Sale</p>
                                </div>
                                <img src="images/13.jpg" class="img-fluid" alt="Image">
                                <div class="mask-icon">
                                    <ul>
                                        <li><a href="productDetail?product_id=13" data-bs-toggle="tooltip" data-bs-placement="right" title="View"><i class="fas fa-eye"></i></a></li>
                                        <li><a href="#" data-bs-toggle="tooltip" data-bs-placement="right" title="Compare"><i class="fas fa-sync-alt"></i></a></li>
                                        <li><a href="#" data-bs-toggle="tooltip" data-bs-placement="right" title="Add to Wishlist"><i class="far fa-heart"></i></a></li>
                                    </ul>
                                    <a class="cart" href="#">Add to Cart</a>
                                </div>
                            </div>
                            <div class="why-text">
                                <h4>PUMA RS-X3</h4>
                                <h5>3250000.0 VND</h5>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-3 col-md-6 special-grid best-seller">
                        <div class="products-single fix">
                            <div class="box-img-hover">
                                <div class="type-lb">
                                    <p class="sale">Sale</p>
                                </div>
                                <img src="images/12.jpg" class="img-fluid" alt="Image">
                                <div class="mask-icon">
                                    <ul>
                                        <li><a href="productDetail?product_id=12" data-bs-toggle="tooltip" data-bs-placement="right" title="View"><i class="fas fa-eye"></i></a></li>
                                        <li><a href="#" data-bs-toggle="tooltip" data-bs-placement="right" title="Compare"><i class="fas fa-sync-alt"></i></a></li>
                                        <li><a href="#" data-bs-toggle="tooltip" data-bs-placement="right" title="Add to Wishlist"><i class="far fa-heart"></i></a></li>
                                    </ul>
                                    <a class="cart" href="#">Add to Cart</a>
                                </div>
                            </div>
                            <div class="why-text">
                                <h4>Continental</h4>
                                <h5>1290000.0 VND</h5>
                            </div>
                        </div>
                    </div>     
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
        <script src="js/tooltip.js"></script>
    </body>
</html>
