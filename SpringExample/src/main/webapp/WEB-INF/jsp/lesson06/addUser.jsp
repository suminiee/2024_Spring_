<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>회원가입</h1>
		
		<form method="post" action="/lesson06/ex01/add-user">
			<div class="form-group">
				<label for="name">이름</label>
				<input type="text" id="name" name="name" class="form-control col-4">
			</div>
			<div class="form-group">
				<label for="yyyymmdd">생년월일</label>
				<input type="text" id="yyyymmdd" name="yyyymmdd" class="form-control col-4" placeholder="예) 19951108">
			</div>
			<div class="form-group">
				<label for="email">이메일</label>
				<input type="text" id="email" name="email" class="form-control col-4">
			</div>
			<div class="form-group">
				<label for="introduce">자기소개</label>
				<textarea id="introduce" name="introduce" class="form-control"></textarea>
			</div>
			
			<input type="button" id="joinBtn" value="회원가입" class="btn btn-success">
		</form>
	</div>
	
	<script>
		$(document).ready(function() {
			// 1) jquery의 submit - form 태그
			/*
			$("form").on('submit', function(e) {
				//e.preventDefault(); // 서브밋 기능 중단
				
				// validation
				let name = $("input[name=name]").val().trim();
				if (name.length < 1) {
					alert("이름을 입력하세요");
					return false;
				}
				
				let yyyymmdd = $("#yyyymmdd").val().trim();
				if (yyyymmdd == "") {
					alert("생년월일을 입력하세요");
					return false;
				}
				
				let email = $("#email").val().trim();
				if (!email) {
					alert("이메일을 입력하세요");
					return false;
				}
				
				alert("서브밋");
			});
			*/
			
			// 2) jquery의 AJAX 통신 이용
			$("#joinBtn").on('click', function() {
				//alert("클릭");
				
				// validation
				let name = $("input[name=name]").val().trim();
				if (name.length < 1) {
					alert("이름을 입력하세요");
					return;
				}
				
				let yyyymmdd = $("#yyyymmdd").val().trim();
				if (yyyymmdd == "") {
					alert("생년월일을 입력하세요");
					return;
				}
				
				let email = $("#email").val().trim();
				if (!email) {
					alert("이메일을 입력하세요");
					return;
				}
				
				let introduce = $("#introduce").val();
				
				console.log(name);
				console.log(yyyymmdd);
				console.log(email);
				console.log(introduce);
				
				//alert("체크 완료");
				// AJAX 통신: 서버에 요청
				$.ajax({
					// request
					type:"POST"
					
					// response
					
				});
				
				
			}); //-- joinBtn 끝
		}); //-- ready 끝
	</script>
</body>
</html>




