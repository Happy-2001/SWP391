<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inder Construction || SneakerStore</title>
    <!-- Site Icons -->
    <link rel="shortcut icon" href="../images/favicon.ico" type="image/x-icon">

    <!-- Bootstrap 5 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>

    <style>
        body {
            font-family: Poppins,sans-serif;
            position: relative;
            color: #000;
            overflow-x: hidden;
        }
        body, html {
            height: 100%;
        }
        .del-btn .btn.btn-back{
            background-color: #d33b33;
            color: #fff;
        }
    </style>
</head>
<body class="d-md-flex align-items-center justify-content-center">
    <div class="container text-center p-5 p-md-0">
        <div class="row mb-4">
            <div class="col-md-4 m-auto">
                <figure>
                    <img class="img-fluid" src="images/shopping-cart-icon.png" alt="image">
                </figure>
            </div>
        </div>
        <h2 class="display-6">There are no products in the cart</h2>
        <p class="text-muted my-4">Let's experience shopping with Sneaker Store</p>
        <div class="del-btn">
            <div class="d-flex gap-3 justify-content-center">
                <a href="home" class="btn btn-back">By Now</a>
            </div>
        </div>
    </div>
</body>
</html>
