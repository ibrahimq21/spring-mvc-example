<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Manager</title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<link rel="stylesheet" href="<spring:url value="/resources/css/home.css"/>" type="text/css"/>
	<link rel="stylesheet" href="<spring:url value="/resources/css/bootstrap-select.min.css"/>" type="text/css"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script src="<spring:url value="/resources/js/bootstrap-select.min.js"/>"></script>

</head>
<body>

	<jsp:include page="../views/fragments/header.jsp"></jsp:include>
	
	<div class="container">
		<div class="row">
		
			<%-- <form action="<spring:url value="/project/add"/>" method="post" class="col-md-8 col-md-offset-2"> --%>
			<spring:url value="/project/add" var="formUrl"/>
			<form:form method="POST" action="${formUrl}" modelAttribute="project">
			
				<div class="form-group">
					<label for="project-name">Name</label>
					<form:input path="name" cssClass="form-control" id="project-name"/>
					<form:errors path="name"/>
					<!-- <input type="text" id="project-name" 
							class="form-control" name="name"/> -->
				</div>

				<div class="form-group">
					<label for="project_type">Type</label>
					<form:select path="type" items="${typeOptions }" cssClass="selectpicker"/>
					<!-- <select name="type" class="selectpicker">
						<option></option>
						<option value="single">Single Year</option>
						<option value="multi">Multi-Year</option>
					</select> -->
				</div>
							
				<div class="form-group">
					<label for="sponsor-name">Sponsor Name</label>
					<form:input path="sponsor.name" cssClass="form-control" id="sponsor-name"/>
					<!-- <input id="sponsor" type="text" 
							class="form-control" name="sponsor"/> -->
				</div>
				<div class="form-group">
					<label for="sponsor-phone">Sponsor Phone</label>
					<form:input path="sponsor.phone" cssClass="form-control" id="sponsor-phone"/>
					<!-- <input id="sponsor" type="text" 
							class="form-control" name="sponsor"/> -->
				</div>
				<div class="form-group">
					<label for="sponsor-email">Sponsor Email</label>
					<form:input path="sponsor.email" cssClass="form-control" id="sponsor-email"/>
					<!-- <input id="sponsor" type="text" 
							class="form-control" name="sponsor"/> -->
				</div>
			
				<div class="form-group">
					<label for="funds">Authorized Funds</label>
					<form:input path="authorizedFunds" cssClass="form-control" id="funds"/>
					<!-- <input id="funds" type="text"
						class="form-control" name="authorizedFunds"/> -->
				</div>
			
				<div class="form-group">
					<label for="hours">Authorized Hours</label>
					<form:input path="authorizedHours" cssClass="form-control" id="hours"/>
					<!-- <input id="hours" type="text"
						class="form-control" name="authorizedHours"/> -->
				</div>
				
				<div class="form-group">
					<label for="startDate">Start Date (Julian)</label>
					<form:input id="startDate"
						cssClass="form-control" path="startDate"/>
				</div>
			
				<div class="form-group">
					<label for="project-name">Description</label>
					<form:textarea path="description" cssClass="form-control" id="project-name" rows=""/>
					<form:errors path="description"/>
					<!-- <textarea class="form-control" name="description" rows="3"></textarea> -->
				</div>
				
				<div class="form-group">
					<label for="poc">POC</label>
					<form:input path="pointsOfContact[0]" cssClass="form-control" id="poc"/>
					<!-- <input id="sponsor" type="text" 
							class="form-control" name="sponsor"/> -->
				</div>
				<div class="form-group">
					<label for="poc2">POC2</label>
					<form:input path="pointsOfContact[1]" cssClass="form-control" id="poc2"/>
					<!-- <input id="sponsor" type="text" 
							class="form-control" name="sponsor"/> -->
				</div>
				<div class="form-group">
					<label for="poc3">POC3</label>
					<form:input path="pointsOfContact[2]" cssClass="form-control" id="poc3"/>
				</div>
				
				<div class="form-group">
					<label for="special">Special</label>
					
					<input id="special" name="special" type="checkbox"/>
				</div>
			
				<button type="submit" class="btn btn-default">Submit</button>
	
			</form:form>
			
		</div>
	</div>
</body>
</html>