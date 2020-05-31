<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>ATM tools</title>
</head>

<body>
	<h2>ATM NAP Interface - Test Harness</h2>

	<form:form method="POST" modelAttribute="testaniMVbinder">

		<table>
			<tr>
				<td><spring:message code="lbl_3.tran01"/></td>
				<td><spring:message code="lbl_3.tran07"/></td>
			</tr>
			
			<tr>
				<td><spring:message code="lbl_3.tran02"/></td>
				<td><spring:message code="lbl_3.tran08"/></td>
			</tr>
		
			<tr>
				<td><spring:message code="lbl_3.tran03"/></td>
				<td><spring:message code="lbl_3.tran09"/></td>
			</tr>
			
			<tr>
				<td><spring:message code="lbl_3.tran04"/></td>
				<td><spring:message code="lbl_3.tran10"/></td>
			</tr>
			
			<tr>
				<td><spring:message code="lbl_3.tran05"/></td>
				<td><spring:message code="lbl_3.tran11"/></td>
			</tr>
			
			<tr>
				<td><spring:message code="lbl_3.tran06"/></td>
			</tr>
	
			<tr>
				<td><spring:message code="lbl_3.tranopt"/></td>
				<td><form:select path="tranOpt">
					<form:option value="NONE" label="select tran"/>
					<form:options items="${tranOptList}"/>
					</form:select>
				</td>
			</tr>
			
			<tr>
				<td><spring:message code="lbl_3.cardbrand"/></td>
				<td><form:select path="cardBrand">
					<form:option value="NONE" label="select brand"/>
					<form:options items="${cardBrandList}"/>
					</form:select>
				</td>
			</tr>		
			
			<tr>
				<td><spring:message code="lbl_3.card2process"/></td>
				<td><form:select path="cardToProcess">
					<form:option value="NONE" label="select card"/>
					<form:options items="${cardOptList}"/>
					</form:select>
				</td>
			</tr>
			
			<tr>
				<td></td>
			</tr>
			<tr>
				<spring:message code="lbl_3.submit" var="lblsubmit"/>
              	<td colspan="2"><input type="submit" value="${lblsubmit}"/></td>
            </tr>
			
		</table>
		
	</form:form>
	
</body>
</html>