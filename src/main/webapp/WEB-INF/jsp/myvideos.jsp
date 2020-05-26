<jsp:include page="layout.jsp"/>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<link href="../../resources/css/myvideos.css" rel="stylesheet" id="bootstrap-css">
    <h1><span class="blue"><span class="yellow">HOME PAGE</pan></h1><hr>
<body style = "margin-left:2rem; margin-right:2rem;">
<table class = "container">
<c:if test="${message != null}">
    </div><div style = "" class="alert alert-success">
	<span style = "display:flex; justify-content:center;">${message}</span>
	</div>
	<br>  
</c:if>

</table>

<table class="container" >




</table>


<div style="clear; both;"></div> 
<c:if test="${!videos.isEmpty()}">
<div class="">
<h2><strong>${videos.get(0).user.firstname} ${videos.get(0).user.lastname }</strong></h2>
<div  class="cards">
<c:forEach items="${videos}" var="video">

<div>

  <div class="card">
  
  <video  controls style=" width:100%;height:100%;margin-left: auto; margin-right: auto; display: block; width:100%">
    <source src="/${video.path}" type="${video.mimeType }">
    
</video>

</div>

<div id = "contentOfVideo" class = "parentOfContentOfVideo card">

<div onclick="location.href='/secured/updatevideo?id=${video.id}';" style="cursor:pointer;" class = "childOfContentOfVideo">

<div>
	<h3 style = "margin-left:2rem;">${video.name}</h3><hr>
	<h3 style = "margin-left:1rem;color:red;display:inline;">Subject <h4 style = "margin-left:2rem;">${video.videoSubject}</h4></h3>
	<h3  style = "margin-left:1rem;color:red;display:inline;">Content <h4 style = "margin-left:2rem;">${video.videoContent}</h4></h3>
<br>	
</div>

	</div>
	
	
</div>


</div>

</c:forEach>
</div>

</div>
</c:if>



</body>


					
				