/*Validate contact-us fields*/
function validateContactUser(){
	var name = $('#contact-name').val();
	var email = $('#contact-email').val();
	var phone = $('#contact-phone').val();
	var message = $('#contact-message').val();
	if(name == ""){
		$('#contact-name').css('border-color', 'red');
		$('#message').text('Name can not be empty');
	}
	else if(name.length < 3){
		$('#contact-name').css('border-color', 'red');
		$('#message').text('Invalid name:'+name);
	}
	else if(phone == ""){
		$('#contact-phone').css('border-color', 'red');
		$('#message').text('Phone can not be empty');
	}
	else if(phone.length < 11){
		$('#contact-phone').css('border-color', 'red');
		$('#message').text('Please provide a valid phone number');
	}
	else if(email == ""){
		$('#contact-email').css('border-color', 'red');
		$('#message').text('Email can not be empty');
	}
	else if(validateEmail(email) == false){
		$('#contact-email').css('border-color', 'red');
		$('#message').text('Please provide a valid email address');
	}
	else if(message == ""){
		$('#contact-message').css('border-color', 'red');
		$('#message').text('Message can not be empty');
	}
	else if(message.length < 50 || message.trim.length < 50){
		$('#contact-message').css('border-color', 'red');
		$('#message').text('Message should be atleast 50 characters');
	}
	else {
		contactServer();
	}
}

function reset(){
	alert('rana');
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
        	$('#message').text(response.message);
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
        	$('#message').text(error);
    } 
	
    });
}