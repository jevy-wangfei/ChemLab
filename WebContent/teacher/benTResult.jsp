<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
		
		<h2 align="center"><s:text name="temper"></s:text><s:text name="affectToAbsorb"></s:text></h2>
		<h4 align="left"><s:text name="apeData"></s:text> &nbsp; <s:text name="lightAbsorb"></s:text></h4>
	<table  width="800px">
		<tr><td></td>
			<td><s:property value="#request.benT[0].time1"/>min</td>
			<td><s:property value="#request.benT[0].time2"/>min</td>
			<td><s:property value="#request.benT[0].time3"/>min</td>
			<td><s:property value="#request.benT[0].time4"/>min</td>
			<td><s:property value="#request.benT[0].time5"/>min</td>
			<td><s:text name="delete"></s:text></td>
		</tr>	
		<s:iterator id="benT" value="#request.benT">
			<s:iterator value="#benT">
			<tr>
				<td><s:property value="#benT.temperOrQ"/>℃ </td>
				<td><s:property value="#benT.absorb1"/></td>
				<td><s:property value="#benT.absorb2"/></td>
				<td><s:property value="#benT.absorb3"/></td>
				<td><s:property value="#benT.absorb4"/></td>
				<td><s:property value="#benT.absorb5"/></td>
				<td align="center"><a href="deleteData.action?did=<s:property value='#benT.did'/>" title="删除数据"><img src="delete.png" border="0"/></a></td>
			</tr>
			</s:iterator>
		</s:iterator>
	</table>
	
	<h4 align="left"><s:text name="calcuData"></s:text> &nbsp; <s:text name="wipeOff"></s:text></h4>
	<table  width="800px">
		<tr><td></td>
			<td><s:property value="#request.benT2[0].time1"/>min</td>
			<td><s:property value="#request.benT2[0].time2"/>min</td>
			<td><s:property value="#request.benT2[0].time3"/>min</td>
			<td><s:property value="#request.benT2[0].time4"/>min</td>
			<td><s:property value="#request.benT2[0].time5"/>min</td>
		</tr>	
		<s:iterator id="benT2" value="#request.benT2">
			<s:iterator value="#benT2">
			<tr>
				<td><s:property value="#benT2.temperOrQ"/>℃ </td>
				<td><s:property value="#benT2.wipeoff1"/></td>
				<td><s:property value="#benT2.wipeoff2"/></td>
				<td><s:property value="#benT2.wipeoff3"/></td>
				<td><s:property value="#benT2.wipeoff4"/></td>
				<td><s:property value="#benT2.wipeoff5"/></td>
			</tr>
			</s:iterator>
	</s:iterator>
	</table>
