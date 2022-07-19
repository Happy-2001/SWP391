<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                            <a class="active" href="#">
                                <span class="nav-link-icon">
                                    <i class="fa-solid fa-chart-simple"></i>
                                </span>
                                <span class="text nav-text">Dashboard</span>
                            </a>
                        </li>
        
                        <li class="nav-link">
                            <a href="MyOrderController">
                                <span class="nav-link-icon">
                                    <i class="fa-solid fa-receipt fa-xl"></i>
                                </span>
                                <span class="text nav-text">Orders</span>
                            </a>
                        </li>

                        <li class="nav-link">
                            <a href="/ShopOnline/listproduct">
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
                            <a href="/ShopOnline/message">
                                <span class="nav-link-icon">
                                <i class="fa-solid fa-envelope fa-xl"></i>
                                </span>
                                <span class="text nav-text">Chats</span>
                                <span class="badge bg-success rounded-circle ms-auto">1</span>
                            </a>
                        </li>
        
                        <li class="nav-link">
                            <a href="FeedbackAd?act=view">
                                <span class="nav-link-icon">
                                    <i class="fa-solid fa-comment-dots fa-xl"></i>
                                </span>
                                <span class="text nav-text">Feedback</span>
                            </a>
                        </li>
        
                        <li class="nav-link">
                            <a href="admin/userList.jsp">
                                <span class="nav-link-icon">
                                    <i class="fa-solid fa-circle-user fa-xl"></i>
                                </span>
                                <span class="text nav-text">Accounts</span>
                            </a>
                        </li>
                        
                        <li class="nav-link">
                            <a href="SuppliersController">
                                <span class="nav-link-icon">
                                    <i class="fa-solid fa-truck-arrow-right fa-xl"></i>
                                </span>
                                <span class="text nav-text">Suppliers</span>
                            </a>
                        </li>
                        <li class="nav-link">
                            <a href="slider">
                                <span class="nav-link-icon">
                                <i class="fa-solid fa-images fa-xl"></i>
                                </span>
                                <span class="text nav-text">Manage Slider</span>
                               
                            </a>
                        </li>
                        <li class="nav-link">
                            <a href="/ShopOnline/PostMan">
                                <span class="nav-link-icon">
                                <i class="fa-solid fa-sliders fa-xl"></i>
                                </span>
                                <span class="text nav-text">Blog Manager</span>
                            </a>
                        </li>
                        <li class="nav-link">
                            <a href="MyOrderController">
                                <span class="nav-link-icon">
                                    <i class="fa-solid fa-receipt fa-xl"></i>
                                </span>
                                <span class="text nav-text">Add Address</span>
                            </a>
                        </li>
                        <li class="nav-link">
                            <a href="/ShopOnline/PostController">
                                <span class="nav-link-icon">
                                    <i class="fa-solid fa-receipt fa-xl"></i>
                                </span>
                                <span class="text nav-text">Post Manager</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-9 main">
                <div class="row row-cols-1 row-cols-md-3 g-4">
                    <div class="col-lg-4 col-md-12">
                        <div class="card h-100">
                            <div class="card-body">
                                <div class="d-flex mb-4">
                                    <h6 class="card-title mb-0">Customer Rating</h6>
                                    <div class="dropdown ms-auto">
                                        <a href="#" data-bs-toggle="dropdown" class="btn btn-sm">
                                            <i class="fa-solid fa-ellipsis"></i>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-end">
                                            <a href="#" class="dropdown-item">View Detail</a>
                                            <a href="#" class="dropdown-item">Download</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="text-center">
                                    <div class="display-6">
                                        <strong>${average}</strong>
                                    </div>
                                    <div class="d-flex justify-content-center align-items-center gap-3 my-3">
                                        <c:forEach begin="1" end="${average}">
                                            <i class="fa-solid fa-star" style="color: #faae42;"></i>
                                        </c:forEach>
                                        <c:forEach begin="1" end="${5 - average}">
                                            <i class="fa-regular fa-star"></i>
                                        </c:forEach>
                                        <span>(${starTotal})</span>
                                    </div>
                                </div>
                                <div class="text-center">
                                    <button class="btn btn-outline-primary btn-icon">
                                        <i class="fa-solid fa-download"></i> Download Report
                                    </button>
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
