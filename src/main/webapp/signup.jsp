<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="assets/css/main.css" />
</head>
<body>
	<div style="text-align: center;">
		<h1>회원가입</h1>
		<hr>
		<div style="display: grid; place-content: center;">

			<form action="signup.do" method="post">
				<table>
					<tr>
						<td>아이디</td>
						<td><input type="text" id="userId" name="userId"
							required="required"></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" id="userPassword"
							name="userPassword" required="required"></td>
					</tr>
					<tr>
						<td>이름</td>
						<td><input type="text" id="userName" name="userName"
							required="required"></td>
					</tr>
					<tr>
						<td>이메일</td>
						<td><input type="text" id="userEmail" name="userEmail"
							required="required"></td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: right;"><input
							type="submit" value="회원가입"></td>
					</tr>
				</table>
			</form>
			<button onclick="history.back();">돌아가기</button>
		</div>
	</div>
</body>
</html>