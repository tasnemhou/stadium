<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>注册</title>
    <script type="text/javascript" src="jquery-3.3.1.js"></script>
	<script type="text/javascript" src="bootstrap/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript" src="bootstrap/bootstrap.min.js"></script>
	<script type="text/javascript" src="select2/select2.min.js"></script>
	
	<link rel="stylesheet" href="bootstrap/bootstrap-datetimepicker.min.css" type="text/css" />
	<link rel="stylesheet" href="bootstrap/bootstrap.min.css" type="text/css" />
	<link rel="stylesheet" href="select2/select2.min.css" type="text/css" />
    
    <style type="text/css">
    	p {
/*     		test-align:center; */
    	}
    	form {
    		margin:150px auto;
    		width:300px;
    	}
    	div {
/*     		text-align:center; */
    	}
    </style>
  </head>
  <body>	
    <form action="regist.do" >
    	<div class="form-group form-inline">
	    	<label class="control-label">用户名：</label>
	    	<input class="form-control" name="userName">
    	</div>
    	<div class="form-group form-inline">
    		<label class="control-label">&nbsp;密&nbsp;&nbsp;码：</label>
	    	<input type="password" class="form-control" name="pwd">
    	</div>
    	<div class=" form-group form-inline">
    		<label class="control-label">&nbsp;手&nbsp;&nbsp;机：</label>
	    	<input class="form-control" name="phone">
    	</div>
    	<div class="form-group form-inline">
    		<label class="control-label">&nbsp;性&nbsp;&nbsp;别：</label>
		    <label class="radio-inline">
		        <input type="radio" name="sex" value="0" checked> 男
		    </label>
		    <label class="radio-inline">
		        <input type="radio" name="sex" value="1">女
		    </label>
		</div>
    	<div class="form-inline">
    		<label class="control-label">用户级别：</label>
		    <label class="radio-inline">
		        <input type="radio" name="level" value="0" > 管理员
		    </label>
		    <label class="radio-inline">
		        <input type="radio" name="level" value="1" checked>员工
		    </label>
		</div>
    	<div style="text-align:center;padding-top:10px">
    		<input type="submit" class="btn btn-primary" value="保存">
    		<a href="login.jsp" class="btn btn-default">返回</a>
    	</div>
    </form>
  </body>
</html>