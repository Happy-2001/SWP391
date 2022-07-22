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
        <link rel="stylesheet" href="../css/profile.css">
        <script src="https://kit.fontawesome.com/a4edd5786f.js" crossorigin="anonymous"></script>

        <!-- Bootstrap 5 -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    </head>
    <body>
        <c:set var="SuppliersActive" value="active"/>
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
                            <li class="breadcrumb-item active" aria-current="page">User List</li>
                        </ul>
                    </div>
                    <a href="SupplierListController" class="btn btn-success " >Top 5 Suppliers</a>
                <a href="AddSupplier?action=add" class="btn btn-success my-5">Add Suppliers</a>
                    <div class="container-fluid">
                        <div class="table-responsive cus-box">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>
                                            <input class="select-all" type="checkbox" value="deselect">
                                        </th>
                                        <th>ID</th>
                                        <th>Company Name</th>
                                        <th>Contact Name</th>
                                        <th>Contact Title</th>
                                        <th>Gender</th>
                                        
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${suplist}" var="sup">
                                        <tr class="customers">
                                            <td>
                                                <input class="form-check-input" type="checkbox" value="${sup.id}">
                                            </td>
                                            <td>
                                                <a href="#">#${sup.id}</a>
                                            </td>
                                            <td>${sup.name}</td>
                                            <td>${sup.contactName}</td>
                                            <td>${sup.contactTitle}</td>
                                            <td><h7> <c:if test="${sup.gender == 1}">Male</c:if>
                                                     <c:if test="${sup.gender == 0}">Female</c:if>
                                            </h7></td>
                                    </tr>
                                </c:forEach>
                                    
                                <!-- Edit Profile -->

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

                    <script>
                        var checkArea = document.getElementById('check-err');
                        var passIn = document.getElementById('password');
                        var passCf = document.getElementById('password_confirmation');

                        passCf.onkeyup = () => {
                            var inP = passCf.value;

                            if (inP !== passIn.value) {
                                checkArea.innerHTML = '<i class="fa-solid fa-circle-xmark"></i>';
                                return false;
                            }

                            checkArea.innerHTML = '<i style="color: #2e8b57;" class="fa-solid fa-circle-check"></i>';
                            return true;
                        };



                    </script>

                    <script src="../js/list-selectSup.js"></script>
                </div>
            </div>
        </div>
    </body>
</html>