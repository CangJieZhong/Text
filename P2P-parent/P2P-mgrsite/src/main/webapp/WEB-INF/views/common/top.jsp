<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="navbar cm-navbar">
	<img class="logo" alt="Brand" src="<%=request.getContextPath() %>/images/logo.png">
	<span class="pageTitle">&nbsp;</span>
	<ul class="nav navbar-nav navbar-right cm-navbar-nav">
		<li>
			<p class="navbar-text text-info">${current.username}</p>
		</li>
		<li><a href="">安全退出</a></li>
		<li><a href="">个人设置</a></li>
	</ul>
</div>