
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<jsp:include page="layout.jsp"/>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../../resources/css/userProfile.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>



</head>
<body >

<!------ Include the above in your HEAD tag ---------->
<%if (request.getRemoteUser() != null) {%>
<div class="container emp-profile" >
            <%-- <form method="post"> --%>
            <form:form action="/updateprofile" modelAttribute="user" method="GET">
            	<form:hidden path="id" />
                <div class="row" >
                    <div  class="col-md-4">
                        <div class="profile-img">
                           	   <c:if test="${user.photoPath != null}">
                            		<img src="${user.photoPath}" alt="Profil Photo"/>
                           		</c:if>
	                            <c:if test="${user.photoPath == null}">
	                            	<img src="https://via.placeholder.com/300" alt="Profil Photo"/>
	                            	<div class="file btn btn-lg btn-primary">
                                		 Add a Photo at Edit Profile Section
                            		</div>
	                            </c:if>
                             
                            
                        </div>
                    
                        <div class="profile-work">
                            <p>WORK LINK</p>
                            <a href="">Website Link</a><br/>
                            <a href="">Bootsnipp Profile</a><br/>
                            <a href="">Bootply Profile</a>
                            <p>SKILLS</p>
                            <a href="">Web Designer</a><br/>
                            <a href="">Web Developer</a><br/>
                            <a href="">WordPress</a><br/>
                            <a href="">WooCommerce</a><br/>
                            <a href="">PHP, .Net</a><br/>
                        </div>

                        
                        
                        
                        
                        
                    </div>
                    <div class="col-md-6">
                        <div class="profile-head" >
                                    <h4 class="form-heading"><scan style = "font-size:3rem;"><b>${user.firstname} ${user.lastname}</b></scan></h4>
                                    <h3>
                                        ${user.username}
                                    </h3>
                                    <!-- <p class="proile-rating">RANKINGS : <span>8/10</span></p> -->
                            <ul class="nav nav-tabs" id="myTab" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">About</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">Lectures</a>
                                </li>
                            </ul>
                            
                        </div>
                    
                     
                
                

                    
                    
                    <div class="col-md-12">
                        <div class="tab-content profile-tab" id="myTabContent">
                            <div class="tab-pane show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>User Id</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p/>${user.id}</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Firstname</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${user.firstname }</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Lastname</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${user.lastname }</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Username</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${user.username }</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Email</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${user.email }</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Phone</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${user.phone }</p>
                                            </div>
                                        </div>
                                        
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>School</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${user.school}</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Class</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${user.classNumber }</p>
                                            </div>
                                        </div>
                            </div>
                            <div class="tab-pane " id="profile" role="tabpanel" aria-labelledby="profile-tab">
                            
                             		<div class = "row" style = "">
	                                        <div class = "col-md-12">
		                                        <c:if test="${user.lecturePhotoPath != null}">
					                            	<img style = "width:100%;height:100%;" id = "dersProgramiImg" src="${user.lecturePhotoPath}" alt="Lecture Photo"/>
					                            </c:if>
					                            <c:if test="${user.lecturePhotoPath == null}">
					                            	<img id = "dersProgramiImg" src="https://via.placeholder.com/700" alt="Lecture Photo"/>
					                            </c:if>
			                                 </div>

                                        </div><br>
                                        
                                        
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Experience</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>Expert</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Hourly Rate</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>10$/hr</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Total Projects</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>230</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>English Level</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>Expert</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Availability</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>6 months</p>
                                            </div>
                                        </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <label>Your Bio</label><br/>
                                        <p>Your detail description</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    

              </div>
              		<div class="col-md-2">
                        <div id = "allLinks" ><a id = "editLink" href="#"><p><span class="bg"></span><span class="base"></span><span class="text">Edit Profile</span></p></a>
                        <input id= "editProfileInput" type="submit" style = "display:none;" class="profile-edit-btn" name="btnAddMore" value="Edit Profile"/>
                    </div> 
                    </div>
            </form:form>           
        </div>
<%}%>
</body>

<script type="text/javascript">
/* 	var div = document.getElementById("allLinks");
	var input = document.getElementById("editProfileInput");

	div.onclick = function(){input.click();console.log("IT IS HERE2;")} */


	$('#editLink').click(function(){
		console.log("IT IS HERE;")
	     	$("#editProfileInput").click();
	});
</script>

</html>




