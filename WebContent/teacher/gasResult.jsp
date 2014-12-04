<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title><s:text name="gasLiquid"></s:text></title>
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
				<h2 class="title"><s:text name="gasLiquid"></s:text>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<s:url id="url" value="excellentCom.action" namespace="teacher">
    			<s:param name="tid" value="#team.tid"></s:param>
    			</s:url>
    			<s:a href="%{url}"><s:text name="favorite"></s:text></s:a>
				</h2>
				<p class="meta"><s:text name="teamMembers"></s:text>: <s:iterator id="stu" value="#request.students">&nbsp;&nbsp;
			<s:property value="#stu.name"/>  
		</s:iterator></p>
				
				<div class="entry">
					<p>
<h3><s:text name="apeData"></s:text></h3>
<table width="800px" align="center">
  <tr>
    <td rowspan="2"><s:text name="sysPressure"></s:text> /MPa</td>
    <td rowspan="2"><s:text name="balanceTemper"></s:text> /℃</td>
    <td colspan="6"><s:text name="gasPhase"></s:text></td>
    <td colspan="2"><s:text name="liquidPhase"></s:text></td>
  </tr>
  <tr>
    <td><s:text name="G<sub>1</sub>"></s:text> /g</td>
    <td><s:text name="G<sub>2</sub>"></s:text> /g</td>
    <td><s:text name="G<sub>3</sub>"></s:text> /g</td>
    <td><s:text name="n<sub>D</sub><sup>30</sup>"></s:text></td>
    <td><s:text name="y<sub>1</sub><sup>'</sup>"></s:text> /%</td>
    <td><s:text name="y"></s:text> /%</td>
    <td><s:text name="n<sub>D</sub><sup>30</sup>"></s:text></td>
    <td><s:text name="x<sub>1</sub>"></s:text> /%</td>
  </tr>
  <s:iterator id="sta" value="#request.gasBase" status="statue">
  <tr>
    <td><s:property value="#sta.sysPress"/></td>
    <td><s:property value="#sta.balanceTemper"/></td>
    <td><s:property value="#sta.g1"/></td>
    <td><s:property value="#sta.g2"/></td>
    <td><s:property value="#sta.g3"/></td>
    <td><s:property value="#sta.ngas"/></td>
    <td><s:property value="#sta.yy"/></td>
    <td><s:property value="#sta.y"/></td>
    <td><s:property value="#sta.nliquid"/></td>
    <td><s:property value="#sta.x1"/></td>
  </tr>
  </s:iterator>
</table><br />
<h3><s:text name="calcuData"></s:text></h3>
<table  width="900px">
	<tr>
		<td><s:text name="number"></s:text></td>
		<td><s:text name="balanceTemper"></s:text> /℃</td>
		<td>y1</td>
		<td>x1</td>
		<td>y<sub><s:text name="fact"></s:text></sub></td>
		<td>y<sub><s:text name="theory"></s:text></sub></td>
		<td>γ1<sub><s:text name="fact"></s:text></sub></td>
		<td>γ1<sub><s:text name="theory"></s:text></sub></td>
		<td>γ2<sub><s:text name="fact"></s:text></sub></td>
		<td>γ2<sub><s:text name="theory"></s:text></sub></td>
		<td><s:text name="delete"></s:text></td>
	</tr>
	
	<s:iterator id="sta" value="#request.gasRes" status="statue">
		<tr>
		<td><s:property value="#statue.index +1"/></td>
		<td><s:property value="#sta.balanceTemper"/></td>
		<td><s:property value="#sta.yy"/></td>
		<td><s:property value="#sta.x1"/></td>
		<td><s:property value="#sta.y1ex"/></td>
		<td><s:property value="#sta.y1cal"/></td>
		<td><s:property value="#sta.r1ex"/></td>
		<td><s:property value="#sta.r1cal"/></td>
		<td><s:property value="#sta.r2ex"/></td>
		<td><s:property value="#sta.r2cal"/></td>
		<td align="center"><a href="deleteData.action?did=<s:property value='#sta.did'/>" title="删除数据"><img src="delete.png" border="0"/></a></td>
		</tr>
	</s:iterator>
	
</table><br />
  <img src="gasChart.action?tid=<s:property value='tid'/>" alt="" /><br />
  <br />
  <br />
	<img src="gasChart2.action?tid=<s:property value='tid'/>" alt="" /><br />

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