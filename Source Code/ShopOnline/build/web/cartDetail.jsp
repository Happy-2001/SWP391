<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="css/card.css">
    <link rel="stylesheet" href="css/responsive.css">
    <script src="js/fontAwesome.js"></script>
    
    <!-- Bootstrap 5 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</head>
<body>
    <%@include file="topbar.jsp" %>
    <%@include file="header.jsp" %> 

    <div class="container">
        <!-- Start All Title Box -->
        <div class="all-title-box" style="margin-top: 60px;">
            <div aria-label="breadcrumb">
                <ul class="breadcrumb">
                    <li class="breadcrumb-item"><a href="HomePage.html">Home</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Card</li>
                </ul>
            </div>
        </div>
        <!-- End All Title Box -->
        <div class="container">
            <div class="row">
                <div class="col-lg-8">
                    <div class="bg-light mb-2">
                        <div class="d-flex justify-content-between align-items-center pe-3">
                            <div class="save-pass">
                                <label class="save-pass-container">Select All
                                    <input type="checkbox" id="toggle" value="select">
                                    <span class="checkmark"></span>
                                </label>
                            </div>
                            <div class="remove-icon">
                                <i class="fa-regular fa-trash-can"></i>
                                <span>Delete</span>
                            </div>
                        </div>
                    </div>
                    <div class="order-items">
                        <table class="table">
                            <thead>
                                <tr>
                                    <td></td>
                                    <td>Product</td>
                                    <td>Price </td>
                                    <td>Quantity</td>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${carts}" var="carts">
                                    <tr>
                                        <td>
                                            <input id="buyItem" type="checkbox" name="item" value="${carts.itemId}">
                                        </td>
                                        <td class="d-flex flex-row me-3">
                                            <div class="image">
                                                <img src="${carts.product.img}" class="img-fluid">
                                            </div>
                                            <div class="d-flex flex-column">
                                                <span><strong>${carts.product.name}</strong></span>
                                                <span>Color:</span>
                                                <div>
                                                    <span>Size:</span>
                                                    <select name="" id="">
                                                        <option selected>35</option>
                                                        <option>36</option>
                                                        <option>37</option>
                                                        <option>38</option>
                                                        <option>39</option>
                                                        <option>40</option>
                                                        <option>41</option>
                                                        <option>42</option>
                                                        <option>43</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="d-flex flex-column">
                                                <span><strong>${carts.product.price}</strong><i class="fa-solid fa-dong-sign"></i></span>
                                                <div class="d-flex flex-row">
                                                    <a href="#" style="color: #212529;" class="pe-3"><i class="fa-regular fa-heart remove-icon"></i></a>
                                                    <a href="DeleteCart?pid=${carts.itemId}" style="color: #212529;"><i class="fa-regular fa-trash-can remove-icon"></i></a>
                                                </div>
                                            </div>
                                        </td>
                                        <td>
                                            <form action="UpdateCartController" method="POST">
                                                <div class="input-group">
                                                    <input type="hidden" name="id" value="${carts.itemId}">
                                                    <input type="hidden" name="uid" value="${carts.userId}">
                                                    <button id="subs" type="submit" formmethod="GET" class="input-group-text"><i class="fa-solid fa-minus"></i></button>
                                                    <input id="qtyV" type="text" name="qty" value="${carts.quantity}" class="form-control">
                                                    <button type="submit" class="input-group-text close-search"><i class="fa-solid fa-plus"></i></button>
                                                </div>
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="why-text d-flex justify-content-center">
                        <a href="#" class="btn" onclick="redirect()">Buy Now</a>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="bg-light px-3 text-uppercase font-weight-bold" style="padding: 6px; font-weight: 600;">Price</div>
                    <div class="pt-3 px-4">
                        <ul class="list-unstyled mb-0">
                            <li class="d-flex justify-content-between py-3 border-bottom">
                                <strong class="text-muted">Sub Total</strong>
                                <strong>${total} ₫</strong>
                            </li>
                            <li class="d-flex justify-content-between py-3 border-bottom">
                                <strong class="text-muted">Shipping</strong>
                                <img src="images/payment-icon/free-shipping.png" style="width: 10%;">
                            </li>
                            <li class="d-flex justify-content-between py-3 border-bottom">
                                <strong class="text-muted">VAT</strong>
                                <strong>${vat} ₫</strong>
                            </li>
                            <li class="d-flex justify-content-between py-3 border-bottom">
                                <strong class="text-muted">Total</strong>
                                <h5 class="font-weight-bold">${sum} ₫</h5>
                            </li>
                        </ul>
                    </div>
                    <div class="why-text d-flex justify-content-center">
                        <a href="#" class="btn" onclick="redirect()">Buy Now</a>
                    </div>
                </div>
            </div>
        </div>
        <script>
            var getItem = document.querySelectorAll("#buyItem");
            function redirect(){
                var itemid = "item=";
                var sum = 0;
                for (let i = 0; i < getItem.length; i++){
                    if (getItem[i].checked == true){
                        sum = sum+1;
                        if(sum > 1){
                            itemid = itemid + "&item=" + getItem[i].value;
                        }else{
                            itemid = itemid + getItem[i].value;
                        }
                    }
                }
                window.location.href = 'CartContact?'+itemid;
            };
        </script>
        <script src="js/cart-select.js"></script>
    </div>

    <%@include file="footer.jsp" %>
    
</body>
</html>