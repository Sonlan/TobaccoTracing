<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/storeInfo.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/storeInfo.js"></script>
<script type="text/javascript" src="../jquery/My97DatePicker/WdatePicker.js"></script>

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
        <li><input id="inDatesCheckbox" type="checkbox"  />
        	<label>仓储信息编号:&nbsp;&nbsp;</label><input id="selInDates" type="text" style="height:75%;"/></li>
        <li><input id="storeIdsCheckbox" type="checkbox" />
        	<label>仓库编号:&nbsp;&nbsp;</label><input id="selStoreIds" type="text" style="height:75%;"/></li>												
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
    <div id="editStoreInfo" >
    	<p><center style="font-weight:900;font-size:20px;">在下表中编辑数据</center></p>
    	<table class="tablelist">
	    		<tr class="proTitle">
				    <th><input name='' type='checkbox' value='' checked='checked'/></th>
				    <th>仓库编号<i class='sort'><img src='images/px.gif' /></i></th>
				    <th>ID</th>
				    <th >入库时间</th>
				    <th >出库时间</th>
				    <th>产品生产批号</th>
				    <th>仓库地址</th>
				    <th>是否为空</th>
				    <th>备注</th>
				    <th>操作</th>
				</tr>
				<tr class="proValue">
				   <td><input name='' type='checkbox' value='' /></td>
			       <td><textarea id="editWarehouseIDs" readonly="readonly"></textarea></td>
			       <td><textarea id="editstoreIDs"></textarea></td>
			       <!-- <td><textarea id="editInDates"></textarea></td>
			       <td><textarea id="editOutDates"></textarea></td> -->
			       <td> 
		                <input id="editInDates" type="text" class="Wdate" 
		                onFocus="var overTime=$dp.$('editOutDates');WdatePicker({readOnly:'true',maxDate:'#F{$dp.$D(\'editOutDates\')}'})"
		                />
              	   </td>
                	<td> 
		                <input id="editOutDates" type="text" class="Wdate" 
		                onFocus="WdatePicker({readOnly:'true',minDate:'#F{$dp.$D(\'editInDates\')}'})"
		                />
               	  </td>
			       <td><textarea id="editPbs"></textarea></td>
			       <td><textarea id="editLocations"></textarea></td>
			       <td><textarea id="editStates"></textarea></td>
			       <td><textarea id="editRemarks"></textarea></td>     
			       <td><a href='#' class='saveEdit'>保存</a>       <a href='#' class='cancelEdit'>取消</a></td>
			    </tr>      	
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
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</div>

</body>
</html>
