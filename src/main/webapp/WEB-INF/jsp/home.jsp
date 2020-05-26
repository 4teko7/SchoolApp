<%@page import="com.teko.commercial.utils.CheckRoles"%>
<jsp:include page="layout.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="../../resources/css/home.css" rel="stylesheet" id="bootstrap-css">
    <h1><span class="blue"><span class="yellow">HOME PAGE</pan></h1><hr>
    
<table class = "container">
<c:if test="${message != null}">
    </div><div style = "" class="alert alert-success">
	<span style = "display:flex; justify-content:center;">${message}</span>
	</div>
	<br>  
</c:if>

<c:url var = "myVideos" value="/secured/myvideos">
	<c:param name="user" value="${request.getRemoteUser()}" />
</c:url>



</table>

<table class="container" >

<div style = "display: flex; justify-content: center;">







</table>
<div style="clear; both;"></div> 


<%if (new CheckRoles().hasRole("ROLE ADMIN")) {%>

<div id = "allLinks">
	<a href="/secured/myvideos"><p><span class="bg"></span><span class="base"></span><span class="text">My Videos</span></p></a>
    <a class="white" href="/secured/addvideopage"><p><span class="bg"></span><span class="base"></span><span class="text">Add Video</span></p></a>
    <a class="transparent" href="/chat"><p><span class="bg"></span><span class="base"></span><span class="text">Join Chat</span></p></a>
    </div>



<% } %>

	
				