<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title><s:text name="description"></s:text>
		</title>
		<link href="css.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<div id="all">
			<div id="login">
				<s:text name="school"></s:text>
				|
				<s:text name="college"></s:text>
				|
				<s:text name="collection"></s:text>
				|
				<s:text name="login"></s:text>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<s:text name="explorer"></s:text>
			</div>
			<div id="photo"></div>
			<div id="contener">
				<div id="word1">
					<table width="720px" height="30px" align="left">
						<tr>
							<td width="185px">
								&nbsp;&nbsp;
								<a href="index.action"><s:text name="description"></s:text>
								</a>
							</td>
							<td width="185px">
								&nbsp;&nbsp;
								<a href="layExnameDataInput.action"><s:text
										name="dataProcess"></s:text>
								</a>
							</td>
							<td width="185px">
								&nbsp;&nbsp;
								<a href="favorites.action"><s:text name="excellent"></s:text>
								</a>
							</td>
							<td width="180px">
								&nbsp;
								<a href="layData.action"><s:text name="myData"></s:text>
								</a>
							</td>
						</tr>
					</table>
				</div>

				<div id="content">


					<s:action name="layExnameDescription" executeResult="true"></s:action>

					<table width="700" border="1" align="center">
						<tr>
							<td align="center">
								<s:text name="descriptionDetail"></s:text>
							</td>
						</tr>
					</table>
				</div>
				<!--end of content-->

			</div>
			<!--end of cocntener-->

			<div id="bottom">
				<s:text name="aboutUs"></s:text>
			</div>
		</div>
		<!--end of all-->
	</body>
</html>