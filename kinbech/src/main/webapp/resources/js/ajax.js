	// pathname is contextRoot/path/path/ so we want to get [1] that is where contextRoot is
	// [0] has "" as a result of split 
	var contextRoot = "/" + window.location.pathname.split( '/' )[1];

function addressSubmit(){
   	var dataToSend = JSON.stringify(serializeObject($('#addressForm')));
   	 $.ajax({
		type: 'POST',
		url: contextRoot + '/users/addAddress',
//		url: '/Book5Rest/addCategory',
		dataType: "json",           // Accepts
 		data:dataToSend,
 		contentType: 'application/json',   // Sends
		success: function(){
			$('#errors').html("");
 			$("#result").append( '<H3 align="center"> OKAY!! <H3>');                
	 	    $('#result').show();
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


 