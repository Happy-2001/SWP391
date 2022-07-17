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
        <link rel="shortcut icon" href="../images/favicon.ico" type="image/x-icon">
        <link rel="stylesheet" href="../css/style.css">
        <link rel="stylesheet" href="../css/Dashboard.css">
        <link rel="stylesheet" href="../css/Customers.css">
        <script src="https://kit.fontawesome.com/a4edd5786f.js" crossorigin="anonymous"></script>

        <!-- Bootstrap 5 -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    </head>
    <body>
        <c:set var="OrdersActive" value="active"/>
        <%@include file="Topbar.jsp" %>

        <div class="container-fluid">
            <div class="row">
                <%@include file="menuDashBoard.jsp" %>

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
                    <div class="content">
                        <div class="card">
                            <div class="card-body">
                                <div class="d-md-flex gap-4 align-items-center">
                                    <div class="d-none d-md-flex">All Orders</div>


                                    <div class="row g-3">
                                        <form action="MyOrderController" method="POST">
                                            <div class="col-md-3">
                                                <select class="form-select" name="filter">
                                                    <option value="0" ${param.filter==0 ? 'selected' : ''} selected>Sort by</option>
                                                    <option value="-2" ${param.filter==-2 ? 'selected' : ''}>ASC</option>
                                                    <option value="1" ${param.filter==1 ? 'selected' : ''}>DESC</option>
                                                    <option value="2" ${param.filter==2 ? 'selected' : ''}>Pending</option>
                                                    <option value="3" ${param.filter==3 ? 'selected' : ''}>Completed</option>
                                                    <option value="4" ${param.filter==4 ? 'selected' : ''}>Shipped</option>
                                                    <option value="5" ${param.filter==5 ? 'selected' : ''}>Refunded</option>
                                                    <option value="6" ${param.filter==6 ? 'selected' : ''}>Canceled</option>
                                                </select>
                                                <div class="why-text py-0">
                                                    <button type="submit" class="btn m-0">Sort</button>
                                                </div>
                                            </div>
                                        </form>
                                        
                                    </div>

                                </div>
                            </div>
                        </div>
                        <div class="table-responsive cus-box">
                            <table class="table table-custom table-lg mb-0">               
                                <thead>
                                    <tr>
                                        <th>
                                            <input class="form-check-input select-all" type="checkbox" data-select-all-target="#orders" id="defaultCheck1">
                                        </th>
                                        <th>ID</th>
                                        <th>Customer ID</th>
                                        <th>Date</th>
                                        <th>Total</th>
                                        <th>Status</th>
                                        <th class="text-end">Actions</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${Orderlist}" var="u">
                                        <tr>
                                            <td>
                                                <input class="form-check-input" type="checkbox">
                                            </td>
                                            <td>
                                                <a href="#">#${u.orderID}</a>
                                            </td>
                                            <td>${u.customerId}</td>
                                            <td>${u.orderDate}</td>
                                            <td>$239,00</td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${u.status eq 'pending'}">
                                                        <span class="badge bg-primary">${u.status}</span>
                                                    </c:when>
                                                    <c:when test="${u.status eq 'shipped'}">
                                                        <span class="badge bg-dark">${u.status}</span>
                                                    </c:when>
                                                    <c:when test="${u.status eq 'completed'}">
                                                        <span class="badge bg-success">${u.status}</span>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <span class="badge bg-danger">${u.status}</span>
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td class="text-end">
                                                <div class="d-flex">
                                                    <div class="dropdown ms-auto">
                                                        <a href="#" data-bs-toggle="dropdown" class="btn btn-floating">
                                                            <i class="fa-solid fa-ellipsis"></i>
                                                        </a>
                                                        <div class="dropdown-menu dropdown-menu-end">
                                                            <a href="OrderDetailController?id=${u.orderID}&cid=${u.customerId}" class="dropdown-item">View</a>
                                                            <a href="#" class="dropdown-item">Delete</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </td>
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
                </div>
                <script src="js/list-select.js"></script>
            </div>
        </div>
    </body>
</html>

