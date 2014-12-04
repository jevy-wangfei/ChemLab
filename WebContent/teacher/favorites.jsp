<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title><s:text name="description"></s:text></title>
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
				<h2 class="title"><s:text name="excellent"></s:text></h2>
				<p class="meta">Click the <s:text name="layData"></s:text> to List The Data and Picture of the Experiment.</p>
				
				<div class="entry">
					<p><table align="center" width="900px">
  	<s:iterator id="faMap" value="#request.favorites">
  		<tr>
  		<s:url id="url" value="favorites.action" namespace="teacher">
    		<s:param name="tid" value="#faMap.tid"></s:param>
    		<s:param name="enid" value="#faMap.enid"></s:param>
    	</s:url>
  			<td><s:property value="#faMap.exname"/></td>
  			<td><s:property value="#faMap.tname"/></td>
  			<td><s:iterator id="stu" value="#faMap.member">
  				<s:property value="#stu.name"/>
  			</s:iterator></td>
  			<td><s:date name="#faMap.date"/></td>
  			<td><s:a href="%{url}"><s:text name="layData"></s:text></s:a></td>
  			<s:url id="url2" value="deleteFavorites.action" namespace="teacher">
	    		<s:param name="eid" value="#faMap.eid"></s:param>
    		</s:url>
  			<td><s:a href="%{url2}"><s:text name="delete"></s:text></s:a></td>
  		</tr>
 	 </s:iterator>
 	 </table>
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