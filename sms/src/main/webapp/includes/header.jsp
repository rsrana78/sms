<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Cloud Schools</title>
<script src="${pageContext.request.contextPath}/js/jquery-2.2.0.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/main.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript">
var context = getContext();
function getContext(){
	return window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
}
var isUserLoggedIn;
$(document).ready(function(){
	var userName = "${sessionScope['scopedTarget.securityService'].userFullName}";
	isUserLoggedIn = "${sessionScope['scopedTarget.securityService'].isUserLoggedIn}";
	if(isUserLoggedIn == 'true'){
		$("#log-button").text("Logout");
		$("#log-button").attr("href", context+"/logout");
		$("#log-button").attr("title", "Logout from system");
	}
});
</script>
</head>
<body>
<div id="header-wrapper">
	<div id="header">
		<div id="logo">
			<a href="${pageContext.request.contextPath}/"><img src="${pageContext.request.contextPath}/images/logo/logo.png" title="Cloud Schools" alt="Cloud School logo"></a>
		</div>
		<div id="menu">
			<ul>
				<li id="home" class="current_page_item"><a href="${pageContext.request.contextPath}/" title="Go to home page">Home</a></li>
				<li id="mission" class=""><a href="${pageContext.request.contextPath}/ourMission" title="View our mission statement">Our Mission</a></li>
				<li id="schools" class=""><a href="${pageContext.request.contextPath}/ourSchools" title="Check schools working with us">Our Schools</a></li>
				<li id="about" class=""><a href="${pageContext.request.contextPath}/aboutUs" title="About us">About</a></li>
				<li id="contact" class=""><a href="${pageContext.request.contextPath}/contactUs" title="Contact us if you have any query">Contact Us</a></li>
				<li id="login" class=""><a href="${pageContext.request.contextPath}/login" title="Login to your school" id="log-button">Login</a></li>
			</ul>
		</div>
	</div>
</div>
<!-- end #header -->
