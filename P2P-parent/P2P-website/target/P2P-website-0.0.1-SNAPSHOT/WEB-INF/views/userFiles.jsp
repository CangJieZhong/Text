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
		<script type="text/javascript" src="/js/plugins/uploadify/jquery.uploadify.min.js"></script>
		
		<style type="text/css">
			.uploadify{
				height: 20px;
				font-size:13px;
				line-height:20px;
				text-align:center;
				position: relative;
				margin-left:auto;
				margin-right:auto;
				cursor:pointer;
				background-color: #337ab7;
			    border-color: #2e6da4;
			    color: #fff;
			}
		</style>
		<script type="text/javascript">
		$(function(){

		//上传风控材料图片 (需要配置文件上传相关信息 导入fileupload包)
			$("#btn_uploadUserFiles").uploadify({
					buttonText : "用户风控资料文件",
					fileObjName : "file",
					fileTypeDesc : "风控资料文件",
					fileTypeExts : "*.gif; *.jpg; *.png",
					swf : "/js/plugins/uploadify/uploadify.swf",
					uploader : "/userFile_apply.do;jsessionid=${sessionId}",
					overrideEvents : [ "onQueueComplete" ],
					onQueueComplete : function() {
						window.location.reload();
					}

				});
			});
		</script>
	</head>
	<body>
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
					  <c:forEach items="${userFiles }" var="file">
					  <div class="col-sm-6 col-md-4">
					    <div class="thumbnail">
					      <img src="${file.image}" />
					      <div class="caption">
					        <h4>${file.fileType.title}</h4>
					        <p>得分：${file.score} &nbsp;&nbsp;状态：${file.stateDisplay}</p>
					      </div>
					    </div>
					  </div>
					  </c:forEach>
					</div>
					<div class="row">
						<a href="javascript:;" id="btn_uploadUserFiles"></a>
					</div>
				</div>
			</div>
		</div>		
		<%@ include file="common/footer-tpl.jsp" %>			
	</body>
</html>