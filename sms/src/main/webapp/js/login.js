/*Validate login fields*/
function validateLoginUser(){
	var user = $('#login-user-name').val();
	var password = $('#login-password').val();
	var remember = false;
	if(user == ""){
		$('#login-user-name').css('border-color', 'red');
		$('#message').text('Please enter username');
	}
	else if(user.length < 6){
		$('#login-user-name').css('border-color', 'red');
		$('#message').text('user name must be atleast 6 characters');
	}
	else if(password == ""){
		$('#login-password').css('border-color', 'red');
		$('#message').text('Please enter password');
	}
	else if(password.length < 6){
		$('#login-password').css('border-color', 'red');
		$('#message').text('password must be atleast 6 characters');
	}
	else{
		if($('#remember').is(":checked")){
			remember = true;
		}
		loginUser(user, password, remember);
	}
}

/*Login user function*/
function loginUser(user, pass, remember){
	var loginData = {'userName':user,'password':pass,'rememberMe':remember};
	jQuery.ajax({
        url: context+"/login",
        type: 'POST',
        headers: {'Content-Type': 'application/json'},
	    data: JSON.stringify(loginData),
        success: function(response) {
        	if(response.status == 'SUCCESS'){
        		window.location.replace(context+"/myschool");
        	}else{
        		$('#message').text(response.message);
        	}
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
        	$('#message').text(error);
    } 
	
    });
}