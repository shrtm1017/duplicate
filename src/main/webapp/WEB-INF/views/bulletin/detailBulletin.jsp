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
	<%-- <%List<UserVo> userList = (List<UserVo>)request.getAttribute("userList");  %> --%>
	<!-- 정적 include -->

	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h1 class="page-header">게시글 상세조회</h1>
		<form class="navbar-form navbar-right"></form>
	</div>

	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">




		<div class="form-group">
			<div class="col-sm-12">
				<li style="margin: 10px; padding: 10px; font-size: 14pt;">제목 :
					${selectBulletinList.bulletin_title }</li>
				<li style="margin: 10px; padding: 10px; font-size: 14pt;">작성자 :
					${selectBulletinList.mem_id }</li>
				<li style="margin: 10px; padding: 10px; font-size: 14pt;">작성일시
					: <fmt:formatDate value="${ selectBulletinList.reg_dt }"
						pattern="yyyy/MM/dd hh:mm:ss" />
				</li>


				<!-- 첨부파일 출력 -->
				<%-- 				<c:forEach var="vo" items="${ attachmentList }"> --%>
				<%-- 					<a href="${ pageContext.servletContext.contextPath }/fileDownload?file_name=${ vo.file_name }">${ vo.file_name }</a><br> --%>
				<%-- 				</c:forEach> --%>

				<!-- 구분선 -->
				<hr style="border: 1px solid #333;" />
			</div>
		</div>
		<div class="form-group">

			<div class="col-sm-12"
				style="margin: 10px; padding: 10px; font-size: 14pt;">${ selectBulletinList.bulletin_content }
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-12">
				<hr style="border: 1px solid #333;" />
				<div style="float: right;">

					<!-- 작성자와 login ID 가 같을 때 버튼 생성 -->
					<c:if test="${ noticeVO.userId == loginId }">
						<button type="button" id="updatebutton">수정</button>
						<button type="button" id="deletebutton">삭제</button>
						<button type="button" id="replybutton">답글</button>
					</c:if>
				</div>
			</div>
		</div>


		<div class="form-group">
			<div class="col-sm-12"
				style="text-align: center; margin: 30px; padding: 30px; height: 100px;">
				<div class="col-sm-10">
					<form id="cmtsavefrm"
						action="${pageContext.request.contextPath }/comment"
						method="post">
						<textarea name="cmt_content" rows="10" cols="100"
							style="width: 1000px; height: 100px;"></textarea>
						<input type="hidden" name="mem_id" value="${userVo.mem_id }">
						<input type="hidden" name="bulletin_no" value="${selectBulletinList.bulletin_no}">
					</form>
				</div>
				<div class="col-sm-1">
					<button type="button" id="cmtbutton" class="btn btn-default"
						style="width: 100px; height: 100px;">댓글저장</button>
				</div>
			</div>
		</div>


		<div class="form-group">
			<div class="col-sm-12" style="text-align: center; padding: 30px;">
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th><h3>Comment</h3></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${commentList }" var="commentList">
								<c:choose>
									<c:when test="${commentList.cmt_del_check != 'y' }">

										<label for="content" class="col-sm-3 control-label">${userVo.mem_id }:${commentList.cmt_content }</label>

										<form id="cmtDeletefrm"
											action="${pageContext.request.contextPath }/commentDelete"
											method="post">
											<button class="cmt_delete" type="button"
												onclick="click_cmtdel(${commentList.cmt_no})">삭제</button>
											 <input type="hidden" name="mem_id" value="${userVo.mem_id }">
											<input type="hidden" id="cmt_no" name="cmt_no">
											<input type="hidden" name="bulletin_no" value="${selectBulletinList.bulletin_no}">
										</form>
									</c:when>
									<c:otherwise>
										<label for="content" class="col-sm-3 control-label">${userVo.mem_id }:삭제된
											글입니다</label>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<form id="deletefrm" action="${pageContext.request.contextPath }/bulletin/deleteBulletin" method="post">
			<input type="hidden" name="bulletin_del_checkt" value="del"/> 
			<input type="hidden" name="mem_id" value="${selectBulletinList.mem_id }"/>
			<input type="hidden" name="bulletin_no" value="${selectBulletinList.bulletin_no }"/>
		</form>
		
		<%-- 	<form id="updatefrm" action="${pageContext.request.contextPath }/bulletin/updateBulletin.jsp" method="post"> --%>
		<form id="updatefrm" action="${pageContext.request.contextPath }/bulletin/updateBulletin" method="get">
		<input type="hidden" name="bulletin_no" value="${selectBulletinList.bulletin_no} ">
		</form>
			
			<form id="replyfrm" action="${pageContext.request.contextPath }/bulletin/bulletinReply" method="get">
			 <input type="hidden" name="mem_id" value="${selectBulletinList.mem_id }"/>
			 <input type="hidden" name="bulletin_no" value="${selectBulletinList.bulletin_no }"/>
			
			</form>
</body>
<script>
	function click_cmtdel(n){
		console.log(n);
		$("#cmt_no").val(n);
	}
	
	$("#deletebutton").click(function() {
		$("#deletefrm").submit();
	})
	$("#updatebutton").click(function() {
		$("#updatefrm").submit();
	})
	$("#cmtbutton").click(function() {
		$("#cmtsavefrm").submit();
	})
	$(".cmt_delete").click(function() {
		$("#cmtDeletefrm").submit();
	})
		$("#replybutton").click(function() {
		$("#replyfrm").submit();
	})
</script>
</html>