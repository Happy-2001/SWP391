<%-- 
    Document   : Messenger
    Created on : May 30, 2022, 4:39:20 PM
    Author     : Administrator
--%>
<%@page import="model.Message"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/message.css">

    <c:if test="${sessionScope.role ne sessionScope.roleadmin or sessionScope.role eq null}">
        <!-- mess -->
        <div class="collapse show" id="mess">
            <div class="card message" id="mess1">
                <div class="card-header">
                    <div class="row">
                        <div class="col-lg-10 col-md-10">            
                            <img src="images/logo.png" class="logo" width="50%">
                        </div>
                        <div class="col-lg-2 col-md-2 text-center" onclick="hindMessage()">

                            <i  class="fa-solid fa-minus" style="cursor: pointer;color: #d95e36"></i>

                        </div>
                    </div>
                </div>
                <div id="scroll-to-bottom" class="card-body">
                    <div class="content_message content_messageCUS">

                        <div class="slogans">
                            <img src="images/logo.png" width="60%">
                                <h6>Wear your Best - A Moments of Your Style</h6>
                        </div>
                        <c:choose>
                            <c:when test="${listMess.isEmpty() or listMess == null}">

                                <div class="autochat">
                                    <div>
                                        <input type="text" name="checkMess" hidden="" value="nullMessage" />
                                        <span class="title">Let us help you</span>
                                        <div class="basicBox">
                                            <a href="autochat">Start
                                                <svg viewBox="0 0 120 40" xmlns="http://www.w3.org/2000/svg">
                                                    <rect x='0' y='0' fill='none' width='120' height='40'/>
                                                </svg>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <c:forEach items="${listMess}" var="mess">

                                    <c:choose>
                                        <c:when test="${listUserAdminID.contains(mess.fromID)}">

                                            <c:if test="${mess.parentMessageID ne null}">                           <!--Xác nhận parent message-->
                                                <c:forEach items="${listMess}" var="messParent">
                                                    <c:if test="${messParent.id eq mess.parentMessageID}">
                                                        <c:set var="creatorParentContent" value="${messParent.content}"/>
                                                    </c:if>
                                                </c:forEach>

                                                <c:choose>
                                                    <c:when test="${listUserAdminID.contains(creatorParentContent)}">   <!--nếu creatorParentContent do admin tạo -->
                                                        <div class="divMYR parent-message-title" >
                                                            <div class="MYR" style="background-color: white;font-size: 10px;color: #CCCCCC;margin-bottom: -20px;">
                                                                <i class="fa-solid fa-reply" style="display: block;"><span style="font-family: monospace"> Relying to theirself</span></i> 
                                                            </div>
                                                        </div>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <div class="divMYR parent-message-title" >
                                                            <div class="MYR" style="background-color: white;font-size: 10px;color: #CCCCCC;margin-bottom: -20px;">
                                                                <i class="fa-solid fa-reply" style="display: block;"><span style="font-family: monospace"> Their replying</span></i> 
                                                            </div>
                                                        </div>
                                                    </c:otherwise>
                                                </c:choose>

                                                <div class="divMYR parent-message" >
                                                    <div class="MYR" style="background-color: #f6f9fa;color: #CCCCCC;margin-bottom: -25px">
                                                        ${parentContent}
                                                    </div>
                                                    
                                                </div>
                                            </c:if>


                                            <div class="divMYR">


                                                <c:if test="${mess.content ne null}">

                                                    <div class="dropdown dropdown-option-reply ">
                                                        <a href="#" class="dropdown-toggle" data-bs-toggle="dropdown">
                                                            <i class="fa-solid fa-ellipsis-vertical"></i>
                                                        </a>

                                                        <ul class="dropdown-menu">

                                                            <li><a class="dropdown-item" href="messageedits?type=deleteAll&&messid=${mess.id}&&r=cus&&mrID=null">Delete All</a></li>
                                                            <li><a class="dropdown-item" href="messageedits?type=delete&&messid=${mess.id}&&r=cus&&mrID=null">Delete</a></li>
                                                        </ul>
                                                    </div>
                                                    <i onclick="replyMessageR('${mess.content}',${mess.id})" class="fa-solid fa-reply" title="reply"></i>
                                                    <div class="MYR" title="${mess.createDate}">
                                                        ${mess.content}
                                                    </div>

                                                </c:if>
                                                <c:if test="${mess.content eq null}">
                                                    <div class="dropdown dropdown-option-reply ">
                                                        <a href="#" class="dropdown-toggle" data-bs-toggle="dropdown">
                                                            <i class="fa-solid fa-ellipsis-vertical"></i>
                                                        </a>

                                                        <ul class="dropdown-menu">

                                                            <li><a class="dropdown-item" href="messageedits?type=deleteAll&&messid=${mess.id}&&r=cus&&mrID=null">Delete All</a></li>

                                                        </ul>
                                                    </div>
                                                    <div class="MYR mess-removed">
                                                        This messages is removed
                                                    </div>



                                                </c:if>
                                            </div>
                                        </c:when>
                                        <c:otherwise>

                                            <c:if test="${mess.parentMessageID ne null}">                        <!--Xác nhận parent message-->



                                                <c:forEach items="${listMess}" var="messParent">
                                                    <c:if test="${messParent.id eq mess.parentMessageID}">
                                                        <c:set var="parentContent" value="${messParent.content}"/>
                                                        <c:set var="creatorParentContent" value="${messParent.fromID}"/>
                                                    </c:if>
                                                </c:forEach>

                                                <c:choose>
                                                    <c:when test="${listUserAdminID.contains(creatorParentContent)}">   <!--nếu creatorParentContent do admin tạo -->
                                                        <div class="divMYS parent-message-title" >
                                                            <div class="MYS" style="background-color: white;font-size: 10px;color: #CCCCCC;margin-bottom: -20px;">
                                                                <i class="fa-solid fa-reply" style="display: block;"><span style="font-family: monospace"> You replying</span></i> 
                                                            </div>
                                                        </div>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <div class="divMYS parent-message-title" >
                                                            <div class="MYS" style="background-color: white;font-size: 10px;color: #CCCCCC;margin-bottom: -20px;">
                                                                <i class="fa-solid fa-reply" style="display: block;"><span style="font-family: monospace"> Relying to yourself</span></i> 
                                                            </div>
                                                        </div>
                                                    </c:otherwise>
                                                </c:choose>

                                                <div class="divMYS parent-message" >
                                                    <div class="MYS" style="background-color: #f6f9fa;color: #CCCCCC;margin-bottom: -25px">
                                                        ${parentContent}
                                                    </div>
                                                </div>
                                            </c:if>

                                            <div class="divMYS">         <!--div noi dung-->
                                                <c:if test="${mess.isread eq 1}">
                                                    <span style="margin-left: 5px" class="small text-muted checkIsread"><i class="fa-solid fa-circle-check" style="color:#BBB "></i></span>
                                                    </c:if>

                                                <c:if test="${mess.content ne null}">
                                                    <div class="MYS" title="${mess.createDate}">
                                                        ${mess.content}
                                                    </div>
                                                    <i onclick="replyMessageS('${mess.content}',${mess.id})" class="fa-solid fa-reply" title="reply"></i>
                                                    <div class="dropdown dropdown-option-reply ">
                                                        <a href="#" class="dropdown-toggle" data-bs-toggle="dropdown">
                                                            <i class="fa-solid fa-ellipsis-vertical"></i>
                                                        </a>

                                                        <ul class="dropdown-menu">

                                                            <li><a class="dropdown-item" href="messageedits?type=deleteAll&&messid=${mess.id}&&r=cus&&mrID=null">Delete All</a></li>
                                                            <li><a class="dropdown-item" href="messageedits?type=delete&&messid=${mess.id}&&r=cus&&mrID=null">Delete</a></li>
                                                        </ul>
                                                    </div>
                                                </c:if>
                                                <c:if test="${mess.content eq null}">
                                                    <div class="MYS mess-removed" >
                                                        This messages is removed
                                                    </div>

                                                    <div class="dropdown dropdown-option-reply ">
                                                        <a href="#" class="dropdown-toggle" data-bs-toggle="dropdown">
                                                            <i class="fa-solid fa-ellipsis-vertical"></i>
                                                        </a>

                                                        <ul class="dropdown-menu">

                                                            <li><a class="dropdown-item" href="messageedits?type=deleteAll&&messid=${mess.id}&&r=cus&&mrID=null">Delete All</a></li>

                                                        </ul>
                                                    </div>
                                                </c:if>


                                            </div>      
                                            <c:if test="${listMess.get(listMess.size()-1).content eq 'Bắt đầu'}">
                                                <div class="divMYR">
                                                        <div class="MYR">
                                                        <div class="container dotjump-container">
                                                            <div class="loader" >
                                                                <div class="circle dotjump-circle" id="a"></div>
                                                                <div class="circle dotjump-circle" id="b"></div>
                                                                <div class="circle dotjump-circle" id="c"></div>
                                                            </div>
                                                            
                                                        </div>
                                                    </div>
                                                    </div>
                                            </c:if>       
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
                <div class="card-footer">
                    <div class="menu_message">
                        <form action="message" method="post" >
                            
                            <div id="replyMessS" class="replyMess row" >
                                <div class="replyMess-left col-md-11">
                                    Answering yourself<br>
                                        <h8 id="contentParentS" style="font-size: 13px;color: gray" ></h8>
                                </div>

                                <div class="replyMess-left col-md-1">
                                    <i onclick="removeReplyS()" class="fa-solid fa-xmark"></i>
                                </div>
                            </div>
                            <div id="replyMessR" class="replyMess row" >
                                <div class="replyMess-left col-md-11">
                                    Replying<br>
                                        <h8 id="contentParentR" style="font-size: 13px;color: gray" ></h8>
                                </div>

                                <div class="replyMess-left col-md-1">
                                    <i onclick="removeReplyR()" class="fa-solid fa-xmark"></i>
                                </div>
                            </div>
                            <c:if test="${!listMess.isEmpty()}">
                                <div class="row align-items-center">
                                    <div class="send col-md-10">
                                        <input class="form-control" name="contentsend" type="text" placeholder="Viết gì đó...">
                                            <input id="parentMessageID" name="parentMessageID" type="hidden"/>
                                    </div>
                                    <div class="send_button col-md-2">
                                        <button name="getFROMandTO" value="${listMess.get(0).fromID};${listMess.get(0).toID}" type="submit" style="border: none;width: 0;height: 0"  title="Send"><i class="fa-solid fa-paper-plane" style="font-size: 20px"></i></button
                                    </div>
                                </div>
                            </c:if>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <form action="autochat" method="post" id="message-form">
            <input name="autochat" id="autochatcontent" hidden/>
        </form>
        <!-- end mess -->
        <i id="message2" onclick="showMessage()" class="fa-brands fa-facebook-messenger message2" ></i>
    </c:if>


