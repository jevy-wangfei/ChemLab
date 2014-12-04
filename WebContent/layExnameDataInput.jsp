<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><s:text name="dataProcess"></s:text></title>
<link href="css.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="all">
<s:include value="head.jsp"></s:include>
  <div id="contener">
   <s:include value="index-2.jsp"/>
<div id="content">
<div id="co2"><br />
		<s:iterator id="data" value="#request.exname">
    	<s:url id="url" action="dispacherDataInput">
    		<s:param name="enid" value="#data.enid"></s:param>
    	</s:url>
    	<h4 align="center"><s:a href="%{url}"><s:property value="#data.exname"/></s:a></h4>
    </s:iterator>
</div>
</div>
  <!--end of contener -->
</div>
<s:include value="bottom.jsp"></s:include>
</div>
</body>
</html>
 