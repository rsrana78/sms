<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="/includes/header.jsp"%>
<link href="${pageContext.request.contextPath}/css/schooldatatable.css" rel="stylesheet" type="text/css" media="screen" />
<!-- Change button class -->
<script>
$(document).ready(function(){
	$('#home').removeClass('current_page_item');
	$('#mission').removeClass('current_page_item');
	$('#schools').addClass('current_page_item');
	$('#about').removeClass('current_page_item');
	$('#contact').removeClass('current_page_item');
	$('#login').removeClass('current_page_item');
});
</script>
<!-- Change button class end-->

<!-- Schools with us -->


<div id="nav">
<!-- This div is for space between header and footer -->
</div>

<div class="page-heading">
	<p>"Schools who have complete trust on us"</p>
</div>

<table id="school-data-table">
	<thead>
		<tr class="dataTable-header">
			<th>School Name</th>
			<th>Address</th>
			<th>Monogram</th>
			<th>Owner</th>
			<th>Principal</th>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${fn:length(schoolList) > 0}">
				<c:forEach items="${schoolList}" var="school">
					<tr>
						<td><a href="#">${school.schoolName}</a></td>
						<td>${school.address}</td>
						<td><a href="#"><img src="${pageContext.request.contextPath}${school.monogramPath}" title="${school.schoolName}" alt="${school.schoolName}"></a></td>
						<td><a href="#"><img src="${pageContext.request.contextPath}${school.ownerImagePath}" title="${school.ownerName}" alt="${school.ownerName}"></a></td>
						<td><a href="#"><img src="${pageContext.request.contextPath}${school.principalImagePath}" title="${school.principalName}" alt="${school.principalName}"></a></td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td></td>
					<td></td>
					<td>No Schools are registered with us</td>
					<td></td>
					<td></td>
				</tr>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>


<!-- schools with us -->
<%@ include file="/includes/footer.jsp"%>