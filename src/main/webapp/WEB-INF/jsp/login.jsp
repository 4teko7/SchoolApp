<jsp:include page="layout.jsp"/>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Log in with your account</title>


  </head>

  <body>

    <div class="container">
    <h3 class="text-center"><a href="${contextPath}/home">Home</a></h3>
      <form method="POST" action="${contextPath}/login" modelAttribute="user" class="form-signin">
        <h2 class="form-heading"><scan style = "font-size:3rem;"><b>Log in</b></scan></h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            
	            <table class = "container">
					<c:if test="${message != null}">
					    </div><div style = "" class="alert alert-success">
						<span style = "display:flex; justify-content:center;">${message}</span>
						</div>
						<br>  
					</c:if>
					
				</table>
            
            
            
            <input name="username" type="text" class="form-control" placeholder="Username"
                   autofocus="true"/>
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
            <h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>
        </div>
      </form>
    </div>

  </body>
</html>
