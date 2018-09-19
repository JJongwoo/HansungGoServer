<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="<c:url value="/resources/js/controller.js"/>"></script>

<div class="container-wrapper" ng-app="cartApp">
	<div class="container">
		<h3>상품 상세</h3>
		<div>상품에 대한 상세정보를 확인하세요!</div>
		<br/>

		<div class="row" ng-controller="cartCtrl">
			<div class="col-md-6">
				<img
					src="<c:url value="/resources/images/${product.imageFilename}" />"
					alt="image" style="width: 60%" />
			</div>
			
			<div class="col-md-6">
				<h3>${product.name}</h3>
				<p>${product.description}</p>
				<p>제조사 : ${product.manufacturer}</p>
				<p>분류 : ${product.category}</p>
				<h5>가격 : ${product.price}원</h5>
				
				
				<br/>
				
				<c:if test="${pageContext.request.userPrincipal.name !=null}">
					<p>
						<a href="<c:url value="/products"/>" class="btn btn-danger">Back</a>
						
						<button class="btn btn-warning btn-large" ng-click="addToCart('${product.id}')">
							<i class="fa fa-shopping-cart"></i>Order Now
						</button>
						
						<a href="<c:url value="/cart"/>" class="btn btn-info">
							<i class="fa fa-eye"><</i>View Cart
						</a>
					</p>
				</c:if>
			</div>
		</div>
	</div>
</div>