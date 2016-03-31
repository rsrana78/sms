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
<!-- new employee registration screen -->

<div class="container">
	<form method="POST" id="empform" name="empform">
	  <fieldset>
	  	<div class="col-lg-12 col-md-12  col-sm-12 col-xs-12 text-center">  
		  	<h2>New Employee Registration Form</h2>
		</div>  
	    <div class="col-lg-6 col-md-6  col-sm-6 col-xs-12">
			<div class="clearfix">
	    	<select name="empType" id="type" class="selectpicker">
				<option value="">Employee Type</option>
	            <c:if test="${fn:length(dto.employeeTypeList) gt 0}">
				<c:forEach items="${dto.employeeTypeList}" var="type">
					<option value="${type.id}">${type.employeeTypeName}</option>
				</c:forEach>
				</c:if>
			</select>
			</div>
			<div class="clearfix">
				<input name="name" id="name" type="text" placeholder="Complete Name" maxlength="100"><br><br>
		    </div>
			<div class="clearfix">
				<input name="fatherName" id="father-name" type="text" placeholder="Father Name" maxlength="100"><br><br>
			</div>
			<div class="clearfix">
				<input name="cnic" id="cnic" type="text" maxlength="13" placeholder="CNIC number" onkeypress='return event.charCode >= 48 && event.charCode <= 57 || event.keyCode === event.DOM_VK_BACK_SPACE || event.keyCode === event.DOM_VK_DELETE'><br><br>
			</div>
			<div class="clearfix">
				<input name="phone" id="phone" type="text" maxlength="11" placeholder="Phone number" onkeypress='return event.charCode >= 48 && event.charCode <= 57 || event.keyCode === event.DOM_VK_BACK_SPACE || event.keyCode === event.DOM_VK_DELETE'><br><br>
			</div>
			<div class="clearfix">
				<input type="radio" name="gender" value="Male"> Male<br>
  				<input type="radio" name="gender" value="Female"> Female<br>
  			</div>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
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
			<div class="clearfix">
		    	<input name="salary" id="salary" type="text" placeholder="Salary" maxlength="6" onkeypress='return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 8'><br><br>
		    </div>
		    <div class="clearfix">
		    	<input name="email" id="email" type="text" placeholder="Email address" maxlength="100"><br><br>
			</div>
			<div class="clearfix">
		    	<textarea name="address" id="address" name="address" cols="45" rows="15" placeholder="Complete Address..." maxlength="300"></textarea><br><br>
	    	</div>
	    	<div class="ajax-file-upload" style="position: relative; overflow: hidden; cursor: default;">Profile Picture
	    		<form method="POST" action="/SMS/saveFiles" enctype="multipart/form-data" style="margin: 0px; padding: 0px;">
	    			<input type="file" id="ajax-upload-id-1459313674345" name="file[]" accept="*" style="position: absolute; cursor: pointer; top: 0px; width: 100%; height: 100%; left: 0px; opacity: 0;"/>
	    		</form>
	    	</div>
	    </div>
	    <div class="col-lg-12 col-md-12  col-sm-12 col-xs-12">
		    <div class="col-md-6">
				<input type="button" id='submit-contact' value="Submit" onclick="validateEmployee()" title="Add New Employee"/>
			</div>
			<div class="col-md-6">
				<input type="reset" id='submit-reset' value="Reset" title="Reset This Form" style="margin-left: 340px" onclick="reset()"/>
			</div>
		</div>
	    <div class="error-message">
	    	<p id="message"></p>
	    </div>
	  </fieldset>
	</form>
</div>

<%@ include file="/includes/schoolfooter.jsp"%>