<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title><s:text name="styreneProducts"></s:text></title>
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
<div id="wrapper">
	<div id="header">
		<div id="logo">
			<s:include value="logoWord.jsp"></s:include>
		</div>
	</div>
	<!-- end #header -->
	<div id="menu">
		<s:include value="head.jsp"></s:include>
	</div>
	<!-- end #menu -->
    
	<div id="page">
	<div id="page-bgtop">
	<div id="page-bgbtm">
		<div id="content">
        <!--repeat this part below-->
			<div class="post">
			<div class="post-bgtop">
			<div class="post-bgbtm">
				<h2 class="title"><s:text name="styreneProducts"></s:text>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<s:url id="url" value="excellentCom.action" namespace="teacher">
    		<s:param name="tid" value="#team.tid"></s:param>
    	</s:url>
  <s:a href="%{url}"><s:text name="favorite"></s:text></s:a>
				
				</h2>
				<p class="meta"><s:text name="teamMembers"></s:text>
		<s:iterator id="stu" value="#request.students">
			<s:property value="#stu.name"/>
		</s:iterator></p>
				
				<div class="entry">
	<p>
<table width="900" border="0" align="center">
		  <tr>
		    <td rowspan="3"><s:text name="number"></s:text></td>
		    <td><s:text name="temper"></s:text>℃</td>
		    <td colspan="2"><s:text name="addMeterialVolume"></s:text>/(mL/min)</td>
		    <td colspan="6">
		      <s:text name="inpureProducts"></s:text>/g</td>
		    <td rowspan="3"><s:text name="a"></s:text></td>
		    <td rowspan="3"><s:text name="S"></s:text></td>
		    <td rowspan="3"><s:text name="Y"></s:text></td>
		    <td rowspan="3"><s:text name="delete"></s:text></td>
		  </tr>
		  <tr>
		    <td rowspan="2"><s:text name="reactor"></s:text></td>
		    <td><s:text name="styrene"></s:text></td>
		    <td><s:text name="water"></s:text></td>
		    <td rowspan="2"><s:text name="hyLayer"></s:text></td>
		    <td rowspan="2"><s:text name="waterLayer"></s:text></td>
		    <td colspan="2"><s:text name="styrene"></s:text></td>
		    <td colspan="2"><s:text name="hyStyrene"></s:text></td>
		    </tr>
		  <tr>
		    <td ><s:text name="quality"></s:text>/g</td>
		    <td ><s:text name="quality"></s:text>/g</td>
		    <td><s:text name="qualityP"></s:text>/%</td>
		    <td><s:text name="quality"></s:text>/g</td>
		    <td><s:text name="qualityP"></s:text>/%</td>
		    <td><s:text name="quality"></s:text>/g</td>
	      </tr>
	      <s:iterator id="da" value="#request.res" status="sta">
	      	<tr>
		 	<td><s:property value="#sta.index"/></td>
		    <td><s:property value="#da.reactorTemper"/></td>
		    <td><s:property value="#da.benQuality"/></td>
		    <td><s:property value="#da.waterQuality"/></td>
		    <td><s:property value="#da.hyLayer"/></td>
		    <td><s:property value="#da.waterLayer"/></td>
		    <td><s:property value="#da.benResP"/></td>
		    <td><s:property value="#da.benRes"/></td>
		    <td><s:property value="#da.styreneResP"/></td>
		    <td><s:property value="#da.styreneRes"/></td>
		    <td><s:property value="#da.a"/></td>
		    <td><s:property value="#da.s"/></td>
		    <td><s:property value="#da.y"/></td>
		    <td align="center"><a href="deleteData.action?did=<s:property value='#da.did'/>" title="删除数据"><img src="delete.png" border="0"/></a></td>
		    </tr>
	      </s:iterator>
	      </table>
	      <br />
	      <img src="styreneChart.action?tid=<s:property value='tid'/>" alt="" />

</p>
				</div>
			</div>
			</div>
			</div>
             <!--repeat this part above-->
            
		  <div style="clear: both;">&nbsp;</div>
		</div>
		<!-- end #content -->
		<!-- end #sidebar -->
		<div style="clear: both;">&nbsp;</div>
	</div>
	</div>
	</div>
	<!-- end #page -->
    
</div>
<!-- end #wrapper -->
	<div id="footer">
		<p><s:include value="bottom.jsp"></s:include></p>
	</div>
	<!-- end #footer -->
</body>
</html>