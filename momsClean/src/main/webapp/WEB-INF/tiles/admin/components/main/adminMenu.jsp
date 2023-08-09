<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<style>
	ul {
		list-style: none;
	}
	a {
		text-decoration: none;
		
	}
	
	#container {
		display: flex;
        justify-content: center;
		margin:0 auto;
		width: 100%;
		height: 130px;
		position: relative;
	}
	
	#logo {
		top: -110px;
	}
	
	nav{
		height:53px;
		display: inline;
		position: absolute;
		width: 100%;
		bottom: 0;
		
	}
	
	nav ul {
		display: flex;
		padding: 0;
		margin: 0;
		justify-content: space-around;
		background-color: #6AAAFF;
		
	}
	
	#topMenu{
		height: 61px;
	}
	
	#topMenu > li {
		float: left;
		position: relative;
		color: white;
		
	}
	
	#topMenu > li > a{
		display: block;
		font-weight: 600;
	
		padding: 19px 61px;
	}
	
	#topMenu > li > a > span {
		font-size: 0.5em;
	}
	
	#topMenu > li > a:hover {
		color: #fff;
		text-shadow: 0 -1px #07c;
	}
	
	#topMenu > li > ul {
		display: none;
		position: absolute;
		width: 250px;
		background: white;
		left: 20px;
		margin: 0;
		border:none;
	}
	
	#topMenu > li > ul > li {
		padding: 10px 10px 10px 30px;
		border:1px solid black;
		border-top:0;
		border-left: 0;
		border-right: 0;
	}
	
	#topMenu > li > ul > li > a {
		font-size: 16px;
		padding: 11px;
		color: #363636;
		font-weight: normal;
	}
	
	#topMenu > li:hover > ul {
		display: block;
		z-index: 10;
	}
	
	#topMenu > li > ul > li > a:hover {
		color: #363636;
		font-size : 20px;
		font-weight: bold;
	}
	#boardList {
		color: inherit;
		font-size: 22px;
	}
</style>
	<div align="center" id="container">
		<nav>
				<!-- 상품관리를 메뉴에 추가한다. -->
			<ul id="topMenu">
				<li><a href="/admin/item/list" id="boardList"><spring:message	code="menu.item.admin" /></a></li>
					<!-- 회원 관리를 메뉴에 추가한다. -->
				<li><a href="#" id="boardList"><spring:message code="menu.user.admin" /><span>▼</span></a>
					<ul>
						<li><a href="/admin/user/list"><spring:message code="menu.userList.admin" /></a></li>
						<li><a href="/admin/user/withdraw/list"><spring:message code="menu.withdrawList.admin" /></a></li>
					</ul>
				</li>
					<!-- 예약정보 관리를 메뉴에 추가한다. -->
				<li><a href="#" id="boardList"><spring:message code="menu.reserve.admin" /><span>▼</span></a>
					<ul>
						<li><a href="/admin/reserve/request/list"><spring:message code="menu.approval.admin" /></a></li>
						<li><a href="/admin/reserve/complete/list"><spring:message code="menu.reserveComplete.admin" /></a></li>
						<li><a href="/admin/reserve/cancel/list"><spring:message code="menu.reserveCancel.admin" /></a></li>
					</ul>
				</li>
					<!-- 게시판 관리 메뉴에 추가한다. -->
				<li><a href="#" id="boardList"><spring:message code="menu.board.admin" /><span>▼</span></a>
					<ul>
						<li><a href="/admin/notice/list"><spring:message code="menu.admin.notice" /></a></li>
						<li><a href="/admin/reference/list"><spring:message	code="menu.reference.admin" /></a></li>
						<li><a href="/admin/review/list"><spring:message code="menu.review.admin" /></a></li>
					</ul>
				</li>
			</ul>
		</nav>
	</div>
<hr>