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
<%ArrayList<Message> MYR = (ArrayList<Message>) request.getAttribute("MYR");%>
<%ArrayList<Message> MYS = (ArrayList<Message>) request.getAttribute("MYS");%>

<c:if test="${sessionScope.role ne sessionScope.roleadmin}">
<div id="mess2" class="message2">
    <i style="font-size: 0"  id="iofmess2" onclick="showMessage()" class="fa-brands fa-facebook-messenger"></i>
</div>
<div id="mess" class="message" style="display: ${admin};display: block">
    <div class="header_message row">
        <div class="col-md-10">

            <%if (MYR != null && MYR.get(0).getToID().equals("1")) {%>  <!--admin rieng SKIP-->


            <a href="home"><h4><b>${usersend}</b></h4></a>
                        <%} else {%>
            <img src="images/logo.png" class="logo" alt="" width="30%">
            <h4><b>Hỗ trợ trực tuyến</b></h4>  <!-- default and user -->
            <%}%>
        </div>
        <div class="col-md-2" >

            <i onclick="hideMessage()" class="fa-solid fa-minus"></i>
        </div>
    </div>
    <div class="content_message" style="display: block;display: ${messageadmin}">
        <br/>
        <img src="images/logo.png" class="logo" alt="" width="70%">

        <h6>Wear your Best - A Moments of Your Style
        </h6>

        <%if (MYR != null && MYS != null) {%><!--1-->

        <%int MYRidx = 0, MYSidx = 0, MYRid = 0, MYSid = 0, MYRidOLD = 0, MYSidOLD = 0;%>
        <%for (int idx = 0; idx < MYS.size() + MYR.size(); idx++) {%><!--2-->
        <% MYRid = Integer.parseInt(MYR.get(MYRidx).getId());%>
        <% MYSid = Integer.parseInt(MYS.get(MYSidx).getId());%>
        <%if (MYRid > MYSid) {%><!--3-->
        <%if (MYRidOLD == MYRid && MYSidOLD == MYSid && MYSidx == MYS.size() - 1) {%>
        <%for (int j = 0; j <= MYR.size(); j++) {%>
        <%if (MYRidx == MYR.size()) {
                break;
            }%>
        <div class="MYR"><p><%=MYR.get(MYRidx++).getContent()%></p></div>
                <%}%>

        <%break;
        } else {%>

        <div class="divMYS">
            <div class="MYS_EMP"></div>
            <div class="MYS"><p><%=MYS.get(MYSidx).getContent()%></p></div></div>

        <%  MYRidOLD = MYRid;
            MYSidOLD = MYSid;
        %>

        <%if (MYSidx + 1 != MYS.size()) {
                MYSidx++;
            }%>
        <%}%>

        <%}%><!--3-->

        <%if (MYRid < MYSid) {%><!--4-->

        <%if (MYRidOLD == MYRid && MYSidOLD == MYSid && MYRidx == MYR.size() - 1) {%>  
        <%for (int j = 0; j <= MYS.size(); j++) {%>
        <%if (MYSidx == MYS.size()) {
                break;
            }%>
        <div class="divMYS">

            <div class="MYS"><p><%=MYS.get(MYSidx++).getContent()%></p></div> </div>  
                    <% }%>

        <%break;
        } else {%>
        
        <div class="MYR"><p><%=MYR.get(MYRidx).getContent()%></p></div>

        <%MYRidOLD = MYRid;
            MYSidOLD = MYSid;%>
        <%if (MYRidx + 1 != MYR.size()) {
                MYRidx++;
            }%>
        <%}%>

        <%}%><!--4-->

        <%}%><!--2-->
        <%}%><!--1-->
        <%if (MYS != null && MYR == null) {%>         <!--trường hợp có mỗi table người dùng gửi tồn tại -->

        <%for (Message mess : MYS) {%>
        <div class="divMYS">
        <div class="MYS"><p><%=mess.getContent()%></p></div> 
        </div>
                <%}%>
                <%}%>    


        <%if (MYS == null && MYR != null) {%>         <!--trường hợp có mỗi table Admin gửi tồn tại -->
        <%for (Message mess : MYR) {%>
        <div class="MYR"><p><%=mess.getContent()%></p></div>     
                <%}%>
                <%}%>

    </div>
    <div id="menumess" class="menu_message">
        <div class="menu_messenger_conponent ">
        <form action="message" method="post">
            <div class="row">
                <div class="send col-md-8">
                <input name="contentsend" type="text" placeholder="Viết gì đó...">
                
            </div>
                <div class="col-md-2"></div>
            <div class="send_button col-md-2">
                <a><i class="fa-solid fa-paper-plane"></i></a>
            </div>
            </div>
        </form>
        </div>
    </div>
</div>
  </c:if> 
<!--chat end-->
