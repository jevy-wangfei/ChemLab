<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title><s:text name="co2"></s:text></title>
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
				<h2 class="title"><s:text name="co2"></s:text>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<s:url id="url" value="excellentCom.action" namespace="teacher">
    		<s:param name="tid" value="#team.tid"></s:param>
    	</s:url>
   <s:a href="%{url}"><s:text name="favorite"></s:text></s:a></h2>
				<p class="meta"><s:text name="teamMembers"></s:text>: <s:iterator id="stu" value="#request.students">&nbsp;&nbsp;
			<s:property value="#stu.name"/>  
		</s:iterator></p>
				
				<div class="entry">
<p>

<table width="900" border="0" align="center">
<tr><td align="center" valign="top">
		<table width="300">
	<tr><td width="40">T(℃) </td>
    <td width="51">P(Mpa)</td>
    <td width="49">△h(cm) </td>
    <td width="69">v=(m<sup>3</sup>/kg) </td>
    <td><s:text name="delete"></s:text></td>
    </tr>
    
	<s:iterator id="da" value="#request.data1">
    <tr>
        <td><s:property value="#da.temper"/></td>
        <td><s:property value="#da.p"/></td>
        <td><s:property value="#da.dh"/></td>
        <td><s:property value="#da.v"/></td>
        <td align="center"><a href="deleteData.action?did=<s:property value='#da.did'/>" title="删除数据"><img src="delete.png" border="0"/></a></td>
    </tr>
	</s:iterator>
	</table>

</td>
  <td align="center" valign="top"><table width="300">
    <tr>
      <td width="43"> T(℃) </td>
      <td width="54"> P(Mpa) </td>
      <td width="49"> △h(cm) </td>
      <td width="71"> v=(m<sup>3</sup>/kg) </td>
      <td><s:text name="delete"></s:text></td>
    </tr>
    <s:iterator id="da" value="#request.data2">
    <tr>
        <td><s:property value="#da.temper"/></td>
        <td><s:property value="#da.p"/></td>
        <td><s:property value="#da.dh"/></td>
        <td><s:property value="#da.v"/></td>
        <td align="center"><a href="deleteData.action?did=<s:property value='#da.did'/>" title="删除数据"><img src="delete.png" border="0"/></a></td>
    </tr>
	</s:iterator>
  </table></td>
  <td align="center" valign="top"><table width="300">
    <tr>
      <td width="41"> T(℃) </td>
      <td width="51"> P(Mpa) </td>
      <td width="51"> △h(cm) </td>
      <td width="71"> v=(m<sup>3</sup>/kg) </td>
      <td><s:text name="delete"></s:text></td>
    </tr>
   <s:iterator id="da" value="#request.data3">
    <tr>
        <td><s:property value="#da.temper"/></td>
        <td><s:property value="#da.p"/></td>
        <td><s:property value="#da.dh"/></td>
        <td><s:property value="#da.v"/></td>
        <td align="center"><a href="deleteData.action?did=<s:property value='#da.did'/>" title="删除数据"><img src="delete.png" border="0"/></a></td>
    </tr>
	</s:iterator>
  </table></td></tr>
</table>


<br />
<img src="co2Chart.action?tid=<s:property value='tid'/>" alt="" />

<br />

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