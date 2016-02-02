<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="/includes/header.jsp"%>
<!-- Change button class -->
<script>
$(document).ready(function(){
	$('#home').removeClass('current_page_item');
	$('#mission').removeClass('current_page_item');
	$('#schools').removeClass('current_page_item');
	$('#about').addClass('current_page_item');
	$('#contact').removeClass('current_page_item');
	$('#login').removeClass('current_page_item');
	$('#team').removeClass('current_page_item');
});
</script>
<!-- Change button class -->

<!-- About us -->

<div id="nav">
<!-- This div is for space between header and footer -->
</div>

<div class="about-statement">
	<p>	
		Cloud computing, also known as 'on-demand computing', is a kind of Internet-based computing, where shared resources, 
		data and information are provided to computers and other devices on-demand. It is a model for enabling ubiquitous, 
		on-demand access to a shared pool of configurable computing resources.<br>
		Cloud computing and storage solutions provide users and enterprises with various capabilities to store and process their 
		data in third-party data centers. It relies on sharing of resources to achieve coherence and economies of scale, similar 
		to a utility (like the electricity grid) over a network. At the foundation of cloud computing is the broader concept of converged 
		infrastructure and shared services.<br>Cloud computing is a model for enabling ubiquitous, convenient, on-demand network access to a 
		shared pool of configurable computing resources (e.g., networks, servers, storage, applications and services) that can be rapidly
		provisioned and released with minimal management effort.Proponents claim that cloud computing allows companies to 
		avoid upfront infrastructure costs, and focus on projects that differentiate their businesses instead of on infrastructure.
		Proponents also claim that cloud computing allows enterprises to get their applications up and running faster, with improved 
		manageability and less maintenance, and enables IT to more rapidly adjust resources to meet fluctuating and unpredictable business 
		demand.Cloud providers typically use a "pay as you go" model. This can lead to unexpectedly high charges if administrators 
		do not adapt to the cloud pricing model.<br>The present availability of high-capacity networks, low-cost computers and storage 
		devices as well as the widespread adoption of hardware virtualization, service-oriented architecture, and autonomic and utility 
		computing have led to a growth in cloud computing.[8][9][10] Companies can scale up as computing needs increase and then scale 
		down again as demands decrease.Cloud computing has now become a highly demanded service or utility due to the advantages 
		of high computing power, cheap cost of services, high performance, scalability, accessibility as well as availability.
		Cloud vendors are experiencing growth rates of 50% per annum.<br> But due to being in a stage of infancy, it still has 
		some pitfalls which need to be given proper attention to make cloud computing services more reliable and user friendly.
	</p>
</div>

<!-- About us -->
<%@ include file="/includes/footer.jsp"%>
