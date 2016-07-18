<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*"
    pageEncoding="UTf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JVM性能监控</title>
<meta content="pragma" content="cache-control" >
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="zxwtry, JVM, monitor">
<meta http-equiv="description" content="This is zxwtry's JVM Page">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/highcharts.js"></script>
<!-- 
<script type="text/javascript" src="js/exporting.js"></script>
 -->

<script type="text/javascript">
//去后台请求数据
function getJVMMemory () {
	var res;
	$.ajax({
		async : false,
		type : 'post',
		url : 'Memory',
		success : function (data) {
			res = data;
		},
		error : function (data) {
			res = "400"
		}
	});
	return res;
}

$(function () { 
    Highcharts.setOptions({
		global:{
			useUTC: false
		}
    });
    $("#container").highcharts({
    	chart:{
    		type:'spline',
    		events : {
    			load : function () {
    				var series0 = this.series[0];
    				var series1 = this.series[1];
    				// setInterval(function(){alert('这时一条消息')}, 2000);
    				setInterval(function() {
    					var result = getJVMMemory();
    					result = $.parseJSON(result);
    					var x = (new Date()).getTime();
    					series0.addPoint([x,parseFloat(result.avail)], true, true);
    					series1.addPoint([x,parseFloat(result.total)], true, true);
    				}, 5000);
    			}
    		}
    	},
    	credits : {
    		enable : true,
    		href: 'http://www.zxwtry.com',
    		text: 'C语言的个人分享'
    	},
    	title:{
    		text:'zxwtry JVM'
    	},
    	xAxis: {
    		type: 'datetime',
    		tickPixelInterval: 100,
    		title : {
				text: '时间'
    		}
    	},
    	yAxis: {
    		title: {
    			text:'可用内存'
    		},
    		labels : {
    			formatter: function() {
    				return this.value + 'M';
    			}
    		}
    	},
    	// 提示
    	tooltip : {
    		formatter : function () {
    			return '<b>' + this.series.name + '</b><br/>' + Highcharts.dateFormat("%Y-%m-%d %H:%M:%S", this.x)+"<br/>";
    		}
    	},
    	// 图例
    	legend : {
    		enable: false
    	},
    	exporting : {
    		enable : false
    	},
    	series:[{
    		name : 'JVM可用内存',
    		data : (function () {
    			var data = [];
    			var time = (new Date()).getTime();
    			for (var i = -10; i <= 0; i ++) {
    				data.push({
    					x : time + i *1000,
    					y : 100
    				});
    			}
    			return data;
    		})()
    	},{
    		name : 'JVM总内存',
    		data : (function () {
    			var data = [];
    			var time = (new Date()).getTime();
    			for (var i = -10; i <= 0; i ++) {
    				data.push({
    					x : time + i *1000,
    					y : 120
    				});
    			}
    			return data;
    		})()
    	}]
    });
});
</script>
</head>
<body>
	<div id="container"></div>
	<!-- 
	<div id="txtShow"></div>
	 -->
</body>
</html>