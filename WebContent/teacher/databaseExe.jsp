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
				<h2 class="title"><s:text name="database"></s:text><s:text name="backup"></s:text></h2>
				<p class="meta"></p>
				
				<div class="entry">
					<p>
<%
	//String back = "http://"+request.getServerName()+":"+request.getServerPort()+"/"+request.getContextPath()+"/chem.sql";
	String back = "D:\\chem.sql";
	out.println(back);
		String sql = "mysqldump -uroot -pcontinue --opt chem > " + back;
		java.lang.Runtime.getRuntime().exec("cmd /c "+sql);
		out.println("Backup Database Success! <br/> Check chem.sql file in D:\\chem.sql. <br/>"
		+"If the file volume little than 20KB<br/> or don't contents tables like:<br/> admin, data, basicData, student, teams, teams_has_student, excellent<br/>"
		+"Please rebackup aother times.");
	
	
%>

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