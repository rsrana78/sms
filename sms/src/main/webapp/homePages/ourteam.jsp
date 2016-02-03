<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="/includes/header.jsp"%>
<link href="${pageContext.request.contextPath}/css/team.css" rel="stylesheet" type="text/css" media="screen" />
<!-- Change button class -->
<script>
$(document).ready(function(){
	$('#home').removeClass('current_page_item');
	$('#mission').removeClass('current_page_item');
	$('#schools').removeClass('current_page_item');
	$('#about').removeClass('current_page_item');
	$('#contact').removeClass('current_page_item');
	$('#login').removeClass('current_page_item');
	$('#team').addClass('current_page_item');
});
</script>
<!-- Change button class end-->

<!-- Schools with us -->


<div id="nav">
<!-- This div is for space between header and footer -->
</div>

<div class="team-page-heading">
	<p>"A Team Of Highly Qualified And Professionally Skilled People"</p>
</div>

<table id="team-data-table">
	<tbody>
		<tr>
			<td>
				<table id="team-data-table-inner">
					<tr><td><img src="${pageContext.request.contextPath}/images/profilepics/a.png" title="Rana Rashid" alt="Rana Rashid"></td></tr>
					<tr><td><h1>RANA</h1></td></tr>
					<tr><td><hr><h2>Developer</h2></td></tr>
					<tr><td><hr><p>As everybody knows by this time, I don't think the major league baseball players of today can be compared to the old-timers. I think the slider is a nickel curve and I detest hearing the modern sissies moan about how it has ruined batting averages.</p></td></tr>
				</table>
			</td>
			<td>
				<table id="team-data-table-inner">
					<tr><td><img src="${pageContext.request.contextPath}/images/profilepics/a.png" title="Shahid Mehmood" alt="Shahid Mehmood"></td></tr>
					<tr><td><h1>SHADY</h1></td></tr>
					<tr><td><hr><h2>Developer</h2></td></tr>
					<tr><td><hr><p>As everybody knows by this time, I don't think the major league baseball players of today can be compared to the old-timers. I think the slider is a nickel curve and I detest hearing the modern sissies moan about how it has ruined batting averages.</p></td></tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table id="team-data-table-inner">
					<tr><td><img src="${pageContext.request.contextPath}/images/profilepics/a.png" title="Fawad Rafiq" alt="Fawad Rafiq"></td></tr>
					<tr><td><h1>FADI</h1></td></tr>
					<tr><td><hr><h2>Developer</h2></td></tr>
					<tr><td><hr><p>As everybody knows by this time, I don't think the major league baseball players of today can be compared to the old-timers. I think the slider is a nickel curve and I detest hearing the modern sissies moan about how it has ruined batting averages.</p></td></tr>
				</table>
			</td>
			<td>
				<table id="team-data-table-inner">
					<tr><td><img src="${pageContext.request.contextPath}/images/profilepics/a.png" title="Jamil Shehzad" alt="Jamil Shehzad"></td></tr>
					<tr><td><h1>JAY</h1></td></tr>
					<tr><td><hr><h2>FARAG</h2></td></tr>
					<tr><td><hr><p>As everybody knows by this time, I don't think the major league baseball players of today can be compared to the old-timers. I think the slider is a nickel curve and I detest hearing the modern sissies moan about how it has ruined batting averages.</p></td></tr>
				</table>
			</td>
		</tr>
	</tbody>
</table>


<!-- schools with us -->
<%@ include file="/includes/footer.jsp"%>