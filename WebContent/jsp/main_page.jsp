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
		#name,#phone,#registDt,#customerType,#begDt,#endDt,#lastTimes,#customer,#amount,#dealKind,#dealType{
			background:#ffffff
		}
	</style>
	
	<script type="text/javascript">
		var customerId = "";
		
		$(function() {
			var phone;
			var url=window.location.search; //获取url中"?"符后的字串  
			if(url.indexOf("?")!=-1){
				phone = url.substr(url.indexOf("=")+1);
			}
			if(phone=="9") {
				//说明是散客登陆
// 				getCusTypeVal("N");
				updateCusType(3);
			}else {
				//获取用户信息
				getUserInfo(phone);
			}
			
			// 初始化日期组件 
 			init_date();
			
			$("#dealKind").attr("disabled","disabled");
			$("#dealKind").val("1");
		});

		function getUserInfo(phone) {
			//获取登陆页面传过来的参数：phone
			var customertype;
			//根据手机号查询用户信息
			$.ajax({
 				url:"customer.deal",
 				type:"post",
 				data:{"phone":phone},
 				dataType:"json",
 				success:function(data){   
 					customerId = data.userInfo.customerId;
 					customertype = data.userInfo.customertype;
					$("#name").val(data.userInfo.name);
					$("#registDt").val(data.userInfo.registDt);
					$("#customerType").val(customertype);
					
					/* $("#endDt").val(data.userInfo.name);*/
					$("#lastTimes").val(data.userInfo.lastTimes);
					$("#begDt").val(data.userInfo.begDate);
					$("#endDt").val(data.userInfo.endDate);
					$("#phone").val(phone); 
					
					if(customertype=="0"||customertype=="1") {
						$(".lastTimes").hide();
						$(".beDate").show();
					}else {
						$(".lastTimes").show();
						$(".beDate").hide();
					}
 				},
 				error:function(){
 					window.location.href="../jsp/error.jsp";
 				}
 			})
		}
		
		//获取交易明细
		function getDealDt() {
			 $('#dealDetail_table').bootstrapTable({
			    url:'DealDetail.deal',
			    method:'post',
			    contentType:'application/x-www-form-urlencoded;charset=UTF-8',  //post请求的时候，一定要加上这句话，否则后台接收不到入参
			    striped:true, 	// 是否显示行间隔色
			    cache:'true',
			    pagination:true,
			    sidePagination: "server", 
			    toolbar: "#toolbar",
			    /* pageNumber: 1,
			    pageSize: 10, */
			    pageList: [10, 25, 50, 100],
			    
			    dataField:'list',
			    totleField:20,
			    queryParams:function (params) {return {'customerId':customerId,'pageSize':10,'pageNumber':1};},
			    columns:[
			 		{field: 'customerId',	title: '用户id'},
			 		{field: 'customer',		title: '使用人'},
			 		{field: 'dealDt',		title: '交易日期'},
			 		{field: 'dealAmount',	title: '交易金额'},
			 		{field: 'dealTimes',	title: '交易次数'},
			 		{field: 'dealType',		title: '交易类型'},
			 		{field: 'dealKind',		title: '交易方式'}
			    ]
			}) 
			 $('#dealDetail').modal();
		}
		
		//取消弹框页面
		function cancle_btn() {
			$('#dealDetail').modal("hide");
		}
		
		//修改用户类型
		function updateCusType(flag) {
			if(flag=="1") {    //会员充值
				$('#begDt').removeAttr("disabled");
				$('#endDt').removeAttr("disabled");
				$('#lastTimes').removeAttr("disabled");
				$("#dealKind").val("0");
				
				$("#customerType option[value='3']").remove();
				
				$("#isPay").removeClass();
				$("#isPay").addClass("btn btn-primary");
				
				$("[value='会员消费']").hide();
				$("[value='散客消费']").hide();
				
				if($('#isPay').val()=="确认") {
					$('#isPay').val("提交")
					
					$('#customerType').css("background","#ffffff");
					$('#customerType').attr("disabled","disabled");
					$('#begDt').attr("disabled","disabled");
					$('#endDt').attr("disabled","disabled");
					$('#lastTimes').attr("disabled","disabled");
					$('#customer').attr("disabled","disabled");
					$('#amount').attr("disabled","disabled");
					$("#dealType").attr("disabled","disabled");
// 					$("#dealKind").attr("disabled","disabled");
				}else if($('#isPay').val()=="会员充值") {
					$('#isPay').val("确认")
					
					$('#customerType').removeAttr("disabled");
					$("#customerType").css("background","red");
					$(".dealTimes,.amount").hide();
					$(".amount1").show();
				}else if($('#isPay').val()=="提交") {
					dealInfoSubmit(flag);
				}
			}else if(flag=="2") {   //会员消费
				$("[value='散客消费']").hide();
				$("[value='会员充值']").hide();
				
				if($("#vip_consum").val()=="会员消费") {
					$("#vip_consum").val("提交")
				}else if($("#vip_consum").val()=="提交") {
					dealInfoSubmit(flag);
				}
			}else if(flag=="3") {	//散客消费
				$("#customerType").val("3");
			
				$(".cus_info,.beDate,.lastTimes").hide();
				$("[value='会员消费']").hide();
				$("[value='会员充值']").hide();
				
				$("#dealKind").val(1).attr("disabled","disabled");
				$("#dealType option[value='1']").remove();
				$(".dealTimes,.amount").hide();
				$(".amount1").show();
				
				$("#consum").removeClass();
				$("#consum").addClass("btn btn-primary");
				if($("#consum").val()=="散客消费") {
					$("#consum").val("提交")
				}else if($("#consum").val()=="提交") {
					dealInfoSubmit(flag);
				}
			}
		}
		
		//初始化日期组件
		function init_date() {
		  //起始日期
		  $("#begDt").datetimepicker({
		        format: "yyyy-mm-dd",
		        autoclose: true,
		        todayBtn: true,
		        minView:'month',
		        pickerPosition: "bottom-left",
		        language:'zh-CN'
		    });
			//截止日期
		    $("#endDt").datetimepicker({
		        format: "yyyy-mm-dd",
		        autoclose: true,
		        todayBtn: true,
		        minView:'month',
		        pickerPosition: "bottom-left",
		        language:'zh-CN'
		    });
		}
		
		//根据会员类型判断,显示日期组件 还是显示剩余次数
		function getCusTypeVal() {
			
			$("#customer").val("");
			$("#dealTimes").val("");
			$("#amount").val("");
			
			$("#dealKind").val(0).attr("disabled","disabled").css("background","#ffffff");
			$("#dealTimes").attr("disabled","disabled").css("background","#ffffff")
			$("#dealType").val(0).attr("disabled","disabled").css("background","#ffffff");
			
			$(".amount").hide();
			$(".amount1").show();
			var customerType = $("#customerType").val();
			if(customerType=="0" || customerType=="1") {
				$(".lastTimes").hide();
				$(".beDate").show();
				$('#begDt').removeAttr("disabled");
				$('#endDt').removeAttr("disabled");
				/* $('#lastTimes').attr("disabled","disabled"); */
			}else if(customerType=="2") {
				$(".lastTimes").show();
				$(".beDate").hide();
				/* $('#begDt').attr("disabled","disabled");
				$('#endDt').attr("disabled","disabled"); */
				$('#lastTimes').removeAttr("disabled");
			}else if(customerType=="3") {
				//如果是散客，则按照消费处理
// 				$("#dealKind").removeAttr("disabled");
				$("#dealType").removeAttr("disabled");
				$("#amount").removeAttr("disabled");
				
				$('.beDate,.lastTimes').hide();
// 				$('.lastTimes').hide();
				
				$("#dealKind").val(1);
				$("#dealType").val(0);
			}
		}
		
		function getDealType() {
			if($("#dealType").val()=='0') {
				$(".amount").hide();
				$(".amount1").show();
			}else {
				$(".amount").hide();
			}
		}
		
		//提交
		function dealInfoSubmit(isPay) {
			var param = {
				"customerId":   customerId,
				"isPay": 		isPay,  //1-会员充值  2-会员消费  3-散客消费
				"customerType": $("#customerType").val(),
				"begDt": 		$("#begDt").val(),
				"endDt": 		$("#endDt").val(),
				"lastTimes": 	$("#lastTimes").val(),
				"customer": 	$("#customer").val(),
				"dealKind": 	$("#dealKind").val(),
				"dealTimes": 	$("#dealTimes").val(),
				"dealType": 	$("#dealType").val(),
				"amount": 		$("#amount").val()					
			}
			
			$.ajax({
 				url:"customerDeal.deal",
 				type:"post",
 				data:param,
 				dataType:"json",
 				success:function(data){  
 					if(data.i==0) {
 						alert("保存成功！");
 					}
 					
 				},
 				error:function(){
 					window.location.href="../jsp/error.jsp";
 				}
 			})
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
					<div class="col-md-6 form-group cus_info">
						<div class="col-md-3 title">会员姓名：</div>
						<div class="col-md-9">
							<input id="name" class="form-control background" type="text" disabled>
						</div>
					</div>
				    <div class="col-md-6 form-group cus_info">
						<div class="col-md-3 title">会员电话：</div>
						<div class="col-md-9">
							<input id="phone" class="form-control" type="text" maxlength="11" disabled>
						</div>
					</div>
					<div style="clear:both;" class="cus_info"></div>
				    <div class="col-md-6 form-group cus_info">
						<div class="col-md-3 title">注册日期：</div>
						<div class="col-md-9">
							<input id="registDt" class="form-control" type="text" disabled />
						</div>
					</div>
				    <div class="col-md-6 form-group">
						<div class="col-md-3 title">会员类型：</div>
						<div class="col-md-9">
<!-- 							<div class="input-group col-md-12"> -->
								<select id="customerType" class="form-control" onchange="getCusTypeVal()" disabled>
									<option value="0">年卡会员</option>
									<option value="1">月卡会员</option>
									<option value="2">次卡会员</option>
									<option value="3">散客</option>
								</select>
<!-- 							</div> -->
						</div>
					</div>
					<div class="beDate" style="clear:both;"></div>
					<div class="col-md-6 form-group beDate">
						<div class="col-md-3 title">起始日期：</div>
						<div class="col-md-9">
							<div class="input-group date form-date">
								 <input id="begDt" class="form-control" type="text" disabled/><span class="input-group-addon"><span class=" glyphicon glyphicon-calendar" ></span></span>
							</div>
						</div>
					</div>
					<div class="col-md-6 form-group beDate">
						<div class="col-md-3 title">截止日期：</div>
						<div class="col-md-9">
							<div class="input-group date form-date">
								 <input id="endDt" class="form-control" type="text" disabled/><span class="input-group-addon"><span class=" glyphicon glyphicon-calendar" ></span></span>
							</div>
						</div>
					</div>
					<div style="clear:both;" class="lastTimes"></div>
					<div class="col-md-6 form-group lastTimes">
						<div class="col-md-3 title">剩余次数：</div>
						<div class="col-md-9">
							<input id="lastTimes" class="form-control" type="text" disabled>
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
							<div class="col-md-3 title">使用人：</div>
							<div class="col-md-9">
								<input id="customer" class="form-control background" type="text">
							</div>
						</div>
					    <div class="col-md-6 form-group">
							<div class="col-md-3 title">交易类型：</div>
							<div class="col-md-9">
								<select id="dealKind" class="form-control">
									<option value="9">请选择</option>
									<option value="0">充值</option>
									<option value="1">消费</option>
								</select>
							</div>
						</div>
						<div style="clear:both;"></div>
					    <div class="col-md-6 form-group dealTimes">
							<div class="col-md-3 title">消费次数：</div>
							<div class="col-md-9">
								<div class="input-group">
									<input id="dealTimes" class="form-control" type="text" />
									<span class="input-group-addon">次</span>
								</div>
							</div>
						</div>
					    <div class="col-md-6 form-group">
							<div class="col-md-3 title">交易方式：</div>
							<div class="col-md-9">
								<select id="dealType" class="form-control" onchange="getDealType();">
									<option value="9">请选择</option>
									<option value="0">现金</option>
									<option value="1">会员卡</option>
									<option value="2">免费（优惠券）</option>
								</select>
							</div>
						</div>
						<div style="clear:both;" class="amount" style="display:none"></div>
					    <div class="col-md-6 form-group amount amount1" style="display:none">
							<div class="col-md-3 title">交易金额：</div>
							<div class="col-md-9">
								<div class="input-group">
									<input id="amount" class="form-control" type="text" />
									<span class="input-group-addon">元</span>
								</div>
							</div>
						</div>
						<div style="clear:both;"></div>
						<div style="text-align:center;padding-top:10px">
							<input id="vip_consum" type="button" class="btn btn-primary" onclick="updateCusType('2')" value="会员消费">
							<!-- <input id="consum" type="button" class="btn btn-default" onclick="updateCusType('3')" value="散客消费"> -->
							<input id="isPay" type="button" class="btn btn-default" onclick="updateCusType('1')" value="会员充值">
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
								<!-- <th data-field="customerId" data-align="center">使用id</th>
								<th data-field="customer" 	data-align="center">使用人</th>
								<th data-field="dealDt" 	data-align="center">交易日期</th>
								<th data-field="dealAmount" data-align="center">交易金额</th>
								<th data-field="dealTimes" 	data-align="center">交易次数</th>
								<th data-field="dealType" 	data-align="center">交易类型</th>
								<th data-field="dealKind" 	data-align="center">交易方式</th> -->
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