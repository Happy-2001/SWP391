<%-- 
    Document   : Messenger
    Created on : May 30, 2022, 4:39:20 PM
    Author     : Administrator
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="js/fontAwesome.js"></script>

<%@page import="model.Message"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--Chat-->

<c:if test="${sessionScope.role ne sessionScope.roleadmin or sessionScope.role eq null }">
    <div id="mess2" class="message2">
        <i style="font-size: 0;"  id="iofmess2" onclick="showMessage()" class="fa-brands fa-facebook-messenger" data-bs-toggle="tooltip" title="Message with ShopDep"></i>
    </div>
    <div id="mess" class="message">
        <div class="header_message row">
            <div class="col-md-10">
                <img src="images/logo.png" class="logo" alt="" width="50%">               
            </div>
            <div class="col-md-2" >
                <i onclick="hideMessage()" class="fa-solid fa-minus"></i>
            </div>
        </div>
        <div class="content_message" >
            <br/>
            <img src="images/logo.png" class="logo" alt="" width="70%">

            <h6>Wear your Best - A Moments of Your Style</h6>
            <c:forEach items="${listMess}" var="mess">
                <c:choose>
                    <c:when test="${listUserAdminID.contains(mess.fromID)}">
                        <div class="divMYR">
                            <div class="MYR">
                                <p>${mess.content} ${listUserAdminID[0]}</p>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="divMYS">
                            <div class="MYS">
                                <p>${mess.content}</p>
                            </div>
                        </div>
                    </c:otherwise>

                </c:choose>
            </c:forEach>



        </div>
        <div id="menumess" class="menu_message">
            <div class="menu_messenger_conponent ">
                <form action="messengerServlet" method="post">
                    <div class="row">
                        <div class="send col-md-8">
                            <input name="contentsend" type="text" placeholder="Viết gì đó...">

                        </div>
                        <div class="col-md-2"></div>
                        <div class="send_button col-md-2">

                            
                            <button name="getFROMandTO" value="${listMess.get(0).fromID};${listMess.get(0).toID}" type="submit" style="border: none;background-color: white"  title="Send"><i class="fa-solid fa-paper-plane"></i></button>
                                <!--nhắn tin tự động. Tự sinh ra group,user group , message creator, sau đó add customerid vào user group vừa tạo-->

                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</c:if> 
<!--chat end-->
