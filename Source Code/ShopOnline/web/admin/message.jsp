<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="model.Message"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="group-chat" id="chat"  style="display: none;">
                        <div class="grouplist" >

                            <div class="listCusMess">
                                <ul>
                                    <li><div><h8>All Chats</h8></div></li>
                                    <li><div><h8>Settings</h8></div></li>

                                </ul>
                                <div class="t-search " style="margin-bottom: 20px">
                                    <form action="action">
                                        <div class="search-box search_user" style=" width: 400px;">
                                            <input type="text" placeholder="Search..." >
                                            <i class="fa-solid fa-magnifying-glass fa-sm icon"></i>
                                        </div>
                                    </form>
                                </div>
                                <div class="group-chat-detail">
                                    <c:forEach items="${listGroupChat}" var="lgc">
                                        <div class="Customer_chat_group">

                                            <div class="Customer_chat_group_left">
                                                <h6>${lgc.name}</h6>
                                                <h8>${lgc.content}</h8>
                                            </div>
                                            <div class="Customer_chat_group_right">
                                                <h4>...</h4>
                                                
                                                <jsp:useBean id="now" class="java.util.Date" />
                                                <fmt:formatDate var="time" value="${now}" pattern="yyyy-MM-dd HH:mm:ss" />
                                                
                                                                                                
                                                <fmt:parseDate var="time2" value="${lgc.time}" pattern="yyyy-MM-dd HH:mm:ss" />
                                                <fmt:formatDate var="time3" value="${time2}" pattern="yyyy-MM-dd HH:mm:ss" />
                                                <c:choose>
                                                    <c:when test="${0 eq 0}">
                                                        <p>${time}</p>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <p>${time}</p>
                                                    </c:otherwise>
                                                </c:choose>
                                                <h8>${time3}</h8>
                                                <h8>${time2}</h8>
                                            </div>
                                        </div>
                                    </c:forEach>

                                    <c:forEach items="${listGroupChat}" var="lgc">
                                        <div class="Customer_chat_group">

                                            <div class="Customer_chat_group_left">
                                                <h6>${lgc.name}</h6>
                                                <h8>${lgc.content}</h8>
                                            </div>
                                            <div class="Customer_chat_group_right">
                                                <h4>...</h4>
                                                <h8>${lgc.time}</h8>
                                            </div>
                                        </div>
                                    </c:forEach>

                                    <c:forEach items="${listGroupChat}" var="lgc">
                                        <div class="Customer_chat_group">

                                            <div class="Customer_chat_group_left">
                                                <h6>${lgc.name}</h6>
                                                <h8>${lgc.content}</h8>
                                            </div>
                                            <div class="Customer_chat_group_right">
                                                <h4>...</h4>
                                                <h8>${lgc.time}</h8>
                                            </div>
                                        </div>
                                    </c:forEach>

                                </div>

                            </div>

                        </div>
                        <div class="contentChat-buttonChat">
                            <div class="contentChat">
                                <c:forEach items="${listMess}" var="mess">
                                    <c:choose>
                                        <c:when test="${listUserAdminID.contains(mess.fromID)}">
                                            <div class="divMYS">
                                                <div class="MYS">
                                                    <p>${mess.content}</p>
                                                </div>
                                            </div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="divMYR">
                                                <div class="MYR">
                                                    <p>${mess.content}</p>
                                                </div>
                                            </div>
                                        </c:otherwise>

                                    </c:choose>
                                </c:forEach>

                            </div>
                            <div class=" card-footer">
                                <div class="buttonChat">
                                    <form action="message" method="post">
                                        <div class="row align-items-center">
                                            <div class="send col-md-10">
                                                <input name="contentsend" type="text" placeholder="Viết gì đó...">
                                            </div>
                                            <div class="send_button col-md-2">
                                                <button name="getFROMandTO" value="${listMess.get(0).fromID};${listMess.get(0).toID}" type="submit"><i class="fa-solid fa-paper-plane fa-lg"></i></button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>

                    </div>