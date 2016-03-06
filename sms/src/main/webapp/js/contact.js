
function nameOfUser(){
	var name = $('#contact-name').val();
	if(name == ""){
		$('#contact-name').css('border-color', 'red');
		//$('#message').text('PLz Enter Fame');
	}
	else if(name.length < 3){
		$('#contact-name').css('border-color', 'red');
		//$('#message').text('Name Length must Greter than three Character');
	}else{
		$('#contact-name').css('border-color', 'green');
	}
}
function emailOfUser(){
	var email = $('#contact-email').val();
	if(email == ""){
		$('#contact-email').css('border-color', 'red');
		//$('#message').text('PLz Enter email...!');
		return false;
	}else if(validateEmail(email) == false){
		$('#contact-email').css('border-color', 'red');
		//$('#message').text('PLz Enter valid eMail...!');
		return false;
	}else{
		$('#contact-email').css('border-color', 'green');
		return true;
	} 
}
function messageOfUser(){
	var message = $('#contact-message').val();
	message = message.trim();
	if(message == ""){
		$('#contact-message').css('border-color', 'red');
		//$('#message').text('Must write your experience...!');
		return false;
	}
	else if(message.length < 50){
		$('#contact-message').css('border-color', 'red');
		//$('#message').text('Message should be atleast 50 characters');
		return false;
	}else{
		$('#contact-message').css('border-color', 'green');
		return true;
	}
}
function phoneOfUser(){
	var phoneno = /^\(?([0-9]{11})\)$/;
	var phone = $('#contact-phone').val();
	if(phone == ""){
		$('#contact-phone').css('border-color', 'red');
		//$('#message').text('PLz Enter Phone Number');
	}
	else if(phone.length < 11){
		$('#contact-phone').css('border-color', 'red');
		//$('#message').text('Must Write valid and Complete Phone Number....!');
	}else{
		$('#contact-phone').css('border-color', 'green');
	}
}	
function validateContactUser(){
	if(name =="" || email =="" || phone =="" || message ==""){
		nameOfUser();
		emailOfUser();
		phoneOfUser();
		messageOfUser();
		$('#message').text('');
		$("#error_Field").show();
		$("#error_Field").fadeOut(5000);
	}else{
		contactServer();
	}
}

function reset(){

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

$(document).keypress(function(event) {
	var keycode = (event.keyCode ? event.keyCode : event.which);
	if (event.keyCode == 13)
	{
		document.getElementById('submit-contact').click();
		return false;
	}
	return true;
});