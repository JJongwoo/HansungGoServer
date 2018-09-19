<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container-wrapper">
	<div class="container">

		<h2>
			코인 순위<a href="#" onclick="history.go(0)"><i
				class="fa fa-refresh fa-pull-right" style="color: black;"></i></a>
		</h2>
		<div class="table-responsive">
			<table class="table table-hover">
				<thead class="thead-dark">
					<tr>
						<th>학번</th>
						<th>이름</th>
						<th>학과</th>
						<th>학년</th>
						<th>코인 갯수</th>
						<th>최근 수집 시각</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="sum" items="${sum}">
						<c:if test="${sum.sum > 13}">
							<tr>
								<td>${sum.id}</td>
								<td>${sum.name}</td>
								<td>${sum.major}</td>
								<td>${sum.year}</td>
								<td>${sum.sum}</td>
								<td>${sum.time}</td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>