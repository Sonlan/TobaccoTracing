<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
  <head>
    <title>address.html</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
    <link rel="stylesheet" type="text/css" href="css/address.css">
    <script language="JavaScript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/highcharts.js"></script>
    <script type="text/javascript" src="js/highcharts-3d.js"></script>
    <link href='../jquery/chosen/chosen.min.css' rel='stylesheet' />
    <script src="../jquery/chosen/chosen.jquery.min.js"></script>
    <script type="text/javascript" src="js/address.js"></script>

  </head>
  
  <body>
  	<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
	    <li><a href="#">首页</a></li>
	    <li><a href="#">数据分析</a></li>
	    </ul>
    </div>
        
    <div class="tools">
    	<div class="click" style="float:left;background-color:rgb(240, 255, 255);height:33px;width:56px;padding-right:6px;border-radius:5px;cursor:pointer;border:solid 1px #d3dbde;">
    		<span style="float:left;padding:5px 2px;"><img src="images/select.png" /></span><span style="float:left;margin:8px 1px;">查看</span>
    	</div>
    	<div style="float:left;background-color:rgb(240, 255, 255);height:33px;width:210px;padding:0px 6px;border-radius:5px;cursor:pointer;border:solid 1px #d3dbde;margin-left:10px;">
    		<input id="typeCheckbox" type="checkbox" style="margin-top:10px;"/>
    		<label style="margin:auto -2px;">产品种类:&nbsp;</label>
    		<select  class="chzn-select form-inline input-sm" id="typeSelect" style="width:120px;margin:2px 0px;height:80%;">
    			<option disabled="disabled" value="">查询</option>
    		</select>
    	</div>
    	<div style="float:left;background-color:rgb(240, 255, 255);height:33px;width:210px;padding:0px 6px;border-radius:5px;cursor:pointer;border:solid 1px #d3dbde;margin-left:10px;">
    		<input id="regionCheckbox" type="checkbox" style="margin-top:10px;"/>
    		<label style="margin:auto -2px;">地理范围:&nbsp;</label>
    		<select  class="chzn-select form-inline input-sm" id="regionSelect" style="width:120px;margin:2px 0px;height:80%;">
    			<option disabled="disabled" value="">查询</option>
    		</select>
    	</div>
 <!--    	<ul class="toolbar">
    	<li class="click"><span><img src="images/select.png" /></span>查看</li>
        <li style="width:200px;"> <input id="typeCheckbox" type="checkbox" />
        	<label>产品种类:&nbsp;</label><select id="typeSelect">
        								  <option class="typeOption">请选择产品种类    </option>
										  <option class="typeOption">红金龙</option>
										  <option class="typeOption">雪茄</option>
										  <option class="typeOption">红塔山</option>
										  <option class="typeOption">黄鹤楼</option>
										  <option class="typeOption">熊猫</option>
										  <option class="typeOption">+</option>
										</select></li>
		</li>
        <li><input id="regionCheckbox" type="checkbox" />
        	<label>地理范围:&nbsp;</label><select id="regionSelect">
        								  <option >请选择地理区域</option>
        								  <option >中国</option>
										  <option >湖北</option>
										  <option >湖南</option>
										  <option >河南</option>
										  <option >广东</option>
										  <option>+</option>
										</select></li>													
        </ul>
        <ul class="toolbar1">
      		<li><input id="deleteCheckbox" type="checkbox"/><label>是否删除选中条目&nbsp;</label></li>
        </ul>           -->
    </div>
    
    <div class="graph">
	    <div id="container" class="container" ></div>
	    <div id="container1" class="container" ></div>
	    <div id="container2" class="container1" ></div>
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
    
  </body>
</html>
