<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="/includes/header.jsp"%>
<script src="${pageContext.request.contextPath}/js/contact.js" type="text/javascript"></script>
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
	    <div id="error-message">
	    <p id="message"></p>
	    </div>
	    Name<br>
	    <input id="contact-name" type="text" name="name" value="" required><br><br>
	    Phone<br>
	    <input id="contact-phone" type="text" name="phone" value="" required><br><br>
	    Email<br>
	    <input id="contact-email" type="text" name="email" value="" required><br><br>
	    Message<br>
	    <textarea id="contact-message" name="message" cols="50" rows="5" placeholder="Enter Your Message Here..." required></textarea><br><br>
	    <input type="button" id='submit-contact' value="Submit" onclick="validateContactUser()"/>
	  </fieldset>
	</form>
</div>

<!-- Contact us -->
<%@ include file="/includes/footer.jsp"%>