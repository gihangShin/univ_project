<%@ tag language="java" pageEncoding="UTF-8"%>

<!-- Header -->
<header id="header">
	<h1>
		<a href="#">프로젝트 설계</a>
	</h1>
	<nav class="links">
		<ul>
			<li><a href="mainpage.do">메인페이지</a></li>
			<li><a href="chat.do">대화방</a></li>
			<li><a href="insertboard.jsp">글올리기</a></li>
			<li><a href="logout.do">로그아웃</a></li>
		</ul>
	</nav>
</header>

<!-- Menu -->
<section id="menu">

	<!-- Search -->
	<section>
		<form class="search" method="get" action="#">
			<input type="text" name="query" placeholder="Search" />
		</form>
	</section>

	<!-- Links -->
	<section>
		<ul class="links">
			<li><a href="insertboard.jsp">
					<h3>글 올리기</h3>
			</a></li>
			<li><a href="mainpage.do"><h3>메인페이지</h3></a></li>
			<li><a href="chat.do"><h3>대화방<h3></h3></a></li>
		</ul>
	</section>

	<!-- Actions -->
	<section>
		<ul class="actions vertical">
			<li><a href="logout.do" class="button big fit">로그아웃</a></li>
		</ul>
	</section>

</section>