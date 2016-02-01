<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="/includes/header.jsp"%>
<script src="${pageContext.request.contextPath}/js/school.js" type="text/javascript"></script>
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
	$('#team').removeClass('current_page_item');
	getSchools();
});
</script>
<!-- Change button class end-->

<!-- Schools with us -->


<div id="nav">
<!-- This div is for space between header and footer -->
</div>

<div class="page-heading">
	<p>Following school are using this system and making their life easier. This is the best system a school can have ever.
	This system ensures data security using cloud technology and make it accessible around the globe.</p>
</div>

<table id="school-data-table">
	<tbody id="tb-data">
	</tbody>
</table>


<!-- schools with us -->
<%@ include file="/includes/footer.jsp"%>