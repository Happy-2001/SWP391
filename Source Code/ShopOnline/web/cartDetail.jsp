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
                    <li class="breadcrumb-item"><a href="HomeController">Home</a></li>
                    <li class="breadcrumb-item"><a href="CartController">Card</a></li>
                </ul>
            </div>
        </div>
        <!-- End All Title Box -->
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
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
                                            <input type="checkbox" name="item" value="${carts.item_id}">
                                        </td>
                                        <td class="d-flex flex-row me-3">
                                            <div class="image">
                                                <img src="${carts.url}" class="img-fluid">
                                            </div>
                                            <div class="d-flex flex-column">
                                                <span><strong>${carts.product_name}</strong></span>
                                                <span>Color:</span>
                                                <div>
                                                    <span>Size:</span>
                                                    <select name="" id="">
                                                        <option>35</option>
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
                                                <span><strong>${carts.unit_price}</strong><i class="fa-solid fa-dong-sign"></i></span>
                                                <div class="d-flex flex-row">
                                                    <a href="#" style="color: #212529;" class="pe-3"><i class="fa-regular fa-heart remove-icon"></i></a>
                                                    <a href="DeleteCart?id=${carts.item_id}" style="color: #212529;"><i class="fa-regular fa-trash-can remove-icon"></i></a>
                                                </div>
                                            </div>
                                        </td>
                                <form action="UpdateCartController" method="POST">
                                    <td>
                                        <div class="input-group">
                                            <input type="hidden" name="id" value="${carts.item_id}">
                                            <button id="subs" type="submit" formmethod="GET" class="input-group-text"><i class="fa-solid fa-minus"></i></button>
                                            <input id="qtyV" type="text" name="qty" value="1" class="form-control">
                                            <button type="submit" class="input-group-text close-search"><i class="fa-solid fa-plus"></i></button>
                                        </div>
                                    </td>
                                </form>
                            </tr>
                        </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="why-text d-flex justify-content-center">
                        <a href="CartContact" class="btn">Buy Now</a>
                    </div>
                </div>
            </div>
        </div>
        <script src="js/cart-select.js"></script>
    </div>
    
    <%@include file="footer.jsp" %>
</body>
</html>