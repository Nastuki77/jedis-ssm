<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${!empty data}"> 
<c:if test="${data.totalPage >= 1}">
	<div class="pageList" style="margin-top:15px;">
		总计${data.totalCount}条记录&nbsp;&nbsp;
		共计${data.totalPage}页&nbsp;&nbsp;
		每页${data.pageSize}条&nbsp;&nbsp;
		当前第${data.curPage}页&nbsp;&nbsp;
		<c:if test="${data.isPrev}">
			<a href="#" onclick="MyUtil.pageByForm2('${data.curPage-1}','${param.curpgname }','${param.fmname }','${param.repsonseId }')" >上一页</a>
		</c:if>
		<c:if test="${data.isNext}">
			<a href="#" onclick="MyUtil.pageByForm2('${data.curPage+1}','${param.curpgname }','${param.fmname }','${param.repsonseId }')" >下一页</a>
		</c:if>
		<select onchange="MyUtil.pageByForm2(this.value,'${param.curpgname }','${param.fmname }','${param.repsonseId }')">
			<c:forEach begin="${data.pageIndex.startIndex}" end="${data.pageIndex.endIndex}" var="v">
				<option value="${v}" <c:if test="${data.curPage==v}">selected="selected"</c:if>>
					${v}
				</option>
			</c:forEach>
		</select>
	</div>
</c:if>
<c:if test="${data.totalPage == 0}">
	<div class="pageList" style="margin-top:15px;">
		总计${data.totalCount}条记录&nbsp;&nbsp;
		共计1页&nbsp;&nbsp;
		每页${data.pageSize}条&nbsp;&nbsp;
		当前第1页&nbsp;&nbsp;
	</div>
</c:if>
</c:if>
<c:if test="${empty data}"> 
	<div class="pageList" style="margin-top:15px;">
		总计0条记录&nbsp;&nbsp;
		共计1页&nbsp;&nbsp;
		每页20条&nbsp;&nbsp;
		当前第1页&nbsp;&nbsp;
	</div>
</c:if>
