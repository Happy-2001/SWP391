<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Admin || Shop Online</title>
        <!-- Site Icons -->
        <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/Dashboard.css">
        <link rel="stylesheet" href="css/Customers.css">
        <script src="https://kit.fontawesome.com/a4edd5786f.js" crossorigin="anonymous"></script>

        <!-- Bootstrap 5 -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    </head>
    <body>
        <%@include file="Topbar.jsp" %>

        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-3 menu-bar">
                    <div class="menu">
                        <ul class="menu-links">
                            <li class="nav-link">
                                <a href="Dashboard">
                                    <span class="nav-link-icon">
                                        <i class="fa-solid fa-chart-simple fa-xl"></i>
                                    </span>
                                    <span class="text nav-text">Dashboard</span>
                                </a>
                            </li>

                            <li class="nav-link">
                                <a class="active" href="MyOrderController">
                                    <span class="nav-link-icon">
                                        <i class="fa-solid fa-receipt"></i>
                                    </span>
                                    <span class="text nav-text">Orders</span>
                                </a>
                            </li>

                            <li class="nav-link">
                                <a href="#">
                                    <span class="nav-link-icon">
                                        <i class="fa-solid fa-box fa-xl"></i>
                                    </span>
                                    <span class="text nav-text">Products</span>
                                </a>
                            </li>

                            <li class="nav-link">
                                <a href="CusController">
                                    <span class="nav-link-icon">
                                        <i class="fa-solid fa-user-group fa-xl"></i>
                                    </span>
                                    <span class="text nav-text">Customers</span>
                                </a>
                            </li>

                            <li class="nav-link">
                                <a href="message">
                                    <span class="nav-link-icon">
                                        <i class="fa-solid fa-envelope fa-xl"></i>
                                    </span>
                                    <span class="text nav-text">Chats</span>
                                    <span class="badge bg-success rounded-circle ms-auto">1</span>
                                </a>
                            </li>

                            <li class="nav-link">
                                <a href="#">
                                    <span class="nav-link-icon">
                                        <i class="fa-solid fa-bell fa-xl"></i>
                                    </span>
                                    <span class="text nav-text">Notifications</span>
                                </a>
                            </li>

                            <li class="nav-link">
                                <a href="FeedbackAd">
                                    <span class="nav-link-icon">
                                        <i class="fa-solid fa-comment-dots fa-xl"></i>
                                    </span>
                                    <span class="text nav-text">Feedback</span>
                                </a>
                            </li>

                            <li class="nav-link">
                                <a href="account.html">
                                    <span class="nav-link-icon">
                                        <i class="fa-solid fa-circle-user fa-xl"></i>
                                    </span>
                                    <span class="text nav-text">Accounts</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-9 main">
                    <div aria-label="breadcrumb" class="mb-3">
                        <ul class="breadcrumb">
                            <li class="breadcrumb-item">
                                <i class="fa-solid fa-globe fa-sm"></i>
                                <a href="dashboard">Dashboard</a>
                            </li>
                            <li class="breadcrumb-item active" aria-current="page">Order</li>
                        </ul>
                    </div>
                    <div class="container my-5">
                        <table  class="table table-dark table-striped">               
                            <thead>
                                <tr>
                                    <th scope="col">Order ID</th>
                                    <th scope="col">Order Date</th>
                                    <th scope="col">Required Date</th>
                                    <th scope="col">Shipped Date</th>
                                    <th scope="col">Customer ID</th>
                                    <th scope="col">View</th>

                                </tr>
                            </thead>
                            <tbody>
                                <c:set var="i" value="0"></c:set>
                                <c:forEach items="${Orderlist}" var="u">
                                    <tr>
                                        <td>${u.orderID}</td>

                                        <td>${u.orderDate}</td>

                                        <td>${u.requireDate}</td>

                                        <td>${u.shippedDate}</td>

                                        <td>${u.customerId}</td>


                                        <td><a class="btn btn-success" href="OrderDetailController?id=${u.orderID}">View</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <ul class="pagination justify-content-center">
                            <li class="page-item">
                                <a class="page-link" href="#"><i class="fa-solid fa-angles-left"></i></a>
                            </li>
                            <li class="page-item active"><a class="page-link" href="#">1</a></li>
                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item">
                                <a class="page-link" href="#"><i class="fa-solid fa-angles-right"></i></a>
                            </li>
                        </ul>
                    </div>
                </div>
                <script src="js/list-select.js"></script>
            </div>
        </div>
    </div>
</body>
</html>

