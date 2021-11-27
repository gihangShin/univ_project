<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ct"%>
<!DOCTYPE HTML>
<!--
	Future Imperfect by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
<title>MAIN PAGE 마이크 테스트 하나 둘 셋</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/main.css" />
</head>
<body>

	<!-- Wrapper -->
	<div id="wrapper">

		<ct:header />

		<!-- Main -->
		<div id="main">
			<h2>feeds</h2>
			<!-- Post -->
			<c:forEach items="${boardList}" var="board">
				<article class="post">
					<header>
						<div class="title" style="padding: 20px; margin: 20px;">
							<h2>
								<a href="#">${board.boardTitle}</a>
							</h2>
							<div
								style="text-align: right; position: absolute; right: 350px; bottom: 60px;">
								<a href="boardlike.do?boardSeq=${board.boardSeq}"
									class="icon fa-heart">&nbsp;&nbsp; ${board.boardLike}</a>
							</div>
						</div>
						<div class="meta" style="padding: 20px; margin: 20px;">
							<a href="#" class="author"><span class="name">${board.boardWriter}</span><img
								src="images/avatar.jpg" alt="" /></a>
						</div>
					</header>
					<c:if test="${board.fileOriName!=null }">
						<a href="#" class="image featured"> <img
							src="images/${board.fileOriName}" alt=""
							style="width: 300px; height: 300px" /></a>
					</c:if>
					<p>${board.boardContent }</p>

					<div style="padding: 0; margin: 0;">
						<h5 style="display: block; width: 100%; margin: 0; padding: 0;">comment</h5>
						<br>

						<c:if test="${board.comments != null}">
							<ul style="font-size: 10pt; list-style-type: none; margin: 0;">
								<c:forEach items="${board.comments}" var="comment">
									<li style="margin: 0; padding: 0;">

										${comment.commentWriter}&nbsp;:&nbsp;${comment.commentContent}
										<span style="text-align: right;">
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<a href="commentlike.do?commentSeq=${comment.commentSeq}"
											class="icon fa-heart"> ${comment.commentLike}</a>
									</span>

									</li>
								</c:forEach>
							</ul>
						</c:if>
						<form action="insertcomment.do" method="post"
							style="padding: 0; margin: 0;">
							<input type="hidden" id="boardSeq" name="boardSeq"
								value="${board.boardSeq}"> <input type="hidden"
								id="commentWriter" name="commentWriter" value="${user.userName}">
							<textarea
								style="padding: 5px; height: 40px; width: 800px; display: inline; resize: none; vertical-align: middle;"
								id="commentContent" name="commentContent"></textarea>
							<button type="submit"
								style="height: 40px; align-content: center; vertical-align: middle; padding: 10px; line-height: 0;">댓글
								달기</button>
						</form>

					</div>
				</article>
			</c:forEach>

			<!-- Pagination -->
			<ul class="actions pagination">
				<li><a href="" class="disabled button big previous">Previous
						Page</a></li>
				<li><a href="#" class="button big next">Next Page</a></li>
			</ul>

		</div>

		<!-- Sidebar -->
		<section id="sidebar">

			<!-- Intro -->
			<section id="intro">
				<a href="#" class="logo"><img src="images/logo.jpg" alt="" /></a>
				<h2>${user.userName}님환영합니다.</h2>
				<header>
					<h2>updated Friends</h2>
					<p>
						업데이트한 친구의 게시글을 확인해 보세요 <br>
						<button onclick="location.href('mainpage.do')">새로고침</button>
					</p>
				</header>
			</section>

			<!-- <!-- Mini Posts -->
			<!-- <section>
				<div class="mini-posts">
					<h3>인기 많은 Feeds</h3>
					Mini Post
					<article class="mini-post">
						<header>
							<h3>
								<a href="#">Vitae sed condimentum</a>
							</h3>
							<time class="published" datetime="2015-10-20">October 20,
								2015</time>
							<a href="#" class="author"><img src="images/avatar.jpg"
								alt="" /></a>
						</header>
						<a href="#" class="image"><img src="images/pic04.jpg" alt="" /></a>
					</article>

					Mini Post
					<article class="mini-post">
						<header>
							<h3>
								<a href="#">Rutrum neque accumsan</a>
							</h3>
							<time class="published" datetime="2015-10-19">October 19,
								2015</time>
							<a href="#" class="author"><img src="images/avatar.jpg"
								alt="" /></a>
						</header>
						<a href="#" class="image"><img src="images/pic05.jpg" alt="" /></a>
					</article>

					Mini Post
					<article class="mini-post">
						<header>
							<h3>
								<a href="#">Odio congue mattis</a>
							</h3>
							<time class="published" datetime="2015-10-18">October 18,
								2015</time>
							<a href="#" class="author"><img src="images/avatar.jpg"
								alt="" /></a>
						</header>
						<a href="#" class="image"><img src="images/pic06.jpg" alt="" /></a>
					</article>

					Mini Post
					<article class="mini-post">
						<header>
							<h3>
								<a href="#">Enim nisl veroeros</a>
							</h3>
							<time class="published" datetime="2015-10-17">October 17,
								2015</time>
							<a href="#" class="author"><img src="images/avatar.jpg"
								alt="" /></a>
						</header>
						<a href="#" class="image"><img src="images/pic07.jpg" alt="" /></a>
					</article>

				</div>
			</section> -->
			<!-- Posts List -->
			<section>
				<h2>가입한 회원 리스트</h2>
				<ul class="posts">
					<c:forEach items="${userList}" var="users">
						<li><header>
								<h3>이름 : ${users.userName}</h3>
								<h3>Email : ${users.userEmail}</h3>
							</header> <!-- <article>
							<header>
								<h3>
									<a href="#">Lorem ipsum fermentum ut nisl vitae</a>
								</h3>
								<time class="published" datetime="2015-10-20">October 20,
									2015</time>
							</header>
							<a href="#" class="image"><img src="images/pic08.jpg" alt="" /></a>
						</article> --></li>
					</c:forEach>
				</ul>
			</section>

			<!-- About -->
			<section class="blurb">
				<h2>About</h2>
				<p>Mauris neque quam, fermentum ut nisl vitae, convallis maximus
					nisl. Sed mattis nunc id lorem euismod amet placerat. Vivamus
					porttitor magna enim, ac accumsan tortor cursus at phasellus sed
					ultricies.</p>
				<ul class="actions">
					<li><a href="#" class="button">Learn More</a></li>
				</ul>
			</section>

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