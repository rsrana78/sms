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
<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
<div class="container">
  <p class="clearfix">
  <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 team-page-heading">
	<p>"A Team Of Highly Qualified And Professionally Skilled People"</p>
  </div>
  </p><br /> <br />
 <div class="co-lg-6 col-md-6 col-sm-6 col-xs-12 teamMemberBox" >
   <div class="row">
    <div class="thumbnail">
      <img src="${pageContext.request.contextPath}/images/profilepics/a.png" alt="...">
      <div class="caption">
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 NameOfTeamMemeber"><h1>RANA</h1></div>
        <h3 class="jobCriteria">Developer</h3>
        <p>As everybody knows by this time, I don't think the major league baseball players of today can be compared to the old-timers. I think the slider is a nickel curve and I detest hearing the modern sissies moan about how it has ruined batting averages.</p>
      </div>
    </div>
   </div>
  </div>
  
   <div class="co-lg-6 col-md-6 col-sm-6 col-xs-12 teamMemberBox" >
   <div class="row">
    <div class="thumbnail">
      <img src="${pageContext.request.contextPath}/images/profilepics/a.png" alt="...">
      <div class="caption">
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 NameOfTeamMemeber"><h1>RANA</h1></div>
        <h3 class="jobCriteria">Developer</h3>
        <p>As everybody knows by this time, I don't think the major league baseball players of today can be compared to the old-timers. I think the slider is a nickel curve and I detest hearing the modern sissies moan about how it has ruined batting averages.</p>
      </div>
    </div>
   </div>
  </div>
  
   <div class="co-lg-6 col-md-6 col-sm-6 col-xs-12 teamMemberBox" >
   <div class="row">
    <div class="thumbnail">
      <img src="${pageContext.request.contextPath}/images/profilepics/a.png" alt="...">
      <div class="caption">
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 NameOfTeamMemeber"><h1>RANA</h1></div>
        <h3 class="jobCriteria">Developer</h3>
        <p>As everybody knows by this time, I don't think the major league baseball players of today can be compared to the old-timers. I think the slider is a nickel curve and I detest hearing the modern sissies moan about how it has ruined batting averages.</p>
      </div>
    </div>
   </div>
  </div>
  
   <div class="co-lg-6 col-md-6 col-sm-6 col-xs-12 teamMemberBox" >
   <div class="row">
    <div class="thumbnail">
      <img src="${pageContext.request.contextPath}/images/profilepics/a.png" alt="...">
      <div class="caption">
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 NameOfTeamMemeber"><h1>RANA</h1></div>
        <h3 class="jobCriteria">Developer</h3>
        <p>As everybody knows by this time, I don't think the major league baseball players of today can be compared to the old-timers. I think the slider is a nickel curve and I detest hearing the modern sissies moan about how it has ruined batting averages.</p>
      </div>
    </div>
   </div>
  </div>
  
</div>
</div>

<!-- schools with us -->
<%@ include file="/includes/footer.jsp"%>