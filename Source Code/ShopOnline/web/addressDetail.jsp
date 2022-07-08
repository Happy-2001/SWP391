<%-- 
    Document   : addressDetail
    Created on : Jul 6, 2022, 4:22:41 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Site Icons -->
        <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
        <link rel="apple-touch-icon" href="images/apple-touch-icon.png">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/profile.css">
        <link rel="stylesheet" href="css/responsive.css">
        <script src="js/fontAwesome.js"></script>

        <!-- Bootstrap 5 -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    </head>
    <body>
        <%@include file="topbar.jsp" %>
        <%@include file="header.jsp" %>   
        <!-- Edit Address -->
        <form action="address" method="post">
            <!--sửa ở đây-->

            <div class=" Popup-body2" style="margin-top: 200px;">
                <div class="Pop-title">
                    <h3>Address User</h3>
                </div>
                <div class="options-divider"></div>
                <input type="hidden" name="id" value="${sessionScope.user.userid}">
                <div class="Set-pop">
                    <div class="row">
                        <div class="col-lg-5 col-md-5">
                            <div style="border-right: 1px solid #231f20;">
                                <h5>Add address</h5>
                                <div class="options ">
                                    <label>Full name</label>
                                    <input id="fullname" class="col-md-6" name="fullname" type="text" value="${fullname}" placeholder="Full name" />
                                    <label>Phone</label>
                                    <input id="phone" class="col-md-6" name="phone" type="text" value="${phone}" placeholder="Phone" />
                                    <label>Province, District, Sub-district</label>
                                    <input id="straddress" name="straddress"  type="text" value="${valueAddress}" placeholder="Address..." onclick="onClickAddress()"  onblur="outSearchAddress()"	ondblclick ="onKeydownAdress()"> <!--onclick để hiển thị select, 	onkeydown ẩn select-->


                                    <div id="selectaddress2" class="select-addess2" style="${selectaddress2Style}">           <!--xử lý việc khách hàng nhập địa chỉ-->
                                        <ul id="ulsearch" style=" ${ulBlock}">
                                            <c:if test="${adList ne null}">
                                                <c:forEach items="${adList}" var="adList">
                                                    <li onclick="getAddress('${adList.addressDetail}', '${adList.provinceID}', '${adList.districtID}',${adList.subDistrictID})">${adList.addressDetail}</li>

                                                </c:forEach>
                                            </c:if>
                                        </ul>
                                    </div>
                                </div>

                                <div class="options">
                                    <input value="${adddetail}" id="adddetail" type="text" name="adddetail" placeholder="Address detail..." ondblclick="searchProject()">
                                    <div id="selectaddress3" class="select-addess3" style=" ${selectaddress3Style}">           <!--xử lý việc khách hàng nhập địa chỉ-->
                                        <ul id="ulsearch3" style="${ulBlock3}">
                                            <c:if test="${listProject ne null}">
                                                <c:forEach items="${listProject}" var="listProject">

                                                    <li onclick="getProject('${listProject.name}', '${listProject.lat}', '${listProject.ing}')">${listProject.name}</li>

                                                </c:forEach>
                                            </c:if>
                                        </ul>
                                    </div>
                                </div>
                                <div id="googleMap" style="width: 100%;height: 400px;"></div>           
                            </div>
                            <div class="options">
                                <button class="opt-btn" type="submit">Save</button>
                            </div>
                        </div>
                        <div class="col-lg-7 col-md-7 card-body" >
                            <c:set var="count" value="0"/>
                            <c:forEach items="${listUserAddress}" var="ua">
                                <div class="row" >
                                    <div class="col-md-3 mainaddress" style="">
                                        <h6>Address ${count = count+1}</h6>
                                        <p>Full Name </p> 
                                        <p>Phone </p> 
                                        <p>Address</p> 

                                    </div>
                                    <div class="col-md-7 contentaddress" style="">


                                        <c:if test="${ua.status ne null}">
                                            <c:set var="idDefault" value="${ua.uaID}" />
                                            <p> ${ua.fullname} <font>Default</font></p>
                                            </c:if>
                                            <c:if test="${ua.status eq null}">
                                            <p> ${ua.fullname} </p>
                                        </c:if>
                                        <p> ${ua.phone} - ${ua.otherPhone}</p>
                                        <p>${ua.detailAddress} ${ua.prname} ${ua.strname} ${ua.wname} ${ua.dname} ${ua.pname} </p>
                                    </div>
                                    <div class="col-md-2 optionaddress">

                                        <a href="#" onclick="deleteAddress('${count}',${ua.uaID})">Delete</a>
                                        
                                        <div class="dropdown">
                                            <a href="#" class="dropdown-toggle" data-bs-toggle="dropdown">
                                                Settings
                                            </a>
                                            <ul class="dropdown-menu">
                                                <li><a class="dropdown-item" href="address?accesstype=settings&&settingtype=editaddress&&userid=${sessionScope.userid}">Edit address</a></li>
                                                <li><a class="dropdown-item" href="address?accesstype=settings&&settingtype=setdefault&&idDefault=${idDefault}&&idSetDefault=${ua.uaID}&&userid=${sessionScope.userid}">Set as default</a></li>
                                                
                                            </ul>
                                        </div>
                                    </div>

                                </div>
                           
                        </c:forEach>
                    </div>
                    <div class="options-divider"></div>

                </div>
            </div>
        </div>

    </form>
    <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js"></script>
    <script type="text/javascript">
                                            function changeProvince() {

                                                document.getElementById('province').style.borderBottomColor = "#d33b33";
                                                document.getElementById('province').style.color = "#d33b33";
                                                document.getElementById('provinces').style.display = "block";


                                                document.getElementById('district').style.borderBottomColor = "#ccc";
                                                document.getElementById('district').style.color = "black";
                                                document.getElementById('subdistrict').style.borderBottomColor = "#ccc";
                                                document.getElementById('subdistrict').style.color = "black";

                                                document.getElementById('districts').style.display = "none";
                                                document.getElementById('subdistricts').style.display = "none";
                                            }
                                            function changeDistrict() {

                                                document.getElementById('district').style.borderBottomColor = "#d33b33";
                                                document.getElementById('district').style.color = "#d33b33";
                                                document.getElementById('districts').style.display = "block";

                                                document.getElementById('province').style.borderBottomColor = "#ccc";
                                                document.getElementById('province').style.color = "black";
                                                document.getElementById('subdistrict').style.borderBottomColor = "#ccc";
                                                document.getElementById('subdistrict').style.color = "black";

                                                document.getElementById('provinces').style.display = "none";
                                                document.getElementById('subdistricts').style.display = "none";
                                            }
                                            function changeSubdistrict() {

                                                document.getElementById('subdistrict').style.borderBottomColor = "#d33b33";
                                                document.getElementById('subdistrict').style.color = "#d33b33";
                                                document.getElementById('subdistricts').style.display = "block";

                                                document.getElementById('province').style.borderBottomColor = "#ccc";
                                                document.getElementById('province').style.color = "black";
                                                document.getElementById('district').style.borderBottomColor = "#ccc";
                                                document.getElementById('district').style.color = "black";

                                                document.getElementById('provinces').style.display = "none";
                                                document.getElementById('districts').style.display = "none";
                                            }
                                            function onClickAddress() {
                                                document.getElementById('selectaddress').style.height = '300px';
                                                document.getElementById('selectaddress2').style.height = '0';
                                                document.getElementById('hindaddress').style.display = 'none';
                                            }
                                            function onKeydownAdress() {
                                                var straddress = document.getElementById('straddress').value;
                                                var fullname = document.getElementById('fullname').value;
                                                var phone = document.getElementById('phone').value;
//                alert(straddress)
                                                window.location.href = 'address?accesstype=access&&userid=${sessionScope.userid}&&straddress=' + straddress + "&&fullname=" + fullname + "&&phone=" + phone;
                                                document.getElementById('selectaddress').style.height = '0';
                                                document.getElementById('selectaddress2').style.height = '300px';
                                                document.getElementById('hindaddress').style.display = 'block';



                                            }
                                            function getAddress(address, provinceID, districtID, subDistrictID) {
                                                document.getElementById('straddress').value = address;
                                                document.getElementById('selectaddress2').style.height = '0';
                                                document.getElementById('ulsearch').style.display = 'none';
                                                var fullname = document.getElementById('fullname').value;
                                                var phone = document.getElementById('phone').value;
                                                window.location.href = 'address?accesstype=access&&userid=${sessionScope.userid}&&straddress=' + address + '&&provinceID=' + provinceID + '&&districtID=' + districtID + '&&subDistrictID=' + subDistrictID + "&&fullname=" + fullname + "&&phone=" + phone;
                                            }
                                            function searchProject() {
                                                var straddress = document.getElementById('straddress').value;
                                                var straddressdetail = document.getElementById('adddetail').value;
                                                var fullname = document.getElementById('fullname').value;
                                                var phone = document.getElementById('phone').value;
//                alert(straddress)

                                                window.location.href = 'address?accesstype=access&&userid=${sessionScope.userid}&&straddress=' + straddress + '&&straddressdetail=' + straddressdetail + "&&phone=" + phone + "&&fullname=" + fullname;

                                            }

                                            function getProject(address, lat, ing) {
                                                document.getElementById('adddetail').value = address;
                                                document.getElementById('selectaddress3').style.height = '0';
                                                document.getElementById('ulsearch3').style.display = 'none';
                                                initialize(lat, ing);



                                            }
                                            function deleteAddress(address, uaID) {
                                                var option = confirm("Delete address: " + address + " ?");
                                                if (option === true) {
                                                    window.location.href = 'address?accesstype=delete&&uaID=' + uaID + '&&userid=${sessionScope.userid}';
                                                }

                                            }
    </script>

    <script type="text/javascript">

        function initialize(lat, ing) {

            var myCenter = new google.maps.LatLng(lat, ing);
            var mapProp = {
                center: myCenter,
                zoom: 12,
                mapTypeId: google.maps.MapTypeId.RoadMAP
            };
            var map = new google.maps.Map(document.getElementById("googleMap"), mapProp);
            var marker = new google.maps.Marker({
                position: myCenter
            });
            marker.setMap(map);
        }
        ;
        if (lat !== null || ing !== null) {
            google.maps.event.addDomListener(window, 'load', initialize);
        }

    </script>
    <script src="js/Popup.js"></script>

    <%--<%@include file="footer.jsp" %>--%>
</body>
</html>
