<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
  $(document).ready(function() {
    // 모든 게시글 내용의 길이를 체크하고 15자를 넘어가면 자르고 "..."을 붙입니다.
    $(".review-content").each(function() {
      var content = $(this).text();
      var maxLength = 15;
      if (content.length > maxLength) {
        content = content.substring(0, maxLength) + "...";
      }
      $(this).text(content);
    });
  });
</script>

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
		width:70%;
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
	width:70%;
	}

</style>
<br>
<h2><spring:message code="review.header.list" /></h2>

<%-- <form method="get" action="admin/review/list">
    <label for="searchType">글 내용</label>
    <input type="text" name="keyword" id="keyword">
    
    <button id="searchBtn" type="submit">검색</button>
</form> --%>


<form:form id="search" modelAttribute="pgrq" method="get" action="${pgrq.toUriStringByPage(1)}" align="right">		
	<form:select class="custom-select" path="searchType" items="${searchTypeCodeValueList}" itemValue="value" itemLabel="label" />
	
	<form:input class="custom-input" path="keyword" placeholder="검색어를 입력해주세요."/>
	<button id='searchBtn'><spring:message code="action.search" /></button>
</form:form>
<br>


<table border="1" id="list">
  <tr>
    <th align="center" width="80"><spring:message code="review.no" /></th>
    <th align="center" width="80"><spring:message code="review.grade" /></th>
    <th align="center" width="420"><spring:message code="review.content" /></th>
    <th align="center" width="180"><spring:message code="review.date" /></th>
  </tr>
  <c:choose>
   	<c:when test="${empty list}">
  		<tr>
    		<td colspan="4" align="center"><spring:message code="common.listEmpty" /></td>
  		</tr>
  	</c:when>
  	<c:otherwise>
  		<c:forEach items="${list}" var="review">
  			<tr>
  				<td align="center">${review.reviewNo}</td>
  				<!-- 평점을 숫자에서 별점으로 바꾸는 명령어 -->
  				<td align="center"><c:choose>
                     <c:when test="${review.reviewGrade == 1}">★</c:when>
                     <c:when test="${review.reviewGrade == 2}">★★</c:when>
                     <c:when test="${review.reviewGrade == 3}">★★★</c:when>
                     <c:when test="${review.reviewGrade == 4}">★★★★</c:when>
                     <c:when test="${review.reviewGrade == 5}">★★★★★</c:when>
                     <c:otherwise>Unknown</c:otherwise>
                  </c:choose></td>
  				<!-- 게시글 상세보기할 때 페이징 요청 정보를 매개변수로 전달한다 -->
  				<td align="left"><a href="/admin/review/read?reviewNo=${review.reviewNo}"><span class="review-content"><c:out value="${review.reviewContent}" /></span></a></td>
  				<td align="center"><fmt:formatDate pattern="yyyy-MM-dd" value="${review.reviewDate}" /></td>
  			</tr>
  		</c:forEach>
  	</c:otherwise>
  </c:choose>
  
</table>
<br>
<!-- 페이징 네비게이션 -->
<div class="page">
	<c:if test="${pagination.prev}">
		<a href="/admin/review/list${pagination.makeQuery(pagination.startPage -1)}">&laquo;</a>
	</c:if>

	<c:forEach begin="${pagination.startPage }" end="${pagination.endPage }" var="idx">
		<a href="/admin/review/list${pagination.makeQuery(idx)}">${idx}</a>
	</c:forEach>
	<!-- 게시글 페이지가 10페이지를 넘어가면 엔드페이지에 +1을 해줘서 11페이지로 넘어갈 수 있게한다 -->
	<c:if test="${pagination.next && pagination.endPage > 0}">
		<a href="/admin/review/list${pagination.makeQuery(pagination.endPage +1)}">&raquo;</a>
		
		<!-- 원래 있던 명령어 -->
		<%-- <a href="${pagination.endPage +1}">&raquo;</a> --%>
	</c:if>
</div>
<br>
