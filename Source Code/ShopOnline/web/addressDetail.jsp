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
        <form action="UpdateProfile" method="POST">
            <div  >              <!--sửa ở đây-->

                <div class="container Popup-body2" style="margin-top: 200px;">
                    <div class="Pop-title">
                        <h3>Address User</h3>
                    </div>
                    <div class="options-divider"></div>
                    <input type="hidden" name="id" value="${sessionScope.user.userid}">
                    <div class="Set-pop">
                        <div class="row">
                            <div class="col-lg-6 col-md-6">
                                <div style="border-right: 1px solid #231f20;">
                                    <h5>Add address</h5>
                                    <div class="options">
                                        <label>Province, District, Sub-district</label>
                                        <input id="straddress" name="straddress"  type="text" value="${valueAddress}" placeholder="Address..." onclick="onClickAddress()"  onblur="outSearchAddress()"	ondblclick ="onKeydownAdress()"> <!--onclick để hiển thị select, 	onkeydown ẩn select-->
                                        

                                        <div id="selectaddress2" class="select-addess2" style="${selectaddress2Style}">           <!--xử lý việc khách hàng nhập địa chỉ-->
                                            <ul id="ulsearch" style="display: none; ${ulBlock}">
                                                <c:if test="${adList ne null}">
                                                    <c:forEach items="${adList}" var="adList">
                                                        <li onclick="getAddress('${adList.addressDetail}','${adList.provinceID}','${adList.districtID}')">${adList.addressDetail}</li>

                                                    </c:forEach>
                                                </c:if>
                                            </ul>
                                        </div>
                                    </div>

                                    <div class="options">
                                        <input value="${adddetail}" id="adddetail" type="text" name="adddetail" placeholder="Address detail..." ondblclick="searchProject()">
                                        <div id="selectaddress3" class="select-addess3" style=" ${selectaddress3Style}">           <!--xử lý việc khách hàng nhập địa chỉ-->
                                            <ul id="ulsearch3" style="display: none; ${ulBlock3}">
                                                <c:if test="${listProject ne null}">
                                                    <c:forEach items="${listProject}" var="listProject">
                                                        
                                                        <li onclick="getProject('${listProject.name}','${listProject.lat}','${listProject.ing}')">${listProject.name}</li>

                                                    </c:forEach>
                                                </c:if>
                                            </ul>
                                        </div>
                                    </div>
                                    <div id="googleMap" style="width: 100%;height: 400px;"></div>           
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6 card-body" >
                                <c:set var="count" value="0"/>
                                <c:forEach items="${listUserAddress}" var="ua">
                                    <div>
                                        <div>
                                            <h4>Address ${count+1}</h4>
                                            <h6>Full Name <h5> ${sessionScope.user.lastname}</h5></h6> 
                                            <h6>Phone <h5> ${ua.phone}</h5></h6> 
                                            <h6>Address <h5> 
                                                    ${ua.addressDetail}, ${ua.prname}, ${ua.strname}, ${ua.wname}
                                                , ${ua.dname}, ${ua.pname}</h5></h6> 
                                        </div>
                                        <div>
                                            <a>Delete</a>
                                            <a>Change</a>
                                            
                                        </div>
                                    </div>
                                </c:forEach>
                                

                                



                            </div>
                            <div class="options-divider"></div>
                            <div class="options">
                                <button class="opt-btn" type="submit">Save</button>
                            </div>
                        </div>
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
//                alert(straddress)
                window.location.href = 'address?straddress=' + straddress;
                document.getElementById('selectaddress').style.height = '0';
                document.getElementById('selectaddress2').style.height = '300px';
                document.getElementById('hindaddress').style.display = 'block';



            }
            function getAddress(address,provinceID,districtID) {
                document.getElementById('straddress').value = address;
                document.getElementById('selectaddress2').style.height = '0';
                document.getElementById('ulsearch').style.display = 'none';
                window.location.href = 'address?straddress=' + address+'&&provinceID='+provinceID+'&&districtID='+districtID;
            }
            function searchProject(){
                var straddress = document.getElementById('straddress').value;
                var straddressdetail = document.getElementById('adddetail').value;
//                alert(straddress)

                window.location.href = 'address?straddress=' + straddress+'&&straddressdetail='+straddressdetail;
                
            }
             
            function getProject(address,lat,ing) {
                document.getElementById('adddetail').value = address;
                document.getElementById('selectaddress3').style.height = '0';
                document.getElementById('ulsearch3').style.display = 'none';
                initialize(lat,ing);
        
                
                
            }
            
        </script>
        
        <script type="text/javascript">
           
            function initialize(lat,ing) {
                
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
            };
            if(lat !== null || ing !== null){
            google.maps.event.addDomListener(window, 'load', initialize);
            }
        
        </script>
        <script src="js/Popup.js"></script>

        <%--<%@include file="footer.jsp" %>--%>
    </body>
</html>
