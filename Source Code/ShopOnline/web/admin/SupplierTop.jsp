
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Admin || Shop Online</title>
        <!-- Site Icons -->
        <link rel="shortcut icon" href="../images/favicon.ico" type="image/x-icon">
        <link rel="stylesheet" href="../css/style.css">
        <link rel="stylesheet" href="../css/Dashboard.css">
        <link rel="stylesheet" href="../css/ProfileAd.css">
        <script src="https://kit.fontawesome.com/a4edd5786f.js" crossorigin="anonymous"></script>

        <!-- Bootstrap 5 -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    </head>
    <c:set var="SuppliersActive" value="active"/>
    <%@include file="Topbar.jsp" %>
    <body>
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
                                <i class="fa-solid fa-sliders fa-xl"></i>
                            </span>
                            <span class="text nav-text">Manage Slider</span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
        <div>
            <div class="col-lg-3">

            </div>
            <div class="col-lg-9">
                <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
                <body>

                    <canvas id="myChart" style="width:100%;max-width:800px;margin-left: 500px"></canvas>

                    <script>
                        var xValues = ["Nike", "Addidas AG", "Puma", "Converse", "Vans"];
                        var yValues = [3, 2, 2, 1, 1,0];
                        var barColors = ["red", "green", "blue", "orange", "brown"];

                        new Chart("myChart", {
                            type: "bar",
                            data: {
                                labels: xValues,
                                datasets: [{
                                        backgroundColor: barColors,
                                        data: yValues
                                    }]
                            },
                            options: {
                                legend: {display: false},
                                title: {
                                    display: true,
                                    text: "Top 5 Suppliers 2022"
                                }
                            }
                        });
                    </script>

            </div>
        </div>





    </body>
</html>

