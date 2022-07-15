<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                        <li class="breadcrumb-item" aria-current="page">
                            <a href="SuppliersController">Suppliers</a>
                        </li>
                        <li class="breadcrumb-item active" aria-current="page">Profile</li>
                    </ul>
                </div>
                <div class="content">
                    <div class="profile-cover bg-image mb-4" style="background: url(&quot;../images/profile-bg.jpg&quot;);">
                        <div class="avatar-profile">
                            <figure class="ava me-4 flex-shrink-0">
                                <img width="120" height="120" class="rounded-pill" src="../RetrieveImg?eaID=${supAdd.sup.id}" alt="...">
                                <span class="edit" data-bs-toggle="collapse" data-bs-target="#e-ava">
                                    <i class="fa-solid fa-pen-to-square"></i>
                                </span>
                            </figure>
                            <div class="flex-fill">
                                <h5>${supAdd.sup.name}</h5>
                            </div>
                            <div class="del-btn">
                                <a href="#" class="btn btn-icon" data-bs-toggle="tooltip" title="Remove Customers">
                                    <i class="fa-solid fa-trash-can"></i>
                                </a>
                            </div>
                        </div>
                        <form action="/ShopOnline/UploadImage" method="POST" enctype="multipart/form-data">
                            <div class="ava-popup collapse" id="e-ava">
                                <div class="edit-img">
                                    <span style="color: #fff;">For best results, use an image at least 256px by 256px in either .jpg or .png format</span>
                                    <div class="submit-file-box">
                                        <input type="hidden" name="cusID" value="${supAdd.sup.id}">
                                        <input type="file" class="cus-file-input" name="photo" id="submit-file">
                                        <p class="text-center mb-0"><label class="trigger" for="submit-file">Click here</label> to upload file</p>
                                    </div>
                                    <div class="attachment-box">
                                        <div class="file-name-attachment text-lightbold">
                                            <div class="name">
                                                <span class="name-text"></span>
                                                <span class="label-checked"><i class="las la-check"></i></span>
                                            </div>
                                            <div class="del-btn">
                                                <a href="#" class="btn btn-icon">
                                                    <i class="fa-solid fa-trash-can attachment-btn"></i>
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="del-btn">
                                        <input class="btn btn-icon" type="submit" value="Save">
                                        <input class="btn btn-icon" value="Cancel" data-bs-toggle="collapse" data-bs-target="#e-ava">
                                    </div>
                                </div>
                                <script>
                                        document.querySelector("html").classList.add('js');

                                        var fileInput = document.getElementById("submit-file"),  
                                            button = document.querySelector(".trigger"),
                                            the_return = document.querySelector(".name-text"),
                                            popupDis = document.querySelector(".attachment-box"),
                                            deleBtn = document.querySelector(".attachment-btn");;
      
                                        button.addEventListener("keydown", function(event) {  
                                            if (event.keyCode == 13 || event.keyCode == 32 ) {  
                                                fileInput.focus();  
                                            }  
                                        });
                                        button.addEventListener("click", function( vent) {
                                            fileInput.focus();
                                            return false;
                                        });  
                                        fileInput.addEventListener("change", function(event) {
                                            popupDis.style.display = "block";
                                            the_return.innerHTML = this.value;  
                                        });
                                        deleBtn.onclick = function(){
                                            popupDis.style.display = "none";
                                        };
                                </script>
                            </div>
                        </form>
                    </div>
                    <script src="../js/tooltip.js"></script>
                    <div class="row">
                        <div class="col-md-7">
                            <div class="tab-content" id="myTabContent">
                                <div class="tab-pane fade active show" id="profile">
                                    <div class="mb-4">
                                        <form action="" method="">
                                            <div class="card mb-4">
                                                <div class="card-body">
                                                    <div class="card-title mb-4">
                                                        <h6>Basic Information</h6>
                                                        <span class="d-flex">
                                                            <button type="submit" class="btn save-btn close">
                                                                <i class="fa-regular fa-floppy-disk"></i> Save
                                                            </button>
                                                            <button type="button" class="btn ms-2" id="infoBtn">
                                                                <i class="fa-solid fa-pen-to-square"></i>
                                                            </button>
                                                        </span>
                                                    </div>
                                                    <div class="row">
                                                    <div class="col-md-6">
                                                        <div class="mb-3">
                                                            <label class="form-label">Company Name</label>
                                                            <input type="text" class="form-control" value="${supAdd.sup.name}">
                                                        </div>
                                                        <div class="mb-3">
                                                            <label class="form-label">Contact Name</label>
                                                            <input type="text" class="form-control" value="${supAdd.sup.contactName}">
                                                        </div>
                                                        <div class="mb-3">
                                                            <label class="form-label">Contact Title</label>
                                                            <input type="text" class="form-control" value="${supAdd.sup.contactTitle}">
                                                        </div>
                                                        <div class="mb-3">
                                                            <label class="form-label">Gender</label>
                                                            <div>
                                                                <div class="form-check form-check-inline">
                                                                    <input type="radio" id="inlineRadio1" name="inlineRadio" class="form-check-input">
                                                                    <label class="form-check-label" for="inlineRadio1">Male</label>
                                                                </div>
                                                                <div class="form-check form-check-inline">
                                                                    <input type="radio" id="inlineRadio2" name="inlineRadio" class="form-check-input">
                                                                    <label class="form-check-label" for="inlineRadio2">Female</label>
                                                                </div>
                                                                <div class="form-check form-check-inline">
                                                                    <input type="radio" id="inlineRadio3" name="inlineRadio" class="form-check-input">
                                                                    <label class="form-check-label" for="inlineRadio3">Other</label>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="mb-3">
                                                            <label class="form-label">Creator</label>
                                                            <input type="text" class="form-control" value="${supAdd.sup.creator}">
                                                        </div>
                                                        <div class="mb-3">
                                                            <label class="form-label">Create On</label>
                                                            <input type="date" class="form-control" value="${supAdd.sup.createOn}" readonly>
                                                        </div>
                                                        <div class="mb-3">
                                                            <label class="form-label">Update On</label>
                                                            <input type="date" class="form-control" value="${supAdd.sup.updateOn}" readonly>
                                                        </div>
                                                        <div class="mb-3">
                                                            <label class="form-label">Date of Birth</label>
                                                            <input type="date" class="form-control" value="${supAdd.sup.dob}">
                                                        </div>
                                                    </div>
                                                </div>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="card mb-4">
                                        <form action="" method="">
                                            <div class="card-body">
                                                <div class="card-title mb-4">
                                                    <h6>Contact</h6>
                                                    <span class="d-flex">
                                                        <button type="submit" class="btn save-btn close">
                                                            <i class="fa-regular fa-floppy-disk"></i> Save
                                                        </button>
                                                        <button type="button" class="btn ms-2" id="infoBtn">
                                                            <i class="fa-solid fa-pen-to-square"></i>
                                                        </button>
                                                    </span>
                                                </div>
                                                <div class="row">
                                                <div class="col-md-6">
                                                    
                                                    
                                                    <div class="mb-3">
                                                        <label class="form-label">Province</label>
                                                        <div class="d-flex gap-3">
                                                            <select class="form-select">
                                                                <c:forEach items="${province}" var="prv">
                                                                    <c:if test="${prv.name eq supAdd.sup_add.proID.name}">
                                                                        <option value="${prv.id}" selected>${supAdd.sup_add.proID.name}</option>
                                                                    </c:if>
                                                                    <option value="${prv.id}">${prv.name}</option>
                                                                </c:forEach>
                                                            </select>
                                                        </div>
                                                    </div>
                                                   
                                                    <div class="mb-3">
                                                        <label class="form-label">District</label>
                                                        <div class="d-flex gap-3">
                                                            <select class="form-select">
                                                                <c:forEach items="${district}" var="dis">
                                                                    <c:if test="${dis.districtID eq supAdd.sup_add.disID.districtID}">
                                                                        <option value="${dis.districtID}" selected>${dis.name}</option>
                                                                    </c:if>
                                                                    <option value="${dis.districtID}">${dis.name}</option>
                                                                </c:forEach>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    
                                                    <div class="mb-3">
                                                        <label class="form-label">Ward</label>
                                                        <div class="d-flex gap-3">
                                                            <select class="form-select">
                                                                <c:forEach items="${ward}" var="ward">
                                                                    <c:if test="${ward.subDistrictID eq supAdd.sup_add.wardID.subDistrictID}">
                                                                        <option value="${ward.subDistrictID}" selected>${ward.prefix}  ${ward.name} </option>
                                                                    </c:if>
                                                                    <option value="${ward.subDistrictID}">${ward.prefix}  ${ward.name}</option>
                                                                </c:forEach>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    
                                                    
                                                    
                                                    <div class="mb-3">
                                                        <label class="form-label">Street</label>
                                                        <div class="d-flex gap-3">
                                                            <select class="form-select">
                                                                <c:forEach items="${street}" var="str">
                                                                    <c:if test="${str.id eq supAdd.sup_add.streetID.id}">
                                                                        <option value="${str.id}" selected>${str.prefix}  ${str.name} </option>
                                                                    </c:if>
                                                                    <option value="${str.id}">${str.prefix}  ${str.name}</option>
                                                                </c:forEach>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    
                                                    <div class="mb-3">
                                                        <label class="form-label">Project</label>
                                                        <div class="d-flex gap-3">
                                                            <select class="form-select">
                                                                <c:forEach items="${project}" var="pro">
                                                                    <c:if test="${pro.id eq supAdd.sup_add.projectID.id}">
                                                                        <option value="${pro.id}" selected>${pro.name}</option>
                                                                    </c:if>
                                                                    <option value="${pro.id}">${pro.name}</option>
                                                                </c:forEach>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="mb-3">
                                                            <label class="form-label">Phone</label>
                                                            <input type="text" class="form-control" value="${supAdd.sup_add.telephone}">
                                                        </div>
                                                    
                                                    <div class="mb-3">
                                                            <label class="form-label">Fax</label>
                                                            <input type="text" class="form-control" value="${supAdd.sup_add.fax}">
                                                        </div>
                                                        
                                                        <div class="mb-3">
                                                            <label class="form-label">Email</label>
                                                            <input type="text" class="form-control" value="${supAdd.sup_add.email}">
                                                        </div>
                                                </div>
                                                <div class="mb-3">
                                                    <label class="form-label">Address Detail</label>
                                                    <input type="text" class="form-control" value="${supAdd.sup_add.addDetail}">
                                                </div>
                                            </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                                <script type="text/javascript">
                                    var editBtn = document.querySelectorAll("#infoBtn");
                                    var save = document.querySelectorAll(".save-btn");

                                    for(let i = 0; i < editBtn.length; i++){
                                        editBtn[i].addEventListener("click", function() {
                                            save[i].classList.toggle("close");
                                        });
                                    }
                                </script>
                            </div>
                        </div>
                        <div class="col-md-5">
                            <div class="card">
                                <div class="card-body">
                                    <h6 class="card-title mb-3">Recent Order</h6>
                                    <div class="od-date mb-3">${orderDate}</div>
                                    <c:forEach items="${orders}" var="order">
                                        <div class="od-items">
                                            <div class="items">
                                                <div class="pd-img">
                                                    <img src="../${order.product.img}">
                                                </div>
                                                <div class="d-flex flex-column qty pe-3">
                                                    <h5 class="p-0">${order.product.name}</h5>
                                                    <span>Quantity: ${order.quantity}</span>
                                                    <span>Size: </span>
                                                    <span>Color: </span>
                                                </div>
                                                <fmt:formatNumber value="${order.product.salePrice}" type="currency"/>
                                            </div>
                                        </div>
                                    </c:forEach>
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
