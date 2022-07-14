<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <!-- Mobile Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Site Metas -->
        <title>Shop Online</title>
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- Site Icons -->
        <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
        <link rel="apple-touch-icon" href="images/apple-touch-icon.png">

        <!-- Bootstrap CSS -->

        <!-- Site CSS -->
        <link rel="stylesheet" href="css/style.css">
        <!-- Responsive CSS -->
        <link rel="stylesheet" href="css/responsive.css">
        <!-- Custom CSS -->
        <link rel="stylesheet" href="css/custom.css">
        <link rel="stylesheet" href="css/Dashboard.css">
        <script src="https://kit.fontawesome.com/a4edd5786f.js" crossorigin="anonymous"></script>

        <!-- Bootstrap 5 -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>


    </head>
    <body>
        <c:set var="ProductsActive" value="active"/>
        <%@include file="Topbar.jsp" %>
        <div class="container-fluid">
            <div class="row">
                <%@include file="menuDashBoard.jsp" %>
                <div class="col-lg-9 main">
                    <div aria-label="breadcrumb" class="mb-3">
                    <ul class="breadcrumb">
                        <li class="breadcrumb-item">
                            <i class="fa-solid fa-globe fa-sm"></i>
                            <a href="/ShopOnline/listproduct">Product</a>
                        </li>
                        <li class="breadcrumb-item active" aria-current="page">Edits product</li>
                    </ul>
                </div>
                    <form class="container py-5" action="listproduct" method="POST" id="fileUploadForm">
                        <input type="hidden" name="actionpage" value="edit">
                        <input type="hidden" name="id" value="${product.id}">
                        <div class="mb-3">
                            <label for="name" class="form-label">Name</label>
                            <input type="text" class="form-control" id="name" name="productName" value="${product.name}" required>
                        </div>
                        <div class="mb-3">
                            <label for="category" class="form-label">Category</label>
                            <select class="form-select form-control" id="category" name="categoryId">
                                <option selected>Select Category</option>
                                <c:forEach items="${categories}" var="c">
                                    <c:if test="${product.categoryid eq c.id}">
                                        <option value="${c.id}" selected>${c.name}</option>
                                    </c:if>
                                    <c:if test="${product.categoryid ne c.id}">
                                        <option value="${c.id}">${c.name}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label for="supplier" class="form-label">Supplier</label>
                            <select class="form-select form-control" id="category" name="categoryId">
                                <option selected>Select Supplier</option>
                                <c:forEach items="${suppliers}" var="c">
                                    <c:if test="${product.supplierID eq c.id}">
                                        <option value="${c.id}" selected>${c.contactName}</option>
                                    </c:if>
                                    <c:if test="${product.supplierID ne c.id}">
                                        <option value="${c.id}">${c.contactName}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label for="price" class="form-label">Price</label>
                            <input type="number" class="form-control" id="price" name="productPrice" value="${product.price}" required>
                        </div>
                        <div class="mb-3">
                            <label for="price" class="form-label">Sale Price</label>
                            <input type="number" class="form-control" id="price" name="productPrice" value="${product.salePrice}" required>
                        </div>
                        <div class="mb-3">
                            <label for="stock" class="form-label">Stock</label>
                            <input type="number" class="form-control" id="stock" name="productStock" value="${product.stock}" required>
                        </div>
                        <div class="mb-3">
                            <label for="brief_information" class="form-label">Brief Information</label>
                            <textarea name="brief_information" id="brief_information" class="form-control"  rows="10">${product.brief_information}</textarea>
                        </div>
                        <div class="mb-3">
                            <label for="description" class="form-label">Description</label>
                            <textarea name="description" id="description" class="form-control"  rows="10">${product.description}</textarea>
                        </div>

                        <div class="mb-3">
                            <label for="sortdescription" class="form-label">Sort description</label>
                            <textarea name="sortdescription" id="sortdescription" class="form-control"  rows="6">${product.sortdesc}</textarea>
                        </div>
                        <div class="mb-3">
                            <label for="view" class="form-label">Views</label>
                            <input type="number" class="form-control" id="view" name="view" value="${product.view}" required>
                        </div>
                        <div class="mb-3">
                            <label for="like" class="form-label">Likes</label>
                            <input type="number" class="form-control" id="like" name="like" value="${product.like}" required>
                        </div>
                        <input type="hidden" name="image" id="imagefile" value="">
                        <img style="width: 30%" id="imagedisplay" src="${product.img}"/>
                        <div id="inputfile" class="form-group mb-3">
                            <div class="form-group">
                                <label for="file" class="form-label">Image url</label>
                                <input class="form-control" type="file" name="file" id="file" />
                            </div>
                        </div>

                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>
        </div>




        <script>
            $(document).ready(function () {
                $("input[name='file']").change(function () {
                    //stop submit the form, we will post it manually.
                    //event.preventDefault();
                    // Get form
                    var form = $('#fileUploadForm')[0];
                    // Create an FormData object 
                    var data = new FormData(form);
                    // disabled the submit button
                    $.ajax({
                        type: "POST",
                        enctype: 'multipart/form-data',
                        url: "UploadServlet",
                        data: data,
                        processData: false,
                        contentType: false,
                        cache: false,
                        timeout: 600000,
                        success: function (data) {
                            $("#imagecover").text(data);
                            console.log("SUCCESS : ", data);
                            document.getElementById('imagefile').value = data;
                            $("#inputfile").css("display", "none");
                            $("#imagedisplay").attr("src", "upload/" + data);
                            $("#imagedisplay").css("display", "block");
                            //document.getElementById('imagefile').value = data;                            
                        },
                        error: function (e) {
                            $("#imagecover").text(e.responseText);
                            console.log("ERROR : ", e);
                        }
                    });
                });
            });
        </script>
    </body>
</html>
