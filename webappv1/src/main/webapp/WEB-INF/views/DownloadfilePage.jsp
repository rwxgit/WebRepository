<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>

<html>
	
	<head>
		<title>ATM Dev Tools</title>
			
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
		<spring:url value="/resources/css/background.css" var="backCSS" />
		<spring:url value="/resources/js/mainJS.js" var="mainJS" />
		<%-- <spring:url value="/resources/js/mainCSS.css" var="mainCSS" /> --%>
		
		<link href="${backCSS}" rel="stylesheet" />
		<script src="${mainJS}"></script>
		<%-- <link href="${mainCSS}" rel="stylesheet" /> --%>
		
   	</head>
	
<body>

	<%-- <div id="javascriptMessage"></div>
	
	<h2 style="color:red;"><spring:message code="lbl_1.pageName"/></h2> --%>

	<!-- <div class="wrapper"> -->
	<!-- 	<div class="container"> -->
			<form:form method="POST" modelAttribute="downloadMVbinder">
				<table>
					<tr>
						<td><spring:message code="lbl_1.ipAddress" /></td>
						<td><form:select path="ipAddress">
								<form:option value="NONE" label="select host" />
								<form:options items="${hostList}" />
							</form:select></td>
						<td><form:errors path="ipAddress" cssClass="error" /></td>
					</tr>

					<tr>
						<td><spring:message code="lbl_1.userName" /></td>
						<td><form:input path="userName" /></td>
						<td><form:errors path="userName" cssClass="error"></form:errors></td>
					</tr>

					<tr>
						<td><spring:message code="lbl_1.password" /></td>
						<td><form:password showPassword="true" path="password" /></td>
						<td><form:errors path="password" cssClass="error"></form:errors></td>
					</tr>

					<tr>
						<td><spring:message code="lbl_1.fileName" /></td>
						<td><form:input path="fileName" /></td>
						<td><form:errors path="fileName" cssClass="error"></form:errors></td>
					</tr>

					<tr>
						<td><spring:message code="lbl_1.windowsPath" /></td>
						<td><form:input path="windowsPath" /></td>
						<td><form:errors path="windowsPath" cssClass="error"></form:errors></td>
					</tr>

					<tr>
						<spring:message code="lbl_1.submit" var="lblsubmit" />
						<td colspan="2"><input type="submit" value="${lblsubmit}" /></td>
					</tr>

					<tr>
						<td><form:errors cssClass="error" /></td>
					</tr>

				</table>
			</form:form>
	<!-- 	</div> -->
	<!-- </div> -->

</body>
</html>
