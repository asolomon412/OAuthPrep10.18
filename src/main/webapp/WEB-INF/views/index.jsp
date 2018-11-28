<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OAuth Prep</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/sketchy/bootstrap.min.css" />
</head>
<body>
<body>
	<%@include file="partials/header.jsp"%>

	
	<p class="message">${ message }</p>

	<p>This is an auth demo.</p>

	<c:if test="${ not empty user }">
		<p>
			Feel free to browse our <a href="/secrets">secrets</a>.
		</p>
	</c:if>
</body>

</body>
</html>