/*Validate contact-us fields*/
function validateContactUser(){
	var name = $('#contact-name').val();
	var email = $('#contact-email').val();
	var phone = $('#contact-phone').val();
	var message = $('#contact-message').val();
	if(name == ""){
		$('#message').text('Name can not be empty');
	}
	else if(phone == ""){
		$('#message').text('Phone can not be empty');
	}
	else if(phone.length < 11){
		$('#message').text('Please provide a valid phone number');
	}
	else if(email == ""){
		$('#message').text('Email can not be empty');
	}
	else if(validateEmail(email) == false){
		$('#message').text('Please provide a valid email address');
	}
	else if(message == ""){
		$('#message').text('Message can not be empty');
	}
	else if(message.length < 50 || message.trim.length < 50){
		$('#message').text('Message should be atleast 50 characters');
	}
	else {
		contactServer();
	}
}