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
<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12"></div>
<div class="container col-lg-6 col-md-6 col-sm-6 col-xs-12">
	<div id="contact-form" class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
	<form>
	    <p class="legend-text">Please fill and submit this form</p>
	    <div class="form-group">
	    <input id="contact-name" type="text" class="form-control col-lg-4 col-md-4 col-sm-6 col-xs-6" onblur="nameOfUser()" placeholder="Complete Name" maxlength="100"><br><br>
		</div>
		<div class="form-group">
	    <input id="contact-phone" type="text" class="col-lg-4 col-md-4 col-sm-6 col-xs-6"  maxlength="11" onblur="phoneOfUser()" placeholder="Phone number" onkeypress='return event.charCode >= 48 && event.charCode <= 57 || event.keyCode === event.DOM_VK_BACK_SPACE || event.keyCode === event.DOM_VK_DELETE'><br><br>
		</div>
		<div class="form-group">	   
	    <input id="contact-email" type="text" class="col-lg-4 col-md-4 col-sm-6 col-xs-6" onblur="emailOfUser()" placeholder="Email for reply" maxlength="100"><br><br>
		</div>
		<div class="form-group">   
	    <textarea id="contact-message" class="col-lg-12 col-md-12 col-sm-12 col-xs-12" name="message" cols="45" rows="15"  onblur="messageOfUser()" placeholder="Enter Your Message Here...Atleast 50 Characters" maxlength="1000"></textarea><br /><br />
	    </div>
	    <div class="error-message col-lg-12 col-md-12 col-sm-12 col-xs-12">
	    <p id="message"></p>
	    </div>
	    
	    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="btn_contacts">
	    <button class="btn btn-success" id='submit-contact' type="button" onclick="validateContactUser()" title="Send your request">Submit</button>
	    <button class="btn btn-danger" id='submit-reset' type="button" title="Reset This Form" onclick="reset()">Reset</button>
	    </div>
	    
	</form>
	    
  </div> 	
</div>
</div>
<div class="col-lg-12 col-md-12" id="error_Field">
<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 alert alert-danger" role="alert">
  <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
  <span class="sr-only">Error:</span>
  All fields are required...!
</div>
</div>

<!-- Contact us -->
<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="contactUsFoter">
<%@ include file="/includes/footer.jsp"%>
</div>