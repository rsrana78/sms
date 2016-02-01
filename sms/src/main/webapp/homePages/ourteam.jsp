<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="/includes/header.jsp"%>
<link href="${pageContext.request.contextPath}/css/team.css" rel="stylesheet" type="text/css" media="screen" />
<!-- Change button class -->
<script>
$(document).ready(function(){
	$('#home').removeClass('current_page_item');
	$('#mission').removeClass('current_page_item');
	$('#schools').removeClass('current_page_item');
	$('#about').removeClass('current_page_item');
	$('#contact').removeClass('current_page_item');
	$('#login').removeClass('current_page_item');
	$('#team').addClass('current_page_item');
});
</script>
<!-- Change button class end-->

<!-- Schools with us -->


<div id="nav">
<!-- This div is for space between header and footer -->
</div>

<div class="page-heading">
	<p>A team of fully qualified and professional skills</p>
</div>

<table id="team-data-table">
	<tbody>
		<tr>
			<td>
				<table id="inner-table">
					<tr><td>Image</td></tr>
					<tr><td>Name</td></tr>
					<tr><td>Designation</td></tr>
					<tr><td>Bio</td></tr>
				</table>
			</td>
			<td>
				<table id="inner-table">
					<tr><td>Image</td></tr>
					<tr><td>Name</td></tr>
					<tr><td>Designation</td></tr>
					<tr><td>Bio</td></tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table id="inner-table">
					<tr><td>Image</td></tr>
					<tr><td>Name</td></tr>
					<tr><td>Designation</td></tr>
					<tr><td>Bio</td></tr>
				</table>
			</td>
			<td>
				<table id="inner-table">
					<tr><td>Image</td></tr>
					<tr><td>Name</td></tr>
					<tr><td>Designation</td></tr>
					<tr><td>Bio</td></tr>
				</table>
			</td>
		</tr>
	</tbody>
</table>


<!-- schools with us -->
<%@ include file="/includes/footer.jsp"%>