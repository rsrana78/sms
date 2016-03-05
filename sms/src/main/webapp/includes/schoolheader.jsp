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
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/main.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/school.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/css/school.css" rel="stylesheet" type="text/css" media="screen" />
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript">
var context = getContext();
function getContext(){
	return window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
}
</script>
</head>
<body>
<div id="main-header">
<p>${sessionScope['scopedTarget.securityService'].userFullName}:${sessionScope['scopedTarget.securityService'].campusName}</p>
</div>
<div id="header-wrapper">
<div id="header">
	<div id="logo">
		<a href="${pageContext.request.contextPath}/myschool/"><img src="${pageContext.request.contextPath}${sessionScope['scopedTarget.securityService'].logo}" title="${sessionScope['scopedTarget.securityService'].campusName}" alt="${sessionScope['scopedTarget.securityService'].campusName}"></a>
	</div>
	<div id="menu">
		<ul>
			<li id="home"><a href="${pageContext.request.contextPath}/myschool/" title="Go to home page">Home</a></li>
			<li id="employee">
				<a>Employees &#9662;</a>
				<ul class="dropdown">
	                <li><a href="${pageContext.request.contextPath}/myschool/newEmployee" title="Create New Employee">New Employee</a></li>
	                <li><a href="${pageContext.request.contextPath}/myschool/activeEmployees" title="Get List of All Active Employees">Active Employees</a></li>
	                <li><a href="${pageContext.request.contextPath}/myschool/inactiveEmployees" title="Get List of All Terminated Employees">Inactive Employees</a></li>
            	</ul>
			</li>
			<li id="student">
				<a>Students &#9662;</a>
				<ul class="dropdown">
	                <li><a href="#">New Admission</a></li>
	                <li><a href="#">List Students</a></li>
	                <li><a href="#">Fine a Student</a></li>
	                <li><a href="#">Warning a Student</a></li>
	                <li><a href="#">Send Complain Message</a></li>
	                <li><a href="#">Cancel Admission</a></li>
                </ul>
			</li>
			<li id="classes">
				<a>Classes &#9662;</a>
				<ul class="dropdown">
	                <li><a href="#">List All Classes</a></li>
	                <li><a href="#">List All Sections</a></li>
	                <li><a href="#">Start New Class</a></li>
	                <li><a href="#">Start New Section</a></li>
                </ul>
			</li>
			<li id="timetable">
				<a>Time Table &#9662;</a>
				<ul class="dropdown">
	                <li><a href="#">View Time Table</a></li>
	                <li><a href="#">Change Time Table</a></li>
                </ul>
			</li>
			<li id="exam">
				<a>Exams &#9662;</a>
				<ul class="dropdown">
	                <li><a href="#">List Exams</a></li>
	                <li><a href="#">Date Sheet for New Exam</a></li>
	                <li><a href="#">view Date Sheet</a></li>
	                <li><a href="#">Change Date Sheet</a></li>
                </ul>
			</li>
			<li id="tests">
				<a id="tests">Tests &#9662;</a>
				<ul class="dropdown">
	                <li><a href="#">Take New Test</a></li>
	                <li><a href="#">List All Tests</a></li>
	                <li><a href="#">Change Test Date</a></li>
                </ul>
			</li>
			<li id="results">
				<a>Results &#9662;</a>
				<ul class="dropdown">
	                <li><a href="#">Exam Results</a></li>
	                <li><a href="#">Test Results</a></li>
                </ul>
			</li>
			<li id="reports">
				<a>Reports &#9662;</a>
				<ul class="dropdown">
	                <li><a href="#">Teachers Report</a></li>
	                <li><a href="#">Students Report</a></li>
	            </ul>
			</li>
			<li id="account">
				<a>Account &#9662;</a>
				<ul class="dropdown">
	                <li><a href="${pageContext.request.contextPath}/logout/">Logout</a></li>
	                <li><a href="#">Change Password</a></li>
	                <li><a href="#">View Profile</a></li>
	            </ul>
			</li>
		</ul>
	</div>
</div>
</div>
<!-- end #header -->
