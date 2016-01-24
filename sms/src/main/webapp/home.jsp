<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="/includes/header.jsp"%>
<!-- change button class -->
<script>
$(document).ready(function(){
	$('#home').addClass('current_page_item');
	$('#mission').removeClass('current_page_item');
	$('#schools').removeClass('current_page_item');
	$('#about').removeClass('current_page_item');
	$('#contact').removeClass('current_page_item');
	$('#login').removeClass('current_page_item');
});
</script>
<!-- change button class -->
<!-- Image -->
<div id="home-page-image-div">
<img src="${pageContext.request.contextPath}/images/homepage/city.jpg" alt="School Management" style="width:100%;height:550px;">
</div>
<!-- Image -->
<%@ include file="/includes/footer.jsp"%>
