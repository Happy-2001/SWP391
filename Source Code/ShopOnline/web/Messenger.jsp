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
        <div class="card message">
            <div class="card-header">
                <div class="row">
                    <div class="col-lg-10 col-md-10">            
                        <img src="images/logo.png" class="logo" width="50%">
                    </div>
                    <div class="col-lg-2 col-md-2 text-center">
                        <a href="#mess" data-bs-toggle="collapse">
                            <i class="fa-solid fa-minus"></i>
                        </a>
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
                                        <div class="divMYR">
                                            <i onclick="replyMessageR(${mess.id})" class="fa-solid fa-reply" title="reply"></i>
                                            <div class="MYR" title="${mess.createDate}">
                                                ${mess.content}
                                            </div>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="divMYS">
                                            <c:if test="${mess.isread eq 1}">
                                                <span style="margin-left: 5px" class="small text-muted checkIsread"><i class="fa-solid fa-circle-check" style="color:#BBB "></i></span>
                                                </c:if>
                                                   
                                                <div class="MYS" title="${mess.createDate}">
                                                ${mess.content}
                                            </div>
                                            <i onclick="replyMessageS(${mess.id})" class="fa-solid fa-reply" title="reply"></i>
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
                                Answering myself<br>
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
</c:if>
    <script>
        function replyMessageS(id){
            document.getElementById('replyMessR').style.height ='0';
            document.getElementById('replyMessR').style.width ='0';
            document.getElementById('replyMessS').style.height ='100%';
            document.getElementById('replyMessS').style.width ='100%';
            document.getElementById('contentParentS').innerHTML =id;
        }
        function removeReplyS(){
            document.getElementById('replyMessS').style.height ='0';
            document.getElementById('replyMessS').style.width ='0';
        }
        function replyMessageR(id){
            document.getElementById('replyMessS').style.height ='0';
            document.getElementById('replyMessS').style.width ='0';
            document.getElementById('replyMessR').style.height ='100%';
            document.getElementById('replyMessR').style.width ='100%';
            document.getElementById('contentParentR').innerHTML =id;
        }
        function removeReplyR(){
            document.getElementById('replyMessR').style.height ='0';
            document.getElementById('replyMessR').style.width ='0';
        }
    </script>
<button id="messenger-btn" data-bs-toggle="collapse" data-bs-target="#mess"><i class="fa-brands fa-facebook-messenger"></i></button>
