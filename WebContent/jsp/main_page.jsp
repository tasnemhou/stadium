<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页</title>
 	<script type="text/javascript" src="../framework/jquery/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="../framework/bootstrap-datetimepicker/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript" src="../framework/bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../framework/select2/select2.min.js"></script>
	
	<link rel="stylesheet" href="../framework/bootstrap-datetimepicker/bootstrap-datetimepicker.min.css" type="text/css" />
	<link rel="stylesheet" href="../framework/bootstrap-3.3.7/dist/css/bootstrap.min.css" type="text/css" />
	<link rel="stylesheet" href="../framework/select2/select2.min.css" type="text/css" />
	
	<style type="text/css">
		.background {
			background:white;
		}
	</style>
</head>
<body>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">
				<div  class="panel-title">
					<a class="collapsed" role="button" data-toggle="collapse" href="#collapseOne" >
						<span class="glyphicon glyphicon-list"></span>基础信息
					</a>
					<button type="button" class="btn btn-success" style="float:right">交易明细 </button>
				</div>
			</div>
			<div id="collapseOne" class="panel-collapse collapse in">
				<div class="panel-body">
					<div class="col-md-6 form-group">
						<div class="col-md-3 title">姓名:</div>
						<div class="col-md-9">
							<input class="form-control background" type="text" disabled>
						</div>
					</div>
				    <div class="col-md-6 form-group">
						<div class="col-md-3 title">电话：</div>
						<div class="col-md-9">
							<input class="form-control" type="text" maxlength="11">
						</div>
					</div>
					<div style="clear:both;"></div>
				    <div class="col-md-6 form-group">
						<div class="col-md-3 title">注册日期：</div>
						<div class="col-md-9">
							<input id="registDt" class="form-control" type="text" />
						</div>
					</div>
				    <div class="col-md-6 form-group">
						<div class="col-md-3 title">会员类型：</div>
						<div class="col-md-9">
							<input class="form-control" type="text" >
						</div>
					</div>
					<div style="clear:both;"></div>
					<div class="col-md-6 form-group">
						<div class="col-md-3 title">截止日期：</div>
						<div class="col-md-9">
							<input class="form-control" type="text" >
						</div>
					</div>
					<div class="col-md-6 form-group">
						<div class="col-md-3 title">剩余次数：</div>
						<div class="col-md-9">
							<input class="form-control" type="text" >
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<!-- 交易信息 -->
		<div class="panel panel-default">
			<div class="panel-heading">
				<div  class="panel-title">
					<a class="collapsed" role="button" data-toggle="collapse" href="#collapseTwo" >
						<span class="glyphicon glyphicon-list"></span>交易信息
					</a>
				</div>
			</div>
			<div id="collapseTwo" class="panel-collapse collapse in">
				<div class="panel-body">
					<form action="" method="post">
						<div class="col-md-6 form-group">
							<div class="col-md-3 title">使用人:</div>
							<div class="col-md-9">
								<input class="form-control background" type="text">
							</div>
						</div>
					    <div class="col-md-6 form-group">
							<div class="col-md-3 title">交易类型：</div>
							<div class="col-md-9">
								<select class="form-control">
									<option>消费</option>
									<option>充值</option>
								</select>
							</div>
						</div>
						<div style="clear:both;"></div>
					    <div class="col-md-6 form-group">
							<div class="col-md-3 title">消费次数：</div>
							<div class="col-md-9">
								<div class="input-group">
									<input id="registDt" class="form-control" type="text" />
									<span class="input-group-addon">次</span>
								</div>
							</div>
						</div>
					    <div class="col-md-6 form-group">
							<div class="col-md-3 title">交易方式：</div>
							<div class="col-md-9">
								<select class="form-control">
									<option>现金</option>
									<option>会员卡</option>
									<option>优惠券</option>
								</select>
							</div>
						</div>
						<div style="text-align:center;padding-top:10px">
							<input type="submit" class="btn btn-primary" value="提交">
							<a href="./customer.jsp" class="btn btn-default">返回</a>	
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>