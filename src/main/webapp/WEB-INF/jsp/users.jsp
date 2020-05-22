<jsp:include page="layout.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <h1><span class="blue"><span class="yellow">USERS</pan></h1><hr>

<table class="container" >
<div style = "display: flex; justify-content: center;"><button style = "color:green"  class = "btn btn-info" onclick="window.location.href = '${pageContext.request.contextPath}/registration'">Add User</button>
<%if (request.getRemoteUser() == null) {%><button  class = "btn btn-info" style = "margin-left:3rem; color:green" onclick="window.location.href =  '${pageContext.request.contextPath}/login' ">Login</button><%}%></div>
	<thead>
	
		<tr>
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

<!-- <div style="clear; both;"></div>  -->
					
				