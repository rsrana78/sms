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
<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12"></div>
<div class="container col-lg-4 col-md-4 col-sm-4 col-xs-12">
	<div id="logIn-form" class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
	<form method="POST" id="login-form" name="login-form">
	    <p class="legend-text">Login to your school</p>
	    <div class="form-group">
	    <input type="text" class="form-control col-lg-4 col-md-4 col-sm-6 col-xs-6"  id="login-user-name" onblur="loginUserName()" placeholder="Complete Name" maxlength="100"><br><br>
		</div>
		<div class="form-group">
	    <input type="password"  class="col-lg-4 col-md-4 col-sm-6 col-xs-6" id="login-password" name="password" placeholder="Password" autocomplete="off" maxlength="50" onblur="loginUserPassword();" ><br><br>
		</div>
		<p class="clearfix">
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
		    	<input type="checkbox" id="remember" name="remember">Remember me<br><br>
		    </div>
		    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
		    	<a href="#">Forgot Password?</a>
		    </div>
	    </p>
	    <br />
	    <br />
	    <div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
	    <button  type="button" class="btn btn-success right col-md-8" title="Login to the system" onclick="validateLoginUser()">Login</button>
	    </div>
	</form>
	    
  </div> 	
</div>
</div>
<!-- Login validation error message -->
<div class="col-lg-12 col-md-12" id="error_Field">
<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 alert alert-danger" role="alert">
  <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
  <span class="sr-only">Error:</span>
  All fields are required...!
</div>
</div>
<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="loginFoter">
<%@ include file="/includes/footer.jsp"%>
</div>