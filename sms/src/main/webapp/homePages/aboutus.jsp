<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="/includes/header.jsp"%>
<!-- Change button class -->
<script>
$(document).ready(function(){
	$('#home').removeClass('current_page_item');
	$('#mission').removeClass('current_page_item');
	$('#schools').removeClass('current_page_item');
	$('#about').addClass('current_page_item');
	$('#contact').removeClass('current_page_item');
	$('#login').removeClass('current_page_item');
});
</script>
<!-- Change button class -->

<!-- About us -->

<div id="nav">
<!-- This div is for space between header and footer -->
</div>

<div class="page-heading">
	<p>	
		About us<br>
		We are four toonts<br>
		One day we decided to desigh and develop this system and on next day we started working on it<br>
		So finally this system is complete now.<br>
		Fadi yara Bhabi say ye bhi likhwa day.<br>
		Fit see english ho jo samaj hi na aye :) :D
	</p>
</div>

<!-- About us -->
<%@ include file="/includes/footer.jsp"%>
