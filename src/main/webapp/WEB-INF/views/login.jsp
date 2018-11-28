<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cookies</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/sketchy/bootstrap.min.css" />
</head>
<body>
	<!-- This is an include directive and allows us to reuse other files in our pages so we don't have to duplicate code -->
	<%@ include file="partials/header.jsp"%>
	<h1>Login</h1>

	<p class="message">${ message }</p>

	<form action="/login" method="post">
		<p>
			<label for="username">Username:</label> 
			<input id="username" name="username" value="${ param.username }" required minlength="2" />
		</p>
		<p>
			<label for="password">Password:</label> 
			<input id="password" type="password" name="password" required minlength="2" />
		</p>
		<p>
			<button>Submit</button>
		</p>
	</form>

	or

	<p>
		<a
			href="https://github.com/login/oauth/authorize?client_id=6eacafeb98d0f02fc1f7&redirect_uri=http://localhost:8080/result">Sign
			in with GitHub</a>
	</p>
</body>
</html>