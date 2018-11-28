<%@page import="java.util.Random"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Counter Page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/sketchy/bootstrap.min.css" />
</head>
<body>
	<%@include file="partials/header.jsp" %>
	<h1>Psssssst...</h1>
	
	<p>If you made it here, you must be logged in. Congratulations here's your reward...</p>
	
	<p class="secret"><%=
		Arrays.asList("Chuck Norris can kill two stones with one bird.",
				"Giraffes were created when Chuck Norris uppercutted a horse.",
				"Chuck Norris beat the sun in a staring contest.",
				"Chuck Norris is the reason Waldo is hiding.",
				"Chuck Norris makes onions cry.",
				"Chuck Norris can rub two pieces of fire together and make wood.")
		.get(new Random().nextInt(6))
	%></p>
</body>
</html>