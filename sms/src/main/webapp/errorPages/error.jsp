<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="/includes/header.jsp"%>
<link href='http://fonts.googleapis.com/css?family=Love+Ya+Like+A+Sister' rel='stylesheet' type='text/css'>
<style type="text/css">	
.wrap{
	font-family: 'Love Ya Like A Sister', cursive;
	margin:0 auto;
	width:1100px;
}
.lgo{
	text-align:center;
	margin-top:10px;
}
.lgo img{
	width:350px;
	text-align:center;
}
.lgo p{
	color:#272727;
	font-size:40px;
	margin-top:20px;
	width:1100px;
}	
</style>
<!-- Change button class -->
<script>
$(document).ready(function(){
	$('#home').removeClass('current_page_item');
	$('#mission').removeClass('current_page_item');
	$('#schools').removeClass('current_page_item');
	$('#about').removeClass('current_page_item');
	$('#contact').removeClass('current_page_item');
	$('#login').removeClass('current_page_item');
});
</script>
<!-- Change button class -->
 <div class="wrap">
	<div class="lgo">
			<img src="${pageContext.request.contextPath}/images/error.png"/>
            <p>SORRY ! - ${message}</p>
			<div class="sub">
			  <p><input type="button" onclick='window.history.back()' value="Back"></p>
			</div>
	</div>
 </div>	
<%@ include file="/includes/footer.jsp"%>