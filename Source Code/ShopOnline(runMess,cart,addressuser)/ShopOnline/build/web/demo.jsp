<%@page import="model.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sneaker Store</title>
    <!-- Site Icons -->
    <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
    <link rel="apple-touch-icon" href="images/apple-touch-icon.png">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/card.css">
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
    
    <div class="order-box">
                                <div class="title-top">
                                    <h4>Your order</h4>
                                </div>
                                <div class="order-ls" style="margin-top: 20px;">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <td>Product</td>
                                                <td>Quantity</td>
                                                <td>Price</td>
                                                <td></td>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${cartList}" var="carts">
                                                <tr>
                                                    <td class="d-flex flex-row me-3">
                                                        <div class="image">
                                                            <img src="${carts.product.img}" class="img-fluid">
                                                        </div>
                                                        <div class="d-flex flex-column">
                                                            <span><strong>${carts.product.name}</strong></span>
                                                            <span>Color</span>
                                                            <span>Size</span>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <input type="text" value="${carts.quantity}" disabled>
                                                    </td>
                                                    <td>${carts.product.price*carts.quantity}<i class="fa-solid fa-dong-sign"></i></td>
                                                    <td><i class="fa-regular fa-trash-can remove-icon"></i></td>
                                                </tr>     
                                            </c:forEach>
                                            <tr>
                                                <td style="color: #d33b33; font-size: 20px; font-weight: 600;">Total:</td>
                                                <td></td>
                                                <td>${total}<i class="fa-solid fa-dong-sign"></i></td>
                                                <td></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                                                
</body>
</html>
