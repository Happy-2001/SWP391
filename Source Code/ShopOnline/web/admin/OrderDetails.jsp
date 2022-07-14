<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin || Shop Online</title>
    <!-- Site Icons -->
    <link rel="shortcut icon" href="../images/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/Dashboard.css">
    <link rel="stylesheet" href="../css/Order.css">
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
                            <a href="dashboard">
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
                            <a href="#">
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
                <div class="content"> 
                    <div aria-label="breadcrumb" class="mb-3">
                        <ul class="breadcrumb">
                            <li class="breadcrumb-item">
                                <i class="fa-solid fa-globe fa-sm"></i>
                                <a href="dashboard">Dashboard</a>
                            </li>
                            <li class="breadcrumb-item">
                                <a href="MyOrderController">Order</a>
                            </li>
                            <li class="breadcrumb-item active" aria-current="page">Order Detail</li>
                        </ul>
                    </div>

                    <div class="row cus-box">
                        <div class="col-lg-8 col-md-12">
                            <div class="card mb-4">
                                <div class="card-body">
                                    <div class="mb-5 d-flex align-items-center justify-content-between">
                                        <span>Order No : <a href="#">#${order.orderID}</a></span>
                                        <div class="dropdown ms-auto">
                                            <c:choose>
                                                <c:when test="${order.status eq 'pending'}">
                                                    <span class="badge bg-primary">${order.status}</span>
                                                </c:when>
                                                <c:when test="${order.status eq 'shipped'}">
                                                    <span class="badge bg-dark">${order.status}</span>
                                                </c:when>
                                                <c:when test="${order.status eq 'completed'}">
                                                    <span class="badge bg-success">${order.status}</span>
                                                </c:when>
                                                <c:otherwise>
                                                    <span class="badge bg-danger">${order.status}</span>
                                                </c:otherwise>
                                            </c:choose>
                                            <a href="#" data-bs-toggle="dropdown" class="btn btn-floating">
                                                <i class="fa-solid fa-ellipsis"></i>
                                            </a>
                                            <div class="dropdown-menu dropdown-menu-end">
                                                <a href="#" class="dropdown-item">
                                                    <i class="fa-solid fa-circle fa-2xs pe-2 text-primary"></i> Pending
                                                </a>
                                                <a href="#" class="dropdown-item">
                                                    <i class="fa-solid fa-circle fa-2xs pe-2 text-success"></i> Completed
                                                </a>
                                                <a href="#" class="dropdown-item">
                                                    <i class="fa-solid fa-circle fa-2xs pe-2"></i> Shipped
                                                </a>
                                                <a href="#" class="dropdown-item">
                                                    <i class="fa-solid fa-circle fa-2xs pe-2 text-warning"></i> Refunded
                                                </a>
                                                <a href="#" class="dropdown-item">
                                                    <i class="fa-solid fa-circle fa-2xs pe-2 text-danger"></i> Cancelled
                                                </a>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row mb-5 g-4">
                                        <div class="col-md-3 col-sm-6">
                                            <p class="fw-bold">Order Created at</p>
                                            ${order.orderDate}
                                        </div>
                                        <div class="col-md-3 col-sm-6">
                                            <p class="fw-bold">Name</p>
                                            Sayres Seater
                                        </div>
                                        <div class="col-md-3 col-sm-6">
                                            <p class="fw-bold">Email</p>
                                            sayres@sayres.com
                                        </div>
                                        <div class="col-md-3 col-sm-6">
                                            <p class="fw-bold">Contact No</p>
                                            767-251-8637
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="card widget">
                                <div class="card-body">
                                    <h5 class="mb-0">Order Items</h5>
                                    <div class="table-responsive">
                                        <table class="table table-custom mb-0">
                                            <thead>
                                                <tr>
                                                    <th>Photo</th>
                                                    <th>Name</th>
                                                    <th>Quantity</th>
                                                    <th>Price</th>
                                                    <th>Total</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${orderlist}" var="o">
                                                    <tr>
                                                        <td class="product-ava">
                                                            <a href="#">
                                                                <img src="../${o.product.img}" class="rounded" height="60" width="60" alt="..." style="object-fit: cover;">
                                                            </a>
                                                        </td>
                                                        <td>${o.product.name}</td>
                                                        <td>${o.quantity}</td>
                                                        <td>
                                                            <fmt:formatNumber value="${o.product.salePrice}" type="currency"/>
                                                        </td>
                                                        <td>
                                                            <fmt:formatNumber value="${o.quantity * o.product.salePrice}" type="currency"/>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-12 mt-4 mt-lg-0">
                            <div class="card mb-4">
                                <div class="card-body">
                                    <h6 class="card-title mb-4">Price</h6>
                                    <div class="row justify-content-center mb-3">
                                        <div class="col-4 text-end">Sub Total :</div>
                                        <div class="col-4">
                                            <fmt:formatNumber value="${total}" type="currency"/>
                                        </div>
                                    </div>
                                    <div class="row justify-content-center mb-3">
                                        <div class="col-4 text-end">Shipping :</div>
                                        <div class="col-4">Free</div>
                                    </div>
                                    <div class="row justify-content-center mb-3">
                                        <div class="col-4 text-end">Tax(10%) :</div>
                                        <div class="col-4">
                                            <fmt:formatNumber value="${vat}" type="currency"/>
                                        </div>
                                    </div>
                                    <div class="row justify-content-center">
                                        <div class="col-4 text-end">
                                            <strong>Total :</strong>
                                        </div>
                                        <div class="col-4">
                                            <strong><fmt:formatNumber value="${sum}" type="currency"/></strong>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="card mt-4">
                                <div class="card-body d-flex flex-column gap-3">
                                    <div class="d-flex justify-content-between">
                                        <h5 class="mb-0">Address</h5>
                                        <a href="#">Edit</a>
                                    </div>
                                    <div>Name: Home</div>
                                    <div>Josephin Villa</div>
                                    <div>81 Fulton Park, Brazil/Pedro Leopoldo</div>
                                    <div>
                                        <i class="fa-solid fa-phone me-2"></i> 408-963-7769
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>