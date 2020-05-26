<%@page import="com.teko.commercial.utils.CheckRoles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<link href="${contextPath}/resources/css/navbar.css" rel="stylesheet" id="bootstrap-css">

<% request.getClass(); %>


<nav class="nav navInsideNavbarjs">
        <div style = "margin-right:1.5rem; margin-left:1.5rem; margin-bottom:1.5rem;">
            <div class="logo">
                <a href="#"><img alt="" style = "width:6rem;" src="https://www.onlygfx.com/wp-content/uploads/2017/12/grunge-yes-no-icon-1-902x1024.png"></a>
            </div>
            <div id="mainListDiv" class="main_list">
                <ul class="navlinks">
          	<li>
              <a href="${pageContext.request.contextPath}/home"><i class="ti-panel">Home</i></a>
            </li>
            
            <li>
              <a href="${pageContext.request.contextPath}/teachers"><i class="ti-panel">All Teachers</i></a>
            </li>
            
            <%if ((new CheckRoles().hasRole("ROLE ADMIN"))) {%>
            <li>
              <a href="${pageContext.request.contextPath}/secured/users"><i class="ti-panel">Users</i></a>
            </li>
            <%}%>
            
            <%if (request.getRemoteUser() == null) {%>
            <li>
              <a href="${pageContext.request.contextPath}/login"><i class="ti-user">Login</i></a>
            </li>
            <%}%>
            
            <%if (request.getRemoteUser() == null) {%>
            <li>
              <a href="${pageContext.request.contextPath}/registration"><i class="ti-power-off">Register</i></a>
            </li>
            <%}%>
            
            <%if (request.getRemoteUser() != null) {%>
            <li>
              <a href="${pageContext.request.contextPath}/profile"><i class="ti-power-off">My Profile</i></a>
            </li>
            <%}%>
            
            <%if (request.getRemoteUser() != null) {%>
            <li>
              <a href="${pageContext.request.contextPath}/logout"><i class="ti-power-off">Logout</i></a>
            </li>
            <%}%>
          </ul>
            </div>
            <span class="navTrigger">
                <i></i>
                <i></i>
                <i></i>
            </span>
        </div>
    </nav>


<!-- Jquery needed -->

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

    <script src="${contextPath}/resources/js/navbar.js" type="text/javascript"></script>

<!-- Function used to shrink nav bar removing paddings and adding black background -->
    <script>
        $(window).scroll(function() {
            if ($(document).scrollTop() > 50) {
                $('.navInsideNavbarjs').addClass('affix');
                console.log("OK");
            } else {
                $('.navInsideNavbarjs').removeClass('affix');
            }
        });
    </script>
    
    
    
    
 <%--  <div class="row">
  <div class="">
    <div class="profile-bar">
      <div class="contents">
        <img src="https://gravatar.com/avatar/cd62d88a83461e0b1daa8f2fa31c4dcb?s=512&d=https://codepen.io/assets/avatars/user-avatar-512x512-6e240cf350d2f1cc07c2bed234c3a3bb5f1b237023c204c782622e80d6b212ba.png" alt="UserAvatar">
      
      <p class="profile-name">Merhaba,<%if (request.getRemoteUser() != null) {%> <%= request.getRemoteUser() %><%}else{ %> Yolcu<% } %></p>
        <p class="profile-description">Seni Aramızda gördüğümüze Sevindik.</p>
        <div class="buttons">
          <ul>
          
          
          	<li>
              <a href="#"><i class="ti-panel"></i><span><button  class = "btn btn-info" style = "margin-left:5%; margin-right:90%; color:green" onclick="window.location.href =  '${pageContext.request.contextPath}/home' ">Home</button></span></a>
            </li>
            
            <li>
              <a href="#"><i class="ti-panel"></i><span><button  class = "btn btn-info" style = "margin-left:3rem; color:green" onclick="window.location.href =  '${pageContext.request.contextPath}/teachers' ">All Teachers</button></span></a>
            </li>
            
            <%if ((new CheckRoles().hasRole("ROLE ADMIN"))) {%>
            <li>
              <a href="#"><i class="ti-panel"></i><span><button  class = "btn btn-info" style = "margin-left:3rem; color:green" onclick="window.location.href =  '${pageContext.request.contextPath}/secured/users' ">Users</button></span></a>
            </li>
            <%}%>
            
            <%if (request.getRemoteUser() == null) {%>
            <li>
              <a href="#"><i class="ti-user"></i><span> <button  class = "btn btn-info" style = "margin-left:3rem; color:green" onclick="window.location.href =  '${pageContext.request.contextPath}/login' ">Login</button></span></a>
            </li>
            <%}%>
            
            <%if (request.getRemoteUser() == null) {%>
            <li>
              <a href="#"><i class="ti-power-off"></i><span> <button  class = "btn btn-info" style = "margin-left:3rem; color:green" onclick="window.location.href =  '${pageContext.request.contextPath}/registration' ">Register</button></span></a>
            </li>
            <%}%>
            
            <%if (request.getRemoteUser() != null) {%>
            <li>
              <a href="#"><i class="ti-power-off"></i><span><button  class = "btn btn-info" style = "margin-left:3rem; color:green" onclick="window.location.href =  '${pageContext.request.contextPath}/profile' ">My Profile</button></span></a>
            </li>
            <%}%>
            
            <%if (request.getRemoteUser() != null) {%>
            <li>
              <a href="#"><i class="ti-power-off"></i><span><button  class = "btn btn-info" style = "margin-left:3rem; color:green" onclick="window.location.href =  '${pageContext.request.contextPath}/logout' ">Logout</button></span></a>
            </li>
            <%}%>
          </ul>
          
        </div>
      </div>
      
    </div>
  </div>
</div>
 --%>

<%-- <button style = "margin-left:3rem; color:green"  class = "btn btn-info" onclick="window.location.href = '${pageContext.request.contextPath}/secured/adduser'">Add User</button> --%>








