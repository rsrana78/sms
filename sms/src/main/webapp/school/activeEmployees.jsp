<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="/includes/schoolheader.jsp"%>
<link href="${pageContext.request.contextPath}/css/empdatatable.css" rel="stylesheet" type="text/css" media="screen" />
<!-- Change button class -->
<script>
$(document).ready(function(){
	
});
</script>
<!-- Change button class -->

<div id="nav">
<!-- This div is for space between header and footer -->
</div>
<!-- Employee Listing page -->
<div class="row">
	<div class="col-md-3 careers_left">
		<div class="clearfix">
				<input type="radio" name="gender" value="Male">Teacher<br>
  				<input type="radio" name="gender" value="Female">Guard<br>
  		</div>
	</div>
	<div class="col-md-9 careers_right">
		<table id="emp-data-table">
			<c:if test="${fn:length(empList) gt 0}">
			<c:forEach items="${empList}" var="emp">
				<tr>
					<td><img src="${pageContext.request.contextPath}${emp.imagePath}" title="${emp.name}" alt="${emp.name}"></td>
					<td>${emp.name}</td>
					<td>${emp.type}</td>
					<td>${emp.cnic}</td>
					<td>${emp.phone}</td>
					<td>${emp.date}</td>
				</tr>
			</c:forEach>
			</c:if>
		</table>
	</div>
</div>
<%@ include file="/includes/schoolfooter.jsp"%>