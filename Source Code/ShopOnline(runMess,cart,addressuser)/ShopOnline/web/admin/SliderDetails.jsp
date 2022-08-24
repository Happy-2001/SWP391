<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="../css/slider.css">
    <script src="https://kit.fontawesome.com/a4edd5786f.js" crossorigin="anonymous"></script>
    
    <!-- Bootstrap 5 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</head>
 <body>
    <c:set var="ManageSliderActive" value="active"/>
    <%@include file="Topbar.jsp" %>
    
    <div class="container-fluid">
        <div class="row">
            <%@include file="menuDashBoard.jsp" %>
            <div class="col-lg-9 main">
                <div aria-label="breadcrumb" class="mb-3">
                    <ul class="breadcrumb">
                        <li class="breadcrumb-item">
                            <i class="fa-solid fa-globe fa-sm"></i>
                            <a href="slider">Manage Slider</a>
                        </li>
                        <li class="breadcrumb-item active" aria-current="page">Edits slide</li>
                    </ul>
                </div>
                <div class="container-fluid edit-form">
                    <div class="card my-3">
                        <div class="card-header">
                            <h5>Image</h5>
                            <span class="edit" data-bs-toggle="collapse" data-bs-target="#e-ava">
                                <i class="fa-regular fa-pen-to-square me-2"></i>
                            </span>
                        </div>
                        <div class="card-body">
                            <div class="view-img">
                                <img id="imgDefault" src="../RetrieveImg?id=${id}&eaID=" onError="this.onerror=null;this.src='../images/carousel-1.svg';">
                            </div>
                            <form action="SliderImgController" method="POST" enctype="multipart/form-data">
                                <div class="file-upload collapse" id="e-ava">
                                    <div class="edit-img">
                                        <div class="submit-file-box">
                                            <input type="file" class="cus-file-input" name="photo" id="submit-file">
                                            <p class="text-center mb-0"><label class="trigger" for="submit-file">Click here</label> to upload file</p>
                                        </div>
                                        <div class="file-upload-content">
                                            <img class="file-upload-image" src="../RetrieveImg?id=${id}&eaID=" alt="your image" />
                                            <div class="del-btn">
                                                <input type="hidden" value="${id}" name="id">
                                                <button type="submit" onclick="removeUpload()" class="btn">Save</button>
                                                <button type="button" onclick="removeUpload()" class="btn">Remove</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <script src="../js/slider.js"></script>
                            </form>
                        </div>
                    </div>
                    <form action="SliderDetail" method="POST">
                        <div class="card my-3">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="mb-3">
                                            <label for="name" class="form-label">Name Button</label>
                                            <input type="text" class="form-control" id="name" name="button" value="${s.namebutton}" required>
                                        </div>
                                        <div class="mb-3">
                                            <label for="heading" class="form-label">Heading</label>
                                            <input type="text" class="form-control" id="heading" name="heading" value="${s.heading}" required>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="mb-3">
                                            <label for="url" class="form-label">URL</label>
                                            <input type="text" class="form-control" id="name" name="url" value="${s.url}" required>
                                        </div>
                                        <div class="mb-3">
                                            <label for="url" class="form-label">Status</label>
                                            <div class="form-check">
                                                <input class="form-check-input" type="radio" name="status" value="1" id="flexRadioDefault1" ${s.status == 1 ? 'checked' : '' }>
                                                <label class="form-check-label" for="flexRadioDefault1">
                                                    Active
                                                </label>
                                            </div>
                                            <div class="form-check">
                                                <input class="form-check-input" type="radio" name="status" value="0" id="flexRadioDefault2" ${s.status == 0 ? 'checked' : '' }>
                                                <label class="form-check-label" for="flexRadioDefault2">
                                                    Nonactive
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="mb-3">
                                        <label for="description" class="form-label">Description</label>
                                        <input type="text" class="form-control" id="description" name="description" value="${s.description}" required>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="del-btn">
                            <input type="hidden" value="${id}" name="id">
                            <input type="submit" class="btn" value="Submit" />
                        </div>              
                    </form>
                </div>
            </div>
        </div>
    </div>
 </body>
</html>
