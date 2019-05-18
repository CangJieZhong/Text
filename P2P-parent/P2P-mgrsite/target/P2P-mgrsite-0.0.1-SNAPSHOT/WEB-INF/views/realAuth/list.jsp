<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="el-common" prefix="el"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>蓝源Eloan-P2P平台(系统管理平台)</title>
<%@ include file="../common/header.jsp"%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/plugins/jquery.form.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/plugins/jquery.twbsPagination.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript">
	$(function() {
		$("#beginDate,#endDate").click(function() {
			WdatePicker();
		});
		$("#query").click(function() {
			$("#currentPage").val(1);
			$("#searchForm").submit();
		});
		// 给审核按钮绑定事件 
		$(".auditClass").click(function() {
			var data = $(this).attr("data");
			var json = eval("(" + data + ")");
			$("#editform")[0].reset();
			$("#id").val(json.id);
			$("#username").text(json.applierName);
			$("#realName").text(json.realname);
			$("#idNumber").text(json.idNumber);
			if (json.sex == 0) {
				$("#sex").text("男");
			} else {
				$("#sex").text("女");
			}
			$("#bornDate").text(json.birthDate);
			$("#address").text(json.address);
			$("#image1").attr("src", json.image1);
			$("#image2").attr("src", json.image2);
			$("#myModal").modal("show");
		});
		//给审核成功和审核失败添加绑定事件
		$(".btn_audit").click(function() {
			var form = $("#editform");
			form.find("[name=state]").val($(this).val()); //将当前对应的value值赋给state
			$("#myModal").modal("hide");
			form.ajaxSubmit(function(data) {
				if (data.success) {
					$.messager.confirm("提示", "审核成功", function() {
						window.location.reload();
					});
				} else {
					$.messager.popup(data.msg);
				}
			});
		});
		//分页
		$('#pagination').twbsPagination({
			//总页数
			totalPages : ${pageResult.pages},
			//当前页
			startPage : ${pageResult.pageNum},
			//页码容量
			visiblePages : 5,
			first : "首页",
			prev : "上一页",
			next : "下一页",
			last : "最后一页",
			//回调函数
			onPageClick : function(event, page) {
				$("#currentPage").val(page);
				$("#searchForm").submit();
			}
		});
	});
</script>
</head>
<body>
	<div class="container">
		<%@ include file="../common/top.jsp"%>
		<div class="row">
			<div class="col-sm-3">
				<c:set var="currentMenu" value="realAuth"></c:set>
				<%@ include file="../common/menu.jsp"%>
			</div>
			<div class="col-sm-9">
				<div class="page-header">
					<h3>实名审核管理</h3>
				</div>
				<form id="searchForm" class="form-inline" method="post"
					action="realAuth.action">
					<input type="hidden" id="currentPage" name="currentPage" value="" />
					<div class="form-group">
						<label>状态</label> <select class="form-control" name="state">
							<option value="-1">全部</option>
							<option value="0">待审核</option>
							<option value="1">审核通过</option>
							<option value="2">审核拒绝</option>
						</select>
						<script type="text/javascript">
							$("[name=state] option[value=${qo.state}]")
									.attr("selected", "selected");
						</script>
					</div>
					<div class="form-group">
						<label>申请时间</label> <input class="form-control" type="text"
						
							name="beginDate" id="beginDate" value="<fmt:formatDate value="${qo.beginDate}"/>" />到 <input
							class="form-control" type="text" name="endDate" id="endDate"
							value="<fmt:formatDate value="${qo.endDate}"/>" />
					</div>
					<div class="form-group">
						<button id="query" class="btn btn-success">
							<i class="icon-search"></i> 查询
						</button>
					</div>
				</form>
				<div class="panel panel-default">
					<table class="table">
						<thead>
							<tr>
								<th>用户名</th>
								<th>真实姓名</th>
								<th>性别</th>
								<th>身份证号码</th>
								<th>身份证地址</th>
								<th>状态</th>
								<th>审核人</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${pageResult.list}" var="info">
								<tr>
									<td>${info.applierName}</td>
									<td>${info.realname}</td>
									<c:choose>
										<c:when test="${info.sex==0}">
											<td>男</td>
										</c:when>
										<c:otherwise>
											<td>女</td>
										</c:otherwise>
									</c:choose>
									<td>${info.idNumber}</td>
									<td>${info.address}</td>
									<c:choose>
										<c:when test="${info.state==0}">
											<td>待审核</td>
										</c:when>
										<c:when test="${info.state==1}">
											<td>审核通过</td>
										</c:when>
										<c:when test="${info.state==2}">
											<td>审核拒绝</td>
										</c:when>
									</c:choose>

									<td>${info.auditorName}</td>
									<td><c:if test="${info.state == 0 }">
											<a href="javascript:void(-1);" class="auditClass"
												data=${el:toJsonString(info)}>审核</a>
										</c:if></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div style="text-align: center;">
						<ul id="pagination" class="pagination"></ul>
					</div>
				</div>
			</div>
		</div>

		<div class="modal fade" id="myModal" tabindex="-1" role="dialog">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-body">
						<form class="form-horizontal" id="editform" method="post"
							action="realAuth_audit.action">
							<fieldset>
								<div id="legend" class="">
									<legend>实名认证审核</legend>
								</div>
								<input type="hidden" name="id" id="id" value="" /> <input
									type="hidden" name="state" id="state" value="" />
								<div class="row">
									<label class="col-sm-2 control-label" for="name">用户名</label>
									<div class="col-sm-4">
										<label class="form-control" name="username" id="username"></label>
									</div>
									<label class="col-sm-2 control-label" for="name">真实姓名</label>
									<div class="col-sm-4">
										<label class="form-control" name="realname" id="realName"></label>
									</div>
								</div>
								<div class="row">
									<label class="col-sm-2 control-label" for="name">身份证号</label>
									<div class="col-sm-4">
										<label class="form-control" name="idNumber" id="idNumber"></label>
									</div>
									<label class="col-sm-2 control-label" for="name">性别</label>
									<div class="col-sm-4">
										<label class="form-control" id="sex"></label>
									</div>
								</div>
								<div class="row">
									<label class="col-sm-2 control-label" for="name">生日</label>
									<div class="col-sm-4">
										<label class="form-control" id="bornDate"></label>
									</div>
									<label class="col-sm-2 control-label" for="name">身份证地址</label>
									<div class="col-sm-4">
										<label class="form-control" id="address"></label>
									</div>
								</div>
								<div class="row">
									<label class="col-sm-2 control-label" for="name">身份证正面</label>
									<div class="col-sm-4">
										<img src="" id="image1" style="width: 150px;" />
									</div>
									<label class="col-sm-2 control-label" for="name">身份证背面</label>
									<div class="col-sm-4">
										<img src="" id="image2" style="width: 150px;" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="name">审核备注</label>
									<div class="col-sm-6">
										<textarea name="remark" rows="4" cols="60"></textarea>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-success btn_audit" value="1">审核通过</button>
						<button type="button" class="btn btn-warning btn_audit" value="2">审核拒绝</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>