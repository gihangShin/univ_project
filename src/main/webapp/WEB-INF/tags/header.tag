<%@ tag language="java" pageEncoding="UTF-8"%>

<!-- Header -->
<header id="header">
	<h1>
		<a href="#">프로젝트 설계</a>
	</h1>
	<nav class="links">
		<ul>
			<li><a href="#">Feed</a></li>
			<li><a href="#">Group Talk</a></li>
			<li><a href="#">Private Talk</a></li>
			<li><a href="#">My Page</a></li>
			<li><a href="logout.do">로그아웃</a></li>
		</ul>
	</nav>
	<nav class="main">
		<ul>
			<li class="search"><a class="fa-search" href="#search">Search</a>
				<form id="search" method="get" action="#">
					<input type="text" name="query" placeholder="Search" />
				</form></li>
			<li class="menu"><a class="fa-bars" href="#menu">Menu</a></li>
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
					<p>Feugiat tempus veroeros dolor</p>
			</a></li>
			<li><a href="#">
					<h3>Dolor sit amet</h3>
					<p>Sed vitae justo condimentum</p>
			</a></li>
			<li><a href="#">
					<h3>Feugiat veroeros</h3>
					<p>Phasellus sed ultricies mi congue</p>
			</a></li>
			<li><a href="#">
					<h3>Etiam sed consequat</h3>
					<p>Porta lectus amet ultricies</p>
			</a></li>
		</ul>
	</section>

	<!-- Actions -->
	<section>
		<ul class="actions vertical">
			<li><a href="#" class="button big fit">Log In</a></li>
		</ul>
	</section>

</section>