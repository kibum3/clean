<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
		 width:500px;

	}
	
	th,td{
	font-family:'Malgun Gothic';
	font-size:18px;
	height:50px;
	}
	

	
	.first-td{
	background-color:#6AAAFF;
	color:white;
	text-align: center;
	}

	button{
	border-color:#6AAAFF;
	font-size:20px;
	background-color:white;
	}


</style>

<br>
<h2 align="center">
	<spring:message code="user.admin.header.modify" />
</h2>
<br>
<form:form modelAttribute="user" action="modify">
	<form:hidden path="userNo" />

	<table id="modify" border="1">
		<tr>
			<td class="first-td"><b><spring:message code="user.userNo" /></b></td>
			<td>${user.userNo}</td>
		</tr>
		<tr>
			<td class="first-td"><b><spring:message code="user.userId" /></b></td>
			<td>${user.userId}</td>
		</tr>
		<tr>
			<td class="first-td"><b><spring:message code="user.userName" /></b></td>
			<td>${user.userName}</td>
		</tr>
		<tr>
			<td class="first-td"><b><spring:message code="user.userPhone" /></b></td>
			<td>${user.userPhone}</td>
		</tr>
		<tr>
			<td class="first-td"><b><spring:message code="user.userEmail" /></b></td>
			<td>${user.userEmail}</td>
		</tr>
		<tr>
			<td class="first-td"><b><spring:message code="user.regDate" /></b></td>
			<td><fmt:formatDate pattern="yyyy-MM-dd" value="${user.regDate}" /></td>
		</tr>
		<tr>
			<td class="first-td"><b><spring:message code="user.userDivision" /></b></td>
			<td>${user.userDivision}</td>
		</tr>
	</table>
</form:form>
<br>
<div align="center">
	<button type="submit" id="btnWithdraw">
		<spring:message code="action.withdraw" /></button>
		&nbsp;&nbsp;&nbsp;&nbsp;
	<button type="submit" id="btnList">
		<spring:message code="action.list" /></button>
</div>
<br>
<script>
	$(document).ready(function() {
		var formObj = $("#user");
		$("#btnWithdraw").on("click", function() {
			var userInfo = "${user.userName}(${user.userId})";
			
			alert(userInfo + "님이 회원탈퇴 처리되었습니다.")
			formObj.submit();
		});
		$("#btnList").on("click", function() {
			self.location = "list${pgrq.toUriString()}";
		});
	});
</script>