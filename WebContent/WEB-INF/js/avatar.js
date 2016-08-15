$('#image').cropper({
	aspectRatio : 1 / 1,
	preview : '.preview',
	crop : function(e) {
		// Output the result data for cropping image.
		console.log(e.x);
		console.log(e.y);
		console.log(e.width);
		console.log(e.height);
		console.log(e.rotate);
		console.log(e.scaleX);
		console.log(e.scaleY);
	}
});

var $image = $('#image');
var $inputImage = $('#inputImage');
var URL = window.URL || window.webkitURL;
var blobURL;

if (URL) {
	$inputImage.change(function() {
		var files = this.files;
		var file;

		if (!$image.data('cropper')) {
			return;
		}

		if (files && files.length) {
			file = files[0];
			if (/^image\/\w+$/.test(file.type)) {
				blobURL = URL.createObjectURL(file);
				$image.one('built.cropper', function() {

					// Revoke when load complete
					URL.revokeObjectURL(blobURL);
				}).cropper('reset').cropper('replace', blobURL);
				$inputImage.val('');
			} else {
				window.alert('Please choose an image file.');
			}
		}
	});
} else {
	$inputImage.prop('disabled', true).parent().addClass('disabled');
}

$('#cancel').click(function() {
	location.reload();
});

$('#finish').click(function() {
	$image.cropper('getCroppedCanvas').toBlob(function(blob) {
		var formData = new FormData();

		formData.append('avatar', blob);

		$.ajax('/weitter/avatar', {
			method : "POST",
			data : formData,
			processData : false,
			contentType : false,
			success : function() {
				alert("修改成功");
			},
			error : function() {
				alert("修改失败");
			}
		});
	});
})