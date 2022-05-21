<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="header" class="bg-light">
    <header>
        <!-- Start Navigation -->
        <div class="container">
            <nav class="navbar navbar-expand-lg navbar-light bootsnav">
                <!-- Start Header Navigation -->
                <div class="navbar-header">
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbar-menu" aria-controls="navbars-rs-food" aria-expanded="false" aria-label="Toggle navigation">
                        <i class="fa fa-bars"></i>
                    </button>
                    <a class="navbar-brand" href="HomeController"><img src="images/logo.png" class="logo" alt=""></a>
                </div>
                <div class="collapse navbar-collapse" id="navbar-menu">
                    <!-- Start Top Search -->
                    <form action="action">
                        <div class="top-search">
                            <div class="input-group">
                                <span class="input-group-text"><i class="fa fa-search"></i></span>
                                <input type="search" class="form-control"  placeholder="Search...">
                                <span class="input-group-text close-search"><i class="fa fa-times"></i></span>
                            </div>
                        </div>
                    </form>
                    <!-- End Top Search -->
                    <ul id="page-header" class="nav navbar-nav ms-auto">
                        <li class="nav-item active"><a class="nav-link" href="HomeController">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="blog">Blogs</a></li>                       
                        <li class="nav-item"><a class="nav-link" href="ProductController">Product</a></li>
                    </ul>
                </div>


                <div class="account-header">
                    <ul class="nav navbar-nav">
                        <li class="search">
                            <a href="#"><i class="fa fa-search"></i></a>
                        </li>
                        <li class="side-menu">
                            <a href="CartController">
                                <i class="fa fa-shopping-bag"></i>
                            </a>
                        </li>
                        <li class="account">
                            <a href="login"><i class="fa fa-user"></i></a>
                            <!-- <a href="profile.jsp" style="border-left: 2px solid #d33b33;"><i class="fa-solid fa-circle-user"></i> VoAnh</a>
                            <a href="logout" style="border-left: 2px solid #d33b33;"><i class="fa-solid fa-power-off"></i></a>
                            <a href="#"><i class="fa-solid fa-clipboard-list fa-lg"></i></a> -->
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
        <!-- End Navigation -->
    </header>
</div>
<script>
    const navMenu = document.getElementById("navbar-menu"),
            searchBtn = document.querySelector(".search"),
            closeBtn = document.querySelector(".close-search"),
            headSpan = document.getElementById("page-header"),
            searchSpan = document.querySelector(".top-search");

    searchBtn.onclick = function () {
        navMenu.removeChild(headSpan);
        navMenu.appendChild(searchSpan);
        searchSpan.style.display = "block";
        searchBtn.style.display = "none";
    };
    closeBtn.onclick = function () {
        navMenu.appendChild(headSpan);
        navMenu.removeChild(searchSpan);
        searchBtn.style.display = "block";
    };

    var prevScrollpos = window.pageYOffset;

    window.onscroll = function () {
        var currentScrollPos = window.pageYOffset;
        if (currentScrollPos === 0) {
            document.getElementById("header").style.top = "37px";
        } else if (prevScrollpos > currentScrollPos) {
            document.getElementById("header").style.top = "0px";
        } else {
            document.getElementById("header").style.top = "-91px";
        }
        prevScrollpos = currentScrollPos;
    };
</script>
