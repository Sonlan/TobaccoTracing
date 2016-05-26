<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${ctx}/super/css/peopleManage.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx}/super/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/super/js/peopleManage.js"></script>

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
    <li><a href="#">人员管理</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <li class="click"><span><img src="${ctx}/super/images/select.png" /></span>刷新</li>
        <li><input id="permissionCheckbox" type="checkbox" />
        	<label>权限等级:&nbsp;</label><select id="permissionSelect">
										  <option class="permissionOption">0 </option>
										  <option class="permissionOption">1</option>
										  <option class="permissionOption">2</option>
										  <option class="permissionOption">3</option>
										  <option>+</option>
										</select></li>
        <li><input id="scopesCheckbox" type="checkbox"  />
        	<label>监管范围:&nbsp;</label><select id="scopesSelect">
										  <option >红塔山</option>
										  <option >雪茄</option>
										  <option >黄鹤楼     </option>
										  <option >长城</option>
										  <option>+</option>
										</select></li>													
        </ul>
        
        
        <ul class="toolbar1">
        <li><input id="deleteCheckbox" type="checkbox"/><label>是否删除选中条目&nbsp;</label></li>
<!--         <li><span><img src="images/t05.png" /></span>设置</li> -->
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
<!--  查无数据    -->
    <div id="noDataWarn" class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="${ctx}/super/images/ticon.png" /></span>
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
