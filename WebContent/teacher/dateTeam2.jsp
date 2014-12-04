<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<table width="900px">
	<s:iterator id="date" value="#request.dateTeam" status="d1">
		<tr>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;
				<s:url id="url" value="layTeam.action" namespace="teacher">
					<s:param name="date" value="#date.date"></s:param>
					<s:param name="enid" value="#date.enid"></s:param>
				</s:url>
				<s:a href="%{url}">
					<s:property value="#date.date2" />
				</s:a>
			</td>
		</tr>
	</s:iterator>
</table>
