<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="/includes/header.jsp"%>
<!-- Change button class -->
<script>
$(document).ready(function(){
	$('#home').removeClass('current_page_item');
	$('#mission').addClass('current_page_item');
	$('#schools').removeClass('current_page_item');
	$('#about').removeClass('current_page_item');
	$('#contact').removeClass('current_page_item');
	$('#login').removeClass('current_page_item');
	$('#team').removeClass('current_page_item');
});
</script>
<!-- Change button class -->

<!-- Mission Statement -->

<div id="nav">
<!-- This div is for space between header and footer -->
</div>

<div class="page-heading">
	<p>"Cloud Schools Mission Statement"</p>
</div>

<div class="mission-statement">
	<p>	
		Our Mission Statement<br>
		This will be added later<br>
		This will also be added later :) :D
	</p>
</div>
<!-- Mission Statement -->
<%@ include file="/includes/footer.jsp"%>
