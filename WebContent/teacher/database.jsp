<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title><s:text name="database"></s:text><s:text name="manage"></s:text></title>
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
				<h2 class="title"><s:text name="database"></s:text><s:text name="manage"></s:text></h2>
				<p class="meta">Manage the Database. Backup OR Resume</p>
				
				<div class="entry">
<p><table width="950" border="0" >
	<tr><td colspan="2"><h1 align="center"><s:text name="database"></s:text><s:text name="manage"></s:text></h1></td></tr>
  <tr >
  	<td><h4><s:text name="database"></s:text><s:text name="backup"></s:text></h4></td>
    <td><a href="databaseExe.action"><s:text name="database"></s:text><s:text name="backup"></s:text>D:\chem.sql </a></td>
  </tr>
  <tr >
  	<td><h4><s:text name="database"></s:text><s:text name="resume"></s:text></h4></td>
    <td><form action="databaseResume.action" method="post" enctype="multipart/form-data">
			<s:text name="choose"></s:text><s:text name="file"></s:text>：<input type="file" name = "databaseResume"/>
			<input value="<s:text name='submit'></s:text>" type="submit"/>
		</form><s:property value="#request.tip"/>
    </td>
   </tr>
</table></p>
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