function validateEmployee(){
	var name = jQuery("#name").val();
	var fatherName = jQuery("#father-name").val();
	var cnic = jQuery("#cnic").val();
	var email = jQuery("#email").val();
	var phone = jQuery("#phone").val();
	var type = jQuery("#type").val();
	var qualification = jQuery("#qualification").val();
	var salary = jQuery("#salary").val();
	var address  = jQuery("#address").val();
	jQuery.ajax({
        url: context+'/myschool/createEmployee',
        type: 'POST',
        data: $('#empform').serialize(),
        success: function(data) {
        	showSuccessAlert(data.message);
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) { 
		
        } 
	});
}