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
                                <th>Date</th>
                                <th>Gender</th>
                                <th>Creator</th>
                                <th>Creator</th>
                                <th>Creator</th>
                                <th class="text-end">Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                               <c:forEach items="${suplist}" var="sup">
                                    <tr class="customers">
                                        <td>
                                            <input class="form-check-input" type="checkbox" value="${sup.id}">
                                        </td>
                                        <td>${sup.id}</td>
                                        <td>${sup.name}</td>
                                        <td>${sup.contactName}</td>
                                        <td>${sup.contactTitle}</td>
                                        <td>${sup.dob}</td>
                                        <td>${sup.gender}</td>
                                        <td>${sup.creator}</td>
                                        <td>${sup.createOn}</td>
                                        <td>${sup.updateOn}</td>
                                        <td class="text-end">
                                            <div class="px-3">
                                                <a href="#link"><i class="fa-solid fa-trash-can"></i></a>
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
                <script src="../js/list-selectSup.js"></script>
            </div>
        </div>
    </div>
</body>
</html>
