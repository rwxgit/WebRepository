<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
	<head>
		<title>ATM tools</title>
	</head>
<body>
	<h2><spring:message code="lbl_2.pageName"/></h2>
	<form:form method="POST" modelAttribute="downloadsMVbinder">
		<table>
			<tr>
				<td><spring:message code="lbl_2.ipAddress"/></td>
				<td><form:input path="ipAddress02"/></td>
				<td><form:errors path="ipAddress02" cssClass="error"/></td>
			</tr>
			
			<tr>
				<td><spring:message code="lbl_2.userName"/></td>
				<td><form:input path="userName02"/></td>
				<td><form:errors path="userName02" cssClass="error"/></td>
			</tr>
			
			<tr>
				<td><spring:message code="lbl_2.password"/></td>
				<td><form:input path="password02"/></td>
				<td><form:errors path="password02" cssClass="error"/></td>
			</tr>
			
			<tr>
				<td><spring:message code="lbl_2.fileName"/></td>
				<td><spring:message code="lbl_2.windowsPath"/></td>
			</tr>	
			
			<tr>
				<td><form:input path="fileName01"/></td>
				<td><form:input path="windowsPath01"/></td>
			</tr>
			
			<tr>
				<td><form:input path="fileName02"/></td>
				<td><form:input path="windowsPath02"/></td>
			</tr>
			
			<tr>
				<td><form:input path="fileName03"/></td>
				<td><form:input path="windowsPath03"/></td>
			</tr>
			
			<tr>
				<td><form:input path="fileName04"/></td>
				<td><form:input path="windowsPath04"/></td>
			</tr>
			
			<tr>
				<td><form:input path="fileName05"/></td>
				<td><form:input path="windowsPath05"/></td>
			</tr>
			
			<tr>
				<td><form:input path="fileName06"/></td>
				<td><form:input path="windowsPath06"/></td>
			</tr>
			
			<tr>
				<td><form:input path="fileName07"/></td>
				<td><form:input path="windowsPath07"/></td>
			</tr>
			
			<tr>
				<td><form:input path="fileName08"/></td>
				<td><form:input path="windowsPath08"/></td>
			</tr>
			
			<tr>
				<td><form:input path="fileName09"/></td>
				<td><form:input path="windowsPath09"/></td>
			</tr>
			
			<tr>
				<td><form:input path="fileName10"/></td>
				<td><form:input path="windowsPath10"/></td>
			</tr>
			
			<tr>
				<spring:message code="lbl_2.submit" var="lblsubmit"/>
              	<td colspan="2"><input type="submit" value="${lblsubmit}"/></td>
            </tr>
            
		</table>
	</form:form>
</body>
</html>