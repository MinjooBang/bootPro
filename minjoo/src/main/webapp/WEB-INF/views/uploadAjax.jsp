<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	 <div class="uploadDiv">
	 	<input type="file" name="uploadFile" multiple>
	 </div>
	 
	 <button id="uploadBtn">Upload</button>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$("$uploadBtn").on("click",function(e){
		var formData = new FormData();
		var inputFile = $("input[name='uploadFile']");
		var files = inputFile[0].files;

		console.log(files);
	});
});
</script>
</body>
</html>