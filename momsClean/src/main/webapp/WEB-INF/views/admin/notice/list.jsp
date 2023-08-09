<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
  $(document).ready(function() {
    // 모든 게시글 내용의 길이를 체크하고 15자를 넘어가면 자르고 "..."을 붙입니다.
    $(".notice-title").each(function() {
      var content = $(this).text();
      var maxLength = 20;
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

#notice 
	{
		border-left:0px;
		border-right:0px;
		border-collapse : collapse;
		width:70%;
	}

.listTitle 
{
	background-color:#6AAAFF;
	font-size:18px;
	color:white;
	height:50px;
	
	}

.listList {
	background-color:#FAFFFF;
	font-size:16px;
	height:42px;
	}

.page {
 	font-size: 22px;
 	color:#6AAAFF;
}

#searchBtn {
	width:100px;
	font-size:18px;
	border-color:#6AAAFF;
	box-shadow: none;
	background-color:white;
	}
	
	#keyword{
	font-size:18px;
	width: 240px;
	}

	#topTable{
	width: 70%;
	}

	#register{
	
	
	}
	
	#regBtn{
	width: 85px;
	font-size:18px;
	border: 2px solid black;
	border-color:#6AAAFF;
	padding: 0px 15px 0px 15px;
	
	}
	 #search{
	
	}

</style>
<br>
<h2 ><spring:message code="notice.header.list" /></h2>

<form:form modelAttribute="pgrq" method="get" action="list${pgrq.toUriStringByPage(1)}" >		
	<table id="topTable">
	  <tr>
	    <td id="register" align="left"><a href="register" id="regBtn"><spring:message code="notice.new" /></a></td>
	    <td id="search" align="right"><form:select path="searchType" items="${searchTypeCodeValueList}" itemValue="value" itemLabel="label" style="display: none;"/>
		<form:input path="keyword" id="keyword" placeholder="글 제목으로 검색 가능합니다."/>
		<button id='searchBtn'><spring:message code="action.search" /></button></td>
	  </tr>
	</table>
</form:form>

<br>
<div></div>
<table id="notice" border="1">
  <tr class="listTitle">
    <th align="center" width="130"><spring:message code="notice.no" /></th>
    <th align="center" width="550"><spring:message code="notice.title" /></th>
    <th align="center" width="230"><spring:message code="notice.date" /></th>
  </tr>
  <c:choose>
   	<c:when test="${empty list}">
  		<tr>
    		<td colspan="3" align="center"><spring:message code="common.listEmpty" /></td>
  		</tr>
  	</c:when>
  	<c:otherwise>
  		<c:forEach items="${list}" var="notice">
  			<tr class="listList">
  				<td align="center">${notice.noticeNo}</td>
  				<%-- <td align="left"><a href="/admin/notice/read?noticeNo=${notice.noticeNo}"><c:out value="${notice.noticeTitle}" /></a></td> --%>
  				<!-- 게시글 상세보기할 때 페이징 요청 정보를 매개변수로 전달한다 -->
  				<td align="left"><a href="/admin/notice/read${pgrq.toUriString(pgrq.page)}&noticeNo=${notice.noticeNo}"><span class="notice-title"><c:out value="${notice.noticeTitle}" /></span></a></td>
  				<td align="center"><fmt:formatDate pattern="yyyy-MM-dd" value="${notice.noticeDate}" /></td>
  			</tr>
  		</c:forEach>
  	</c:otherwise>
  </c:choose>
  
</table>
<br>
<!-- 페이징 네비게이션 -->
<div class="page">
	<c:if test="${pagination.prev}">
		<a href="/admin/notice/list${pagination.makeQuery(pagination.startPage -1)}">&laquo;</a>
	</c:if>

	<c:forEach begin="${pagination.startPage }" end="${pagination.endPage }" var="idx">
		<a href="/admin/notice/list${pagination.makeQuery(idx)}">${idx}</a>
	</c:forEach>
	<!-- 게시글 페이지가 10페이지를 넘어가면 엔드페이지에 +1을 해줘서 11페이지로 넘어갈 수 있게한다 -->
	<c:if test="${pagination.next && pagination.endPage > 0}">
		<a href="/admin/notice/list${pagination.makeQuery(pagination.endPage +1)}">&raquo;</a>
	</c:if>
</div>
<br>