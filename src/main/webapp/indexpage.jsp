<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IndexPage</title>
<script type="text/javascript">
	var notice = "${notice}";
	console.log("notice " + notice);
	if (notice === "loginfail") {
		alert("로그인에 실패했습니다.");
	}else if(notice === "signupsuccess"){
		alert("회원가입에 성공했습니다.");
	}else if(notice === "signupfail"){
		alert("회원가입에 실패했습니다.");
	}else if(notice === "logout"){
		alert("로그아웃되었습니다.");
	}
</script>
<link rel="stylesheet" href="assets/css/main.css" />
</head>
<body>
	<div style="text-align: center;">
		<h1>프로젝트 설계 - SNS</h1>

		<hr>
		<br>
		<div style="display: grid; place-content: center;">
			<form action="login.do" method="post">
				<table>
					<tr>
						<td>ID</td>
						<td><input type="text" id="userId" name="userId"
							required="required"></td>
					</tr>
					<tr>
						<td>PW</td>
						<td><input type="password" id="userPassword"
							name="userPassword" required="required"></td>
					</tr>
					<tr style="text-align: right;">
						<td colspan="2"><input type="submit" value="로그인"></td>
					</tr>

				</table>
			</form>
			<button onclick="location.href='signup.jsp'">회원가입</button>
		</div>
	</div>
</body>
</html>