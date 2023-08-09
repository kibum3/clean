<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

<style>

	h3{
		font-size:30px;
		color:#6AAAFF;
		margin:0;
		background-color:white;
	}
	
	.homeReserve,.homeReference{
		font-size:30px;
		color:#6AAAFF;
		margin:0;
		background-color:white;
	}
	.homeReview{
		border:none;
		border-color:white;
		font-size:30px;
		color:#6AAAFF;
		background-color:white;
	}
	
	#reserve{
		border-left:0px;
		border-right:0px;
		border-collapse : collapse;
		width:1550px;
	}
	
	#reference{
		border-left:0px;
		border-right:0px;
		border-collapse : collapse;
		width: 750px;

	}
	#review{
		border-left:0px;
		border-right:0px;
		border-collapse : collapse;
		margin-left: 47px;
		width: 750px;
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

	#review2{

	}
	#review3{
	margin-left:40px;
	}
}

</style>
<script>
  $(document).ready(function() {
    // 모든 게시글 내용의 길이를 체크하고 자를 넘어가면 자르고 "..."을 붙입니다.
    $(".word-limit").each(function() {
      var content = $(this).text();
      var maxLength = 35;
      if (content.length > maxLength) {
        content = content.substring(0, maxLength) + "...";
      }
      $(this).text(content);
    });
  });
</script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<br><br>
<table align="center">
	<!-- 신규 예약 -->
	<tr>
		<th class="homeReserve" align="left"><spring:message code="home.admin.reserve" />
		</th>
	</tr>
	<tr>
		<td colspan="2"><form:form modelAttribute="request">
				<table border="1" id="reserve">
					<tr>
						<th align="center" width="180"><spring:message
								code="reserve.reserveNo" /></th>
						<th align="center" width="70"><spring:message
								code="reserve.userNo" /></th>
						<th align="center" width="70"><spring:message
								code="reserve.userId" /></th>
						<th align="center" width="70"><spring:message
								code="reserve.userName" /></th>
						<th align="center" width="70"><spring:message
								code="reserve.itemNo" /></th>
						<th align="center" width="400"><spring:message
								code="reserve.reserveAddr" /></th>
						<th align="center" width="80"><spring:message
								code="reserve.totalPrice" /></th>
						<th align="center" width="90"><spring:message
								code="reserve.reserveDate" /></th>
						<th align="center" width="90"><spring:message
								code="reserve.cleanDate" /></th>
						<th align="center" width="70"><spring:message
								code="reserve.reserveState" /></th>
						<th align="center" width="70"><spring:message
								code="reserve.request" /></th>
					</tr>
					<c:choose>
						<c:when test="${empty request}">
							<tr>
								<td colspan="12" align="center"><spring:message
										code="common.listEmpty"></spring:message></td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach items="${request}" var="home">
								<tr>
									<td align="center">${home.reserveNo}</td>
									<td align="center">${home.userNo}</td>
									<td align="center">${home.userId}</td>
									<td align="center">${home.userName}</td>
									<td align="center">${home.itemNo}</td>
									<td class="word-limit" align="center">${home.reserveAddr}</td>
									<td align="center">${home.reserveItemPrice + home.reserveOptionPrice}원</td>
									<td align="center"><fmt:formatDate
											value="${home.reserveDate}" pattern="yyyy-MM-dd" /></td>
									<td align="center"><fmt:formatDate
											value="${home.cleanDate}" pattern="yyyy-MM-dd" /></td>
									<td align="center">${home.reserveState}</td>
									<td align="center">${home.reserveRequest}</td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</table>
			</form:form></td>
	</tr>
	<tr>
		<td><br></td>
	</tr>
	<!-- 신규 문의 -->
	<tr>
		
		<td>
		<table id="review2">
			<th colspan="3" class="homeReference" align="left"><spring:message code="home.admin.reference" /></th>
			</table>
			<table border="1" id="reference">
				
				<tr>
					<th align="center" width="80"><spring:message
							code="reference.no" /></th>
					<th align="center" width="320"><spring:message
							code="reference.title" /></th>
					<th align="center" width="100"><spring:message
							code="reference.name" /></th>
					<th align="center" width="100"><spring:message
							code="reference.referenceDate" /></th>
				</tr>
				<c:choose>
					<c:when test="${empty list}">
						<tr>
							<td colspan="4" align="center"><spring:message code="common.listEmpty" /></td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${list}" var="home">
							<tr>
							<td align="center">
							<c:choose>
    						<c:when test="${not empty home.no}">${home.no}</c:when>
    						</c:choose>
								
        	<c:choose>
    <c:when test="${empty home.no}"><B>└</B></c:when>
    </c:choose>
        </td>
        <td align="left">
            <a href="/admin/reference/read${pgrq.toUriString(pgrq.page)}&referenceNo=${home.referenceNo}">
                <c:out value="${home.referenceTitle}" />
            </a>
        </td>
        <td align="center">${home.userName}</td>
        <td align="center">
            <fmt:formatDate pattern="yyyy-MM-dd" value="${home.referenceDate}" />
        </td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>
		</td>
		
		<!-- 신규 리뷰 -->
		<td>
			<table id="review3">
			<th colspan="3" class="homeReview" align="left"><spring:message code="home.admin.review" /></th>
			</table>
			<table border="1" id="review">
				<tr>
					<th align="center" width="80"><spring:message code="review.no" /></th>
					<th align="center" width="80"><spring:message
							code="review.grade" /></th>
					<th class="word-limit" align="center" width="300"><spring:message
							code="review.content" /></th>
					<th align="center" width="180"><spring:message
							code="review.date" /></th>
				</tr>
				<c:choose>
					<c:when test="${empty review}">
						<tr>
							<td colspan="4" align="center"><spring:message code="common.listEmpty" /></td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${review}" var="home">
							<tr>
								<td align="center">${home.reviewNo}</td>
								<!-- 평점을 숫자에서 별점으로 바꾸는 명령어 -->
								<td align="center"><c:choose>
										<c:when test="${home.reviewGrade == 1}">★</c:when>
										<c:when test="${home.reviewGrade == 2}">★★</c:when>
										<c:when test="${home.reviewGrade == 3}">★★★</c:when>
										<c:when test="${home.reviewGrade == 4}">★★★★</c:when>
										<c:when test="${home.reviewGrade == 5}">★★★★★</c:when>
										<c:otherwise>Unknown</c:otherwise>
									</c:choose></td>
								<!-- 게시글 상세보기할 때 페이징 요청 정보를 매개변수로 전달한다 -->
								<td align="left"><a href="/admin/review/read?reviewNo=${home.reviewNo}"><span class="word-limit">${home.reviewContent}</span></td>
								<td align="center"><fmt:formatDate pattern="yyyy-MM-dd"
										value="${home.reviewDate}" /></td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>
		</td>
	</tr>
</table>

<!-- 통계 차트 -->
<br>
<div class="wrapper">
	<h3>
		<spring:message code="home.admin.chart" />
	</h3>
		<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	    <script type="text/javascript">
	      google.charts.load("current", {packages:["corechart"]});
	      google.charts.setOnLoadCallback(drawCancelChart);
	      google.charts.setOnLoadCallback(drawItemChart);
	      google.charts.setOnLoadCallback(drawMonthlySalesChart);
	      function drawCancelChart() {
	    	var reserveRequest = ${requestCount};
	    	var reserveCompleted = ${reserveCount};
	    	var reserveCancelled = ${cancelCount};
	    	  
	        var data = google.visualization.arrayToDataTable([
	          ['누적 예약취소율', 'Cancel Chart'],
	          ['예약완료',     reserveCompleted],
	          ['예약취소',     reserveCancelled],
	          ['예약대기',     reserveRequest]
	        ]);
	
	        var options = {
	          title: '누적 예약취소율',
	          pieHole: 0.35,
	          slices: {
	              // 예약취소 부분 강조를 위해 설정 (0번부터 시작)
	              1: {offset: 0.1}
	          }
	        };
	
	        var chart = new google.visualization.PieChart(document.getElementById('cancelChart'));
	        chart.draw(data, options);
	      }
	      
	      function drawItemChart() {
		    	var itemCount1 = ${itemCount1};
		    	var itemCount2 = ${itemCount2};
		    	var itemCount3 = ${itemCount3};
		    	var itemCount4 = ${itemCount4};
		    	var itemCount5 = ${itemCount5};
		    	var itemCount6 = ${itemCount6};
		    	  
		        var data = google.visualization.arrayToDataTable([
		          ['누적 상품판매비율', 'Item Chart'],
		          ['A세트',     itemCount1],
		          ['B세트',     itemCount2],
		          ['C세트',     itemCount3],
		          ['D세트',     itemCount4],
		          ['E세트',     itemCount5],
		          ['F세트',     itemCount6]
		        ]);
		
		        var options = {
		          title: '누적 상품판매비율',
		          pieHole: 0.35,
		        };
		
		        var chart = new google.visualization.PieChart(document.getElementById('itemChart'));
		        chart.draw(data, options);
		      }
	      
	      function drawMonthlySalesChart() {
	          
				var data = google.visualization.arrayToDataTable([
				['월 별 매출액', '상품판매액', '옵션판매액', '총 판매액', '총 예약수'],
				['2023/01', ${itemSales1}, ${optionSales1}, ${totalSales1}, ${monthlyReserveCount1}],
				['2023/02', ${itemSales2}, ${optionSales2}, ${totalSales2}, ${monthlyReserveCount2}],
				['2023/03', ${itemSales3}, ${optionSales3}, ${totalSales3}, ${monthlyReserveCount3}],
				['2023/04', ${itemSales4}, ${optionSales4}, ${totalSales4}, ${monthlyReserveCount4}],
				['2023/05', ${itemSales5}, ${optionSales5}, ${totalSales5}, ${monthlyReserveCount5}],
				['2023/06', ${itemSales6}, ${optionSales6}, ${totalSales6}, ${monthlyReserveCount6}],
				['2023/07', ${itemSales7}, ${optionSales7}, ${totalSales7}, ${monthlyReserveCount7}],
				['2023/08', ${itemSales8}, ${optionSales8}, ${totalSales8}, ${monthlyReserveCount8}],
				['2023/09', ${itemSales9}, ${optionSales9}, ${totalSales9}, ${monthlyReserveCount9}],
				['2023/10', ${itemSales10}, ${optionSales10}, ${totalSales10}, ${monthlyReserveCount10}],
				['2023/11', ${itemSales11}, ${optionSales11}, ${totalSales11}, ${monthlyReserveCount11}],
				['2023/12', ${itemSales12}, ${optionSales12}, ${totalSales12}, ${monthlyReserveCount12}]
				
				]);

				var options = {
				        title: '월 별 매출액',
				        vAxes: {
				            0: { title: '매출액' }, // 왼쪽 Y축 (막대 그래프용)
				            1: { title: '예약수', format: '0', ticks: [0, 5, 10, 15, 20, 25, 30, 35] } // 오른쪽 Y축 (선 그래프용)
				        },
				        seriesType: 'bars',
				        series: {
				            0: { targetAxisIndex: 0 }, // 왼쪽 Y축에 막대 그래프 설정
				            1: { targetAxisIndex: 0 }, // 왼쪽 Y축에 막대 그래프 설정
				            2: { targetAxisIndex: 0 }, // 왼쪽 Y축에 막대 그래프 설정
				            3: { type: 'line', targetAxisIndex: 1 } // 오른쪽 Y축에 선 그래프 설정
				        }
				    };

				
				var chart = new google.visualization.ComboChart(document.getElementById('monthlySalesChart'));
				chart.draw(data, options);
			}
	    </script>
	    
	    <table class="chart">
	    	<tr align="center">
	    		<td><div id="itemChart" style="border: 1px solid #ccc; width: 550px; height: 370px;"></div></td>
	    		<td><div id="cancelChart" style="border: 1px solid #ccc; width: 550px; height: 370px;"></div></td>
	    	</tr>
	    	<tr>
	    		<td colspan="2"><div id="monthlySalesChart" style="border: 1px solid #ccc; width: 1106px; height: 500px;"></div></td>
	    	</tr>
	    </table>
		    
			
			
		
	
</div>


