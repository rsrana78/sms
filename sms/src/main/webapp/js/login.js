/*Validate login fields*/
function validateLoginUser(){
	var user = $('#login-user-name').val();
	var password = $('#login-password').val();
	if(user == ""){
		$('#message').text('Username can not be empty');
	}
	else if(password == ""){
		$('#message').text('Password can not be empty');
	}
	else{
		loginUser();
	}
}