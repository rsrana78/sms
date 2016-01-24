<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="/includes/header.jsp"%>
<link href="${pageContext.request.contextPath}/css/contactus.css" rel="stylesheet" type="text/css" media="screen" />
<!-- Change button class -->
<script>
$(document).ready(function(){
	$('#home').removeClass('current_page_item');
	$('#mission').removeClass('current_page_item');
	$('#schools').removeClass('current_page_item');
	$('#about').removeClass('current_page_item');
	$('#contact').addClass('current_page_item');
	$('#login').removeClass('current_page_item');
});
</script>
<!-- Change button class -->

<!-- Contact us -->

<div id="nav">
<!-- This div is for space between header and footer -->
</div>

<!-- <div class="page-heading">
	<p>"Please fill the form below and submit your request"</p>
</div> -->

<div id="contact-form">
	<form>
	  <fieldset>
	    <legend class="legend-text">Please fill the form below and submit your request</legend>
	    Name:<br>
	    <input id="contact-name" type="text" name="name" value="" placeholder="Full Name"><br><br>
	    Phone:<br>
	    <input id="contact-phone" type="text" name="phone" value="" placeholder="Phone"><br><br>
	    Email:<br>
	    <input id="contact-email" type="text" name="email" value="" placeholder="Email"><br><br>
	    Message:<br>
	    <input id="contact-message" type="text" name="message" value="" placeholder="Message"><br><br>
	    <input type="button" id='submit-contact' value="Submit" onclick="contactServer()"/>
	  </fieldset>
	</form>
</div>

<!-- Contact us -->
<%@ include file="/includes/footer.jsp"%>