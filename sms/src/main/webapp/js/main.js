//Validate email address
function validateEmail(email) {
    var re = /[A-Z0-9._%+-]+@[A-Z0-9.-]+.[A-Z]{2,4}/igm;
    return re.test(email);
}

/*pop up notification*/
function showSuccessAlert(messageText){
	$.notify({
		message: messageText,			
	},{
		// settings
		element: 'body',			
		type: "info",			
		placement: {
			from: "bottom",
			align: "right"
		},			
		delay: 5000,
		timer: 1000,	
		offset: 30,
		icon_type: 'class',
		animate: {
			enter: 'animated fadeInDown',
			exit: 'animated fadeOutUp'
		},
		template: '<div style="cursor:pointer" data-notify="container" class="col-xs-11 col-sm-3 alert alert-{0}" role="alert">' +			
		'<button type="button" aria-hidden="true" class="close" data-notify="dismiss">x</button>' +
		'<span data-notify="message">{2}</span>' +
		'</div>' 
	});
}