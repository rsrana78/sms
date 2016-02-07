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
	$('#team').removeClass('current_page_item');
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
	    <p class="legend-text">Login to your school</p>
	    <input type="text" id="login-user-name" name="username" placeholder="User name or email" maxlength="50"><br><br>
	    <input type="password" id="login-password" name="password" placeholder="Password" autocomplete="off" maxlength="50"><br><br>
	    <input type="checkbox" id="remember" name="remember">Keep me logged in<br><br>
	    <p id="message" class="error-message"></p>
	    <input type="button" id='loginBtn' value="Login" title="Login to the system" onclick="validateLoginUser()"/>
	  </fieldset>
	</form>
</div>

<!-- Login -->
<%@ include file="/includes/footer.jsp"%>