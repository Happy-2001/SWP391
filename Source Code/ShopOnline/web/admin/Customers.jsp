<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin || Shop Online</title>
    <!-- Site Icons -->
    <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/Dashboard.css">
    <link rel="stylesheet" href="../css/Customers.css">
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
                            <a href="Dashboard.jsp">
                                <span class="nav-link-icon">
                                    <i class="fa-solid fa-chart-simple fa-xl"></i>
                                </span>
                                <span class="text nav-text">Dashboard</span>
                            </a>
                        </li>
        
                        <li class="nav-link">
                            <a href="#">
                                <span class="nav-link-icon">
                                    <i class="fa-solid fa-receipt fa-xl"></i>
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
                            <a class="active" href="#">
                                <span class="nav-link-icon">
                                    <i class="fa-solid fa-user-group"></i>
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
                            <a href="#">
                                <span class="nav-link-icon">
                                    <i class="fa-solid fa-bell fa-xl"></i>
                                </span>
                                <span class="text nav-text">Notifications</span>
                            </a>
                        </li>
        
                        <li class="nav-link">
                            <a href="#sub-list3">
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
                            <a href="Dashboard.jsp">Dashboard</a>
                        </li>
                        <li class="breadcrumb-item active" aria-current="page">Customers</li>
                    </ul>
                </div>
                <div class="container-fluid">
                    <div class="table-responsive cus-box">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>
                                    <input class="select-all" type="checkbox" value="deselect">
                                </th>
                                <th>ID</th>
                                <th>Photo</th>
                                <th>Fullname</th>
                                <th>Email</th>
                                <th>Country</th>
                                <th>Date</th>
                                <th>Status</th>
                                <th class="text-center">Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr class="customers">
                                <td>
                                    <input class="form-check-input" type="checkbox" value="1">
                                </td>
                                <td>
                                    <a href="#">#1</a>
                                </td>
                                <td>
                                    <div class="avatar avatar-info">
                                        <span class="avatar-text rounded-circle">A</span>
                                    </div>
                                </td>
                                <td>Arlan Pond</td>
                                <td>apond0@nytimes.com</td>
                                <td>Brazil</td>
                                <td>1/11/2021</td>
                                <td>
                                    <span class="badge bg-success">Active</span>
                                </td>
                                <td class="text-end">
                                    <div class="d-flex justify-content-between px-3">
                                        <a href="#"><i class="fa-solid fa-pen-to-square"></i></a>
                                        <a href="#link"><i class="fa-solid fa-trash-can"></i></a>
                                    </div>
                                </td>
                            </tr>
                            <tr class="customers">
                                <td>
                                    <input class="form-check-input" type="checkbox">
                                </td>
                                <td>
                                    <a href="#">#2</a>
                                </td>
                                <td>
                                    <div class="avatar avatar-secondary">
                                        <span class="avatar-text rounded-circle">B</span>
                                    </div>
                                </td>
                                <td>Billi Cicero</td>
                                <td>bcicero1@wiley.com</td>
                                <td>Indonesia</td>
                                <td>11/20/2020</td>
                                <td>
                                    <span class="badge bg-danger">Passive</span>
                                </td>
                                <td class="text-end">
                                    <div class="d-flex">
                                        <div class="dropdown ms-auto">
                                            <a href="#" data-bs-toggle="dropdown" class="btn btn-floating" aria-haspopup="true" aria-expanded="false">
                                                <i class="bi bi-three-dots"></i>
                                            </a>
                                            <div class="dropdown-menu dropdown-menu-end">
                                                <a href="#" class="dropdown-item">Show</a>
                                                <a href="#" class="dropdown-item">Edit</a>
                                                <a href="#" class="dropdown-item">Delete</a>
                                            </div>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr class="customers">
                                <td>
                                    <input class="form-check-input" type="checkbox">
                                </td>
                                <td>
                                    <a href="#">#3</a>
                                </td>
                                <td>
                                    <div class="avatar avatar-warning">
                                        <span class="avatar-text rounded-circle">T</span>
                                    </div>
                                </td>
                                <td>Thorpe Hawksley</td>
                                <td>thawksley2@senate.gov</td>
                                <td>France</td>
                                <td>10/20/2020</td>
                                <td>
                                    <span class="badge bg-success">Active</span>
                                </td>
                                <td class="text-end">
                                    <div class="d-flex">
                                        <div class="dropdown ms-auto">
                                            <a href="#" data-bs-toggle="dropdown" class="btn btn-floating" aria-haspopup="true" aria-expanded="false">
                                                <i class="bi bi-three-dots"></i>
                                            </a>
                                            <div class="dropdown-menu dropdown-menu-end">
                                                <a href="#" class="dropdown-item">Show</a>
                                                <a href="#" class="dropdown-item">Edit</a>
                                                <a href="#" class="dropdown-item">Delete</a>
                                            </div>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr class="customers">
                                <td>
                                    <input class="form-check-input" type="checkbox">
                                </td>
                                <td>
                                    <a href="#">#4</a>
                                </td>
                                <td>
                                    <div class="avatar avatar-danger">
                                        <span class="avatar-text rounded-circle">H</span>
                                    </div>
                                </td>
                                <td>Horacio Versey</td>
                                <td>hversey3@illinois.edu</td>
                                <td>China</td>
                                <td>1/15/2021</td>
                                <td>
                                    <span class="badge bg-success">Active</span>
                                </td>
                                <td class="text-end">
                                    <div class="d-flex">
                                        <div class="dropdown ms-auto">
                                            <a href="#" data-bs-toggle="dropdown" class="btn btn-floating" aria-haspopup="true" aria-expanded="false">
                                                <i class="bi bi-three-dots"></i>
                                            </a>
                                            <div class="dropdown-menu dropdown-menu-end">
                                                <a href="#" class="dropdown-item">Show</a>
                                                <a href="#" class="dropdown-item">Edit</a>
                                                <a href="#" class="dropdown-item">Delete</a>
                                            </div>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr class="customers">
                                <td>
                                    <input class="form-check-input" type="checkbox">
                                </td>
                                <td>
                                    <a href="#">#5</a>
                                </td>
                                <td>
                                    <div class="avatar avatar-success">
                                        <span class="avatar-text rounded-circle">R</span>
                                    </div>
                                </td>
                                <td>Raphael Dampney</td>
                                <td>rdampney4@reference.com</td>
                                <td>Portugal</td>
                                <td>8/17/2020</td>
                                <td>
                                    <span class="badge bg-success">Active</span>
                                </td>
                                <td class="text-end">
                                    <div class="d-flex">
                                        <div class="dropdown ms-auto">
                                            <a href="#" data-bs-toggle="dropdown" class="btn btn-floating" aria-haspopup="true" aria-expanded="false">
                                                <i class="bi bi-three-dots"></i>
                                            </a>
                                            <div class="dropdown-menu dropdown-menu-end">
                                                <a href="#" class="dropdown-item">Show</a>
                                                <a href="#" class="dropdown-item">Edit</a>
                                                <a href="#" class="dropdown-item">Delete</a>
                                            </div>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr class="customers">
                                <td>
                                    <input class="form-check-input" type="checkbox">
                                </td>
                                <td>
                                    <a href="#">#6</a>
                                </td>
                                <td>
                                    <div class="avatar avatar-info">
                                        <span class="avatar-text rounded-circle">A</span>
                                    </div>
                                </td>
                                <td>Arlan Pond</td>
                                <td>apond0@nytimes.com</td>
                                <td>Brazil</td>
                                <td>1/11/2021</td>
                                <td>
                                    <span class="badge bg-success">Active</span>
                                </td>
                                <td class="text-end">
                                    <div class="d-flex">
                                        <div class="dropdown ms-auto">
                                            <a href="#" data-bs-toggle="dropdown" class="btn btn-floating" aria-haspopup="true" aria-expanded="false">
                                                <i class="bi bi-three-dots"></i>
                                            </a>
                                            <div class="dropdown-menu dropdown-menu-end">
                                                <a href="#" class="dropdown-item">Show</a>
                                                <a href="#" class="dropdown-item">Edit</a>
                                                <a href="#" class="dropdown-item">Delete</a>
                                            </div>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr class="customers">
                                <td>
                                    <input class="form-check-input" type="checkbox">
                                </td>
                                <td>
                                    <a href="#">#7</a>
                                </td>
                                <td>
                                    <div class="avatar avatar-secondary">
                                        <span class="avatar-text rounded-circle">B</span>
                                    </div>
                                </td>
                                <td>Billi Cicero</td>
                                <td>bcicero1@wiley.com</td>
                                <td>Indonesia</td>
                                <td>11/20/2020</td>
                                <td>
                                    <span class="badge bg-danger">Passive</span>
                                </td>
                                <td class="text-end">
                                    <div class="d-flex">
                                        <div class="dropdown ms-auto">
                                            <a href="#" data-bs-toggle="dropdown" class="btn btn-floating" aria-haspopup="true" aria-expanded="false">
                                                <i class="bi bi-three-dots"></i>
                                            </a>
                                            <div class="dropdown-menu dropdown-menu-end">
                                                <a href="#" class="dropdown-item">Show</a>
                                                <a href="#" class="dropdown-item">Edit</a>
                                                <a href="#" class="dropdown-item">Delete</a>
                                            </div>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr class="customers">
                                <td>
                                    <input class="form-check-input" type="checkbox">
                                </td>
                                <td>
                                    <a href="#">#8</a>
                                </td>
                                <td>
                                    <div class="avatar avatar-warning">
                                        <span class="avatar-text rounded-circle">T</span>
                                    </div>
                                </td>
                                <td>Thorpe Hawksley</td>
                                <td>thawksley2@senate.gov</td>
                                <td>France</td>
                                <td>10/20/2020</td>
                                <td>
                                    <span class="badge bg-success">Active</span>
                                </td>
                                <td class="text-end">
                                    <div class="d-flex">
                                        <div class="dropdown ms-auto">
                                            <a href="#" data-bs-toggle="dropdown" class="btn btn-floating" aria-haspopup="true" aria-expanded="false">
                                                <i class="bi bi-three-dots"></i>
                                            </a>
                                            <div class="dropdown-menu dropdown-menu-end">
                                                <a href="#" class="dropdown-item">Show</a>
                                                <a href="#" class="dropdown-item">Edit</a>
                                                <a href="#" class="dropdown-item">Delete</a>
                                            </div>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr class="customers">
                                <td>
                                    <input class="form-check-input" type="checkbox">
                                </td>
                                <td>
                                    <a href="#">#9</a>
                                </td>
                                <td>
                                    <div class="avatar avatar-danger">
                                        <span class="avatar-text rounded-circle">H</span>
                                    </div>
                                </td>
                                <td>Horacio Versey</td>
                                <td>hversey3@illinois.edu</td>
                                <td>China</td>
                                <td>1/15/2021</td>
                                <td>
                                    <span class="badge bg-success">Active</span>
                                </td>
                                <td class="text-end">
                                    <div class="d-flex">
                                        <div class="dropdown ms-auto">
                                            <a href="#" data-bs-toggle="dropdown" class="btn btn-floating" aria-haspopup="true" aria-expanded="false">
                                                <i class="bi bi-three-dots"></i>
                                            </a>
                                            <div class="dropdown-menu dropdown-menu-end">
                                                <a href="#" class="dropdown-item">Show</a>
                                                <a href="#" class="dropdown-item">Edit</a>
                                                <a href="#" class="dropdown-item">Delete</a>
                                            </div>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr class="customers">
                                <td>
                                    <input class="form-check-input" type="checkbox">
                                </td>
                                <td>
                                    <a href="#">#10</a>
                                </td>
                                <td>
                                    <div class="avatar avatar-success">
                                        <span class="avatar-text rounded-circle">R</span>
                                    </div>
                                </td>
                                <td>Raphael Dampney</td>
                                <td>rdampney4@reference.com</td>
                                <td>Portugal</td>
                                <td>8/17/2020</td>
                                <td>
                                    <span class="badge bg-success">Active</span>
                                </td>
                                <td class="text-end">
                                    <div class="d-flex">
                                        <div class="dropdown ms-auto">
                                            <a href="#" data-bs-toggle="dropdown" class="btn btn-floating" aria-haspopup="true" aria-expanded="false">
                                                <i class="bi bi-three-dots"></i>
                                            </a>
                                            <div class="dropdown-menu dropdown-menu-end">
                                                <a href="#" class="dropdown-item">Show</a>
                                                <a href="#" class="dropdown-item">Edit</a>
                                                <a href="#" class="dropdown-item">Delete</a>
                                            </div>
                                        </div>
                                    </div>
                                </td>
                            </tr>
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
                <script src="/js/select.js"></script>
            </div>
        </div>
    </div>
</body>
</html>