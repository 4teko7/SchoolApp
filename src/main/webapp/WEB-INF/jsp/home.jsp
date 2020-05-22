
<jsp:include page="layout.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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


<%--
	CHECKS AUTHENTICATIONS


 <sec:authorize access="isAnonymous()">
    <form method="POST" action="<c:url value='j_spring_security_check'/>">
        Username: <input name="j_username" type="text" value="${SPRING_SECURITY_LAST_USERNAME}" /> 
        Password: <input name="j_password" type="password" /> 
        <input type="submit" value="Sign in" />
    </form>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <a href="<c:url value="/j_spring_security_logout" />">Logout</a>
</sec:authorize> --%>



<%if (request.getRemoteUser() != null) {%><button  class = "btn btn-info" style = "margin-left:3rem; color:green" onclick="window.location.href =  '${pageContext.request.contextPath}/secured/users' ">Users</button><%}%>
<%-- <button style = "margin-left:3rem; color:green"  class = "btn btn-info" onclick="window.location.href = '${pageContext.request.contextPath}/secured/adduser'">Add User</button> --%>
<%if (request.getRemoteUser() == null) {%> <button  class = "btn btn-info" style = "margin-left:3rem; color:green" onclick="window.location.href =  '${pageContext.request.contextPath}/login' ">Login</button><%}%>
<%if (request.getRemoteUser() == null) {%> <button  class = "btn btn-info" style = "margin-left:3rem; color:green" onclick="window.location.href =  '${pageContext.request.contextPath}/registration' ">Register</button><%}%>
<%if (request.getRemoteUser() != null) {%><button  class = "btn btn-info" style = "margin-left:3rem; color:green" onclick="window.location.href =  '${pageContext.request.contextPath}/logout' ">Logout</button></div><%}%>



</table>
<div style="clear; both;"></div> 
					
				