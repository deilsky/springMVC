<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<link href="${ctx}/plugins/js/layui/css/layui.css" rel="stylesheet">
</head>
<body class="gray-bg">
	<div class="ibox float-e-margins">
		<div class="ibox-content">
			<div class="row row-lg">
				<div class="col-sm-12">
					<form class="layui-form" action="">
						<div class="layui-form-item">
							<label class="layui-form-label">输入框</label>
							<div class="layui-input-block">
								<input type="text" name="title" required lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">密码框</label>
							<div class="layui-input-block">
								<input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
							</div>
							<!-- <div class="layui-form-mid layui-word-aux">辅助文字</div> -->
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">选择框</label>
							<div class="layui-input-block">
								<select name="city" lay-verify="required">
									<option value=""></option>
									<option value="0">北京</option>
									<option value="1">上海</option>
									<option value="2">广州</option>
									<option value="3">深圳</option>
									<option value="4">杭州</option>
								</select>
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">复选框</label>
							<div class="layui-input-block">
								<input type="checkbox" name="like[write]" title="写作"> <input type="checkbox" name="like[read]" title="阅读" checked> <input type="checkbox" name="like[dai]" title="发呆">
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">单选框</label>
							<div class="layui-input-block">
								<input type="radio" name="sex" value="男" title="男"> <input type="radio" name="sex" value="女" title="女" checked>
							</div>
						</div>
						<div class="layui-form-item layui-form-text">
							<label class="layui-form-label">文本域</label>
							<div class="layui-input-block">
								<textarea name="desc" placeholder="请输入内容" class="layui-textarea"></textarea>
							</div>
						</div>
						<div class="layui-form-item">
							<div class="layui-input-block">
								<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
								<button type="reset" class="layui-btn layui-btn-primary">重置</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script src="${ctx}/plugins/js/layui/layui.js"></script>
	<script type="text/javascript">
		var form,
			layer;
		$(function() {
			layui.use([ 'form', 'layer' ], function() {
				form = layui.form(),
				layer = layui.layer;
				form.on('submit(formDemo)',function(data){
					layer.msg("保存成功，正在返回",{icon : 1});
					var post = JSON.stringify(data.field);
					parent.layer.callback = JSON.parse(post);
					parent.layer.close(layer.index);
					return false;
				});
			});
		});
	</script>
</body>
</html>