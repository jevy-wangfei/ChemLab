<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@  taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title><s:text name="organizeExperiment"></s:text></title>
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
				<h2 class="title"><s:text name="organizeExperiment"></s:text></h2>
				<p class="meta">Through the Method of Upload a File(The Model as Below) to Organise Experiment. For Instance Organise Students in Different Teams.<br/>
					Every Experiment Has a Special Label Just as Listed in the Model Files, It Can't be Change.
				</p>
				
		<div class="entry">
		<s:form action="uploadStudents" method="post" enctype="multipart/form-data" namespace="/teacher">
			<s:text name="choose"></s:text><s:text name="file"></s:text>:
			<s:file name="uploadStudent"></s:file> 
			<s:submit value="提交"></s:submit>
		</s:form>
	
	<s:property value="#request.tip"/>
	<table width="960px" >
		 <tr><td>&nbsp;组织实验所需Excel文件模板，注意一个同学不能在同一实验时间具有多个实验项目</td></tr>
  	<tr><td>&nbsp;<a href="gasLiquid.xls"><s:text name="gasLiquid"></s:text></a></td></tr>
  	<tr><td>&nbsp;<a href="watersalt.xls"><s:text name="waterSalt"></s:text></a></td></tr>
  	<tr><td>&nbsp;<a href="co2.xls"><s:text name="co2"></s:text></a></td></tr>
  	<tr><td>&nbsp;<a href="ben.xls"><s:text name="ben"></s:text></a></td></tr>
  	<tr><td>&nbsp;<a href="styrene.xls"><s:text name="styreneProducts"></s:text></a></td></tr>
	
	</table>
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