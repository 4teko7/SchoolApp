<jsp:include page="layout.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="../../resources/css/home.css" rel="stylesheet" id="bootstrap-css">
    <h1><span class="blue"><span class="yellow">HOME PAGE</pan></h1><hr>
    
<table class = "container">
<c:if test="${message != null}">
    </div><div style = "" class="alert alert-success">
	<span style = "display:flex; justify-content:center;">${message}</span>
	</div>
	<br>  
</c:if>

<c:url var = "myVideos" value="/secured/myvideos">
	<c:param name="user" value="${request.getRemoteUser()}" />
</c:url>



</table>

<table class="container" >

<div style = "display: flex; justify-content: center;">

<%-- <%if (request.getRemoteUser() == null) {%>
	 <li>
	   <a href="#"><i class="ti-user"></i><span> <button  class = "btn btn-info" style = "margin-left:3rem; color:green" onclick="window.location.href =  '${pageContext.request.contextPath}/login' ">Upload Video</button></span></a>
	 </li>
<%}%> --%>
           

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








</table>
<div style="clear; both;"></div> 
 <a href ="/secured/myvideos">
<div class="col-md-4">
        <div class="videoUpload btn btn-lg btn-danger">
            My Videos
            
    </div>
</div>
</a>








					
				