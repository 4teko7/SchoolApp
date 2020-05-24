<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<link href="../../resources/css/navbar.css" rel="stylesheet" id="bootstrap-css">

<% request.getClass(); %>
  <div class="row">
  <div class="">
    <div class="profile-bar">
      <div class="contents">
        <img src="https://gravatar.com/avatar/cd62d88a83461e0b1daa8f2fa31c4dcb?s=512&d=https://codepen.io/assets/avatars/user-avatar-512x512-6e240cf350d2f1cc07c2bed234c3a3bb5f1b237023c204c782622e80d6b212ba.png" alt="UserAvatar">
      
      <p class="profile-name">Merhaba, <%= request.getRemoteUser() %></p>
        <p class="profile-description">Seni Aramızda gördüğümüze Sevindik.</p>
        <div class="buttons">
          <ul>
          
          
          	<li>
              <a href="#"><i class="ti-panel"></i><span><button  class = "btn btn-info" style = "margin-left:5%; margin-right:90%; color:green" onclick="window.location.href =  '${pageContext.request.contextPath}/home' ">Home</button></span></a>
            </li>
            
            <li>
              <a href="#"><i class="ti-panel"></i><span><button  class = "btn btn-info" style = "margin-left:3rem; color:green" onclick="window.location.href =  '${pageContext.request.contextPath}/teachers' ">All Teachers</button></span></a>
            </li>
            
            <%if (request.getRemoteUser() != null) {%>
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


<%-- <button style = "margin-left:3rem; color:green"  class = "btn btn-info" onclick="window.location.href = '${pageContext.request.contextPath}/secured/adduser'">Add User</button> --%>








