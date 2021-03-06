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
<link href="css/salesInfo.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<link href='../jquery/chosen/chosen.min.css' rel='stylesheet' />
<script src="../jquery/chosen/chosen.jquery.min.js"></script>
<script type="text/javascript" src="js/salesInfo.js"></script>

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
     <!--    <li><input id="pNameCheckbox" type="checkbox" />
        	<label>产品名称:&nbsp;&nbsp;</label><input id="selpName" type="text" style="height:75%;" /></li>
        <li><input id="regionCheckbox" type="checkbox"  />
        	<label>地理区域:&nbsp;&nbsp;</label><input id="selRegion" type="text" style="height:75%;"/></li>												 -->
        </ul>
        <div style="float:left;background-color:rgb(240, 255, 255);height:33px;width:210px;padding:0px 6px;border-radius:5px;cursor:pointer;border:solid 1px #d3dbde;margin-left:10px;">
    		<input id="pNameCheckbox" type="checkbox" style="margin-top:10px;"/>
    		<label style="margin:auto -2px;">产品名称:&nbsp;</label>
    		<select  class="chzn-select form-inline input-sm" id="selpName" style="width:120px;margin:2px 0px;height:80%;">
    			<option  value="">查询所有</option>
    		</select>
    	</div>
    	<div style="float:left;background-color:rgb(240, 255, 255);height:33px;width:210px;padding:0px 6px;border-radius:5px;cursor:pointer;border:solid 1px #d3dbde;margin-left:10px;">
    		<input id="regionCheckbox" type="checkbox" style="margin-top:10px;"/>
    		<label style="margin:auto -2px;">地理区域:&nbsp;</label>
    		<select  class="chzn-select form-inline input-sm" id="selRegion" style="width:120px;margin:2px 0px;height:80%;">
    			<option value="">查询所有</option>
    		</select>
    	</div>
        
    
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
    <div id="editSalesInfo" >
    	<p><center style="font-weight:900;font-size:20px;">在下表中编辑数据</center></p>
    	<table class="tablelist">
	    	<thead>
	    		<tr>
				    <th><input name='' type='checkbox' value='' checked='checked'/></th>
				    <th>地域</th>
				    <th>产品名称</th>
				    <th>时间</th>
				    <th>销售额</th>
				    <th>操作</th>
				</tr>
	        </thead>
	        <tbody >
				<tr>
				   <td><input name='' type='checkbox' value='' /></td>
			       <td><textarea id="editRegion"></textarea></td>
			       <td><textarea id="editpName"></textarea></td>
			       <td><textarea id="editTime"></textarea></td>
			       <td><textarea id="editNum"></textarea></td>    
			       <td><a href='#' class='saveEdit'>保存</a>       <a href='#' class='cancelEdit'>取消</a></td>
			    </tr>      	
	        </tbody> 
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
