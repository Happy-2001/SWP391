<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <!-- Mobile Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Site Metas -->
        <title>User Profile</title>
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- Site Icons -->
        <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
        <link rel="apple-touch-icon" href="images/apple-touch-icon.png">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- Site CSS -->
        <link rel="stylesheet" href="css/DetailProduct.css">
        <!-- Responsive CSS -->
        <link rel="stylesheet" href="css/responsive.css">
        <!-- Custom CSS -->
        <link rel="stylesheet" href="css/custom.css">

        <meta name="author" content="Codeconvey" />
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,900&display=swap" rel="stylesheet"><link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css'>
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css'>

        <!--Only for demo purpose - no need to add.-->
        <link rel="stylesheet" href="css/demo.css" />

        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>

        <%@include file="topbar.jsp" %>
        <%@include file="header.jsp" %>       

<div class="single-product-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">

                <div class="col-md-8">
                    <div class="product-content-right">

                        <div class="row">
                            <div class="col-sm-6">
                                <div class="product-images">
                                    <div class="product-main-img">
                                        <img src="${Product.img}" alt="">
                                    </div>
                                </div>
                              
                            </div>
                            
                            <div class="col-sm-6">
                                <div class="product-inner">
                                    <h2 class="product-name">${Product.name}</h2>
                                    <div class="product-inner-price">
                                        <ins>$ ${Product.salePrice}</ins> <del>$ ${Product.price}</del>
                                    </div>    
                                    <div role="tabpanel">
                                        <ul class="product-tab" role="tablist">
                                            <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Description</a></li> 
                                        </ul>
                                        <div class="tab-content">
                                         
                                                <h2>Product Description</h2>  
                                                <p> ${Product.description}</p>
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
        <%@include file="footer.jsp" %>
    </body>
</html>