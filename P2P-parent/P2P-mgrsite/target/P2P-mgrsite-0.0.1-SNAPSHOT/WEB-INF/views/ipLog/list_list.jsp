<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<c:forEach items="${pageResult.listData }" var="item">
	<tr>
		<td>${item.userName}</td>
		<td>${item.loginTime}</td>
		<td>${item.ip}</td>
		<td>${item.stateDisplay}</td>
		<td>${item.userTypeDisplay}</td>
	</tr>
	</c:forEach>

<script type="text/javascript">
	$(function(){
		//先将分页的内容先删了  之后再换成新的分页内容
		$("#page_container").empty().append($('<ul id="pagination" class="pagination"></ul>'));
		$("#pagination").twbsPagination({
			totalPages: ${pageResult.totalPage} ,
			startPage: ${pageResult.currentPage},
			first:"首页",
			prev:"上一页",
			next:"下一页",
			last:"末页",
			initiateStartPageClick:false,
			onPageClick:function(eventm,page){
				$("#currentPage").val(page); 
				$("#searchForm").submit() ; 
			}
		});
	});
</script>