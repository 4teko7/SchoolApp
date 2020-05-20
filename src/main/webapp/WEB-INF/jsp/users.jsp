
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>USER LIST</title>
</head>

<body>
	<div id="wrapper">
		<div id="header">
		<h2> ALL USERS </h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
		
		
		
		<c:forEach items="${users}" var="user">
		
				<c:url var = "deleteLink" value="/users/deleteuser">
					<c:param name="id" value="${user.id}" />
				</c:url>
				<c:url var = "updateLink" value="/users/updateuser">
					<c:param name="id" value="${user.id}" />
				</c:url>
			
			    <table>
				    <theader>
							    <tr>   
						    		  <th>Active</th> 
							          <th>ID</th>   
							          <th>Name</th> 
							          <th>Email</th>
							          <th>Username</th>
							          <th>Password</th>
						       </tr>    
			       </theader>  
					<tbody>        
				    	<tr>    
				    		<td>${user.active}</td>
				             <td>${user.id}</td>  
				         	 <td>${user.name}</td>  
				         	 <td>${user.email}</td>  
				         	 <td>${user.username}</td>  
				         	 <td>${user.password}</td>
				         	 <td><a href="${updateLink}" >Update</a></td>
			    			 <td><a href="${deleteLink}" onclick="if (! (confirm ('Are You Sure ?'))) return false">Delete</a></td>
				         </tr>  
				   </tbody>
			  </table> 
			

			</c:forEach>
			
			
		
		</div>
		
		
			
	</div>
	<br>
				<div style="clear; both;"></div> 
	
				<a href="${pageContext.request.contextPath}/users/adduser">Add User</a>
				<a href="${pageContext.request.contextPath}/users/registration">Registration</a>
				<a href="${pageContext.request.contextPath}/users/login">Login</a>
				<a href="${pageContext.request.contextPath}/todos/todos">Todos</a>
		
</body>
</html>