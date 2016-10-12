<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp"%>

<c:if test="${data.totalPage gt 1}">
	<div class="pageList" style="margin-top:15px;">
		总计${data.totalCount}条记录&nbsp;&nbsp;
		共计${data.totalPage}页&nbsp;&nbsp;
		每页${data.pageSize}条&nbsp;&nbsp;
		当前第${data.curPage}页&nbsp;&nbsp;
		<c:if test="${data.isPrev}">
			<a href="javascript:void(0)" onclick="pageToByForm('${data.curPage-1}')" >上一页</a>
		</c:if>
		<c:if test="${data.isNext}">
			<a href="javascript:void(0)" onclick="pageToByForm('${data.curPage+1}')" >下一页</a>
		</c:if>
		<select onchange="pageToByForm(this.value)">
			<c:forEach begin="${data.pageIndex.startIndex}" end="${data.pageIndex.endIndex}" var="v">
				<option value="${v}" <c:if test="${data.curPage==v}">selected="selected"</c:if>>
					${v}
				</option>
			</c:forEach>
		</select>&nbsp;&nbsp;&nbsp;&nbsp;
		GO <input type="text" value="${data.curPage}" size="1" id="goToPageNo" 
		name="goToPageNo" onblur="pageToByForm(this.value)"  >&nbsp;页
	</div>
</c:if>


<!-- <c:if test="${data.totalPage gt 1}">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<nav>
				<ul class="pagination pull-right ">
					<li <c:if test="${!data.isPrev}">class="disabled"</c:if>><a
						href="#" aria-label="Previous"
						onclick="toNextPage('${data.curPage - 1}');return false;"><span
							aria-hidden="true">&laquo;</span></a></li>

					<c:forEach begin="${data.pageIndex.startIndex}"
						end="${data.pageIndex.endIndex}" var="v">
						<li
							<c:if
									test="${v==data.curPage}">	class="active"</c:if>><a
							href="#" onclick="toNextPage('${v}');return false;">${v} <c:if
									test="${v==data.curPage}">
									<span class="sr-only">(current)</span>
								</c:if>
						</a></li>
					</c:forEach>
					<li <c:if test="${!data.isNext}">class="disabled"</c:if>><a
						href="#" aria-label="Next"
						onclick="toNextPage('${data.curPage+1}');return false;"> <span
							aria-hidden="true">&raquo;</span>
					</a></li>
				</ul>
			</nav>
		</div>
	</div>
	<form action="" method="post" id="ipageform">
		<input value="1" name="curPage" id="icurPage" type="hidden">
		<c:forEach items="${paramMaps}" var="entry">
			<input type="hidden" name="${entry.key}" value="${entry.value}">
		</c:forEach>
	</form>

</c:if> -->
