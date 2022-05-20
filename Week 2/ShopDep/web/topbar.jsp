<%-- 
    Document   : topbar
    Created on : May 19, 2022, 11:01:46 PM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="checkuserconfirm.jsp" %>


<style>
    *{
        font-family: sans-serif;
    }
    .custom-select-box{
        margin-right:100px;
    }
</style>
<!-- Start Main Top -->
<div class="main-top">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                <div class="text-slid-box">
                    <div id="offer-box" class="carouselTicker">
                        <ul class="offer-box">
                            <li>
                                <i class="fab fa-opencart"></i> Off 10%! Shop Now Man
                            </li>
                            <li>
                                <i class="fab fa-opencart"></i> 50% - 80% off on Fashion
                            </li>
                            <li>
                                <i class="fab fa-opencart"></i> 20% off Entire Purchase Promo code: offT20
                            </li>
                            <li>
                                <i class="fab fa-opencart"></i> Off 50%! Shop Now
                            </li>
                            <li>
                                <i class="fab fa-opencart"></i> Off 10%! Shop Now Man
                            </li>
                            <li>
                                <i class="fab fa-opencart"></i> 50% - 80% off on Fashion
                            </li>
                            <li>
                                <i class="fab fa-opencart"></i> 20% off Entire Purchase Promo code: offT20
                            </li>
                            <li>
                                <i class="fab fa-opencart"></i> Off 50%! Shop Now
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            
            <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">              
                <div class="custom-select-box">
                    <select id="basic" class="selectpicker show-tick form-control" onchange="myFunction()">
                        
                        <option value="#" >Select</option>
                        <c:if test="${sessionScope.userlogged.authorityid == 1}">
                            <option value="listslide" >Slide Manager</option>
                            <option value="listproduct" >Product Manager</option>
                            <option value="ListCustomer" >Customer Manager</option>
                            <option value="ListUserController" >User Manager</option>
                            <option value="orderlist" >Order list</option>                  
                            <option value="PostController" >Post</option>
                        </c:if>
                        <c:if test="${sessionScope.userlogged.authorityid == 2}">
                            <option value="Feedbackcontroller">Feedback</option>
                        </c:if>
                        
                    </select>
                </div>

                <div class="our-link">
                    <ul>
                        <c:if test="${sessionScope.userlogged eq null}">
                            <li><a href="login">Sign In</a></li>
                            <li><a href="register">Sign Up</a></li>
                            </c:if>
                            <c:if test="${sessionScope.userlogged ne null}">
                            <li><a href="profile.jsp">Hello ${sessionScope.userlogged.username}</a></li>  
                            <li><a href="logout">Logout</a></li>    
                            <li><a href="changepassword.jsp">ChangePassWord</a></li>   
                            </c:if>                       
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End Main Top -->
<script>
    function myFunction() {
        var x = document.getElementById("basic").value;
        window.location.href = x;
    }
</script>


