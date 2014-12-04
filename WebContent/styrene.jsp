<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><s:text name="styreneProducts"></s:text></title>
<link href="css.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="all">
<s:include value="head.jsp"></s:include>
  <div id="contener">
   <s:include value="index-2.jsp"/>
<div id="content">
<div id="co2"><br />
		<h2 align="center"><s:text name="styreneProducts"></s:text></h2>
	<form action="styrene.action" method="post">
		<table width="800" border="0" align="center">
		  <tr>
		    <td rowspan="3"><s:text name="number"></s:text></td>
		    <td><s:text name="temper"></s:text></td>
		    <td colspan="2"><s:text name="addMeterialVolume"></s:text>		      /(mL)</td>
		    <td colspan="6">
		      <s:text name="inpureProducts"></s:text></td>
		    </tr>
		  <tr>
		    <td rowspan="2"><s:text name="reactor"></s:text></td>
		    <td><s:text name="styrene"></s:text></td>
		    <td><s:text name="water"></s:text></td>
		    <td rowspan="2"><s:text name="hyLayer"></s:text>/g</td>
		    <td rowspan="2"><s:text name="waterLayer"></s:text>/g</td>
		    <td><s:text name="styrene"></s:text></td>
		    <td ><s:text name="hyStyrene"></s:text></td>
		    </tr>
		  <tr>
		    <td ><s:text name="quality"></s:text>/mL</td>
		    <td ><s:text name="quality"></s:text>/mL</td>
		    <td><s:text name="qualityP"></s:text>/%</td>
		    <td><s:text name="qualityP"></s:text>/%</td>
		    
	      </tr>
		  <tr>
		 	<td>1</td>
		    <td><input name="reactorTemper" type="text" size="5" /></td>
		    <td><input name="benQuality" type="text" size="5" /></td><!-- 修改为以mL计 -->
		    <td><input name="waterQuality" type="text" size="5" /></td><!-- 修改为以mL计 -->
		    <td><input name="hyLayer" type="text" size="5" /></td>
		    <td><input name="waterLayer" type="text" size="5" /></td>
		    <td><input name="benResP" type="text" size="5" /></td>
		    <td><input name="styreneResP" type="text" size="5" /></td>
		    
		    </tr>
		  <tr>
		    <td>2</td>
		    <td><input name="reactorTemper" type="text" size="5" /></td>
		    <td><input name="benQuality" type="text" size="5" /></td><!-- 修改为以mL计 -->
		    <td><input name="waterQuality" type="text" size="5" /></td><!-- 修改为以mL计 -->
		    <td><input name="hyLayer" type="text" size="5" /></td>
		    <td><input name="waterLayer" type="text" size="5" /></td>
		     <td><input name="benResP" type="text" size="5" /></td>
		    <td><input name="styreneResP" type="text" size="5" /></td>
		    </tr>
	    </table>
	    <h4 align="right"><input type="submit" name="button"value="<s:text name='submit'></s:text>"/></h4>
	    </form>
		<br />
</div>
</div>
  <!--end of contener -->
</div>
<s:include value="bottom.jsp"></s:include>
</div>
</body>
</html>