<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
	#search{
	width:83.6%;
	}

	.page {
 	margin-top: 20px;
 	font-size: 22px;
 	color:#6AAAFF;
}

</style>
<br>
<h2>
	<spring:message code="reserve.admin.header.request" />
</h2>

<!-- 검색 폼 -->
<form:form id="search" modelAttribute="pgrq" method="get" action="list${pgrq.toUriStringByPage(1)}" align="right">
	<form:select class="custom-select" path="searchType" items="${searchTypeCodeValueList}" itemValue="value" itemLabel="label" />
	<form:input class="custom-input" path="keyword" placeholder="검색어를 입력해주세요."/>
	<button id='searchBtn'><spring:message code="action.search" /></button>
</form:form>

<br>
<form:form modelAttribute="request">
	<table id="list" border="1">
		<tr>
			<th id="r_no" align="center"><spring:message
					code="reserve.reserveNo" /></th>
			<th id="r_uNo" align="center"><spring:message
					code="reserve.userNo" /></th>
			<th id="r_uId" align="center"><spring:message
					code="reserve.userId" /></th>
			<th id="r_uName" align="center"><spring:message
					code="reserve.userName" /></th>
			<th id="r_iNo" align="center"><spring:message
					code="reserve.itemNo" /></th>
			<th id="r_addr" align="center"><spring:message
					code="reserve.reserveAddr" /></th>
			<th id="r_tPrice" align="center"><spring:message
					code="reserve.totalPrice" /></th>
			<th id="r_rDate" align="center"><spring:message
					code="reserve.reserveDate" /></th>
			<th id="r_cDate" align="center"><spring:message
					code="reserve.cleanDate" /></th>
			<th id="r_state" align="center"><spring:message
					code="reserve.reserveState" /></th>
			<th id="r_req" align="center"><spring:message
					code="reserve.request" /></th>
			<th id="r_treatment" align="center"><spring:message
					code="reserve.treatment" /></th>
		</tr>
		<c:choose>
			<c:when test="${empty request}">
				<tr>
					<td colspan="12" align="center"><spring:message
							code="common.listEmpty"></spring:message></td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${request}" var="reserve">
					<tr>
						<td align="center">${reserve.reserveNo}</td>
						<td align="center">${reserve.userNo}</td>
						<td align="center">${reserve.userId}</td>
						<td align="center">${reserve.userName}</td>
						<td align="center">${reserve.itemNo}</td>
						<td class="r_addr" align="center">${reserve.reserveAddr}</td>
						<td align="center">${reserve.reserveItemPrice + reserve.reserveOptionPrice}원</td>
						<td align="center"><fmt:formatDate
								value="${reserve.reserveDate}" pattern="yyyy-MM-dd" /></td>
						<td align="center"><fmt:formatDate
								value="${reserve.cleanDate}" pattern="yyyy-MM-dd" /></td>
						<td align="center">${reserve.reserveState}</td>
						<td align="center">${reserve.reserveRequest}</td>
						<td align="center"><a
							href='/admin/reserve/request/modify?reserveNo=${reserve.reserveNo}'>승인</a></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</form:form>
<br>
<!-- 페이징 네비게이션 -->
<div class="page" align="center">
	<c:if test="${pagination.prev}">
		<a href="/admin/reserve/request/list${pagination.makeQuery(pagination.startPage - 1)}">&laquo;</a>
	</c:if>

	<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}"
		var="idx">
		<a href="/admin/reserve/request/list${pagination.makeQuery(idx)}">${idx}</a>
	</c:forEach>

	<c:if test="${pagination.next && pagination.endPage > 0}">
		<a href="/admin/reserve/request/list${pagination.makeQuery(pagination.endPage + 1)}">&raquo;</a>
	</c:if>
</div>
<br>
<script>
  $(document).ready(function() {
    // 모든 게시글 내용의 길이를 체크하고 15자를 넘어가면 자르고 "..."을 붙입니다.
    $(".r_addr").each(function() {
      var content = $(this).text();
      var maxLength = 15;
      if (content.length > maxLength) {
        content = content.substring(0, maxLength) + "...";
      }
      $(this).text(content);
    });
  });
</script>