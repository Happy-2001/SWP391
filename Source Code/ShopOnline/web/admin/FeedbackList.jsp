<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin || Sneaker Store</title>
    <!-- Site Icons -->
    <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/Dashboard.css">
    <link rel="stylesheet" href="css/Feedback.css">
    <script src="js/fontAwesome.js" crossorigin="anonymous"></script>
    
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
                            <a href="CusController">
                                <span class="nav-link-icon">
                                    <i class="fa-solid fa-user-group fa-xl"></i>
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
                            <a class="active" href="#">
                                <span class="nav-link-icon">
                                    <i class="fa-solid fa-comment-dots"></i>
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
            
            <!-- ------------ Main Content -------------- -->
            <div class="col-lg-9 main">
                <div class="content ">
                    <div class="row">
                        <div class="col-md-9">
                            <div class="row mb-4">
                                <div class="col-md-7 d-flex">
                                    <div class="me-3">
                                        <div class="input-group">
                                            <div class="input-group-text bg-white">
                                                <input class="form-check-input todo-check-all mt-0" type="checkbox" value="" aria-label="Checkbox for following text input">
                                            </div>
                                            <button class="btn btn-light bg-white dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false"></button>
                                            <div class="dropdown-menu" style="margin: 0px;">
                                                <a class="dropdown-item" href="#">Favourites</a>
                                                <a class="dropdown-item" href="#">Done</a>
                                                <a class="dropdown-item" href="#">Deleted</a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="dropdown">
                                        <a href="#" class="btn bg-white" data-bs-toggle="dropdown" aria-expanded="false">
                                            <i class="fa-solid fa-list-ul fa-xs me-2"></i> Order by
                                        </a>
                                        <div class="dropdown-menu" style="margin: 0px;">
                                            <a class="dropdown-item" href="#">Date</a>
                                            <a class="dropdown-item" href="#">User</a>
                                            <a class="dropdown-item" href="#">Subject</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-5">
                                    <form class="mt-4 mt-md-0">
                                        <div class="input-group">
                                            <input type="text" class="form-control" placeholder="Search todo list">
                                            <button class="btn btn-light bg-white" type="submit">
                                                <i class="fa-solid fa-magnifying-glass"></i>
                                            </button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                
                            <div class="todo-list">
                                <ul class="list-group gap-3">
                                    <li class="list-group-item todo-completed">
                                        <div class="flex-shrink-0">
                                            <input class="form-check-input" type="checkbox">
                                        </div>
                                        <div class="flex-shrink-0">
                                            <i class="fa-regular fa-star"></i>
                                        </div>
                                        <div class="flex-grow-1">
                                            <div class="d-flex justify-content-between align-items-center">
                                                <h6 class="text-truncate p-0 m-0" style="color: #05b171;">Lucas Kriebel (via Twitter)</h6>
                                                <div class="ps-3 d-flex">
                                                    <span class="text-nowrap text-muted">15 July</span>
                                                    <div class="dropdown ms-3">
                                                        <a href="#" class="btn btn-floating btn-sm" data-bs-toggle="dropdown" aria-expanded="false">
                                                            <i class="fa-solid fa-ellipsis"></i>
                                                        </a>
                                                        <div class="dropdown-menu dropdown-menu-end" style="margin: 0px;">
                                                            <a class="dropdown-item" href="#">Mark as unread</a>
                                                            <a class="dropdown-item" href="#">Done</a>
                                                            <a class="dropdown-item text-danger" href="#">Delete</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="text-muted d-flex justify-content-between">
                                                <div class="text-truncate">Lorem ipsum dolor sit amet, consectetur adipisicing
                                                    elit. Illum, labore?
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="list-group-item">
                                        <div class="flex-shrink-0">
                                            <input class="form-check-input" type="checkbox">
                                        </div>
                                        <div class="flex-shrink-0">
                                            <i class="fa-regular fa-star"></i>
                                        </div>
                                        <div class="flex-grow-1">
                                            <div class="d-flex justify-content-between align-items-center">
                                                <h6 class="text-truncate p-0 m-0" style="color: #05b171;">Lucas Kriebel (via Twitter)</h6>
                                                <div class="ps-3 d-flex">
                                                    <span class="text-nowrap text-muted">15 July</span>
                                                    <div class="dropdown ms-3">
                                                        <a href="#" class="btn btn-floating btn-sm" data-bs-toggle="dropdown" aria-expanded="false">
                                                            <i class="fa-solid fa-ellipsis"></i>
                                                        </a>
                                                        <div class="dropdown-menu dropdown-menu-end" style="margin: 0px;">
                                                            <a class="dropdown-item" href="#">Mark as unread</a>
                                                            <a class="dropdown-item" href="#">Done</a>
                                                            <a class="dropdown-item text-danger" href="#">Delete</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="text-muted d-flex justify-content-between">
                                                <div class="text-truncate">Lorem ipsum dolor sit amet, consectetur adipisicing
                                                    elit. Illum, labore?
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                
                            <nav aria-label="Page navigation example">
                                <ul class="pagination justify-content-center mt-4">
                                    <li class="page-item">
                                        <a class="page-link" href="#" aria-label="Previous">
                                            <i class="fa-solid fa-angles-left fa-xs"></i>
                                        </a>
                                    </li>
                                    <li class="page-item active"><a class="page-link" href="#">1</a></li>
                                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                                    <li class="page-item">
                                        <a class="page-link" href="#" aria-label="Next">
                                            <i class="fa-solid fa-angles-right fa-xs"></i>
                                        </a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                        <div class="col-md-3">
                            <div class="card sticky-top">
                                <div class="card-body">
                                    <ul class="nav nav-pills flex-column gap-2">
                                        <li class="nav-item">
                                            <a class="nav-link active d-flex align-items-center" href="#">
                                                <i class="fa-solid fa-list-ul fa-xs me-3"></i>
                                                All
                                                <span class="badge bg-primary ms-auto">20</span>
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="#">
                                                <i class="fa-solid fa-list-check fa-sm me-3"></i>My Task
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="#">
                                                <i class="fa-regular fa-heart fa-sm me-3"></i>Favorites
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link d-flex align-items-center" href="#">
                                                <i class="fa-regular fa-circle-check fa-sm me-3"></i>
                                                Done
                                                <span class="badge bg-primary ms-auto">5</span>
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link d-flex align-items-center" href="#">
                                                <i class="fa-solid fa-trash fa-sm me-3"></i> Deleted
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                
                    <div class="modal fade" id="newTaskModal" tabindex="-1" role="dialog" aria-hidden="true">
                        <div class="modal-dialog modal-dialog-centered" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title">Add Task</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <form autocomplete="off">
                                        <div class="mb-3 row">
                                            <label class="col-sm-3 col-form-label">Task title</label>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" spellcheck="false" data-ms-editor="true">
                                            </div>
                                        </div>
                                        <div class="mb-3 row">
                                            <label class="col-sm-3 col-form-label">Tags</label>
                                            <div class="col-sm-9">
                                                <select class="task-tags-input select2-hidden-accessible" multiple="" data-select2-id="1" tabindex="-1" aria-hidden="true">
                                                    <option value="Theme Support">Theme Support</option>
                                                    <option value="Freelance">Freelance</option>
                                                    <option selected="" value="Social" data-select2-id="3">Social</option>
                                                    <option selected="" value="Friends" data-select2-id="4">Friends</option>
                                                    <option value="Coding">Coding</option>
                                                </select><span class="select2 select2-container select2-container--default" dir="ltr" data-select2-id="2" style="width: auto;"><span class="selection"><span class="select2-selection select2-selection--multiple" role="combobox" aria-haspopup="true" aria-expanded="false" tabindex="-1"><ul class="select2-selection__rendered"><li class="select2-selection__choice" title="Social" data-select2-id="5"><span class="select2-selection__choice__remove" role="presentation">×</span>Social</li><li class="select2-selection__choice" title="Friends" data-select2-id="6"><span class="select2-selection__choice__remove" role="presentation">×</span>Friends</li><li class="select2-search select2-search--inline"><input class="select2-search__field" type="search" tabindex="0" autocomplete="off" autocorrect="off" autocapitalize="none" spellcheck="false" role="textbox" aria-autocomplete="list" placeholder="" style="width: 0.75em;"></li></ul></span></span><span class="dropdown-wrapper" aria-hidden="true"></span></span>
                                            </div>
                                        </div>
                                        <div class="mb-3 row row-sm">
                                            <label class="col-sm-3 col-form-label">Deadline</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control task-datepicker-input" placeholder="Date" spellcheck="false" data-ms-editor="true">
                                            </div>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control task-time-input" placeholder="Time" spellcheck="false" data-ms-editor="true">
                                            </div>
                                        </div>
                                        <div class="mb-3 row">
                                            <label class="col-sm-3 col-form-label">Participate</label>
                                            <div class="col-sm-9 d-flex justify-content-between">
                                                <div class="avatar-group">
                                                    <figure class="avatar avatar-sm">
                                                        <img src="../../assets/images/user/women_avatar3.jpg" class="rounded-circle" alt="image">
                                                    </figure>
                                                    <figure class="avatar avatar-danger avatar-sm">
                                                        <span class="avatar-text rounded-circle">S</span>
                                                    </figure>
                                                    <figure class="avatar avatar-sm">
                                                        <img src="../../assets/images/user/women_avatar5.jpg" class="rounded-circle" alt="image">
                                                    </figure>
                                                </div>
                                                <div>
                                                    <button type="button" class="btn" title="Add User" data-bs-toggle="dropdown">
                                                        Add User
                                                    </button>
                                                    <div class="dropdown-menu dropdown-menu-end p-0">
                                                        <div class="p-3">
                                                            <h6 class="mb-3">Add user</h6>
                                                            <div class="input-group input-group-sm">
                                                                <input type="text" class="form-control" placeholder="Search.." spellcheck="false" data-ms-editor="true">
                                                                <button class="btn btn-light" type="button" id="button-addon2">
                                                                    <i class="bi bi-search"></i>
                                                                </button>
                                                            </div>
                                                            <ul class="list-group list-group-flush mt-2">
                                                                <li class="list-group-item d-flex align-items-center ps-0 pe-0">
                                                                    <div class="me-2">
                                                                        <figure class="avatar avatar-info avatar-sm">
                                                                            <span class="avatar-text rounded-circle">V</span>
                                                                        </figure>
                                                                    </div>
                                                                    <div>
                                                                        <h6 class="mb-0">Valentine Maton</h6>
                                                                    </div>
                                                                    <div class="dropdown ms-auto">
                                                                        <a href="#" data-bs-toggle="dropdown" class="btn btn-light btn-sm" aria-haspopup="true" aria-expanded="false">
                                                                            <i class="bi bi-plus"></i>
                                                                        </a>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item d-flex align-items-center ps-0 pe-0">
                                                                    <div class="me-2">
                                                                        <figure class="avatar avatar-sm">
                                                                            <img src="../../assets/images/user/women_avatar3.jpg" class="rounded-circle" alt="image">
                                                                        </figure>
                                                                    </div>
                                                                    <div>
                                                                        <h6 class="mb-0">Valentine Maton</h6>
                                                                    </div>
                                                                    <div class="dropdown ms-auto">
                                                                        <a href="#" data-bs-toggle="dropdown" class="btn btn-light btn-sm" aria-haspopup="true" aria-expanded="false">
                                                                            <i class="bi bi-plus"></i>
                                                                        </a>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item d-flex align-items-center ps-0 pe-0">
                                                                    <div class="me-2">
                                                                        <figure class="avatar avatar-sm">
                                                                            <img src="../../assets/images/user/women_avatar2.jpg" class="rounded-circle" alt="image">
                                                                        </figure>
                                                                    </div>
                                                                    <div>
                                                                        <h6 class="mb-0">Valentine Maton</h6>
                                                                    </div>
                                                                    <div class="dropdown ms-auto">
                                                                        <a href="#" data-bs-toggle="dropdown" class="btn btn-light btn-sm ms-3" aria-haspopup="true" aria-expanded="false">
                                                                            <i class="bi bi-plus"></i>
                                                                        </a>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item d-flex align-items-center ps-0 pe-0">
                                                                    <div class="me-2">
                                                                        <figure class="avatar avatar-sm">
                                                                            <img src="../../assets/images/user/man_avatar2.jpg" class="rounded-circle" alt="image">
                                                                        </figure>
                                                                    </div>
                                                                    <div>
                                                                        <h6 class="mb-0">Valentine Maton</h6>
                                                                    </div>
                                                                    <div class="dropdown ms-auto">
                                                                        <a href="#" data-bs-toggle="dropdown" class="btn btn-light btn-sm ms-3" aria-haspopup="true" aria-expanded="false">
                                                                            <i class="bi bi-plus"></i>
                                                                        </a>
                                                                    </div>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="mb-3 row">
                                            <label class="col-sm-3 col-form-label">Description</label>
                                            <div class="col-sm-9">
                                                <textarea class="form-control" rows="6" spellcheck="false" data-ms-editor="true"></textarea>
                                            </div>
                                        </div>
                                        <div class="mb-3 row">
                                            <label class="col-sm-3"></label>
                                            <div class="col-sm-9">
                                                <button type="submit" class="btn btn-primary">Add</button>
                                            </div>
                                        </div>
                                    </form>
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
