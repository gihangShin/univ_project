<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ct"%>
<!--
	Future Imperfect by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->

<html>
<head>
<title>Single - Future Imperfect by HTML5 UP</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/main.css" />
</head>
<body class="single">

	<!-- Wrapper -->
	<div id="wrapper">

		<ct:header />

		<!-- Main -->
		<div id="main">

			<!-- Post -->
			<article class="post">
				<header>
					<div class="title">
						<h2>글 올리기</h2>
					</div>
					<div class="meta">
						<time class="published" datetime="2015-11-01">November 1,
							2015</time>
						<a href="#" class="author"><span class="name">Jane Doe</span><img
							src="images/avatar.jpg" alt="" /></a>
					</div>
				</header>

				<form action="insertBoard.do" method="post" enctype="multipart/form-data">
					<table>
						<tr>
							<td>제목</td>
							<td><input type="text" id="boardTitle" name="boardTitle"
								required="required">
						</tr>
						<tr>
							<td>작성자</td>
							<td><input type="text" id="boardWriter" name="boardWriter"
								readonly="readonly" value="${user.userName}"></td>
						</tr>
						<tr>
							<td>내용</td>
							<td><textarea rows="10" cols="10" id="boardContent"
									name="boardContent"></textarea></td>
						</tr>
						<tr>
							<td>사진</td>
							<td><input type="file" name="files"></td>
						</tr>
						<tr>
							<td colspan="2" style="text-align: right;"><button type="submit">업로드</button></td>
						</tr>
					</table>
				</form>

				<footer>
					<ul class="stats">
						<li><a href="#">General</a></li>
						<li><a href="#" class="icon fa-heart">28</a></li>
						<li><a href="#" class="icon fa-comment">128</a></li>
					</ul>
				</footer>
			</article>

		</div>

		<!-- Footer -->
		<section id="footer">
			<ul class="icons">
				<li><a href="#" class="fa-twitter"><span class="label">Twitter</span></a></li>
				<li><a href="#" class="fa-facebook"><span class="label">Facebook</span></a></li>
				<li><a href="#" class="fa-instagram"><span class="label">Instagram</span></a></li>
				<li><a href="#" class="fa-rss"><span class="label">RSS</span></a></li>
				<li><a href="#" class="fa-envelope"><span class="label">Email</span></a></li>
			</ul>
			<p class="copyright">
				&copy; Untitled. Design: <a href="http://html5up.net">HTML5 UP</a>.
				Images: <a href="http://unsplash.com">Unsplash</a>.
			</p>
		</section>

	</div>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/skel.min.js"></script>
	<script src="assets/js/util.js"></script>
	<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
	<script src="assets/js/main.js"></script>

</body>
</html>