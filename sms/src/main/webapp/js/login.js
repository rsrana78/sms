/*Validate login fields*/
function errorMessage()
{
	$('#message').text('');
	$("#error_Field").show();
	$("#error_Field").fadeOut(10000);
}
function loginUserName()
{
	var user = $('#login-user-name').val();
	if(user == ""){
		$('#login-user-name').css('border-color', 'red');
		$('#message').text('Please enter username');
	}
	else if(user.length < 6){
		$('#login-user-name').css('border-color', 'red');
		$('#message').text('user name must be atleast 6 characters');
	}else
		{
		$('#login-user-name').css('border-color', 'green');
		}
}
function loginUserPassword()
{
	var password = $('#login-password').val();
	if(password == ""){
		$('#login-password').css('border-color', 'red');
		$('#message').text('Please enter password');
	}
	else if(password.length < 6){
		$('#login-password').css('border-color', 'red');
		$('#message').text('password must be atleast 6 characters');
	}else
	{
		$('#login-password').css('border-color', 'green');
	}
}
function validateLoginUser(){
	var password = $('#login-password').val();
	var user     = $('#login-user-name').val();
	var remember = false;
	if(password == "" || user == "")
	{
		loginUserName();
		loginUserPassword();
		errorMessage();
	}else{
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

$(document).keypress(function(event) {
    var keycode = (event.keyCode ? event.keyCode : event.which);
    if (event.keyCode == 13)
    {
        document.getElementById('loginBtn').click();
        return false;
    }
    return true;
});