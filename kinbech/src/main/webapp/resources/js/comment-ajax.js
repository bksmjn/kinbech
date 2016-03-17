	// pathname is contextRoot/path/path/ so we want to get [1] that is where contextRoot is
	// [0] has "" as a result of split 
	var contextRoot = "/" + window.location.pathname.split( '/' )[1];
	
	

function postSubmit(){
   	var dataToSend = JSON.stringify(serializeObject($('#')));
   	var postmessage = $('#postmessage').val();
   	var commentId = $('#commentid').val();
   	var csrf = $('#')
   	var username = $('#username');
   	var post = {
   			"postMessage":postmessage,
   			"username":"dummy"
   				};
   	
   	console.log(post);
   	var token = $("meta[name='_csrf']").attr("content");
   	var header = $("meta[name='_csrf_header']").attr("content");
   	console.log("header : "+header+"  token : "+ token);
   	 $.ajax({
		type: 'POST',
		headers:{
			'X-CSRF-TOKEN':token,
			'Accept': 'application/json',
	        'Content-Type': 'application/json' 
		},
		url: contextRoot + '/comment/1',
		dataType: "json",           // Accepts
 		data:JSON.stringify(post),
 		contentType: 'application/json',   // Sends
		success: function(messageObject){
			console.log(messageObject);
			addcomment(postmessage,messageObject.username);
		},
 
		error: function(errorObject ){	
//			error: function(jqXHR,  textStatus,  HTTPStatus ){	
//	EXAMPLE:		error: function(jQuery XMLHttpRequest,  "error",  "Bad Request" ){	
						
			if (errorObject.responseJSON.errorType == "ValidationError") {
	 			$('#success').html("");
	 			$('#errors').html("");
	 			$("#errors").append( '<H3 align="center"> Error(s)!! <H3>');                
	  			    $("#result").append( '<p>');
	  	
	  			    var errorList = errorObject.responseJSON.errors;
	 	 	        $.each(errorList,  function(i,error) {			   
	 		    		$("#errors").append( error.message + '<br>');
			    	});
	 	 	        $("#errors").append( '</p>');
	 	 	        $('#result').show();
			}
			else {
				alert(errorObject.responseJSON.errors(0));   // "non" Validation Error
			}
 		}
	});
}

 
resetForm = function(id) {
    var element = document.getElementById(id);
    $(element)[0].reset();

    }	  
	


make_hidden = function(id) {
    var e = document.getElementById(id);
        e.style.display = 'none';
        }	   

make_visible = function(id) {
    var e = document.getElementById(id);
    e.style.display = 'block';
 }	   

// Translate form to array
// Then put in JSON format
 function serializeObject (form)
{
    var jsonObject = {};
    var array = form.serializeArray();
    $.each(array, function() {
         	jsonObject[this.name] = this.value;
    });
    return jsonObject;

};


 