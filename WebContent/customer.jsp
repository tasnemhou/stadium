<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>客户信息登陆</title>

 	<script type="text/javascript" src="jquery-3.3.1.js"></script>
	<script type="text/javascript" src="bootstrap/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript" src="bootstrap/bootstrap.min.js"></script>
	<script type="text/javascript" src="select2/select2.min.js"></script>
	
	<link rel="stylesheet" href="bootstrap/bootstrap-datetimepicker.min.css" type="text/css" />
	<link rel="stylesheet" href="bootstrap/bootstrap.min.css" type="text/css" />
	<link rel="stylesheet" href="select2/select2.min.css" type="text/css" />
 
 	<style type="text/css">
 		form {
    		margin:150px auto;
    		width:300px;
    	}
 	</style>
</head>
<body>
	<form action="cus_login.do">
		<div style="text-align:center">
			<div class="form-group form-inline">
				<label class="control-label">手机号:</label>
				<input class="form-control" type="text" >
			</div>
			<div class="form-group form-inline">
				<label class="control-label">密&nbsp;&nbsp;码：</label>
				<input class="form-control" type="password">
			</div>
		</div>
		<div style="text-align:center;padding-top:10px">
			<input type="submit" class="btn btn-primary" value="提交">
			<input type="button" class="btn btn-default" value="返回">
		</div>
	</form>
</body>
</html>