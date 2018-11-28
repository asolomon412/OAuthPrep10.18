<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header>
	<a href="/">Home</a>
	<!-- We created this to be able to reuse this in all of our pages! -->
	<span> <c:choose>
			<c:when test="${ not empty user }">

				<a href="/logout">Logout</a>
			</c:when>
			<c:otherwise>
				<a href="/login">Login</a>
			</c:otherwise>
		</c:choose>
	</span> <br> <span> <c:choose>
			<c:when test="${ not empty user }">
				<h1>Hello, ${ user.name }!</h1>
				<img alt="missing" src="${user.avatar_url}" width="100px">
			</c:when>
			<c:otherwise>
				<h1>Welcome!</h1>
			</c:otherwise>
		</c:choose>
	</span>
</header>