
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Shop Online</title>
        <!-- Site Icons -->
        <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
        <link rel="apple-touch-icon" href="images/apple-touch-icon.png">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/HomePage.css">
        <link rel="stylesheet" href="css/Feedback.css">

        <script src="js/fontAwesome.js"></script>

        <!-- Bootstrap 5 -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>

    </head>
    <body>
        <%@include file="topbar.jsp" %>
        <%@include file="header.jsp" %>

        <div class="container">
            <div class="all-title-box" style="margin-top: 60px;">
                <div aria-label="breadcrumb">
                    <ul class="breadcrumb">
                        <li class="breadcrumb-item"><a href="HomePage.html">Home</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Feedback</li>
                    </ul>
                </div>
            </div>
            <div class="row d-flex justify-content-center" style="margin-bottom: 60px;">
                <div class="fb-box col-md-8">
                    <div class="card">
                        <div class="card-body">
                            <div class="invoice p-5">
                                <h5>Hello, ${order.user.firstname} ${order.user.middlename} ${order.user.lastname}</h5>
                                <span>Thank you for your support and use of our products. We want to know the quality of our products. Please take a moment to give us your valuable feedback as it will help us improve our product.</span>
                                <div class="payment border-top mt-3 mb-3 border-bottom table-responsive">
                                    <table class="table table-borderless">
                                        <tbody>
                                            <tr>
                                                <td>
                                                    <div class="py-2">
                                                        <span class="d-block text-muted">Order Date</span>
                                                        <span>${order.orderDate}</span>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="py-2">
                                                        <span class="d-block text-muted">Order No</span>
                                                        <span>${order.orderID}</span>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="py-2">
                                                        <span class="d-block text-muted">Shiping Address</span>
                                                        <span>414 Advert Avenue, NY,USA</span>
                                                    </div>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="Attachments mb-3">
                                    <h6 class="mb-3">Attachments</h6>
                                    <form id="uploadImg" action="FeedbackUploadImage" method="POST" enctype="multipart/form-data">
                                        <input type="hidden" name="orderID" value="${order.orderID}">
                                        <div class="d-flex gap-3">
                                            <div class="image">
                                                <img src="FeedbackUploadImage?act=image1&fbid=${myfb.fbID}" id="image1" style="display: block">
                                                <input name="myfeedbackID" value="${myfb.fbID}" hidden/>
                                                <div class="file-upload" id="uploadImg1" style="background: none">
                                                    <div class="edit-img">
                                                        <div class="submit-file-box">
                                                            <input type="file" class="cus-file-input" name="img1" id="submit-file-1">
                                                            <p class="text-center mb-0">
                                                                <label class="trigger" for="submit-file-1">
                                                                    <i class="fa-solid fa-camera fa-2xl"></i>
                                                                </label>
                                                            </p>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="image">
                                                <img src="FeedbackUploadImage?act=image2&fbid=${myfb.fbID}" id="image2" style="display: block">
                                                <div class="file-upload" id="uploadImg2" style="background: none">
                                                    <div class="edit-img">
                                                        <div class="submit-file-box">
                                                            <input type="file" class="cus-file-input" name="img2" id="submit-file-2">
                                                            <p class="text-center mb-0">
                                                                <label class="trigger" for="submit-file-2">
                                                                    <i class="fa-solid fa-camera fa-2xl"></i>
                                                                </label>
                                                            </p>
                                                        </div>
                                                    </div>
                                                </div>
                                                
                                            </div>
                                        </div>
                                    </form>
                                    
                                </div>
                                <form action="Feedback" method="POST">
                                   <input name="myfeedbackID" value="${myfb.fbID}" hidden/>
                                    <input type="hidden" name="uid" value="${order.user.userid}">
                                    <input type="hidden" name="orderID" value="${order.orderID}">
                                    <div class="rating-form py-3">
                                        <h6>Please rate your service experience for the following parameters </h6>
                                        <!-- RATING - Form -->
                                        <div class="form-item">
                                            <input id="rating-5" name="rating" type="radio" value="5" />
                                            <label for="rating-5" data-value="5">
                                                <span class="rating-star">
                                                    <i class="fa fa-star-o"></i>
                                                    <i class="fa fa-star"></i>
                                                </span>
                                                <span class="ir">5</span>
                                            </label>
                                            <input id="rating-4" name="rating" type="radio" value="4" />
                                            <label for="rating-4" data-value="4">
                                                <span class="rating-star">
                                                    <i class="fa fa-star-o"></i>
                                                    <i class="fa fa-star"></i>
                                                </span>
                                                <span class="ir">4</span>
                                            </label>
                                            <input id="rating-3" name="rating" type="radio" value="3" />
                                            <label for="rating-3" data-value="3">
                                                <span class="rating-star">
                                                    <i class="fa fa-star-o"></i>
                                                    <i class="fa fa-star"></i>
                                                </span>
                                                <span class="ir">3</span>
                                            </label>
                                            <input id="rating-2" name="rating" type="radio" value="2" />
                                            <label for="rating-2" data-value="2">
                                                <span class="rating-star">
                                                    <i class="fa fa-star-o"></i>
                                                    <i class="fa fa-star"></i>
                                                </span>
                                                <span class="ir">2</span>
                                            </label>
                                            <input id="rating-1" name="rating" type="radio" value="1" />
                                            <label for="rating-1" data-value="1">
                                                <span class="rating-star">
                                                    <i class="fa fa-star-o"></i>
                                                    <i class="fa fa-star"></i>
                                                </span>
                                                <span class="ir">1</span>
                                            </label>
                                            <c:if test="${myfb.rating eq null}">
                                                <div class="form-action">
                                                    <input class="btn-reset" type="reset" value="Reset" />   
                                                </div>
                                            </c:if>

                                            <div class="form-output">
                                                ? / 5
                                            </div>
                                        </div>
                                    </div>
                                    <div class="pt-4">
                                        <h6 class="mb-3">Any Other suggestions:</h6>
                                                <div class="fb-reply mb-3">
                                                    <textarea name="reply" id="ql-editor" placeholder="Type something... " onkeyup="req()">${myfb.description}</textarea>
                                                    <span id="left">Remaining 1000 fillable characters</span>
                                                </div>
                                        <div class="why-text text-center">
                                            <button type="submit" class="btn">Send</button>
                                        </div>
                                    </div>
                                    
                                </form>
                            </div>
                        </div>
                        <div class="d-flex justify-content-between p-3">
                            <span>Need Help? visit our <a href="#"> help center</a></span>
                            <span>12 June, 2020</span>
                        </div>
                    </div>    
                </div>        
            </div> 
        </div>
                                    <script type="text/javascript">
                                        var fileInput1 = document.getElementById("submit-file-1"),
                                                fileInput2 = document.getElementById("submit-file-2"),
                                                button = document.querySelectorAll(".trigger"),
                                                showDemo1 = document.getElementById("image1"),
                                                showDemo2 = document.getElementById("image2"),
                                                submitBtn = document.getElementById("uploadImg");

                                        button[0].addEventListener("click", function (vent) {
                                            fileInput1.focus();
                                            return false;
                                        });
                                        fileInput1.addEventListener("change", function (event) {
                                            showDemo1.style.display = "block";

                                            if (this.files && this.files[0]) {
                                                let reader = new FileReader();

                                                reader.onload = function (e) {
                                                    showDemo1.src = e.target.result;
                                                };
                                                reader.readAsDataURL(this.files[0]);
                                                submitBtn.submit();
                                            }
                                        });

                                        button[1].addEventListener("click", function (vent) {
                                            fileInput2.focus();
                                            return false;
                                        });
                                        fileInput2.addEventListener("change", function (event) {
                                            showDemo2.style.display = "block";

                                            if (this.files && this.files[0]) {
                                                let reader = new FileReader();

                                                reader.onload = function (e) {
                                                    showDemo2.src = e.target.result;
                                                };
                                                reader.readAsDataURL(this.files[0]);
                                                submitBtn.submit();
                                            }
                                        });
                                        //hind img if img cannot load
                                        const img = document.getElementById('image1');
                                        const img2 = document.getElementById('image2');

                                       
                                        
                                        img.addEventListener('error', function handleError() {
                                            document.getElementById('image1').style.display = 'none';
                                        });
                                        img2.addEventListener('error', function handleError() {
                                            document.getElementById('image2').style.display = 'none';
                                        });
                                        
                                        const messArea = document.getElementById("ql-editor"),
                                                num = document.getElementById("left"),
                                                rateVal = document.getElementsByName("rating");

                                        var v = 5 - ${myfb.rating};
                                        rateVal[v].checked = true;

                                        function req() {
                                            var mess = messArea.value;
                                            var required = 1000;
                                            var left = required - mess.length;

                                            if (left > 0) {
                                                num.innerHTML = "Remaining " + left + " fillable characters";
                                                return false;
                                            }

                                            num.innerHTML = "0";
                                            return true;
                                        }
                                        ;
                                    </script>
        <%@include file="footer.jsp" %>
    </body>
</html>