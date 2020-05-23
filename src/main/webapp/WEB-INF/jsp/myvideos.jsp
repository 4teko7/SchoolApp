<jsp:include page="layout.jsp"/>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<link href="../../resources/css/myvideos.css" rel="stylesheet" id="bootstrap-css">
    <h1><span class="blue"><span class="yellow">HOME PAGE</pan></h1><hr>
    
<table class = "container">
<c:if test="${message != null}">
    </div><div style = "" class="alert alert-success">
	<span style = "display:flex; justify-content:center;">${message}</span>
	</div>
	<br>  
</c:if>

</table>

<table class="container" >

<div style = "display: flex; justify-content: center;">



</table>

<form action="/secured/uploadvideo" method="POST" enctype="multipart/form-data">

                <div class="row">
                    <div class="col-md-4">
                        <div class="profile-img">
                        

                             <div class="videoUpload btn btn-lg btn-primary">
                                Upload Photo
                                <input id = "imgInput" type="file" name="file" />
                                
                            </div>
                            
                            
                        </div>
                        <div  class ="col-md-4 col-md-offset-4" style = "display:flex;justify-content: center">
                        <input type="submit" class="profile-edit-btn" name="btnAddMore" value="Save Profile"/>
                    </div>     
                    </div>
  
  		              
  </div>
  
  </form>
<div style="clear; both;"></div> 


<!-- <video width="320" height="240" controls>
  <source src="${video.path }" type="${video.mimeType }">
   <source src="mov_bbb.ogg" type="video/ogg">
</video>  -->
<div class="wrapper">
<h2><strong>Izlemek Icin Cift Tiklayin<span>( 4 )</span></strong></h2>
<div class="cards">
<c:forEach items="${videos}" var="video">
  <div class="card">
  
  <video  controls style=" width:100%;height:100%;margin-left: auto; margin-right: auto; display: block; width:100%">
    <source src="/${video.path}" type="${video.mimeType }">
    
</video>


</div> 
  <div class="card">
  
  <video  controls style=" width:100%;height:100%;margin-left: auto; margin-right: auto; display: block; width:100%">
    <source src="/${video.path}" type="${video.mimeType }">
    
</video>


</div> 

</c:forEach>
</div>
<h2><strong>What's new?</strong></h2>

	

	
<c:forEach items="${videos}" var="video">


	<div class="news">


		<figure class="article">

			<video width="300" height="300" controls style=" margin-left: auto; margin-right: auto; display: block; width:100%">
    <source src="/${video.path}" type="${video.mimeType }">
    
</video>

			

		</figure>

		
	</div>
	</c:forEach>

</div>







					
				