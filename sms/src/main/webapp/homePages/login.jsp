<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="/includes/header.jsp"%>
<script src="${pageContext.request.contextPath}/js/login.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css" media="screen" />
<!-- Change button class -->
<script>
$(document).ready(function(){
	$('#home').removeClass('current_page_item');
	$('#mission').removeClass('current_page_item');
	$('#schools').removeClass('current_page_item');
	$('#about').removeClass('current_page_item');
	$('#contact').removeClass('current_page_item');
	$('#login').addClass('current_page_item');
});
</script>
<!-- Change button class -->

<div id="nav">
<!-- This div is for space between header and footer -->
</div>

<!-- Login -->

<!-- <div class="page-heading">
	<p>"Please login to get access to your school"</p>
</div> -->

<div id="login-form">
	<form method="POST" id="login-form" name="login-form">
	  <fieldset>
	    <legend class="legend-text">Please login to get access to your school</legend>
	    <div class="error-message">
	    <p id="message"></p>
	    </div>
	    User Name<br>
	    <input type="text" id="login-user-name" name="username" required><br><br>
	    Password<br>
	    <input type="password" id="login-password" name="password"  autocomplete="off" required><br><br>
	    <input type="button" id='loginBtn' value="Login" onclick="validateLoginUser()"/>
	  </fieldset>
	</form>
</div>

<!-- Login -->
<%@ include file="/includes/footer.jsp"%>