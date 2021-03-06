<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<!-- <link href="css/style.css" rel="stylesheet" type="text/css" /> -->
<link href="css/productInfo.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/productInfo.js"></script>
<script type="text/javascript" src="../jquery/My97DatePicker/WdatePicker.js"></script>
<!-- <script type="text/javascript" src="${ctx}/static/jquery-validation/1.11.1/additional.js"></script> -->

<script type="text/javascript">
$(document).ready(function(){
  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>


</head>


<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">信息管理</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
    	<li class="addItems"><span><img src="images/addItems.png" /></span>添加</li>
        <li class="click"><span><img src="images/select.png" /></span>刷新</li>
        <li><input id="boxCheckbox" type="checkbox" />
        	<label>箱体批号:&nbsp;&nbsp;</label><input id="boxID" type="text" style="height:75%;"/></li>
        <li><input id="caseCheckbox" type="checkbox"  />
        	<label>盒体批号:&nbsp;&nbsp;</label><input id="caseID" type="text" style="height:75%;"/></li>	
		<li><input id="productCheckbox" type="checkbox"  />
        	<label>产品批号:&nbsp;&nbsp;</label><input id="productID" type="text" style="height:75%;"/></li>													
        </ul>
        
    
    </div>
    
    
    <table class="tablelist">
    	<thead id="tableHead">
        </thead>
        <tbody id="tableBody"></tbody> 
    </table>
    
   
    <div class="pagin">
    	<div class="message">共<i id="pageSum" class="blue">1</i>页<i id="dataSum" class="blue">0</i>条记录，当前显示第&nbsp;<i id="pageNumber" class="blue">1&nbsp;</i>页</div>
        <ul class="paginList">
        <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
        <li class="paginItem"><input type="text" id="toPageNum" /></li>
        <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
        </ul>
    </div>
    <!-- 编辑和新增条目表，初始均为隐藏状态 -->
    <!-- box表 -->
    <div id="editBox">
    	<p><center style="font-weight:900;font-size:20px;">在下表中编辑数据</center></p>
    	<table class="tablelist">
	    		<tr class="proTitle">
				    <td>ID<i class='sort'><img src='images/px.gif' /></i></td>
				    <td style="width:140px;">生产日期</td>
				    <td>有效期</td>
				    <td>生产厂家</td>
				    <td>生产批号</td>
				    <td>仓储信息编号</td>
				    <td>物流信息</td>
				    <td>品名</td>
			    </tr>
				<tr class="proValue">
			        <td><textarea id="editBoxIDb" readonly="readonly"></textarea></td>
			        <!-- <td><textarea id="editPdb"></textarea></td> -->
			        <td> 
		                <input id="editPdb" type="text" class="Wdate" 
		                onclick="WdatePicker({readOnly:'true'})"
		                />
               		 </td>
			        <td><textarea id="editGpb"></textarea></td>
			        <td><textarea id="editManufacturerb"></textarea></td>
			        <td><textarea id="editPbb"></textarea></td>
			        <td><textarea id="editStoreIDb"></textarea></td>
			        <td><textarea id="editLogisticsIdb"></textarea></td>
			        <td><textarea id="editpNameb"></textarea></td>
				</tr>
				<tr class="proTitle">
				    <td>数量（盒）</td>
				    <td>零售价（￥）</td>
				    <td>消费状态</td>
				    <td>消费地点</td>
				    <td>消费时间</td>
				    <td>目的销售地</td>
				    <td>备注</td>
				    <td>操作</td>
				</tr> 
				<tr class="proValue">   
			       <td><textarea id="editAmountb"></textarea></td>
			       <td><textarea id="editPriceb" onkeyup="this.value=this.value.replace(/\D/g,'');"></textarea></td>
			       <td><textarea id="editStateb"></textarea></td>
			       <td><textarea id="editConsumeAddrb"></textarea></td>
			       <td><textarea id="editConsumeTimeb"></textarea></td>
			       <td><textarea id="editTargetAddrb"></textarea></td>    
			       <td><textarea id="editRemarkb"></textarea></td>   
			       <td><a href='#' class='saveEdit'>保存</a>       <a href='#' class='cancelEdit'>取消</a></td>
			    </tr>      	
	     
    	</table> 
    </div>
    <!-- case表 -->
    <div id="editCase">
    	<p><center style="font-weight:900;font-size:20px;">在下表中编辑数据</center></p>
    	<table class="tablelist">
	    		<tr class="proTitle">
				    <td>ID<i class='sort'><img src='images/px.gif' /></i></td>		    
				    <td style="width:140px;">生产日期</td>
				    <td>有效期</td>
				    <td>生产厂家</td>
				    <td>生产批号</td>
				    <td>所属箱体编号</td>
				    <td>物流信息</td>
				    <td>品名</td>
				 </tr>
				 <tr class="proValue">
			        <td><textarea id="editCaseIDc" readonly="readonly"></textarea></td>
					<!-- <td><textarea id="editPdc"></textarea></td> -->
					<td> 
		                <input id="editPdc" type="text" class="Wdate" 
		                onclick="WdatePicker({readOnly:'true'})"
		                />
               		 </td>
					<td><textarea id="editGpc"></textarea></td>
					<td><textarea id="editManufacturerc"></textarea></td>
					<td><textarea id="editPbc"></textarea></td>
					<td><textarea id="editBoxIDc"></textarea></td>
					<td><textarea id="editLogisticsIdc"></textarea></td>
					<td><textarea id="editpNamec"></textarea></td>					
				</tr>
				 <tr class="proTitle">    
				    <td>容量</td>
				    <td>价格</td>
				    <td>消费状态</td>
				    <td>消费地点</td>
				    <td>消费时间</td>
				    <td>销售地</td>
				    <td>备注</td>
				    <td>操作</td>
				 </tr>
	        	<tr class="proValue">
					<td><textarea id="editAmountc"></textarea></td>
					<td><textarea id="editPricec" onkeyup="this.value=this.value.replace(/\D/g,'')"></textarea></td>
					<td><textarea id="editStatec"></textarea></td>
					<td><textarea id="editConsumeAddrc"></textarea></td>
			        <td><textarea id="editConsumeTimec"></textarea></td>
					<td><textarea id="editTargetAddrc"></textarea></td>
					<td><textarea id="editRemarkc"></textarea></td>	     
					<td><a href='#' class='saveEdit'>保存</a>       <a href='#' class='cancelEdit'>取消</a></td>
				</tr>
    	</table> 
    </div>
    <!-- 由于productInfo条目太多，采用新表 -->
    <div id="editProduct" >
    	<p><center style="font-weight:900;font-size:20px;">在下表中编辑数据</center></p>
    	<table class="tablelist">
    		<tr class="proTitle">
	    		<td>ID</td>
	    		<td>产品名称</td>
	    		<td>生产批号</td>
	    		<td>零售价</td>
	    		<td>目的销售地</td>
	    		<td style="width:140px;">生产日期</td>
	    		<td>产地</td>
	    		<td>有效期</td>
	    		<td>生产厂家</td>
	    		<td>操作</td>
    		</tr>
    		<tr class="proValue">
	    		<td><textarea id="editIDp" readonly="readonly"></textarea></td>
	    		<td><textarea id="editpNamep"></textarea></td>
	    		<td><textarea id="editPbp"></textarea></td>
	    		<td><textarea id="editPricep" onkeyup="this.value=this.value.replace(/\D/g,'')"></textarea></td>
	    		<td><textarea id="editTargetAddrp"></textarea></td>
	    		<!-- <td><textarea id="editPdp"></textarea></td> -->
	    		<td> 
	                <input id="editPdp" type="text" class="Wdate" 
	                onclick="WdatePicker({readOnly:'true'})"
	                />
                </td>
	    		<td><textarea id="editPap"></textarea></td>
	    		<td><textarea id="editGpp"></textarea></td>
	    		<td><textarea id="editManufacturerp"></textarea></td>
	    		<td rowspan="3"><a href="#" class="saveEdit">保存</a>       <a href="#" class="cancelEdit">取消</a></td>
    		</tr>
    		<tr class="proTitle"><td>生产线</td><td>生产原料</td><td>产品档次</td><td>产品状态</td><td>消费地点</td><td>消费时间</td><td>所属盒号</td><td>物流信息</td><td>备注</td></tr>
    		<tr class="proValue"><td><textarea id="editPlp"></textarea></td><td><textarea id="editMaterialp"></textarea></td><td><textarea id="editRangep"></textarea></td><td><textarea id="editStatep"></textarea></td><td><textarea id="editConsumeAddrp"></textarea></td><td><textarea id="editConsumeTimep"></textarea></td><td><textarea id="editCaseIDp"></textarea></td><td><textarea id="editLogisticsIdp"></textarea></td><td><textarea id="editRemarkp"></textarea></td></tr>
    	</table>
    </div>
    
<!--  查无数据    -->
    <div id="noDataWarn" class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>提示信息</p>
        <cite>抱歉，没有查找到任何满足条件的数据</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" id="nodataOK"/>&nbsp;
<!--         <input name="" type="button"  class="cancel" value="取消" /> -->
        </div>
    
    </div>
<!--  新增条目输入框    -->
      <div id="addOption" class="tip">
      <div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>提示信息</p>
        <cite>请输入新增条目</cite>
        <div><input class="newOptionText" type="text"/></div>
        </div>
        </div>
 
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" id="addOK"/>&nbsp;
        <input name="" type="button"  class="cancel" value="取消" id="addCancel"/>
        </div>
    
    </div>
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>


</body>
</html>
