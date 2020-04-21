<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
	
	<head>
		<title>ATM Dev Tools</title>
	</head>
	
		<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script> -->
		
		<!-- css setup -->
		
		<spring:url value="/resources/css/jquery-ui.min.css" var="jqueryuiCSS" />
		<spring:url value="/resources/css/style.css" var="styleCSS" />
		
		<link href="${jqueryuiCSS}" rel="stylesheet" />
		<link href="${styleCSS}" rel="stylesheet" />
		
		<!-- javascript setup --> 
		
		<spring:url value="/resources/js/jquery-3.3.1.min.js" var="jqueryJS" />
		<spring:url value="/resources/js/jquery-ui.min.js" var="jqueryuiJS" />
		<spring:url value="/resources/js/mainJS.js" var="mainJS" />
		
		<script src="${jqueryJS}"></script>
		<script src="${jqueryuiJS}"></script>
		<script src="${mainJS}"></script>

		<script>
			$(function() {
				$("#tabs").tabs();
			});
		</script>

<body>
	
		<!-- <div id="javascriptMessage"></div>
		
		<h2 style="color:blue;">Tools Menu</h2> -->

		<div class="wrapper">
			<div class="container">
				<div id="tabs">
					<ul>
	    				<li><a href="downloadfile">Download file from Mainframe</a></li>
	    				<li><a href="downloadfiles">Download files from Mainframe</a></li>
	    				<li><a href="parsetrace">Format trace</a></li>
	    				<li><a href="parselog">Format connex log</a></li>
	    				<li><a href="testani">Test harness - ANI</a></li>
	    				<li><a href="testccni">Test harness - CCNI</a></li>
					</ul>
				</div>
			</div>
		</div>

	<!-- <nav>
	  <ul>
	    <li><a href="downloadfile">Download file from Mainframe server</a></li>
	    <li><a href="downloadfiles">Download multiple files from Mainframe server</a></li>
	    <li><a href="parsetrace">Format trace data</a></li>
	    <li><a href="parselog">Format connex log data</a></li>
	    <li><a href="testani">Test harness for ANI application</a></li>
	    <li><a href="testccni">Test harness for CCNI application</a></li>
	  </ul>
	</nav> -->
	</body>
	
</html>
