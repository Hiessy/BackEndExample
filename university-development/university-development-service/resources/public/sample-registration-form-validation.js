function formValidation()  
{  
	var uid = document.registration.userid;
	var fname = document.registration.firstname;
	var lname = document.registration.lastname;
	var type = document.registration.type;  
	var gender = document.registration.gender;  

	if(allLetter(fname) && allLetter(lname))  
	{  		
		if(typeselect(type))  
		{  
			if(genderselect(gender))  
			{  
			}  
		}  
	}  

	$.ajax({
		type: "POST",
		url: "http://localhost:8080/v3/clients/",
		async: false,
		data: JSON.stringify( { "name": fname.value + " " + lname.value, "type": type.value, "gender" : gender.value }),
		contentType: "application/json",
		complete: function (data) {
			console.log(data);
			wait = false;
		}
	});

	return false;  

} 



function userid_validation(uid,mx,my)  
{  
	var uid_len = uid.value.length;  
	if (uid_len == 0 || uid_len >= my || uid_len < mx)  
	{  
		alert("User Id should not be empty / length be between "+mx+" to "+my);  
		uid.focus();  
		return false;  
	}  
	return true;  
}  
function passid_validation(passid,mx,my)  
{  
	var passid_len = passid.value.length;  
	if (passid_len == 0 ||passid_len >= my || passid_len < mx)  
	{  
		alert("Password should not be empty / length be between "+mx+" to "+my);  
		passid.focus();  
		return false;  
	}  
	return true;  
}  
function allLetter(uname)  
{   
	var letters = /^[A-Za-z]+$/;  
	if(uname.value.match(letters))  
	{  
		return true;  
	}  
	else  
	{  
		alert('Username must have alphabet characters only');  
		uname.focus();  
		return false;  
	}  
}  
function alphanumeric(uadd)  
{   
	var letters = /^[0-9a-zA-Z]+$/;  
	if(uadd.value.match(letters))  
	{  
		return true;  
	}  
	else  
	{  
		alert('User address must have alphanumeric characters only');  
		uadd.focus();  
		return false;  
	}  
}  

function typeselect(type)  
{  
	if(type.value == "Default")  
	{  
		alert('Select your type from the list');  
		type.focus();  
		return false;  
	}  
	else  
	{  
		return true;  
	}  
} 

function genderselect(gender)  
{  
	if(gender.value == "Default")  
	{  
		alert('Select your gender from the list');  
		gender.focus();  
		return false;  
	}  
	else  
	{  
		return true;  
	}  
} 

function countryselect(ucountry)  
{  
	if(ucountry.value == "Default")  
	{  
		alert('Select your country from the list');  
		ucountry.focus();  
		return false;  
	}  
	else  
	{  
		return true;  
	}  
}  
function allnumeric(uzip)  
{   
	var numbers = /^[0-9]+$/;  
	if(uzip.value.match(numbers))  
	{  
		return true;  
	}  
	else  
	{  
		alert('ZIP code must have numeric characters only');  
		uzip.focus();  
		return false;  
	}  
}  
function ValidateEmail(uemail)  
{  
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;  
	if(uemail.value.match(mailformat))  
	{  
		return true;  
	}  
	else  
	{  
		alert("You have entered an invalid email address!");  
		uemail.focus();  
		return false;  
	}  
} function validsex(umsex,ufsex)  
{  
	x=0;  

	if(umsex.checked)   
	{  
		x++;  
	} if(ufsex.checked)  
	{  
		x++;   
	}  
	if(x==0)  
	{  
		alert('Select Male/Female');  
		umsex.focus();  
		return false;  
	}  
	else  
	{  
		alert('Form Succesfully Submitted');  
		window.location.reload()  
		return true;  
	}  
}  