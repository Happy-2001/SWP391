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

        <div class="container my-5" style="margin-top:60px;">

            <form class="form-control mb-4" action="blogsearch" method="GET">
                <input type="text" name="search" value="${requestScope.search}"> <input type="submit" value="Search" />
            </form>


            <c:forEach items="${blogs}" var="b">
                <div class="card mb-3">
                    <div class="row no-gutters">
                        <div class="col-md-4">
                            <img src="${b.image}" width="300px" height="200px">
                        </div>
                        <div class="col-md-8">
                            <div class="card-body">
                                <a href="blogdetail?id=${b.id}" class="card-title h3">${b.content}</a>
                                <p class="card-text">${b.description}</p>
                                <p class="card-text"><small class="text-muted">${b.createdDate}</small></p>
                            </div>
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
            </c:if>

        </div>
        <!-- Start Footer  -->
        <footer>
            <div class="footer-main">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-12 col-sm-12">
                    <div class="footer-widget">
                        <h4>About ThewayShop</h4>
                        <p>TheWay shoes were born based on the shop owner's love of Nike shoes, Adidas shoes, Vans shoes... by the enchanting beauty of these trendy shoe models!
                        </p>
                        <ul>
                            <li><a href="https://www.facebook.com/bibeoauthentic97"><i class="fab fa-facebook" aria-hidden="true"></i></a></li>
                            <li><a href="https://www.instagram.com/bibeo.authentic/?fbclid=IwAR2o3TdF84Ha1U-idkHYnu1vte-pbUbaRrSsvjl3ClZBPLqk67Wb19-VZss"><i class="fab fa-instagram" aria-hidden="true"></i></a></li>

                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-12 col-sm-12">
                    <div class="footer-link">
                        <h4>Information</h4>
                        <ul>
                            <a >Nike</a><br>
                            <a >Vans</a><br>
                            <a >Adidas</a><br>
                            <a >New Blance</a><br>
                            
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-12 col-sm-12">
                    <div class="footer-link-contact">
                        <h4>Contact Us</h4>
                        <ul>
                            <li>
                                <p><i class="fas fa-map-marker-alt"></i>103 phố Hồ Đắc Di , phường Nam Đồng, <br> quận Đống Đa Hanoi, Vietnam 100000</p>
                            </li>
                            <li>
                                <p><i class="fas fa-phone-square"></i>Phone: <a href="tel:+091 978 55 48">091 978 55 48</a></p>
                            </li>
                            <li>
                                <p><i class="fas fa-envelope"></i>Email: <a href="mailto:bi1508.97@gmail.com">bi1508.97@gmail.com</a></p>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
        </footer>
        <!-- End Footer  -->

        <!-- Start copyright  -->

        <!-- End copyright  -->

        <a href="#" id="back-to-top" title="Back to top" style="display: none;">&uarr;</a>

        <!-- ALL JS FILES -->
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <!-- ALL PLUGINS -->
        <script src="js/jquery.superslides.min.js"></script>
        <script src="js/bootstrap-select.js"></script>
        <script src="js/inewsticker.js"></script>
        <script src="js/bootsnav.js"></script>
        <script src="js/images-loded.min.js"></script>
        <script src="js/isotope.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/baguetteBox.min.js"></script>
        <script src="js/form-validator.min.js"></script>
        <script src="js/contact-form-script.js"></script>
        <script src="js/custom.js"></script>
    </body>
</html>
