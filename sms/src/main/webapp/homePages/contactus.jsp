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
	$('#team').removeClass('current_page_item');
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
	    <p class="legend-text">Please fill and submit this form</p>
	    <input id="contact-name" type="text" placeholder="Complete Name" maxlength="100"><br><br>
	    <input id="contact-phone" type="text" maxlength="11" placeholder="Phone number"><br><br>
	    <input id="contact-email" type="text" placeholder="Email for reply" maxlength="100"><br><br>
	    <textarea id="contact-message" name="message" cols="45" rows="15" placeholder="Enter Your Message Here..." maxlength="1000"></textarea><br><br>
	    <div class="error-message">
	    <p id="message"></p>
	    </div>
	    <input type="button" id='submit-contact' value="Submit" onclick="validateContactUser()" title="Send your request"/>
	    <input type="reset" id='submit-reset' value="Reset" title="Reset This Form" style="margin-left: 340px" onclick="reset()"/>
	  </fieldset>
	</form>
</div>

<!-- Contact us -->
<%@ include file="/includes/footer.jsp"%>