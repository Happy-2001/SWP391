<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
    <link rel="stylesheet" href="css/card.css">
    <link rel="stylesheet" href="css/responsive.css">
    <script src="js/fontAwesome.js"></script>
    
    <!-- Bootstrap 5 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</head>
 <body>
        <jsp:include page="topbar.jsp"/>
        <jsp:include page="header.jsp"/>
            <div class="container">
                <div class="row">
                    <div class="col">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="home">Home</a></li>
                            </ol>
                        </nav>
                    </div>
                </div>
            </div>
            <div class="shopping-cart">
                <div class="px-4 px-lg-0">

                    <div class="pb-5">
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

                                    <!-- Shopping cart table -->
                                    <div class="table-responsive">
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="p-2 px-3 text-uppercase">Sản Phẩm</div>
                                                    </th>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="py-2 text-uppercase">Số Lượng</div>
                                                    </th>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="py-2 text-uppercase">Đơn Giá</div>
                                                    </th>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="py-2 text-uppercase">Thành Tiền</div>
                                                    </th>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="py-2 text-uppercase">Xóa Và Update số lượng</div>
                                                    </th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach items="${sessionScope.listCart}" var="l">
                                            <form action="UpdateCartController?pid=${l.id}" method="post">
                                                <c:set var="total" value="${l.price*l.stock }"></c:set>
                                                    <tr>
                                                        <td>
                                                            <figure class="media">
                                                                <div class="img-wrap"><img width="300" height="300" src="${l.img}" class="img-thumbnail img-sm"></div>
                                                            <figcaption class="media-body">,
                                                                <h6 class="title text-truncate">${l.name} </h6>
                                                            </figcaption>
                                                        </figure> 
                                                    </td>
                                                    <td> 
                                                        <input name="updateQuantity" style="text-align: center" type="number" value="${l.stock}" onchange="">
                                                    </td>
                                                    <td> 
                                                        <div class="price-wrap"> 
                                                            <var style="font-weight: bold"  class="price"> ${l.price}</var> 
                                                        </div> 
                                                    </td>
                                                    <td style="font-weight: bold"> 
                                                        ${l.price*l.stock}
                                                    </td>
                                                    <td class="text-right"> 
                                                        <button type="submit"  class="btn btn-outline-success" data-toggle="tooltip" data-original-title="Save"><i class="fa fa-refresh" aria-hidden="true"></i></button> 
                                                        <a href="DeleteCart?pid=${l.id}" class="btn btn-outline-success">Delete</a>
                                                    </td>
                                                </tr>
                                            </form>


                                        </c:forEach>


                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>

        </div> 
        <form action="checkOut"method="post">
            <div class="row py-5 p-4 bg-white rounded shadow-sm">

                <div class="col-lg-6">
                    <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Thành tiền</div>
                    <div class="p-4">
                        <ul class="list-unstyled mb-4">
                            <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tổng tiền hàng</strong><strong>${total}</strong></li>
                            <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Phí vận chuyển</strong><strong>Free ship</strong></li>
                            <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tổng thanh toán</strong>
                                <h5 class="font-weight-bold">${total} VNĐ </h5>
                            </li>
                        </ul><a href="checkOut?total1=${total}" class="btn btn-dark rounded-pill py-2 btn-block">Mua hàng</a>
                    </div>
                </div>
            </div>                       
        </form>   
                 
    </body>
       
</html>