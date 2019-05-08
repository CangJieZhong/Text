<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>蓝源Eloan-P2P平台(系统管理平台)</title>
<%@ include file="../common/header.jsp" %>
<script type="text/javascript" src="/js/jquery/jquery-2.1.3.js"></script>
<script type="text/javascript" src="/js/bootstrap-3.3.2-dist/js/bootstrap.js"></script>
<script type="text/javascript" src="/js/jquery.bootstrap.min.js"></script>

<script type="text/javascript" src="/js/plugins/jquery.form.js"></script>
<script type="text/javascript" src="/js/plugins/jquery.twbsPagination.min.js"></script>
<script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js" ></script>

<script type="text/javascript">
$(function(){
	$(".beginDate, .endDate").click(function(){
		WdatePicker();
	}) ;
	
	
	var searchForm = $("#searchForm");
	
	var tbody = $("#tbody");
	
	searchForm.ajaxForm(function(data){    //普通请求    获取到代码片段
		tbody.hide();   //让当前的页面内容先隐藏 
		tbody.html(data);   //把当前的页面html代码替换成请求到的表单内容
		tbody.show(500);   //一种淡入的效果
	});
	searchForm.submit();   //第一次请求之后马上发送一个请求去请求内容
	
	
	$("#query").click(function(){
		$("#currentPage").val(1);
		$("#searchForm").submit();
	})
})

</script>
</head>
<body>
	<div class="container">
		<%@ include file="../common/top.jsp" %>
		<div class="row">
			<div class="col-sm-3">
				<c:set var="currentMenu" value="ipLog"></c:set>
				<%@ include file="../common/menu.jsp" %>
			</div>
			<div class="col-sm-9">
				<div class="page-header">
					<h3>登录日志查询</h3>
				</div>
				<form id="searchForm" class="form-inline" method="post" action="/ipLog_list.do">
					<input type="hidden" id="currentPage" name="currentPage" value="1"/>
					<div class="form-group">
					    <label>状态</label>
					     <select class="form-control" name="state" id="state">
					    	<option value="-1">全部</option>
					    	<option value="0">登录失败</option>
					    	<option value="1">登录成功</option>
					    </select>
					    <script type="text/javascript">
					    	 $("#state option[value=${qo.state}]").attr("selected",true);
					    </script>
					</div>
					<div class="form-group">
					    <label>登陆时间</label>
					    <input class="form-control beginDate" type="text" name="beginDate" value='${qo.beginDate}'/>到
					    <input class="form-control endDate" type="text" name="endDate" value='${qo.endDate}'/>
					</div>
					<div class="form-group">
					    <label>用户类型</label>
					     <select class="form-control" name="userType" id="userType">
					    	<option value="-1">全部</option>
					    	<option value="0">后台管理员</option>
					    	<option value="1">前台用户</option>
					    </select>
					    <script type="text/javascript">
					    //高级查询下拉框的选中
					    	$("#userType option[value=${qo.userType}]").attr("selected",true);
					    </script>
					</div>
					<div class="form-group">
						<label>用户名</label>
						<input class="form-control" type="text" name="username" value='${qo.username}'/>
					</div>
					<div class="form-group">
						<button id="query" type="button" class="btn btn-success"><i class="icon-search"></i> 查询</button>
					</div>
				</form>
				<div class="panel panel-default">
					<table class="table">
						<thead>
							<tr>
								<th>用户</th>
								<th>登录时间</th>
								<th>登录ip</th>
								<th>登录状态</th>
								<th>用户类型</th>
							</tr>
						</thead>
						<tbody id="tbody">
							
						</tbody>
					</table>
					<div style="text-align: center;" id="page_container">
						<ul id="pagination" class="pagination"></ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>