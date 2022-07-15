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
    <c:set var="OrdersActive" value="active"/>
    <%@include file="Topbar.jsp" %>
    
    <div class="container-fluid">
        <div class="row">
            <%@include file="menuDashBoard.jsp" %>
            
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
                                        <form action="OrderDetailController" method="POST">
                                            <input type="hidden" name="id" value="${order.orderID}">
                                            <input type="hidden" name="rdate" value="${order.requireDate}">
                                            <input type="hidden" name="sdate" value="${order.shippedDate}">
                                            <div class="ms-auto">
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
                                                <button type="submit" class="btn ms-2 saveBtn close">
                                                    <i class="fa-regular fa-floppy-disk"></i>
                                                </button>
                                                <button type="button" class="btn ms-2" id="statusBtn">
                                                    <i class="fa-solid fa-pen-to-square"></i>
                                                </button>
    
                                                <select name="status" class="form-select close mt-2">
                                                    <option <c:if test="${order.status eq 'pending'}"> selected</c:if>>pending</option>
                                                    <option <c:if test="${order.status eq 'completed'}"> selected</c:if>>completed</option>
                                                    <option <c:if test="${order.status eq 'shipped'}"> selected</c:if>>shipped</option>
                                                    <option>refunded</option>
                                                    <option>cancelled</option>
                                                </select>
                                                <script type="text/javascript">
                                                    var editBtn = document.getElementById("statusBtn");
                                                    var saveBtn = document.querySelector(".saveBtn");
                                                    var editArea = document.querySelector(".form-select");
                
                                                    editBtn.addEventListener("click", function() {
                                                        saveBtn.classList.toggle("close");
                                                        editArea.classList.toggle("close");
                                                    });
                                                </script>
                                            </div>
                                        </form>
                                    </div>

                                    <div class="row mb-5 g-3">
                                        <div class="col-md-4 col-sm-6">
                                            <p class="fw-bold">Order Created at</p>
                                            ${order.orderDate}
                                        </div>
                                        <div class="col-md-4 col-sm-6">
                                            <p class="fw-bold">Required Date</p>
                                            ${order.requireDate}
                                        </div>
                                        <div class="col-md-4 col-sm-6">
                                            <p class="fw-bold">Shipped Date</p>
                                            ${order.shippedDate}
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
                                    <h5 class="mb-0">Price</h5>
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
                                        <a href="#"><i class="fa-solid fa-pen-to-square"></i></a>
                                    </div>
                                    <div>
                                        <i class="fa-solid fa-user me-2"></i>${cus.us.firstname} ${cus.us.middlename} ${cus.us.lastname}
                                    </div>
                                    <div><i class="fa-solid fa-location-dot me-2"></i>${ward.name}, ${district.name}, ${province.name}</div>
                                    <div class="ms-4">${cus.uad.addressDetail}</div>
                                    <div>
                                        <i class="fa-solid fa-phone me-2"></i>${cus.us.phone}
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