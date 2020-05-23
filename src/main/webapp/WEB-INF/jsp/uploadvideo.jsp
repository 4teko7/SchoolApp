<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="layout.jsp"/>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../../resources/css/myvideos.css" rel="stylesheet" id="bootstrap-css">
</head>
<body>


<div class="container">
   				 <table class = "container">
					<c:if test="${error != null}">
					    </div><div style = "" class="alert alert-danger">
						<span style = "display:flex; justify-content:center;">${error}</span>
						</div>
						<br>  
					</c:if>
					
				</table>
				
			<form:form action="/secured/uploadvideo" modelAttribute="video" method="POST" enctype="multipart/form-data">
			
	  			<form:hidden path="id" />


					<div class="row" style = "display:flex; justify-content: center; margin-top:2rem;">
                    <div class="col-md-4">
                        <div class="profile-img">
                        
						
                             <div class="videoUpload btn btn-lg btn-primary">
                                Choose Photo
                                <input id = "imgInput" type="file" name="file" />
                                
                            </div>
                            
                            
                            
                            
                        </div>
                        <div  class ="col-md-4 col-md-offset-4" style = "display:flex;justify-content: center">
                    </div>     
                    </div>
  					</div>
                 
                  <br>
                  <form:input name="name" path = "name" type="text" class="form-control" placeholder="Name Of Video"/> 
                  <form:input name="videoContent" path = "videoContent" type="text" class="form-control" placeholder="Content Of Video"/> 
                  <form:input name="videoSubject" path = "videoSubject" type="text" class="form-control" placeholder="Subject Of Video"/> 
                  <%-- <form:input name="username" path = "lastname" type="text" class="form-control" placeholder="Lastname"/> --%> 
<%--                   <form:input name="username" path = "username" type="text" class="form-control" placeholder="Username" autofocus="true"/>
                  <form:input name="password" path = "password" type="password" class="form-control" placeholder="Password"/>
                  <form:input name="passwordConfirm" path = "passwordConfirm" type="password" class="form-control" placeholder="Password Confirm"/>
                  <form:input name="email" path = "email" type="text" class="form-control" placeholder="Email"/>
                  <form:input name="username" path = "phone" type="text" class="form-control" placeholder="Phone"/> 
                  <form:input name="username" path = "school" type="text" class="form-control" placeholder="School"/> 
                  <form:input name="username" path = "classNumber" type="text" class="form-control" placeholder="Class"/>  --%>
                   
                  
<!--                   <input name="makeAdmin" type="radio" value="admin" />Make Admin
                  <input name="makeUser" type="radio" value="user" />Make User -->
                   <button class="btn btn-lg btn-primary btn-block" type="submit">Save</button>
            		<h4 class="text-center"><a href="${pageContext.request.contextPath}/secured/myvideos">Go My Videos</a></h4>
            
  
	       </form:form> 
	       
			<div style="clear; both;"></div>
			
		</div>
		
		
		



                
  




  
  
  
</body>
</html>