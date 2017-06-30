<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${ctx}/css/plugins/uploadify/uploadify.css">
</head>
<body class="gray-bg">
	<form>
		<div id="queue"></div>
		<input id="file_upload" name="file_upload" type="file" multiple="true">
	</form>
	<script src="${ctx}/js/plugins/uploadify/jquery.uploadify.min.js"></script>
	<script type="text/javascript">
		$(function() {
			$('#file_upload').uploadify({
				'formData' : {},
				'swf' : '${ctx}/css/plugins/uploadify/img/uploadify.swf',
				'uploader' : '${ctx}/default/admin/uploadFile',
				onUploadSuccess : function(f, h, d) {
				},
				onUploadError : function(e, i, h) {
				}
			});
		});
	</script>
</body>
</html>