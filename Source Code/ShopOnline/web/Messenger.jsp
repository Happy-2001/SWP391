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

    <c:if test="${sessionScope.role ne sessionScope.roleadmin or sessionScope.role eq null }">
        <!-- mess -->
        <div class="collapse show" id="mess">
            <div class="card message" id="mess1">
                <div class="card-header">
                    <div class="row">
                        <div class="col-lg-10 col-md-10">            
                            <img src="images/logo.png" class="logo" width="50%">
                        </div>
                        <div class="col-lg-2 col-md-2 text-center" onclick="hindMessage()">
                            
                            <i  class="fa-solid fa-minus"></i>
                            
                        </div>
                    </div>
                </div>
                <div id="scroll-to-bottom" class="card-body">
                    <div class="content_message">
                        <div class="slogans">
                            <img src="images/logo.png" width="60%">
                                <h6>Wear your Best - A Moments of Your Style</h6>
                        </div>
                        <c:choose>
                            <c:when test="${listMess eq null}">
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
                                                <i onclick="replyMessageR('${mess.content}',${mess.id})" class="fa-solid fa-reply" title="reply"></i>
                                                <div class="MYR" title="${mess.createDate}">
                                                    ${mess.content}
                                                </div>
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

                                                <div class="MYS" title="${mess.createDate}">
                                                    ${mess.content}
                                                </div>

                                                <i onclick="replyMessageS('${mess.content}',${mess.id})" class="fa-solid fa-reply" title="reply"></i>

                                            </div>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
                <div class="card-footer">
                    <div class="menu_message">
                        <form action="message" method="post">
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
                            <div class="row align-items-center">
                                <div class="send col-md-10">
                                    <input class="form-control" name="contentsend" type="text" placeholder="Viết gì đó...">
                                        <input id="parentMessageID" name="parentMessageID" type="hidden"/>
                                </div>
                                <div class="send_button col-md-2">
                                    <button name="getFROMandTO" value="${listMess.get(0).fromID};${listMess.get(0).toID}" type="submit" style="border: none;background-color: white"  title="Send"><i class="fa-solid fa-paper-plane"></i></button
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- end mess -->
        <i id="message2" onclick="showMessage()" class="fa-brands fa-facebook-messenger message2" ></i>
    </c:if>
   
        
