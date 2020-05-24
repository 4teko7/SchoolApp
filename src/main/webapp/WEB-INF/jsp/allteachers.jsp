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
			<th><h1>Image</h1></th>
			<th><h1 style = "margin-right:1rem;">Firstname</h1></th>
			<th><h1 style = "margin-right:1rem;">Lastname</h1></th>
			<th><h1>Username</h1></th>
			<th><h1>Email</h1></th>
			<th><h1>Phone</h1></th>
			<th><h1>Videos</h1></th>
		</tr>
	</thead>
	
	<tbody>  
		<c:forEach items="${users}" var="user">
		<c:url var = "videosLink" value="/teachervideo">
					<c:param name="id" value="${user.id}" />
				</c:url>
			    	<tr>    
			    		<td><img src="/${user.photoPath}" alt="Profil Photo" style="width:10rem; height:10rem;"/></td>
			         	 <td>${user.firstname}</td>
			         	 <td>${user.lastname}</td>  
			         	 <td>${user.username}</td>
			         	 <td>${user.email}</td>  
		         	   	 <td>${user.phone}</td>
		         	   	 <td><a style = "color:green" href="${videosLink}" >Videos</a></td>
			         </tr>  
				   

			</c:forEach>
			</tbody>
</table>

				