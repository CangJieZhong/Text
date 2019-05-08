<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>蓝源Eloan-P2P平台</title>
		<%@ include file="common/links-tpl.jsp"  %>
		<link type="text/css" rel="stylesheet" href="/css/account.css" />
		<script type="text/javascript" src="/js/plugins/jquery.form.js"></script>
		<script type="text/javascript">
			$(function(){
				$("#editForm").ajaxForm(function(){
					window.location.reload();
				});
				
				$("#submitFileType").click(function(){
					$("#editForm").submit();
				});
			})
		</script>
	</head>
	<body>
		<!-- 网页顶部导航 -->
		<!-- 网页顶部导航 -->
		<%@ include file="common/head-tpl.jsp" %>
		<!-- 网页导航 -->
		<c:set var="currentNav" value="personal"></c:set>
		<%@ include file="common/navbar-tpl.jsp" %>
		<div class="container">
			<div class="row">
				<!--导航菜单-->
				<div class="col-sm-3">
					<c:set var="currentMenu" value="userFile"></c:set>
					<%@ include file="common/leftmenu-tpl.jsp" %>
				</div>
				<!-- 功能页面 -->
				<div class="col-sm-9">
					<div class="panel panel-default">
						<div class="panel-heading">
							用户认证文件信息
						</div>
					</div>
					<div class="row">
					  <form method="POST" action="/userFile_selectType.do" id="editForm">
					  <c:forEach items="${userFiles }" var="file">
					  <div class="col-sm-6 col-md-4">
					    <div class="thumbnail">
					      <img src="${file.image}" />
					      <div class="caption">
					        <p>
					        	<input type="hidden" name="id" value="${file.id}" />
					        	<select class="form-control" name="fileType" style="width: 180px" autocomplate="off">
									<c:forEach items="${fileTypes }" var="type">
										<option value="${type.id}">${type.title}</option>
									</c:forEach>
								</select>
					        </p>
					      </div>
					    </div>
					  </div>
					  </c:forEach>
					  </form>
					</div>
					<div class="row">
						<a href="javascript:;" id="submitFileType" class="btn btn-success">确定提交</a>
					</div>
				</div>
			</div>
		</div>		
		<%@ include file="common/footer-tpl.jsp" %>			
	</body>
</html>