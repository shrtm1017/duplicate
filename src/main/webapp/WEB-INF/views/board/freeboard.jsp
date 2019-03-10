                        <%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1 class="page-header">자유게시판</h1>
	<!-- userList 정보를 화면에 출력하는 로직 작성 -->

	<div class="table-responsive">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>글번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>등록일시</th>
				</tr>
			</thead>
			<tbody id="freeboardListTbody">
			</tbody>
		</table>
		<%--                <form action="${pageContext. }/user/userForm" method="get"> --%>
		<!--                <button type="submit" class="btn btn-default">사용자 등록</button> -->
		<!--                </form> -->
		<c:set var="lastPage" value="${Integer( bullentinCnt / pageSize + (bullentinCnt % pageSize > 0 ? 1 : 0))}" />
		
		<nav style="text-align: center;">
			<ul id="pagenation" class="pagination">

			</ul>
		</nav>
	</div>
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<%-- 순서 중요 --%>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<script>
	
		</script>
	<script>
$("#regBtn").click(function() {
	$("#createfrm").submit();
})
   function bulletinPageListHtml(page) {
	   $.ajax({
		  url:"${pageContext.request.contextPath}/bulletin/freeboard",
 		  data : "page="+page,
 		  success : function(data) {
 			var htmlArr= data.split("==============seperator===================");
 			$("#freeboardListTbody").html(data);
 			$("#pagenation").html(htmlArr[1]);
	

	console.log(data)
 		  }
	   });
	}
$(document).ready(function() {
	console.log("document reday");
	bulletinPageListHtml(1);
	//사용시 TR 태그 클릭시 이벤트 핸들러
	$("#freeboardListTbody").on("click",".bulletinTr", function() {
		console.log("bulletinTr click");
		var bulletin_no = $(this).data("bulletin_no");
		 	
			$("#bulletin_no").val(bulletin_no);
			$("#frm").submit();
			
	});
});
</script>
	<%--   <form id="frm" action="${request.getContextPath()}/bulletin/user" method="get"> --%>
	<!--       <input type="hidden" id="userId" name="userId" /> -->
	<!--    </form> -->

</body>
</html>
<%-- localhost/module/main.jsp --%>