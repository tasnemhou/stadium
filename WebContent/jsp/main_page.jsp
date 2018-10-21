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
	<script type="text/javascript" src="../framework/bootstrap-table/dist/bootstrap-table.js"></script>
	<script type="text/javascript" src="../framework/bootstrap-table/dist/locale/bootstrap-table-zh-CN.js"></script>
	
	<link rel="stylesheet" href="../framework/bootstrap-datetimepicker/bootstrap-datetimepicker.min.css" type="text/css" />
	<link rel="stylesheet" href="../framework/bootstrap-3.3.7/dist/css/bootstrap.min.css" type="text/css" />
	<link rel="stylesheet" href="../framework/select2/select2.min.css" type="text/css" />
	<link rel="stylesheet" href="../framework/bootstrap-table/dist/bootstrap-table.min.css">
	<link rel="stylesheet" href="../framework/bootstrap-table/dist/bootstrap-table.css">
	
	<style type="text/css">
		.background {
			background:white;
		}
	</style>
	
	<script type="text/javascript">
		function getDealDt() {
			 $('#dealDetail_table').bootstrapTable({
				 /* columns: [{
			        field: 'customer',
			        title: '使用人'
			    }],*/
			    data: [{
			    	customer: '中国人',
			    	dealDt: '2018-10-11',
			    	dealAmount: '100',
			    	dealTimes:'/',
			    	kind:'优惠券',
			    	dealType:'充值'
			    }, {
			    	customer: '我',
			    	dealDt: '2018-10-12',
			    	dealAmount: '/',
			    	dealTimes:'1',
			    	kind:'会员卡',
			    	dealType:'消费'
			    }]  
			}) 
			 $('#dealDetail').modal();
		}
		//取消弹框页面
		function cancle_btn() {
			$('#dealDetail').modal("hide");
		}
	</script>
</head>
<body>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">
				<div  class="panel-title">
					<a class="collapsed" role="button" data-toggle="collapse" href="#collapseOne" >
						<span class="glyphicon glyphicon-list"></span>基础信息
					</a>
					<button id="getDealDt" type="button" class="btn btn-success" style="float:right" onclick="getDealDt()">交易明细 </button>
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
	
	<div class="modal fade" id="dealDetail" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			 <div class="modal-content">
			 	<div class="modal-header">
			 		<h4 class="modal-title" id="myModalLabel">客户交易明细</h4>
			 	</div>
			 	<div class="modal-body">
					<table id="dealDetail_table" class="table table-hover">
						<thead>
							<tr>
								<th data-field="customer" data-align="center">使用人</th>
								<th data-field="dealDt" data-align="center">交易日期</th>
								<th data-field="dealAmount" data-align="center">交易金额</th>
								<th data-field="dealTimes" data-align="center">交易次数</th>
								<th data-field="kind" data-align="center">交易类型</th>
								<th data-field="dealType" data-align="center">交易方式</th>
							</tr>
						</thead>
					</table>
					<div style="text-align:right;padding-top:10px">
						<button type="button" class="btn btn-primary" onclick="cancle_btn()">确定</button>
					</div>
				</div>
			 </div>
		</div>
	</div>
	
</body>
</html>