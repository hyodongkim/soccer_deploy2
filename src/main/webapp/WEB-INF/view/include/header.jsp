<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="site-mobile-menu site-navbar-target">
	<div class="site-mobile-menu-header">
		<div class="site-mobile-menu-close">
			<span class="icon-close2 js-menu-toggle"></span>
		</div>
	</div>
	<div class="site-mobile-menu-body"></div>
</div>


<header class="site-navbar py-4" role="banner">

	<div class="container">
		<div class="d-flex align-items-center">
			<div class="site-logo">
				<a href="/"> <img src="images/logo.png" alt="Logo">
				</a>
			</div>
			<div class="ml-auto">
				<nav class="site-navigation position-relative text-right"
					role="navigation">
					<ul
						class="site-menu main-menu js-clone-nav mr-auto d-none d-lg-block">
						<li><a href="/" class="nav-link">Home</a></li>
						<li><a href="matches" class="nav-link">Matches</a></li>
						<li><a href="players" class="nav-link">Players</a></li>
						<li><a href="xMain" class="nav-link">MainPage</a></li>
						<li class="dropdown"><a href="/realNotice" class="dropdown-toggle "
						data-toggle="dropdown">게시판<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="/realNotice" class="drop">공지사항</a></li>
							<li><a href="/board" class="drop">자유게시판</a></li>
						</ul></li>
						<li><a href="/login" class="nav-link">Login</a></li>
					</ul>
				</nav>

				<a href="#"
					class="d-inline-block d-lg-none site-menu-toggle js-menu-toggle text-black float-right text-white"><span
					class="icon-menu h3 text-white"></span></a>
			</div>
		</div>
	</div>

</header>