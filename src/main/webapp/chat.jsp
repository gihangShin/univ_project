<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ct"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Chating PAGE</title>
<link rel="stylesheet" href="assets/css/main.css" />
<style>
 * {
	margin: 0;
	padding: 0;
}

.container {
	width: 600px;
	margin: 0 auto;
	padding: 25px
}

.container h1 {
	text-align: left;
	padding: 5px 5px 5px 15px;
	color: #FFBB00;
	border-left: 3px solid #FFBB00;
	margin-bottom: 20px;
}

.chating {
	width: 500px;
	height: 500px;
	overflow: auto;
}

.chating p {
	color: #000;
	text-align: left;
}

input {
	width: 330px;
	height: 25px;
}

</style>
</head>

<script type="text/javascript">
	var ws;

	chatName();
	
	function wsOpen() {
		ws = new WebSocket("ws://" + location.host + "/chating");
		wsEvt();
	}

	function wsEvt() {
		ws.onopen = function(data) {
			//소켓이 열리면 초기화 세팅하기
		}

		ws.onmessage = function(data) {
			var msg = data.data;
			if (msg != null && msg.trim() != '') {
				$("#chating").append("<p>" + msg + "</p>");
			}
		}

		document.addEventListener("keypress", function(e) {
			if (e.keyCode == 13) { //enter press
				send();
			}
		});
	}

	function chatName() {
		var userName = "${user.userName}";
		if (userName == null || userName.trim() == "") {
			alert("로그인해주세요.");
		} else {
			wsOpen();
			$("#yourMsg").show();
		}
	}

	function send() {
		
		var uN = "${user.userName}";
		var msg = $("#chatting").val();
		ws.send(uN + " : " + msg);
		$('#chatting').val("");
	}
</script>
<body>
	<ct:header/>
	<div id="container" class="container">
		<h1>전체채팅</h1>
		<div id="chating" class="chating"></div>

		<div id="yourName">
		</div>
		<div id="yourMsg">
			<table class="inputTable">
				<tr>
					<th>메시지</th>
					<th><input id="chatting" placeholder="보내실 메시지를 입력하세요."></th>
					<th><button onclick="send()" id="sendBtn">보내기</button></th>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>