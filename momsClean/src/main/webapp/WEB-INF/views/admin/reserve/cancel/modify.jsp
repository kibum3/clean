<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>

	h2{
		font-size:30px;
		color:#6AAAFF;
		margin:0;
	}
	
	#modify{
		border-left:0px;
		border-right:0px;
		 border-collapse : collapse;
		 width:700px;

	}
	
	th{
	font-family:'Malgun Gothic';
	font-size:18px;
	height:40px;
	}
	td{
	font-family:'Malgun Gothic';
	font-size:16px;
	height:40px;
	}
	

	
	.first-td{
	background-color:#6AAAFF;
	color:white;
	text-align: center;
	width:100px;
	}

	button{
	border-color:#6AAAFF;
	font-size:20px;
	background-color:white;
	}


</style>

<br>
<h2 align="center">
	<spring:message code="reserve.admin.header.info" />
</h2>
<br>
<form:form modelAttribute="reserve" action="modify">
	<form:hidden path="reserveNo" />
	
	<table border="1" id="modify">
		<c:forEach var="reserve" items="${cancelModifyForm}">
			<tr>
				<td class="first-td"><b><spring:message code="reserve.reserveNo" /></b></td>
				<td>${reserve.reserveNo}</td>
			</tr>
			<tr>
			<tr>
				<td class="first-td"><b><spring:message code="reserve.reserveUserName" /></b></td>
				<td>${reserve.userName}(${reserve.userId})</td>
			</tr>
			<tr>
				<td class="first-td"><b><spring:message code="reserve.reserveAddr" /></b></td>
				<td>${reserve.reserveAddr}</td>
			</tr>
			<tr>
				<td rowspan="2" class="first-td"><b><spring:message code="reserve.itemInfo" /></b></td>
				<td>상품 : ${reserve.reserveItemName}</td>
			</tr>
			<tr>
				<td>가격 : ${reserve.reserveItemPrice}원</td>
			</tr>
			<tr>
				<td rowspan="2" class="first-td"><b><spring:message code="reserve.optionInfo" /></b></td>
				<td>옵션 : ${reserve.reserveOptionName}</td>
			</tr>
			<tr>
				<td>가격 : ${reserve.reserveOptionPrice}원</td>
			</tr>
			<tr>
				<td class="first-td"><b><spring:message code="reserve.reserveDate" /></b></td>
				<td><fmt:formatDate pattern="yyyy-MM-dd"
						value="${reserve.reserveDate}" /></td>
			</tr>
			<tr>
				<td class="first-td"><b><spring:message code="reserve.cleanDate" /></b></td>
				<td><fmt:formatDate pattern="yyyy-MM-dd"
						value="${reserve.cleanDate}" /></td>
			</tr>
			<tr>
				<td class="first-td"><b><spring:message code="reserve.reserveState" /></b></td>
				<td>${reserve.reserveState}</td>
			</tr>
			<tr>
				<td class="first-td"><b><spring:message code="reserve.cancelDate" /></b></td>
				<td><fmt:formatDate pattern="yyyy-MM-dd"
						value="${reserve.cancelDate}" /></td>
			</tr>
			<tr>
				<td class="first-td"><b><spring:message code="reserve.cleanDone" /></b></td>
				<td>${reserve.cleanDone}</td>
			</tr>
			<tr>
				<td class="first-td"><b><spring:message code="reserve.request" /></b></td>
				<td>${reserve.reserveRequest}</td>
			</tr>
		</c:forEach>
	</table>
</form:form>
<br>
<div align="center">
	<button type="submit" id="btnRestore">
		<spring:message code="action.restore" />
	</button>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<button type="submit" id="btnList">
		<spring:message code="action.list" />
	</button>
</div>
<br>
<script>
	$(document).ready(function() {
		var formObj = $("#reserve");
		$("#btnRestore").on("click", function() {
			var reserveNum = "${reserve.reserveNo}";
			
			alert("예약번호 : " + reserveNum + "\n복구가 완료되었습니다.");
			formObj.submit();
		});
		$("#btnList").on("click", function() {
			self.location = "/admin/reserve/cancel/list${pgrq3.toUriString()}";
		});
	});
</script>