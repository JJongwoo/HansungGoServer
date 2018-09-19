<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container-wrapper">
	<div class="container">
	
	<h2>첫번째 퀘스트 클리어 순위<a href="#" onclick="history.go(0)"><i class="fa fa-refresh fa-pull-right" style="color:black;"></i></a> </h2>
		<div class="table-responsive">
			<table class="table table-hover">
				<thead class="thead-dark">
					<tr>
						<th>학번</th>
						<th>이름</th>
						<th>학과</th>
						<th>첫번째 퀘스트</th>
						<th>완료 시각</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="quest" items="${quest}">
						<tr>
							<td>${quest.id}</td>
							<td>${quest.name}</td>
							<td>${quest.major}</td>
							<td>${quest.q1}</td>
							<td>${quest.q1time}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>