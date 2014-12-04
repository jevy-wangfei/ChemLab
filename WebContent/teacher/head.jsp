<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<ul>
	<li class="current_page_item"><s:url id="url" value="descriptionExname.action" namespace="teacher"></s:url>
		<s:a href="%{url}"><s:text name="description"></s:text></s:a></li>
	<li><a href="layExname_layData.action"><s:text name="layData"></s:text></a></li>
	<li><a href="favorites.action"><s:text name="excellent"></s:text></a></li>
	<li><a href="layExname_layTeam.action"><s:text name="layTeam"></s:text></a></li>
	<li><a href="organize.action"><s:text name="organizeExperiment"></s:text></a></li>
	<li><a href="database.action"><s:text name="database"></s:text><s:text name="manage"></s:text></a></li>
</ul>


