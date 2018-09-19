<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="container">

      <div class="py-5 text-center">
        <img class="d-block mx-auto mb-4" src="<c:url value="resources/images/hansungGo.png"/>" alt="" width=20% height=20%>
        <h2>한성GO 이벤트!<a href="#" onclick="history.go(0)"><i class="fa fa-refresh fa-pull-right" style="color:black;"></i></a> </h2>
      </div>
      
      
      <div class="table-responsive">
			<table class="table table-hover">
				<thead class="thead-dark">
					<tr>
						<th>학번</th>
						<th>이름</th>
						<th>학과</th>
						<th>학년</th>
						<th><a
					href="<c:url value="/quest1"/>" style="color: white;"><strong>퀘스트1</strong></a></th>
						<th><a
					href="<c:url value="/quest2"/>" style="color: white;"><strong>퀘스트2</strong></a></th>
						<th><a
					href="<c:url value="/viewsum"/>" style="color: white;"><strong>코인 개수</strong></a></th>
						<th>최근 완료 시각</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="event" items="${event}">
						<tr>
							<td>${event.id}</td>
							<td>${event.name}</td>
							<td>${event.major}</td>
							<td>${event.year}</td>
							<td><a 
					href="<c:url value="/quest1"/>" style="color: black;">${event.q1}</a></td>
							<td><a 
					href="<c:url value="/quest2"/>" style="color: black;">${event.q2}</a></td>
							<c:if test="${event.sum == 13}">
								<td>X</td>
							</c:if>
							<c:if test="${event.sum != 13}">
								<td><a 
					href="<c:url value="/viewsum"/>" style="color: black;"><strong>${event.sum}</strong></a></td>
							</c:if>
							<td>${event.time}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>


</div>