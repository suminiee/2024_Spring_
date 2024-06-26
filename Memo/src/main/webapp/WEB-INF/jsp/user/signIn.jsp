<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="login-box">
	<h1 class="mb-4">로그인</h1>
	
	<form id="loginForm" action="/user/sign-in" method="post">
		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text">ID</span>
			</div>
			<input type="text" class="form-control" id="loginId" name="loginId">
		</div>

		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text">PW</span>
			</div>
			<input type="password" class="form-control" id="password" name="password">
		</div>
		
		<%-- btn-block: 로그인 박스 영역에 버튼을 가득 채운다. --%>
		<input type="submit" id="loginBtn" class="btn btn-block btn-primary" value="로그인">
		<a class="btn btn-block btn-dark" href="/user/sign-up-view">회원가입</a>
	</form>
</div>

<script>
	$(document).ready(function() {
		// 로그인
		$("form").on('submit', function(e) {
			e.preventDefault(); // 폼 중단. 화면 이동 X
			
			//alert("로그인");
			
			let loginId = $("input[name=loginId]").val().trim();
			let password = $("#password").val();
			
			if (!loginId) {
				alert("아이디를 입력하세요");
				return false;
			}
			
			if (!password) {
				alert("비밀번호를 입력하세요");
				return false;
			}
			
			let url = $(this).attr('action');
			console.log(url);
			let params = $(this).serialize(); // name 속성 정의가 반드시 필요
			console.log(params);
			
			$.post(url, params) // request
			.done(function(data) { // response callback
				if (data.result == "성공") {
					// 로그인 성공 시 글 목록 화면으로 이동
					location.href = "/post/post-list-view";
				} else {
					alert(data.error_message);
				}
			}); 
		});
	});
</script>