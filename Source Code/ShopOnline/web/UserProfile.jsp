
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
        <link rel="stylesheet" href="css/userprifile.css">
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
        <!-- Student Profile -->
        <div class="student-profile py-4">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4">
                        <div class="card shadow-sm">
                            <div class="card-header bg-transparent text-center">
                                <img class="profile_img" src="https://source.unsplash.com/600x300/?student" alt="student dp">
                                <h3>${user.fullname}</h3>
                            </div>

                        </div>
                    </div>
                    <div class="col-lg-8">
                        <div class="card shadow-sm">
                            <div class="card-header bg-transparent border-0">
                                <h3 class="mb-0"><i class="far fa-clone pr-1"></i>Personal information</h3>
                            </div>
                            <div class="card-body pt-0">
                                <table class="table table-bordered">
                                    <tr>
                                        <th width="30%">ID</th>
                                        <td width="2%">:</td>
                                        <td><h7>${user.userid}</h7></td>
                                    </tr>
                                    <tr>
                                        <th width="30%">Name</th>
                                        <td width="2%">:</td>
                                        <td><h7>${user.fullname}</h7></td>
                                    </tr>
                                    <tr>
                                        <th width="30%">Phone</th>
                                        <td width="2%">:</td>
                                        <td><h7>${user.phone}</h7></td>
                                    </tr>
                                    <tr>
                                        <th width="30%">Gmail</th>
                                        <td width="2%">:</td>
                                        <td><h7>${user.email}</h7></td>
                                    </tr>
                                    <tr>
                                        <th width="30%">Gender</th>
                                        <td width="2%">:</td>
                                        <td><h7> <c:if test="${user.gender == 1}">
                                            Male
                                        </c:if>
                                        <c:if test="${user.gender == 0}">
                                            Female
                                        </c:if></h7></td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                        <div style="height: 26px"></div>

                    </div>
                </div>
            </div>
        </div>
        <!-- partial -->

    </div>
</div>
</div>
</section>
<%@include file="footer.jsp" %>
</body>
</html>