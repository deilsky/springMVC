<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
<script>if (window.top !== window.self) {
		window.top.location = window.location;
	}
</script>
<link href="${ctx}/plugins/js/layui/css/layui.css" rel="stylesheet" />
</head>
<body class="gray-bg">
	<div class="middle-box text-center loginscreen  animated fadeInDown">
		<div>
			<div>
				<h1 class="logo-name">H+</h1>
			</div>
			<h3>欢迎使用 H+</h3>
			<form class="layui-form" action="">
				<div class="layui-form-item">
					<input type="text" id="userName" name="userName" required lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input" />
				</div>
				<div class="form-group">
					<input type="password" id="passWord" name="passWord" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input" />
				</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button type="submit" class="layui-btn" lay-submit lay-filter="save">立即提交</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript" src="${ctx}/plugins/js/layui/layui.js"></script>
	<script src="${ctx}/plugins/js/common.js"></script>

	<script type="text/javascript">
		$(function() {
			layui.use([ 'layer', 'form', ], function() {
				var form = layui.form(),
					layer = layui.layer;
				form.on('submit(save)', function(data) {
					Public.ajaxPost("${ctx}/default/manager/manager/loginDo", JSON.stringify(data.field), function(d) {
						var icon = 5;
						if (200 == d.status) {
							layer.msg("登录成功，正在跳转！", {
								icon : 1
							});
							window.location.href = "${ctx}/default/manager/index";
						} else {
							layer.msg(d.msg, {
								icon : 5
							});
						}
					}, function(e) {
						layer.msg("出错啦~", {
							icon : 5
						});
					});
					return false;
				});
			});
		});
	</script>
</body>
</html>