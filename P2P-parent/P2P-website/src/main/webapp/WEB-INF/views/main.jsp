<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>蓝源Eloan-P2P平台</title>
		<%@ include file="common/links-tpl.jsp"  %>
		<link rel="stylesheet" href="js/bootstrap-3.3.2-dist/css/bootstrap.css"
	type="text/css" />
<link rel="stylesheet" href="css/core.css" type="text/css" />
<script type="text/javascript" src="js/jquery/jquery-2.1.3.js"></script>
<script type="text/javascript"
	src="js/bootstrap-3.3.2-dist/js/bootstrap.js"></script>
<script type="text/javascript" src="js/jquery.bootstrap.min.js"></script>
<script type="text/javascript"
	src="js/plugins/jquery-validation/jquery.validate.js"></script>
<script type="text/javascript"
	src="js/plugins/jquery-validation/localization/messages_zh.js"></script>
<script type="text/javascript" src="js/plugins/jquery.form.js"></script>
		
	</head>
	<body>
	
		<!-- 网页顶部导航 -->
	<%@ include file="common/head-tpl.jsp"%>
	<!-- 网页导航 -->
		<c:set var="currentNav" value="index"></c:set>
		<%@ include file="common/navbar-tpl.jsp" %>
		
		
		<!-- banner广告部分 start -->
		<div class="container-fuil">
			<div id="carousel-banner-generi" class="carousel slide el-banner" data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#carousel-banner-generi" data-slide-to="0" class="active"></li>
					<li data-target="#carousel-banner-generi" data-slide-to="1"></li>
				</ol>
				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox">
					<div class="item active">
						<img src="/images/banner01.jpg" alt="...">
						<div class="carousel-caption"></div>
					</div>
					<div class="item">
						<img src="/images/banner02.jpg" alt="...">
						<div class="carousel-caption"></div>
					</div>
				</div>
				<!-- Controls -->
				<a class="left carousel-control" href="#carousel-banner-generi" role="button" data-slide="prev"> <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a>
				<a class="right carousel-control" href="#carousel-banner-generi" role="button" data-slide="next"> <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
		</div>
		<!-- banner广告部分 end -->
		
		<!-- 项目3大特色feature -->
		<div class="container el-feature">
			<dl class="el-feature-item01">
				<dt>投资理财</dt>
				<dd>稳定投资、高收益、短期限，易融贷先行赔付，保障投资人权益。</dd>
			</dl>
			<dl class="el-feature-item02">
				<dt>投资理财</dt>
				<dd>稳定投资、高收益、短期限，易融贷先行赔付，保障投资人权益。</dd>
			</dl>
			<dl class="el-feature-item03">
				<dt>投资理财</dt>
				<dd>稳定投资、高收益、短期限，易融贷先行赔付，保障投资人权益。</dd>
			</dl>
		</div>
		
		<!-- 投资列表 -->
		<div class="container el-panel">
			<div class="panel el-panel">
				<div class="panel-title">
					<span class="pull-left">
						进行中借款
					</span>
					<div class="pull-right">
						<a class="btn btn-link " href="/invest.do">
							进入投资列表
						</a>
					</div>
				</div>
				<table class="table el-table table-hover">
					<thead>
						<tr>
							<th>借款人</th>
							<th>借款标题</th>
							<th>年利率</th>
							<th>金额</th>
							<th>还款方式</th>
							<th>借款期限</th>
							<th>进度</th>
							<th width="80px">操作</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td colspan="7" align="center">
								<p class="text-danger">目前暂时没有进行中的借款</p>
							</td>
						</tr>
					</tbody>
					
				</table>
			</div>
			
			
			<div class="panel el-panel">
				<div class="panel-title">
					<span class="pull-left">
						企业最新资讯
					</span>
					<div class="pull-right">
						<a class="btn btn-link " href="">
							 更多资讯
						</a>
					</div>
				</div>
				<div class="el-new-list">
					<ul>
						<li>
							<a href="#">
								<span class="pull-left">央视力挺互联网金融 肯定P2P行业 </span>
								<span class="pull-right">发表日期：2015-03-23</span>
								<span class="clearfix"></span>
							</a>
						</li>
						<li>
							<a href="#">
								<span class="pull-left">央视力挺互联网金融 肯定P2P行业 </span>
								<span class="pull-right">发表日期：2015-03-23</span>
								<span class="clearfix"></span>
							</a>
						</li>
						<li>
							<a href="#">
								<span class="pull-left">央视力挺互联网金融 肯定P2P行业 </span>
								<span class="pull-right">发表日期：2015-03-23</span>
								<span class="clearfix"></span>
							</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		
		<%@ include file="common/footer-tpl.jsp" %>
	</body>
</html>