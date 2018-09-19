<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header>
	<nav class="navbar navbar-expand-md navbar-light fixed-top bg-dark">
		<a id="menuimg" class="navbar-brand" href="<c:url value="/"/>"> 
			<img src="<c:url value="resources/images/hansungGo.png"/>" alt="Logo"
				style="width: 60px;"/>
		</a>

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="<c:url value="/"/>" style="color: white;"><strong>홈</strong><span
						class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link"
					href="<c:url value="/quest1"/>" style="color: white;"><strong>Quest1</strong></a></li>
				<li class="nav-item"><a class="nav-link"
					href="<c:url value="/quest2"/>" style="color: white;"><strong>Quest2</strong></a></li>
				<li class="nav-item"><a class="nav-link"
					href="<c:url value="/viewsum"/>" style="color: white;"><strong>코인 순위</strong></a></li>	
			</ul>
			<!-- <form class="form-inline mt-2 mt-md-0">
				<input class="form-control mr-sm-2" type="text" placeholder="Search"
					aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form> -->
		</div>
	</nav>
</header>