<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>

	h2{
		font-size:30px;
		color:#6AAAFF;
		margin:0;
	}
	
	#list{
		border-left:0px;
		border-right:0px;
		border-collapse : collapse;
		width:83.6%;
	}
	
	th,td{
	font-family:'Malgun Gothic';
	
	}
	
	th{
	background-color:#6AAAFF;
	font-size:18px;
	color:white;
	height:50px;
	
	}
	
	td{
	background-color:#FAFFFF;
	font-size:16px;
	height:42px;
	}

	#searchBtn{
	width:100px;
	font-size:18px;
	border-color:#6AAAFF;
	box-shadow: none;
	background-color:white;
	}
	.custom-input{
	font-size:18px;
	}
	.custom-select{
	font-size:18px;

	}

	.page {
 	margin-top: 20px;
 	font-size: 22px;
 	color:#6AAAFF;
}

	#search{
	width:83.6%;
	}

</style>
<br>
<h2 align="center">
	<spring:message code="user.admin.header.withdraw" />
</h2>

<form:form id="search" modelAttribute="pgrq2" method="get" action="list${pgrq2.toUriStringByPage(1)}" align="right">
	<form:select class="custom-select" path="searchType" items="${searchTypeCodeValueList}" itemValue="value" itemLabel="label" />
	<form:input class="custom-input" path="keyword" placeholder="검색어를 입력해주세요."/>
	<button id='searchBtn'><spring:message code="action.search" /></button>
</form:form>
<br>
<form:form modelAttribute="user">
	<table border="1" id="list">
		<tr>
			<th id="u_no" align="center"><spring:message
					code="user.userNo" /></th>
			<th id="u_id" align="center"><spring:message
					code="user.userId" /></th>
			<th id="u_name" align="center"><spring:message
					code="user.userName" /></th>
			<th id="u_phone" align="center"><spring:message
					code="user.userPhone" /></th>
			<th id="u_email" align="center"><spring:message
					code="user.userEmail" /></th>
			<th id="u_auth" align="center" ><spring:message
					code="user.emailAuth" /></th>
			<th id="u_reg" align="center" ><spring:message
					code="user.regDate" /></th>
			<th id="u_division" align="center" ><spring:message
					code="user.userDivision" /></th>
			<th id="u_withdrawDate" align="center" width="120"><spring:message
					code="user.withdrawDate" /></th>
			<th id="u_treatment" align="center" ><spring:message
					code="user.treatment" /></th>
		</tr>
		<c:choose>
			<c:when test="${empty withdraw}">
				<tr>
					<td colspan="10" align="center"><spring:message code="common.user.listEmpty"></spring:message>
					</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${withdraw}" var="user">
					<tr>
						<td align="center">${user.userNo}</td>
						<td align="center">${user.userId}</td>
						<td align="center">${user.userName}</td>
						<td align="center">${user.userPhone}</td>
						<td align="center">${user.userEmail}</td>
						<td align="center">${user.emailAuth}</td>
						<td align="center"><fmt:formatDate value="${user.regDate}"
								pattern="yyyy-MM-dd" /></td>
						<td align="center">${user.userDivision}</td>
						<td align="center"><fmt:formatDate value="${user.withdrawDate}"
								pattern="yyyy-MM-dd" /></td>
						<td align="center"><a href='/admin/user/withdraw/modify?userNo=${user.userNo}'>복구</a></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</form:form>
<br>
<!-- 페이징 네비게이션 -->
<div align="center" class="page">
	<c:if test="${pagination2.prev}">
		<a href="/admin/user/withdraw/list${pagination2.makeQuery(pagination2.startPage - 1)}">&laquo;</a>
	</c:if>

	<c:forEach begin="${pagination2.startPage}" end="${pagination2.endPage}"
		var="idx">
		<a href="/admin/user/withdraw/list${pagination2.makeQuery(idx)}">${idx}</a>
	</c:forEach>

	<c:if test="${pagination2.next && pagination2.endPage > 0}">
		<a href="/admin/user/withdraw/list${pagination2.makeQuery(pagination2.endPage + 1)}">&raquo;</a>
	</c:if>
</div>
<br>