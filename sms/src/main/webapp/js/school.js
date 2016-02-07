
function getSchools(){
	jQuery.ajax({
        url: context+'/getAllRegisteredSchools',
        type: 'GET',
        data: $('#frm').serialize(),
        success: function(data) {
        	$.each(data, function (i, v) {
        		if (i == 'object') {
					var arrayLength = v.length;
					var scdata = "";
					var td = 0;
					for (var j=0; j<arrayLength; j++) {
						scdata += '<td><a href="#"><img src="'+context+v[j].monogramPath+'" alt="'+v[j].schoolName+'" title="'+v[j].schoolName+'"></a></td>';
						td++;
						if(td == 3 || j+1 == arrayLength){
							$("#tb-data").append('<tr>'+scdata+'</tr>');
							td = 0;
							scdata = "";
						}
					}
        		}
        		
        	});
        },
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			$("#tb-data").append('<tr><td>'+errorThrown+'</td></tr>');
	    } 
	});
}