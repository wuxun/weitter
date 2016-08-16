function success(obj) {
	obj.removeClass("has-error");
	obj.addClass("has-success has-feedback");
}

function fail(obj) {
	obj.removeClass("has-success");
	obj.addClass("has-error has-feedback");
}

$("#inputUsername").change(function() {
	group = $(this).parent().parent();
	len = $(this).val().length;
	if (len > 0 && len < 20) {
		success(group);
		return;
	} else {
		fail(group);
		return;
	}
	$.ajax({
		type : "POST",
		url : "/weitter/register/checkName",
		data : {"name" : $(this).val()},
		datatype : "text",
		success : function(data) {
			if(data.repeat) {
				alert("用户名重复");
				fail(group);
			} else {
				success(group);
			}
		},
		error : function(data) {
			alert("error");
		}
	});
});

$("#inputPassword").change(function() {
	len = $(this).val().length;
	group = $(this).parent().parent();
	if (len > 6 && len < 20) {
		success(group);
	} else {
		fail(group);
	}
});