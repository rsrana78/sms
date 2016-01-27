/*Validate login fields*/
function validateLoginUser(){
	var user = $('#login-user-name').val();
	var password = $('#login-password').val();
	if(user == ""){
		$('#message').text('User name can not be empty');
	}
	else if(user.length < 6){
		$('#message').text('User name should be atleast 6 characters');
	}
	else if(password == ""){
		$('#message').text('Password can not be empty');
	}
	else if(password.length < 6){
		$('#message').text('Password should be atleast 6 characters');
	}
	else{
		loginUser();
	}
}