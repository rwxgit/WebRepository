<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>

<html>
	
	<head>
		
		<title>ATM Dev Tools</title>
		
		<!-- css setup -->
		
		<spring:url value="css/jquery-ui.min.css" var="jqueryuiCSS" />
		<spring:url value="css/style.css" var="styleCSS" />
		<spring:url value="css/topnav1.css" var="topnav" />
		
		<link href="${jqueryuiCSS}" rel="stylesheet" />
		<link href="${styleCSS}" rel="stylesheet" />
		<link href="${topnav}" rel="stylesheet" />
		
		<!-- javascript setup --> 
		
		<spring:url value="js/jquery-3.3.1.min.js" var="jqueryJS" />
		<spring:url value="js/jquery-ui.min.js" var="jqueryuiJS" />
		<spring:url value="js/mainJS.js" var="mainJS" />
		
		<script src="${jqueryJS}"></script>
		<script src="${jqueryuiJS}"></script>
		<script src="${mainJS}"></script>
		
   	</head>


<body>
	<!-- Navigation setup - Start -->
	<div id="nav-placeholder"></div>

			<%@ include file="nav1.jsp" %>
			
	<!-- Navigation setup - End -->

	<div class="wrapper">
		<div class="container">
			<div class="container_home">
				<h2>Test portal to consume a web API</h2>
				<h3>functionality to be integrated in a week</h3>
			</div>
		</div>
	</div></body>
</html>