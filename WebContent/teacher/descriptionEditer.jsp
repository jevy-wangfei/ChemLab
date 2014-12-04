<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title><s:text name="description"></s:text></title>
    <style type="text/css" rel="stylesheet">
    form {
        margin: 0;
    }
    .editor {
        margin-top: 5px;
        margin-bottom: 5px;
    }
  </style>
  <script type="text/javascript" charset="utf-8" src="./../kindeditor.js"></script>
  <script type="text/javascript">
    KE.show({
        id : 'con',
       cssPath : './index.css'
    });
  </script>
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
				<h2 class="title"><s:property value="#request.exname.exname"/>
  <s:text name="description"></s:text></h2>
				<p class="meta">Input the Description of <s:property value="#request.exname.exname"/>.</p>
				
				<div class="entry">
					<p><s:form action="description">
  	<p align="center"><textarea id="con" name="content" style="width:950px;height:500px;visibility:hidden;">
  		<s:property value="%{#request.des}"/>
  	</textarea></p>
  	<s:hidden name="enid" value="%{#parameters.enid}"></s:hidden>
  	<s:submit key="submit"></s:submit>
  </s:form></p>
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