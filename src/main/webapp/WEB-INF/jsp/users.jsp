<jsp:include page="layout.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <h1><span class="blue"><span class="yellow">USERS</pan></h1><hr>
<body style = "margin-left:2rem; margin-right:2rem;">
<div style = "overflow: auto; margin-bottom:2rem;" >
<table style = "overflow: auto;"cellspacing="10" cellpadding="0" border="0" width="340" class="container">
<div id = "allLinks" ><a href="${pageContext.request.contextPath}/registration"><p><span class="bg"></span><span class="base"></span><span class="text">Add User</span></p></a> 
<%if (request.getRemoteUser() == null) {%><a class="white" href="${pageContext.request.contextPath}/login"><p><span class="bg"></span><span class="base"></span><span class="text">Login</span></p></a>  <%}%></div>
	<thead>
	
		<tr>
			<th><h1>Image</h1></th>
			<th><h1>Active</h1></th>
			<th><h1 style = "margin-right:2rem;">ID</h1></th>
			<th><h1 style = "margin-right:1rem;">Firstname</h1></th>
			<th><h1 style = "margin-right:1rem;">Lastname</h1></th>
			<th><h1>Username</h1></th>
			<th><h1>Email</h1></th>
			<th><h1>Phone</h1></th>
			<th><h1>School</h1></th>
			<th><h1>Class</h1></th>
			<th><h1 style = "margin-right:2rem;">Update</h1></th>
			<th><h1 style = "margin-right:2rem;">Delete</h1></th>
		</tr>
	</thead>
	
	<tbody>  
		<c:forEach items="${users}" var="user">
		
				<c:url var = "deleteLink" value="/secured/deleteuser">
					<c:param name="id" value="${user.id}" />
				</c:url>
				<c:url var = "updateLink" value="/secured/updateuser">
					<c:param name="id" value="${user.id}" />
				</c:url>
			
			    
					

			    	<tr>    
			    		<td><img src="/${user.photoPath}" alt="Profil Photo" style="width:10rem; height:10rem;"/></td>
			             <td>${user.active}</td>
			             <td>${user.id}</td>  
			         	 <td>${user.firstname}</td>
			         	 <td>${user.lastname}</td>  
			         	 <td>${user.username}</td>
			         	 <td>${user.email}</td>  
		         	   	 <td>${user.phone}</td>
		         	   	 <td>${user.school}</td> 
			         	 <td>${user.classNumber}</td>
			         	 <td><a style = "color:green" href="${updateLink}" >Update</a></td>
		    			 <td><a style = "color:red" href="${deleteLink}" onclick="if (! (confirm ('Are You Sure ?'))) return false">Delete</a></td>
			         </tr>  
				   

			</c:forEach>
			</tbody>
</table>
</div>
</body><br>
<!-- <div style="clear; both;"></div>  -->
					
				