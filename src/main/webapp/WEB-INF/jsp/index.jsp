<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
<title>TemaVip</title>
<link rel="stylesheet" href="/css/main.css" />
</head>
<body background="18.jpg"
	style="background-position: center; background-repeat: no-repeat; background-size: cover;">
	<noscript>
		<h2>Sorry! Your browser doesn't support Javascript</h2>
	</noscript>


	<div id="username-page">
		<div class="username-page-container">
			<h1 class="title">Welcome, Group Chat</h1>
			<form id="usernameForm" name="usernameForm">
				<div class="form-group">
					<input type="text" id="name" placeholder="Username"
						autocomplete="off" class="form-control" value = "${user.firstname } ${user.lastname }" readonly />
				</div>
				<div class="form-group">
					<button type="submit" class="accent username-submit">Start
						Chatting</button>
				</div>
			</form>
		</div>
	</div>

		
		
	<div  id="chat-page" class="hidden">
		<li style = "display:absolute;">
		   <a href="${pageContext.request.contextPath}/home"><i class="ti-panel"></i><span><button  class = "btn btn-info" style = "margin-top:2rem;margin-left:5%; margin-right:90%; color:green" onclick="window.location.href =  '${pageContext.request.contextPath}/home' ">Home</button></span></a>
		 </li>
		<div class="chat-container">
			
			<div  class="chat-header">
			
				<h2>TemaVip Professyonel Hocalara Soru Sor</h2>
			</div>
			<div class="connecting">Connecting...</div>
			<ul id="messageArea">

			</ul>
			<form id="messageForm" name="messageForm" nameForm="messageForm">
				<div class="form-group">
					<div class="input-group clearfix">
						<input type="text" id="message" placeholder="Type a message..."
							autocomplete="off" class="form-control" />
						<button type="submit" class="primary">Send</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	
	
	<input id = "usernameOfUser" style = "display:none;" value = "${user.firstname } ${user.lastname }" readonly />
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.4/sockjs.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
	<script src="/js/main.js"></script>
</body>
</html>