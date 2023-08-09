<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>

	h2{
		font-size:30px;
		color:#6AAAFF;
		margin:0;
	}
	
	#item,#option{

		border-left:0px;
		border-right:0px;
		border-collapse : collapse;

		width:50%;
	}
	
	
	th{
	font-family:'Malgun Gothic';
	font-size:18px;

	}
	td{
	font-family:'Malgun Gothic';
	font-size:16px;
	}
	
	.no,.name,.price,.modify{
	 border:none;
	 font-size:20px;
	 background-color : #6AAAFF;
	 color:white;
	
	}
	#regist{
	border:none;
	border-collapse : collapse;
	width:50%;
	color:#6AAAFF;


	}

	tr.register th{
	border:none;
	}


</style>
<br>
<h2>
	<spring:message code="item.header.itemList" />
</h2>

<br>
<table id="regist" border="1">
	<tr class="register"> 
		<th width="270"></th>
		<th width="230"></th>
		<th colspan="3" align="right" width="80"><a href="itemRegister"><spring:message
					code="item.regist" /></a></th>
	</tr>
</table>

<table id="item" border="1">
	<tr>
		<th class="no" align="center" width="250"><spring:message code="item.itemNo" /></th>
		<th class="name" align="center" width="690"><spring:message
				code="item.itemName" /></th>
		<th class="price" align="center" width="250"><spring:message
				code="item.itemPrice" /></th>

		<th class="modify" align="center" width="250"><spring:message code="item.edit" /></th>

		<c:choose>
			<c:when test="${empty itemList}">
				<tr>
					<!--  <td colspan="3"><spring:message code="common.listEmpty" /></td>-->
					<td colspan="4"><spring:message code="common.listEmpty" /></td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${itemList}" var="item">

					<tr>
						<td align="center">${item.itemNo}</td>
						<td align="left">${item.itemName}</td>
						<td align="right">${item.itemPrice}원</td>
						<td align="center"><a href="itemChange?itemNo=${item.itemNo}"><spring:message
									code="item.change" /></a></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</tr>
</table>

<br>
<br>

<h2>
	<spring:message code="item.header.optionList" />
</h2>

<br>
<table id="regist" border="1">
	<tr class="register"> 
		<th width="270"></th>
		<th width="230"></th>
		<th colspan="3" align="right" width="80"><a href="optionRegister"><spring:message
					code="item.regist" /></a></th>
	</tr>
</table>

<table id="option" border="1">
	<tr>
		<th class="name" align="center" width="270"><spring:message
				code="item.itemName" /></th>
		<th class="price" align="center" width="230"><spring:message
				code="item.itemPrice" /></th>

		<th class="modify" align="center" width="80"><spring:message code="item.edit" /></th>

		<c:choose>
			<c:when test="${empty itemList2}">
				<tr>
					<!--  <td colspan="3"><spring:message code="common.listEmpty" /></td>-->
					<td colspan="4"><spring:message code="common.listEmpty" /></td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${itemList2}" var="item">

					<tr>
						<td align="left">${item.itemName}</td>
						<td align="right">${item.itemPrice}원</td>


						<td align="center"><a
							href="optionChange?itemName=${item.itemName}"><spring:message
									code="item.change" /></a></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</tr>
</table>
<br>
<script>
	var result = "${msg}";

	if (result === "SUCCESS") {
		alert("<spring:message code='common.processSuccess'/>");
	}
</script>

