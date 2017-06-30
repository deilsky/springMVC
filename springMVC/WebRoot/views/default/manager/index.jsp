<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
</head>
<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
	<div id="wrapper">
		<!--左侧导航开始-->
		<jsp:include page="static/left.jsp" />
		<!--左侧导航结束-->
		<!--右侧部分开始-->
		<div id="page-wrapper" class="gray-bg dashbard-1">
			<jsp:include page="static/top.jsp" />
			<div class="row J_mainContent" id="content-main">
				<iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="" frameborder="0" data-id="" seamless></iframe>
			</div>
			<jsp:include page="static/footer.jsp" />
		</div>
		<!--右侧部分结束-->
		<!--右侧边栏开始-->
		<div id="right-sidebar">
			<jsp:include page="static/right.jsp" />
		</div>
		<!--右侧边栏结束-->
	</div>
	<script src="${ctx}/plugins/js/home/metisMenu/jquery.metisMenu.js"></script>
	<script src="${ctx}/plugins/js/home/slimscroll/jquery.slimscroll.min.js"></script>
	<script src="${ctx}/plugins/js/home/hplus.min.js?v=4.1.0"></script>
	<script src="${ctx}/plugins/js/home/contabs.min.js"></script>
	<script src="${ctx}/plugins/js/home/pace/pace.min.js"></script>
	<script type="text/javascript">
		$(function(){
			
		});
	</script>
</body>
</html>