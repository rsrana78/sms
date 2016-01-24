/*Login user function*/
function loginUser(){
	var loginData = {'userName':$('#login-user-name').val(),'password':$('#login-password').val(),'rememberMe':'false'};
	jQuery.ajax({
        url: context+"/login",
        type: 'POST',
        headers: {'Content-Type': 'application/json'},
	    data: JSON.stringify(loginData),
        success: function(response) {
        	if(response.status == 'SUCCESS'){
        		window.location.replace(context+"/myschool");
        	}else{
        		alert(response.message);
        	}
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
        	alert(error);
    } 
	
    });
}

/*Create contact us request*/
function contactServer(){
	var contactData = {'name':$('#contact-name').val(),'email':$('#contact-email').val(),'phone':$('#contact-phone').val(),'message':$('#contact-message').val()};
	jQuery.ajax({
        url: context+"/contactUs",
        type: 'POST',
        headers: {'Content-Type': 'application/json'},
	    data: JSON.stringify(contactData),
        success: function(response) {
        	alert(response.message);
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
        	alert(error);
    } 
	
    });
}