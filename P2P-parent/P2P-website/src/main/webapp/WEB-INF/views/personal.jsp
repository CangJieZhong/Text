<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>蓝源Eloan-P2P平台</title>
<%@ include file="common/links-tpl.jsp"%>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/plugins/jquery.form.js"></script>
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/css/account.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/plugins/jquery-validation/jquery.validate.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/plugins/jquery-validation/localization/messages_zh.js"></script>
<script type="text/javascript">
	$(function() {
		var sendMessage;
		$("#bindPhoneForm").validate({
			rules : {
				phoneNumber : {
					required : true,
					minlength : 11,
					maxlength : 11
				}
			},
			messages : {
				phoneNumber : {
					required : "电话号码不能为空",
					minlength : "电话号码必须是11位",
					maxlength : "电话号码必须是11位"
				}
			},
			errorClass : "text-danger",
			highlight : function(element) {
				$(element).closest("div.form-group").addClass("has-error");
			},
			unhighlight : function(element) {
				$(element).closest("div.form-group").removeClass("has-error");
			}
		});
		$("#sendVerifyCode").click(function() {
			var phone = $("#phoneNumber").val();
			if (phone.length != 11) {
				alert("亲,您的电话号码有误!");
			} else {
				$("#sendVerifyCode").attr("disabled",true);
				$.ajax({
					url : "sendPhoneMessage.action?phoneNumber=" + phone,
					success : function(data) {
						if(data!=null&&data!=""){
							alert("出错了,请稍后重试!");
						}
					}
				});
				var sec = 90;
                var timer = setInterval(function(){
                    sec--;
                    if(sec > 0){
                   	 $("#sendVerifyCode").text(sec+"秒后重新发送验证码");
                    }else{
                        clearInterval(timer);
                        $("#sendVerifyCode").attr("disabled",false);
                        $("#sendVerifyCode").text("重新发送验证码");
                    }
                },1000);
			}
		});
		$("#verifyCode").blur(
				function() {
					var phone = $("#phoneNumber").val();
					if ($("#verifyCode").val().length != 6) {
						alert("验证码错误!");
						$("#bindPhone").attr("disabled", "disabled");
					} else {
						$.ajax({
							url : "savePhoneNumber.action?code="
									+ $("#verifyCode").val() + "&phoneNumber="
									+ phone,
							success : function(data) {
								if (data.success) {
									alert("保存成功");
									$("#bindPhone").attr("disabled", false);
								} else {
									alert(data.ErroMsg);
									$("#bindPhone")
											.attr("disabled", "disabled");
								}
							}
						});
					}
				});
		$("#bindPhone").click(function() {
			window.location.href = "personal.action";
		});

		$("#bindEmailForm").validate({
			rules : {
				email : {
					required : true,
					email : true
				}
			},
			messages : {
				email : {
					required : "电话号码不能为空",
					email : "请输入一个正确的邮箱"
				}
			},
			errorClass : "text-danger",
			highlight : function(element) {
				$(element).closest("div.form-group").addClass("has-error");
			},
			unhighlight : function(element) {
				$(element).closest("div.form-group").removeClass("has-error");
			}
		});
		$("#email")
				.blur(
						function() {
							var email = $("#email").val();
							$("#bindEmail").attr("disabled", true);
							if (email !== '') {
								if (!email
										.match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/)) {
									alert("邮箱格式不对!");
								} else {
									$.ajax({
										url : "checkEmail.action?email="
												+ email,
										success : function(data) {
											if (data.success) {
												alert("请在关闭会话前去邮箱确认你的邮箱地址才能保存成功哦!")
												$("#bindEmail").attr(
														"disabled", false);
											} else {//返回的是错误信息或保存失败了
												alert(data.ErroMsg);
											}
										}
									});
								}
							}
						});
		$("#bindEmail").click(function() {
			window.location.href = "personal.action";
		});
	});
</script>
</head>
<body>
	<!-- 网页顶部导航 -->
	<%@ include file="common/head-tpl.jsp"%>
	<!-- 网页导航 -->
	<!-- 在当前的freemarker的上下文中,添加一个变量,变量的名字叫currentNav,变量的值叫personal -->
	<c:set var="currentNav" value="personal"></c:set>
	<%@ include file="common/navbar-tpl.jsp"%>
	<div class="container">
		<div class="row">
			<!--导航菜单-->
			<div class="col-sm-3">
				<c:set var="currentMenu" value="personal"></c:set>
				<%@ include file="common/leftmenu-tpl.jsp"%>
			</div>
			<!-- 功能页面 -->
			<div class="col-sm-9">
				<div class="panel panel-default">
					<div class="panel-body el-account">
						<div class="el-account-info">
							<div class="pull-left el-head-img">
								<img class="icon"
									src="<%=request.getContextPath()%>/images/ms.png" />
							</div>
							<div class="pull-left el-head">
								<p>用户名:${current.username}</p>
								<p>
									最后登录时间：
									<fmt:formatDate value="${date}" pattern="yyyy年MM月dd日  HH:mm:ss" />
								</p>
							</div>
							<div class="pull-left"
								style="text-align: center; width: 400px; margin: 30px auto 0px auto;">
								<a class="btn btn-primary btn-lg" href="/recharge.action">账户充值</a>
								<a class="btn btn-danger btn-lg" href="/moneyWithdraw.action">账户提现</a>
							</div>
							<div class="clearfix"></div>
						</div>

						<div class="row h4 account-info">
							<div class="col-sm-4">
								账户总额：<span class="text-primary"><fmt:formatNumber
										value="${account.usableAmount+account.freezedAmount}" pattern="#.##" />元</span>
							</div>
							<div class="col-sm-4">
								可用金额：<span class="text-primary"><fmt:formatNumber
										value="${account.usableAmount}" pattern="#.##" />元</span>
							</div>
							<div class="col-sm-4">
								冻结金额：<span class="text-primary"><fmt:formatNumber
										value="${account.freezedAmount}" pattern="#.##" />元</span>
							</div>
						</div>

						<div class="row h4 account-info">
							<div class="col-sm-4">
								待收利息：<span class="text-primary"><fmt:formatNumber
										value="${account.unReceiveInterest}" pattern="#.##" />元</span>
							</div>
							<div class="col-sm-4">
								待收本金：<span class="text-primary"><fmt:formatNumber
										value="${account.unReceivePrincipal}" pattern="#.##" />元</span>
							</div>
							<div class="col-sm-4">
								待还本息：<span class="text-primary"><fmt:formatNumber
										value="${account.unReturnAmount}" pattern="#.##" />元</span>
							</div>
						</div>

						<div class="el-account-info top-margin">
							<div class="row">
								<div class="col-sm-4">
									<div class="el-accoun-auth">
										<div class="el-accoun-auth-left">
											<img src="images/shiming.png" />
										</div>
										<div class="el-accoun-auth-right">
											<h5>实名认证</h5>
											<c:choose>
												<c:when test="${person_Auth.real_Auth}">
													<p>
														已认证 <a href="realAuth.action">查看</a>
													</p>
												</c:when>
												<c:otherwise>
													<p>
														未认证 <a href="realAuth.action">马上认证 </a>
													</p>
												</c:otherwise>
											</c:choose>
										</div>
										<div class="clearfix"></div>
										<p class="info">实名认证之后才能在平台投资</p>
									</div>
								</div>
								<div class="col-sm-4">
									<div class="el-accoun-auth">
										<div class="el-accoun-auth-left">
											<img src="images/shouji.jpg" />
										</div>
										<div class="el-accoun-auth-right">
											<h5>手机认证</h5>
											<c:choose>
												<c:when test="${person_Auth.phone_Auth}">
													<p>
														已认证 <a href="#">查看</a>
													</p>
												</c:when>
												<c:otherwise>
													<p>
														未认证 <a href="javascript:void(0)" id="showBindPhoneModal"
															data-target="#bindPhoneModal" data-toggle="modal">马上绑定</a>
													</p>
												</c:otherwise>
											</c:choose>
										</div>
										<div class="clearfix"></div>
										<p class="info">可以收到系统操作信息,并增加使用安全性</p>
									</div>
								</div>
								<div class="col-sm-4">
									<div class="el-accoun-auth">
										<div class="el-accoun-auth-left">
											<img src="images/youxiang.jpg" />
										</div>
										<div class="el-accoun-auth-right">
											<h5>邮箱认证</h5>
											<c:choose>
												<c:when test="${person_Auth.mail_Auth}">
													<p>
														已绑定 <a href="#">修改</a>
													</p>
												</c:when>
												<c:otherwise>
													<p>
														未绑定 <a href="javascript:void(0)" id="showBindEmailModal"
															data-target="#bindEmailModal" data-toggle="modal">马上绑定</a>
													</p>
												</c:otherwise>
											</c:choose>





										</div>
										<div class="clearfix"></div>
										<p class="info">您可以设置邮箱来接收重要信息</p>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-4">
									<div class="el-accoun-auth">
										<div class="el-accoun-auth-left">
											<img src="images/baozhan.jpg" />
										</div>
										<div class="el-accoun-auth-right">
											<h5>VIP会员</h5>
											<c:choose>
												<c:when test="${person_Auth.vip}">
													<p>
														会员用户 <a href="#">查看</a>
													</p>
												</c:when>
												<c:otherwise>
													<p>
														普通用户 <a href="#">查看</a>
													</p>
												</c:otherwise>
											</c:choose>

										</div>
										<div class="clearfix"></div>
										<p class="info">VIP会员，让你更快捷的投资</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="modal fade" id="bindPhoneModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">绑定手机</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="bindPhoneForm" method="post"
						action="/bindPhone.action">
						<div class="form-group">
							<label for="phoneNumber" class="col-sm-2 control-label">手机号:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="phoneNumber"
									name="phoneNumber" value="15876021309" />
								<button id="sendVerifyCode" class="btn btn-primary"
									type="button" autocomplate="off">发送验证码</button>
							</div>
						</div>
						<div class="form-group">
							<label for="verifyCode" class="col-sm-2 control-label">验证码:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="verifyCode"
									name="verifyCode" />
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" id="bindPhone">保存</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="bindEmailModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">绑定邮箱</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="bindEmailForm" method="post"
						action="/sendEmail.action">
						<div class="form-group">
							<label for="email" class="col-sm-2 control-label">Email:</label>
							<div class="col-sm-4">
								<input type="email" class="form-control" id="email" name="email" />
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" id="bindEmail">保存</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="common/footer-tpl.jsp"%>
</body>
</html>