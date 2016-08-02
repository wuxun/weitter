function follow(id)
{
	var followId = id.getAttribute("userId");
	$.ajax({
		type:"POST",
		url:"/weitter/follow",
		data:{userId:followId, follow:true},
		datatype:"text",
		success:function(msg) {
			id.disabled = true;
		},
		error:function(msg) {
			id.disabled = false;
		}
	})
}