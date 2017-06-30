<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<link href="${ctx}/plugins/js/bootstrap-table/bootstrap-table.css" rel="stylesheet">
<link href="${ctx}/plugins/js/layui/css/layui.css" rel="stylesheet">
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="ibox float-e-margins">
			<div class="ibox-content">
				<div class="row row-lg">
					<div class="col-sm-12">
						<div class="example-wrap">
							<div class="example">
								<div class="btn-group hidden-xs" id="tableToolbar" role="group">
									<div class="layui-btn-group">
										<button class="layui-btn layui-btn-small" id="add">
											<i class="layui-icon">&#xe654;</i>
										</button>
										<button class="layui-btn layui-btn-small" id="mod">
											<i class="layui-icon">&#xe642;</i>
										</button>
										<button class="layui-btn layui-btn-small" id="del">
											<i class="layui-icon">&#xe640;</i>
										</button>
									</div>
								</div>
								<table id="table" data-height="400" data-mobile-responsive="true">
									<thead>
										<tr>
											<!-- <th data-field="state" data-checkbox="true"></th>
											<th data-field="id">ID</th>
											<th data-field="userName">名称</th>
											<th data-field="birth">生日</th> -->
										</tr>
									</thead>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="${ctx}/plugins/js/layui/layui.js"></script>
	<script src="${ctx}/plugins/js/bootstrap-table/bootstrap-table.js"></script>
	<script src="${ctx}/plugins/js/bootstrap-table/locale/bootstrap-table-zh-CN.js"></script>
	<script type="text/javascript">
		var $table = $('#table');
		var form,
			layer;
		$(function() {
			layui.use([ 'form', 'layer' ], function() {
				form = layui.form(),
				layer = layui.layer;
				layer.config({
					callback : function(data) {}
				});
			});
			initTable();
		});
		function operateFormatter(value, row, index) {
			var html = [];
			html.push('<div class="layui-btn-group">');
			html.push('<button class="layui-btn layui-btn-small cadd"><i class="layui-icon">&#xe654;</i></button>');
			html.push('<button class="layui-btn layui-btn-small cmod"><i class="layui-icon">&#xe642;</i></button>');
			html.push('<button class="layui-btn layui-btn-small cdel"><i class="layui-icon">&#xe640;</i></button>');
			html.push('</div>');
			html.join('');
			return html;
		/* return [
			,
			+
			+
			,
			
			
		].join(''); */
		}
		window.operateEvents = {
			'click .cadd' : function(e, value, row, index) {
				alert('You click like action, row: ' + JSON.stringify(row));
			},
			'click .cmod' : function(e, value, row, index) {
				alert('You click like action, row: ' + JSON.stringify(row));
			},
			'click .cdel' : function(e, value, row, index) {
				$table.bootstrapTable('remove', {
					field : 'id',
					values : [ row.id ]
				});
			}
		};
		function initTable() {
			$table.bootstrapTable({
				url : '${ctx}/default/manager/shopper/bootData',
				striped : true,
				height : $(window).height() - 150,
				search : true,
				pagination : true,
				pageSize : 5,
				pageList : [ 1, 2, 5, 10, 30 ],
				onlyInfoPagination : false,
				pageNumber : 1,
				paginationHAlign : "right",
				paginationVAlign : "bottom",
				paginationDetailHAlign : "left",
				paginationFirstText : "&laquo;",
				paginationPreText : "&lsaquo;",
				paginationNextText : "&rsaquo;",
				paginationLastText : "&raquo;",
				showPaginationSwitch : false, //是否显示分页切换按钮
				showFooter : false,
				showRefresh : false,
				showToggle : false,
				showColumns : false,
				searchAlign : 'left',
				iconSize : "outline",
				sidePagination : "server",
				toolbar : "#tableToolbar",
				/* icons : {
					refresh : "glyphicon-repeat",
					toggle : "glyphicon-list-alt", 
					columns : "glyphicon-list"
				}, */
	
				columns : [
					{
						field : 'state',
						checkbox : true
					}, {
						field : 'operate',
						title : '操作',
						events : operateEvents,
						formatter : operateFormatter,
						align : 'center',
						valign : 'middle'
					},
					{
						field : 'id',
						title : 'ID',
						//align : 'center',
						//valign : 'middle',
						sortable : false
					},
					{
						field : 'userName',
						title : '用户名',
						//align : 'center',
						//valign : 'middle',
						sortable : false
					},
					{
						field : 'realName',
						title : '真实姓名',
						//align : 'center',
						//valign : 'middle',
						sortable : false
					},
					{
						field : 'regTime',
						title : '注册时间',
						//align : 'center',
						//valign : 'middle',
						sortable : true
					}
				]
			});
	
			/* $table.on("all.bs.table", function(e, t, o) {
				// 行点击事件
				console.log("Event:", t, ", data:", o);
			}); 
			$table.on("click-row.bs.table", function(e, t, o) {
				// 行点击事件
				console.log("Event: click-row.bs.table")
			});
			$table.on("dbl-click-row.bs.table", function(e, t, o) {
				console.log("Event: dbl-click-row.bs.table")
			});
			*/
			$table.on("check.bs.table", function(e, t, o) {
				console.log("Event: check.bs.table");
			});
	
			$("#add").on("click", function() {
				layer.open({
					type : 2,
					skin : 'layui-layer-rim', //加上边框
					area : [ '600px', '700px' ], //宽高
					content : '${ctx}/default/manager/shopper/edit/0',
					end : function(layero, index) {
						debugger;
						console.log(layer.callback);
					},
					callback : {}
	
				/* ,
				btn : [ '关闭', '确定' ],
				btn1 : function(index, layero) {
					debugger;
				},
				btn2 : function(index, layero) {
					debugger;
					if (!$("#validateForm").valid()) {
						$("#validateForm").find("input.error").eq(0).focus();
						return false;
					}
				} */
				});
			});
		}
	</script>
</body>
</html>