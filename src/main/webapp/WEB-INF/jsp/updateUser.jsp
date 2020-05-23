<jsp:include page="layout.jsp"/>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
	<title>Update User</title>	
  </head>  
</head>


<body>
	
	
	
	

<%--         <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <input name="username" type="text" class="form-control" placeholder="Username"
                   autofocus="true"/>
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
            <h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>
        </div>
      </form>
    </div> --%>
    
    <div class="container">
			<form:form action="/secured/updateuser" modelAttribute="user" method="POST"  class="form-signin">
			<h2 class="form-heading"><scan style = "font-size:3rem;"><b>Update User</b></scan></h2>
	  			<form:hidden path="id" />
	  			<%-- 
	  					<td>${user.active}</td>
			             <td>${user.id}</td>  
			         	 <td>${user.firstname}</td>
			         	 <td>${user.lastname}</td>  
			         	 <td>${user.username}</td>
			         	 <td>${user.email}</td>  
		         	   	 <td>${user.phone}</td>
		         	   	 <td>${user.school}</td> 
			         	 <td>${user.classNumber}</td> --%>
                 
                  
                  <form:input name="username" path = "firstname" type="text" class="form-control" placeholder="Firstname"/> 
                  <form:input name="username" path = "lastname" type="text" class="form-control" placeholder="Lastname"/> 
                  <form:input name="username" path = "username" type="text" class="form-control" placeholder="Username" autofocus="true"/>
                  <form:input name="password" path = "password" type="password" class="form-control" placeholder="Password"/>
                  <form:input name="passwordConfirm" path = "passwordConfirm" type="password" class="form-control" placeholder="Password Confirm"/>
                  <form:input name="email" path = "email" type="text" class="form-control" placeholder="Email"/>
                  <form:input name="username" path = "phone" type="text" class="form-control" placeholder="Phone"/> 
                  <form:input name="username" path = "school" type="text" class="form-control" placeholder="School"/> 
                  <form:input name="username" path = "classNumber" type="text" class="form-control" placeholder="Class"/> 
                   
                  
                  <input name="makeAdmin" type="radio" value="admin" />Make Admin
                  <input name="makeUser" type="radio" value="user" />Make User
                   <button class="btn btn-lg btn-primary btn-block" type="submit">Save</button>
            		<h4 class="text-center"><a href="${pageContext.request.contextPath}/secured/users/">Go Users</a></h4>
            
            
<%-- 		        <table >    
			         <tr>    
			          <td>Name : </td>   
			          <td><form:input path="name"  /></td>  
			         </tr>    
			         <tr>    
			          <td>Email :</td>    
			          <td><form:input path="email" /></td>  
			         </tr>  
			         
			         <tr>    
			          <td>Password :</td>    
			          <td><form:input path="password" /></td>  
			         </tr>
			         <tr>    
			          <td>Password :</td>    
			          <td><form:input path="passwordConfirm" /></td>  
			         </tr> 
			         
			         <tr>    
			          <td>Username :</td>    
			          <td><form:input path="username" required="required"/></td>  
			         </tr> 
			         <tr>    
			          <td colspan="2"><input type="submit" value="Save" /></td>    
			         </tr>    
		        </table>   --%>  
	       </form:form> 
	       
			<div style="clear; both;"></div>
			
		</div>

		  
	</div>

    
</body>


  <body>

    

    
  </body>
</html>
