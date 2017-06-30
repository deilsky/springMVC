var Public = Public || {};
Public.isIE6 = !window.XMLHttpRequest; // ie6

/*
 * 通用post请求，返回json url:请求地址， params：传递的参数{...}， callback：请求成功回调
 */
Public.ajaxPost = function(url, params, callback, error) {
	$.ajax({
		type : "POST",
		url : url,
		contentType : 'application/json',
		data : params,
		dataType : "json",
		success : function(data, status) {
			callback(data);
		},
		error : function(err) {
			error(err);
		}
	});
};
Public.ajaxGet = function(url, params, callback, error) {
	$.ajax({
		type : "GET",
		url : url,
		data : params,
		dataType : "json",
		success : function(data, status) {
			callback(data);
		},
		error : function(err) {
			error(err);
		}
	});
};