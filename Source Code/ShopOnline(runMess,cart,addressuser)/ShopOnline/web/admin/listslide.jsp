<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <link rel="stylesheet" href="../css/slider.css">
    <script src="https://kit.fontawesome.com/a4edd5786f.js" crossorigin="anonymous"></script>
    
    <!-- Bootstrap 5 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</head>

    <body>

        <%@include file="Topbar.jsp" %>
        <c:set var="ManageSliderActive" value="active"/>
        <div class="container-fluid">
            <div class="row">
                <%@include file="menuDashBoard.jsp" %>
                <div class="col-lg-9 main">
                    <div class="container">
                        <a href="/ShopOnline/addslide" class="btn btn-success my-3">Add new</a>

                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th scope="col">ID</th>
                                    <th scope="col">Heading</th>
                                    <th scope="col">Button</th>
                                    <th scope="col">Description</th>
                                    <th scope="col">Status</th>
                                    <th scope="col">Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${slides}" var="s">
                                    <tr>
                                        <td>${s.id}</td>
                                        <td>${s.heading}</td>
                                        <td>${s.namebutton}</td>
                                        <td>${s.description}</td>
                                        <c:if test="${s.status == 1}">
                                            <td>
                                                Active
                                            </td>
                                        </c:if>
                                        <c:if test="${s.status == 0}">
                                            <td>
                                                Nonactive
                                            </td>
                                        </c:if>
                                        <td>
                                            <div class="dropdown ms-3">
                                                <a href="#" class="btn btn-floating btn-sm" data-bs-toggle="dropdown">
                                                    <i class="fa-solid fa-ellipsis"></i>
                                                </a>
                                                <div class="dropdown-menu dropdown-menu-end" style="margin: 0px;">
                                                    <a class="dropdown-item" href="SliderDetail?id=${s.id}">Edit</a>
                                                    <a class="dropdown-item" href="#">Hide</a>
                                                    <a class="dropdown-item" href="#">Show</a>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>



    </body>
</html>
