function submitWeitter() {
	var a = document.getElementById("weitter").value;

	var xmlhttp;
	if (window.XMLHttpRequest) {
		// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {
		// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			//document.getElementById("test").innerHTML=xmlhttp.responseText;
		}
	}
	xmlhttp.open("POST", "/weitter/postWeitter", true);
	xmlhttp.setRequestHeader("Content-type",
			"application/x-www-form-urlencoded");
	var content = "content=" + a;
	xmlhttp.send(content);
}