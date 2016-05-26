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
    
    <link rel="stylesheet" type="text/css" href="css/antiFake.css">
    <script language="JavaScript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/antiFake.js"></script>

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
    
    <div class="result">
    	<h1><span>你所查询的产品为正品，其相关产品信息如下表</span></h1>
    	<table id="InfoTable">
    		<tr><td>名称</td><td>巴拉拉小魔仙</td><td>产地</td><td>华中科技大学</td></tr>
    		<tr><td>名称</td><td>巴拉拉</td><td>产地</td><td>华中科学</td></tr>
    		<tr><td>名称</td><td>巴拉拉</td><td>产地</td><td>华中科技大学</td></tr>
    		<tr><td>名称</td><td>巴拉拉小魔仙</td><td>产地</td><td>华中科技大学</td></tr>
    	</table>
    </div>
    <div class="noData">
    	<h1>你所查询的产品为伪冒品，举报电话：88888889</h1>
    </div>
  </body>
</html>
