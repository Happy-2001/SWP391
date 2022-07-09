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
    <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/Dashboard.css">
    <link rel="stylesheet" href="css/ProfileAd.css">
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
                    </ul>
                </div>
            </div>
            <div class="col-lg-9 main">
                <div aria-label="breadcrumb" class="mb-3">
                    <ul class="breadcrumb">
                        <li class="breadcrumb-item">
                            <i class="fa-solid fa-globe fa-sm"></i>
                            <a href="dashboard">Dashboard</a>
                        </li>
                        <li class="breadcrumb-item" aria-current="page">
                            <a href="/ShopOnline/CusController">Customers</a>
                        </li>
                        <li class="breadcrumb-item active" aria-current="page">Profile</li>
                    </ul>
                </div>
                <div class="content">
                    <div class="profile-cover bg-image mb-4" style="background: url(&quot;images/profile-bg.jpg&quot;);">
                        <div class="avatar-profile">
                            <div class="flex-fill">
                                <h5>${cus.us.firstname}</h5>
                            </div>
                            <div class="del-btn">
                                <a href="#" class="btn btn-icon" data-bs-toggle="tooltip" title="Remove Customers">
                                    <i class="fa-solid fa-trash-can"></i>
                                </a>
                            </div>
                        </div>
                        <form action ="UploadImage" method="POST" enctype="multipart/form-data">
                            <div class="ava-popup collapse" id="e-ava">
                                <div class="edit-img">
                                    <span style="color: #fff;">For best results, use an image at least 256px by 256px in either .jpg or .png format</span>
                                    <div class="submit-file-box">
                                        <input type="hidden" name="cusID" value="${cus.us.userid}">
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
                                        <div class="card mb-4">
                                            <div class="card-body">
                                                <div class="card-title mb-4">
                                                    <h6>
                                                        Basic Information
                                                    </h6>
                                                    <span id="editBtn">
                                                        <i class="fa-solid fa-pen-to-square"></i>
                                                    </span>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <div class="mb-3">
                                                            <label class="form-label">Name</label>
                                                            <input type="text" class="form-control" value="${cus.us.firstname} ${cus.us.middlename} ${cus.us.lastname}">
                                                        </div>
                                                        <div class="mb-3">
                                                            <label class="form-label">Username</label>
                                                            <input type="text" class="form-control" value="${cus.us.username}">
                                                        </div>
                                                        <div class="mb-3">
                                                            <label class="form-label">Email</label>
                                                            <input type="text" class="form-control" value="${cus.us.email}">
                                                        </div>
                                                        <div class="mb-3">
                                                            <label class="form-label">Date of Birth</label>
                                                            <div class="d-flex gap-3">
                                                                <select class="form-select">
                                                                    <option>Day</option>
                                                                    <option>1</option>
                                                                    <option>2</option>
                                                                    <option>3</option>
                                                                    <option>4</option>
                                                                    <option>5</option>
                                                                    <option>6</option>
                                                                    <option>7</option>
                                                                    <option>8</option>
                                                                    <option>9</option>
                                                                    <option>10</option>
                                                                    <option>11</option>
                                                                    <option>12</option>
                                                                    <option>13</option>
                                                                    <option>14</option>
                                                                    <option>15</option>
                                                                    <option>16</option>
                                                                    <option>17</option>
                                                                    <option>18</option>
                                                                    <option>19</option>
                                                                    <option selected="">20</option>
                                                                    <option>21</option>
                                                                    <option>22</option>
                                                                    <option>23</option>
                                                                    <option>24</option>
                                                                    <option>25</option>
                                                                    <option>26</option>
                                                                    <option>27</option>
                                                                    <option>28</option>
                                                                    <option>29</option>
                                                                    <option>30</option>
                                                                </select>
                                                                <select class="form-select">
                                                                    <option>Month</option>
                                                                    <option selected="">Jan</option>
                                                                    <option>Feb</option>
                                                                    <option>Mar</option>
                                                                    <option>Apr</option>
                                                                    <option>May</option>
                                                                    <option>Jun</option>
                                                                    <option>Jul</option>
                                                                    <option>Aug</option>
                                                                    <option>Sep</option>
                                                                    <option>Oct</option>
                                                                    <option>Nov</option>
                                                                    <option>Dec</option>
                                                                </select>
                                                                <select class="form-select">
                                                                    <option>Year</option>
                                                                    <option>2018</option>
                                                                    <option>2017</option>
                                                                    <option>2016</option>
                                                                    <option>2015</option>
                                                                    <option>2014</option>
                                                                    <option>2013</option>
                                                                    <option>2012</option>
                                                                    <option>2011</option>
                                                                    <option>2010</option>
                                                                    <option>2009</option>
                                                                    <option>2008</option>
                                                                    <option>2007</option>
                                                                    <option>2006</option>
                                                                    <option>2005</option>
                                                                    <option>2004</option>
                                                                    <option>2003</option>
                                                                    <option>2002</option>
                                                                    <option>2001</option>
                                                                    <option>2000</option>
                                                                    <option>1999</option>
                                                                    <option>1998</option>
                                                                    <option>1997</option>
                                                                    <option>1996</option>
                                                                    <option>1995</option>
                                                                    <option>1994</option>
                                                                    <option>1993</option>
                                                                    <option>1992</option>
                                                                    <option>1991</option>
                                                                    <option>1990</option>
                                                                    <option selected="">1989</option>
                                                                    <option>1988</option>
                                                                    <option>1987</option>
                                                                    <option>1986</option>
                                                                    <option>1985</option>
                                                                    <option>1984</option>
                                                                    <option>1983</option>
                                                                    <option>1982</option>
                                                                    <option>1981</option>
                                                                    <option>1980</option>
                                                                </select>
                                                            </div>
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
                                                            <label class="form-label">Role</label>
                                                            <select class="form-select">
                                                                <option value="">All</option>
                                                                <option value="">Admin</option>
                                                                <option value="">User</option>
                                                                <option value="" selected>Customer</option>
                                                            </select>
                                                        </div>
                                                        <div class="mb-3">
                                                            <label class="form-label">Status</label>
                                                            <select class="form-select">
                                                                <option value="">All</option>
                                                                <option value="" selected>Active</option>
                                                                <option value="">Blocked</option>
                                                            </select>
                                                        </div>
                                                        <div class="mb-3">
                                                            <label class="form-label">Department</label>
                                                            <select class="form-select">
                                                                <option value="">All</option>
                                                                <option value="">Sales</option>
                                                                <option value="" selected="">Development</option>
                                                                <option value="">Management</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="card mb-4">
                                        <div class="card-body">
                                            <h6 class="card-title mb-4">Contact</h6>
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="mb-3">
                                                        <label class="form-label">Phone</label>
                                                        <input type="text" class="form-control" value="${cus.us.phone}">
                                                    </div>
                                                    <div class="mb-3">
                                                        <label class="form-label">Website</label>
                                                        <input type="text" class="form-control" value="http://laborasyon.com/" spellcheck="false" data-ms-editor="true">
                                                    </div>
                                                    <div class="mb-3">
                                                        <label class="form-label">Languages</label>
                                                        <input type="text" class="form-control" value="http://laborasyon.com/" spellcheck="false" data-ms-editor="true">
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="mb-3">
                                                        <label class="form-label">Post Code</label>
                                                        <input type="text" class="form-control" value="1868" spellcheck="false" data-ms-editor="true">
                                                    </div>
                                                    <div class="mb-3">
                                                        <label class="form-label">Province</label>
                                                        <input type="text" class="form-control" value="${cus.uad.province.name}">
                                                    </div>
                                                    <div class="mb-3">
                                                        <label class="form-label">Country</label>
                                                        <input type="text" class="form-control" value="Viet Nam">
                                                    </div>
                                                </div>
                                                <div class="mb-3">
                                                    <label class="form-label">Address</label>
                                                    <input type="text" class="form-control" value="A-65, Belvedere Streets" spellcheck="false" data-ms-editor="true">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-5">
                            <div class="card">
                                <div class="card-body">
                                    <h6 class="card-title mb-4">Order</h6>
                                    <div class="od-items">
                                        <div class="od-date">
                                            20-06-2022
                                        </div>
                                        <div class="items">
                                            <div class="pd-img">
                                                <img src="/images/1.jpg">
                                            </div>
                                            <div class="qty pe-3">
                                                <h5>Adidas</h5>
                                                <span>200.000</span>
                                                <input type="text" value="1" disabled>
                                                <span>Size: 40</span>
                                                <span>
                                                    Color: 
                                                    <i class="fa-solid fa-square" style="color: blue;"></i>
                                                </span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="od-items">
                                        <div class="od-date">
                                            20-06-2022
                                        </div>
                                        <div class="items">
                                            <div class="pd-img">
                                                <img src="/images/1.jpg">
                                            </div>
                                            <div class="qty pe-3">
                                                <h5>Adidas</h5>
                                                <span>200.000</span>
                                                <input type="text" value="1" disabled>
                                                <span>Size: 40</span>
                                                <span>
                                                    Color: 
                                                    <i class="fa-solid fa-square" style="color: blue;"></i>
                                                </span>
                                            </div>
                                        </div>
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
