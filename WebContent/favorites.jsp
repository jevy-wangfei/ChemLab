<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title><s:text name="favorite"></s:text></title>
    <link href="css.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
<div id="all">
<s:include value="head.jsp"></s:include>
  <div id="contener">
   <s:include value="index-3.jsp"/>
<div id="content">
<br />
		<h2 align="center"><s:text name="excellent"></s:text></h2>
		<br />
    <table align="left" width="800px">
  	<s:iterator id="faMap" value="#request.favorites">
  		<tr>
  			<td><s:property value="#faMap.exname"/></td>
  			<td><s:property value="#faMap.tname"/></td>
  			<td><s:iterator id="stu" value="#faMap.member">
  				<s:property value="#stu.name"/>
  			</s:iterator></td>
  			<td><s:date name="#faMap.date"/></td>
  			<s:url id="url" value="favorites.action">
    			<s:param name="tid" value="#faMap.tid"></s:param>
    			<s:param name="enid" value="#faMap.enid"></s:param>
    		</s:url>
  			<td><s:a href="%{url}"><s:text name="layData"></s:text></s:a></td>
  		</tr>
 	 </s:iterator>
 	 </table>
 	 <br />&nbsp;
</div>
</div>
  <!--end of contener -->
<s:include value="bottom.jsp"></s:include>
</div>
</body>
</html>
