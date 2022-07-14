<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shop Online</title>
    <!-- Site Icons -->
    <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="css/style.css">
    <script src="https://kit.fontawesome.com/a4edd5786f.js" crossorigin="anonymous"></script>
    
    <!-- Bootstrap 5 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>

    <style>
        @import url('https://fonts.googleapis.com/css2?family=Montserrat&display=swap');
        body{background-color: #ffe8d2;font-family: 'Montserrat', sans-serif}
        .card{border:none}
        .logo{background-color: #eeeeeea8}
        .totals tr td{font-size: 13px}
        .footer{background-color: #eeeeeea8}
        .footer span{font-size: 12px}
        .product-qty span{font-size: 12px;color: #dedbdb}
    </style>
</head>
<body>
    <div class="container mt-5 mb-5">
        <div class="row d-flex justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header text-left logo p-2 px-5">
                        <img src="images/logo.png" width="100">
                    </div>
                    <div class="invoice p-5">
                        <h5>Your order Confirmed!</h5>
                        <span class="d-block mt-4"><strong>Hello, ${name}</strong></span>
                        <span>Your order has been confirmed and will be delivered to you as soon as possible!</span>
                        <div class="payment border-top mt-3 mb-3 border-bottom table-responsive">
                            <table class="table table-borderless">
                                <tbody>
                                    <tr>
                                        <td>
                                            <div class="py-2">
                                                <span class="d-block text-muted">Order Date</span>
                                                <span>${orderDate}</span>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="py-2">
                                                <span class="d-block text-muted">Order No</span>
                                                <span>#${orderNo}</span>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="py-2">
                                                <span class="d-block text-muted">Payment</span>
                                                <span><img src="https://img.icons8.com/color/48/000000/mastercard.png" width="20" /></span>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="py-2">
                                                <span class="d-block text-muted">Shiping Address</span>
                                                <span>414 Advert Avenue, NY,USA</span>
                                            </div>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="product border-bottom table-responsive">
                            <table class="table table-borderless">
                                <tbody>
                                    <c:forEach items="${orders}" var="order">
                                        <tr>
                                            <td width="20%">
                                                <img src="${order.product.img}" width="90" height="90" style="object-fit: cover;">
                                            </td>
                                            <td width="60%">
                                                <span class="font-weight-bold">${order.product.name}</span>
                                                <div class="product-qty">
                                                    <span class="d-block">Quantity: ${order.quantity}</span>
                                                    <span>Color:</span>
                                                </div>
                                            </td>
                                            <td width="20%">
                                                <div class="text-right">
                                                    <span class="font-weight-bold">
                                                        <fmt:formatNumber value="${order.product.salePrice}" type="currency"/>
                                                    </span>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody> 
                            </table>
                        </div>
                        <div class="row d-flex justify-content-end">
                            <div class="col-md-5">
                                <table class="table table-borderless">
                                    <tbody class="totals">
                                        <tr>
                                            <td>
                                                <div class="text-left">
                                                    <span class="text-muted">Subtotal</span>
                                                </div>
                                            </td>
                                                <td>
                                                    <div class="text-right">
                                                        <span>$168.50</span>
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <div class="text-left">
                                                        <span class="text-muted">Shipping Fee</span>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="text-right">
                                                        <span>Free</span>
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <div class="text-left">
                                                        <span class="text-muted">Tax Fee</span>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="text-right">
                                                        <span>$7.65</span>
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <div class="text-left">
                                                        <span class="text-muted">Discount</span>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="text-right">
                                                        <span class="text-success">$168.50</span>
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr class="border-top border-bottom">
                                                <td>
                                                    <div class="text-left">
                                                        <span class="font-weight-bold">Subtotal</span>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="text-right">
                                                        <span>
                                                            <strong>
                                                                <fmt:formatNumber value="${total}" type="currency"/>
                                                            </strong>
                                                        </span>
                                                    </div>
                                                </td>
                                            </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <p>We will be sending shipping confirmation email when the item shipped successfully!</p>
                        <p class="mb-0">
                            <strong>
                                Thanks for shopping with us!
                            </strong>
                        </p>
                        <span>Sneaker Store</span>
                    </div>
                    <div class="why-text px-5">
                        <a href="home" class="btn">Home</a>
                    </div>
                    <div class="d-flex justify-content-between footer p-3">
                        <span>Need Help? visit our <a href="#"> help center</a></span>
                        <span>12 June, 2020</span>
                    </div>
                </div>    
            </div>        
        </div> 
    </div>
</body>
</html>
