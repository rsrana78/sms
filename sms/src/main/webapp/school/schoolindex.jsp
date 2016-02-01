<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="/includes/schoolheader.jsp"%>
<!-- Change button class -->
<script>
$(document).ready(function(){
	$('#home').addClass('current_page_item');
	$('#mission').removeClass('current_page_item');
	$('#schools').removeClass('current_page_item');
	$('#about').removeClass('current_page_item');
	$('#contact').removeClass('current_page_item');
	$('#login').removeClass('current_page_item');
	$('#team').removeClass('current_page_item');
});
</script>
<!-- Change button class -->

<div id="nav">
<!-- This div is for space between header and footer -->
</div>
<!-- school main page -->

<%@ include file="/includes/schoolfooter.jsp"%>