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
 <a href ="/secured/myvideos">
<div class="col-md-4">
        <div class="videoUpload btn btn-lg btn-danger">
            My Videos
            
    </div>
    
</div>
</a>


 <a href ="/secured/addvideopage">
<div class="col-md-4">
        <div class="videoUpload btn btn-lg btn-danger">
            Add Video
            
    </div>
    
</div>
</a>


 <a href ="/chat">
<div class="col-md-4">
        <div class="videoUpload btn btn-lg btn-danger">
            Join Chat
            
    </div>
    
</div>
</a>

<% } %>



					
				