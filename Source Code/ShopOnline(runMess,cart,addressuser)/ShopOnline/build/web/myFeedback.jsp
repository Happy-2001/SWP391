
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
        <link rel="stylesheet" href="css/responsive.css">

        <script src="js/fontAwesome.js"></script>
        <script src="js/message.js"></script>
        
        <!-- Bootstrap 5 -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>

    </head>
    <body>
        <%@include file="topbar.jsp" %>
        <%@include file="header.jsp" %>
        <div class="rt-container">
            <div class="col-rt-12">
                <div class="Scriptcontent">


                    <div class="feedback" style="margin-top: 60px">
                        <p>Dear Customer,<br>
                            Thank you for your support and use of our products. We want to know the quality of our products. Please take a moment to give us your valuable feedback as it will help us improve our product. </p>
                        </br>
                        <h4>Please rate your service experience for the following parameters</h4>

                        <form method="post" action="Feedback">
                            <label> Product quality ?</label><br>

                            <span class="star-rating">
                                <input type="radio" name="rating1" value="1"><i></i>
                                <input type="radio" name="rating1" value="2"><i></i>
                                <input type="radio" name="rating1" value="3"><i></i>
                                <input type="radio" name="rating1" value="4"><i></i>
                                <input type="radio" name="rating1" value="5"><i></i>
                            </span>
                            </br>
                            </br>
                            <div class="clear"></div> 
                            <label for="m_3189847521540640526commentText"> Any Other suggestions:</label><br/><br/>
                            <textarea cols="75" name="des" rows="5"></textarea><br>
                            <br>
                            <div class="clear"></div> 
                            <input type="hidden" value="${pid}" name="pid"/>
                            <input style="background:#43a7d5;color:#fff;padding:12px;border:0" type="submit" value="Submit your review">&nbsp;
                        </form>
                    </div>

                </div>
            </div>
        </div>
        <style>
            .feedback{
                width: 100%;
                max-width: 780px;
                background: #fff;
                margin: 0 auto;
                padding: 15px;
                box-shadow: 1px 1px 16px rgba(0, 0, 0, 0.3);
            }
            .survey-hr{
                margin:10px 0;
                border: .5px solid #ddd;
            }
            .star-rating {
                margin: 25px 0 0px;
                font-size: 0;
                white-space: nowrap;
                display: inline-block;
                width: 175px;
                height: 35px;
                overflow: hidden;
                position: relative;
                background: url('data:image/svg+xml;base64,PHN2ZyB2ZXJzaW9uPSIxLjEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHg9IjBweCIgeT0iMHB4IiB3aWR0aD0iMjBweCIgaGVpZ2h0PSIyMHB4IiB2aWV3Qm94PSIwIDAgMjAgMjAiIGVuYWJsZS1iYWNrZ3JvdW5kPSJuZXcgMCAwIDIwIDIwIiB4bWw6c3BhY2U9InByZXNlcnZlIj48cG9seWdvbiBmaWxsPSIjREREREREIiBwb2ludHM9IjEwLDAgMTMuMDksNi41ODMgMjAsNy42MzkgMTUsMTIuNzY0IDE2LjE4LDIwIDEwLDE2LjU4MyAzLjgyLDIwIDUsMTIuNzY0IDAsNy42MzkgNi45MSw2LjU4MyAiLz48L3N2Zz4=');
                background-size: contain;
            }
            .star-rating i {
                opacity: 0;
                position: absolute;
                left: 0;
                top: 0;
                height: 100%;
                width: 20%;
                z-index: 1;
                background: url('data:image/svg+xml;base64,PHN2ZyB2ZXJzaW9uPSIxLjEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHg9IjBweCIgeT0iMHB4IiB3aWR0aD0iMjBweCIgaGVpZ2h0PSIyMHB4IiB2aWV3Qm94PSIwIDAgMjAgMjAiIGVuYWJsZS1iYWNrZ3JvdW5kPSJuZXcgMCAwIDIwIDIwIiB4bWw6c3BhY2U9InByZXNlcnZlIj48cG9seWdvbiBmaWxsPSIjRkZERjg4IiBwb2ludHM9IjEwLDAgMTMuMDksNi41ODMgMjAsNy42MzkgMTUsMTIuNzY0IDE2LjE4LDIwIDEwLDE2LjU4MyAzLjgyLDIwIDUsMTIuNzY0IDAsNy42MzkgNi45MSw2LjU4MyAiLz48L3N2Zz4=');
                background-size: contain;
            }
            .star-rating input {
                -moz-appearance: none;
                -webkit-appearance: none;
                opacity: 0;
                display: inline-block;
                width: 20%;
                height: 100%;
                margin: 0;
                padding: 0;
                z-index: 2;
                position: relative;
            }
            .star-rating input:hover + i,
            .star-rating input:checked + i {
                opacity: 1;
            }
            .star-rating i ~ i {
                width: 40%;
            }
            .star-rating i ~ i ~ i {
                width: 60%;
            }
            .star-rating i ~ i ~ i ~ i {
                width: 80%;
            }
            .star-rating i ~ i ~ i ~ i ~ i {
                width: 100%;
            }
            .choice {
                position: fixed;
                top: 0;
                left: 0;
                right: 0;
                text-align: center;
                padding: 20px;
                display: block;
            }
            span.scale-rating{
                margin: 5px 0 15px;
                display: inline-block;

                width: 100%;

            }
            span.scale-rating>label {
                position:relative;
                -webkit-appearance: none;
                outline:0 !important;
                border: 1px solid grey;
                height:33px;
                margin: 0 5px 0 0;
                width: calc(10% - 7px);
                float: left;
                cursor:pointer;
            }
            span.scale-rating label {
                position:relative;
                -webkit-appearance: none;
                outline:0 !important;
                height:33px;

                margin: 0 5px 0 0;
                width: calc(10% - 7px);
                float: left;
                cursor:pointer;
            }
            span.scale-rating input[type=radio] {
                position:absolute;
                -webkit-appearance: none;
                opacity:0;
                outline:0 !important;
                /*border-right: 1px solid grey;*/
                height:33px;

                margin: 0 5px 0 0;

                width: 100%;
                float: left;
                cursor:pointer;
                z-index:3;
            }
            span.scale-rating label:hover{
                background:#fddf8d;
            }
            span.scale-rating input[type=radio]:last-child{
                border-right:0;
            }
            span.scale-rating label input[type=radio]:checked ~ label{
                -webkit-appearance: none;

                margin: 0;
                background:#fddf8d;
            }
            span.scale-rating label:before
            {
                content:attr(value);
                top: 7px;
                width: 100%;
                position: absolute;
                left: 0;
                right: 0;
                text-align: center;
                vertical-align: middle;
                z-index:2;
            }
        </style>
        <%@include file="footer.jsp" %>
    </body>
</html>