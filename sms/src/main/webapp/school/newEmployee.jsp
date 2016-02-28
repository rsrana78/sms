<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="/includes/schoolheader.jsp"%>
<script src="${pageContext.request.contextPath}/js/employee.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/css/employee.css" rel="stylesheet" type="text/css" media="screen" />
<!-- Change button class -->
<script>
$(document).ready(function(){
	
});
</script>
<!-- Change button class -->

<div id="nav">
<!-- This div is for space between header and footer -->
</div>
<!-- new employee regstration screen -->

<div id="employee-form">
	<form method="POST" id="empform" name="empform">
	  <fieldset>
	    <p class="legend-text">New Employee Registration Form</p>
	    <div class="col-lg-5 col-md-5  col-sm-5 col-xs-12">
			<div class="clearfix">
	    	<select name="type" id="type">
				<option value="">Employee Type</option>
	            <c:if test="${fn:length(dto.employeeTypeList) gt 0}">
				<c:forEach items="${dto.employeeTypeList}" var="type">
					<option value="${type.id}">${type.employeeTypeName}</option>
				</c:forEach>
				</c:if>
			</select>
			</div>
		</div>
		<div class="col-lg-5 col-md-5 col-sm-5 col-xs-12">
			<div class="clearfix">
		    <input name="name" id="name" type="text" placeholder="Complete Name" maxlength="100"><br><br>
		    <input name="fatherName" id="father-name" type="text" placeholder="Father Name" maxlength="100"><br><br>
		    <input name="cnic" id="cnic" type="text" maxlength="11" placeholder="13 digit CNIC number" onkeypress='return event.charCode >= 48 && event.charCode <= 57'><br><br>
		    <input name="phone" id="phone" type="text" maxlength="11" placeholder="Phone number" onkeypress='return event.charCode >= 48 && event.charCode <= 57'><br><br>
		    <input name="email" id="email" type="text" placeholder="Email address" maxlength="100"><br><br>
		    <input name="salary" id="salary" type="text" placeholder="Salary" maxlength="10" onkeypress='return event.charCode >= 48 && event.charCode <= 57'><br><br>
		    <div class="clearfix">
			    <select name="qualification" id="qualification">
					<option value="">Qualification</option>
		            <c:if test="${fn:length(dto.qualificationList) gt 0}">
					<c:forEach items="${dto.qualificationList}" var="qua">
						<option value="${qua.id}">${qua.name}</option>
					</c:forEach>
					</c:if>
				</select>
			</div>
		    <textarea name="address" id="address" name="address" cols="45" rows="15" placeholder="Enter Your Complete Address Here..." maxlength="300"></textarea><br><br>
	    	</div>
	    </div>
	    <div class="error-message">
	    <p id="message"></p>
	    </div>
	    <input type="button" id='submit-contact' value="Submit" onclick="validateEmployee()" title="Add New Employee"/>
	    <input type="reset" id='submit-reset' value="Reset" title="Reset This Form" style="margin-left: 340px" onclick="reset()"/>
	  </fieldset>
	</form>
</div>

<%@ include file="/includes/schoolfooter.jsp"%>