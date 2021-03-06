<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
  <head>
    <title>antiFake.html</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
    <link rel="stylesheet" type="text/css" href="css/trace.css">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/trace.js"></script>

  </head>
  
  <body>
    <div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
	    <li><a href="#">首页</a></li>
	    <li><a href="#">产品溯源</a></li>
	    </ul>
    </div>
    
    <div class="InfoInput">
	    <p>
	    	<lable for="ids">产品序号</lable><input type="text" id="ids"/><input type="button" id="query" value="查询"/>
	    </p>
    </div>
    <!-- 显示物流信息 -->
    <table class="tablelist">
    	<thead id="tableHead">
        </thead>
        <tbody id="tableBody"></tbody> 
    </table>
    <!-- 翻页 -->
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
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>提示信息</p>
        <cite>抱歉，暂无任何物流信息，请稍后查询</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" id="nodataOK"/>&nbsp;
        </div>
    </div>
  </body>
</html>
