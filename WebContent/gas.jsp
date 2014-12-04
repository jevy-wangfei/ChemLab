<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><s:text name="gasLiquid"></s:text></title>
<link href="css.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="all">
<s:include value="head.jsp"></s:include>
  <div id="contener">
    <s:include value="index-2.jsp"/>
<div id="content">
<div id="co2"><br />

<h2 align="center"><s:text name="gasLiquid"></s:text></h2>
  <form action="gas.action" method="post">
  	  <table width="600" border="0" align="center">
  	    <tr>
  	      <td colspan="3"><h2><s:text name="experimentalCondition"></s:text></h2></td>
  	      <td width="146" rowspan="16" valign="top"><s:text name="notice"></s:text><s:text name="gasNotice"></s:text></td>
	      </tr>
  	    <tr>
  	      <td width="36">&nbsp;</td>
  	      <td width="201"><s:text name="atm"></s:text> /MPa</td>
  	      <td width="198"><input type="text" name="baseatm" /></td>
  	      </tr>
  	    <tr>
  	      <td>&nbsp;</td>
  	      <td><s:text name="sysPressure"></s:text> /MPa</td>
  	      <td><input type="text" name="sysPress" /></td>
  	      </tr>
  	    <tr>
  	      <td>&nbsp;</td>
  	      <td><s:text name="temperature"> </s:text>/℃</td>
  	      <td><input type="text" name="temperature" /></td>
  	      </tr>
  	    <tr>
  	      <td>&nbsp;</td>
  	      <td><s:text name="voltage"></s:text> / V</td>
  	      <td><input type="text" name="voltage" /></td>
  	      </tr>
  	    <tr>
  	      <td colspan="3"><h2><s:text name="experimentData"></s:text></h2></td>
  	      </tr>
  	    <tr>
  	      <td>&nbsp;</td>
  	      <td><s:text name="balanceTemper"></s:text> /℃</td>
  	      <td><input type="text" name="balanceTemper" /></td>
  	      </tr>
  	    <tr>
  	      <td rowspan="5"><h3><s:text name="gasPhase"></s:text></h3></td>
  	      <td><s:text name="G<sub>1</sub>"></s:text> /g</td>
  	      <td><input type="text" name="g1" /></td>
  	      </tr>
  	    <tr>
  	      <td><s:text name="G<sub>2</sub>"></s:text> /g</td>
  	      <td><input type="text" name="g2" /></td>
  	      </tr>
  	    <tr>
  	      <td><s:text name="G<sub>3</sub>"></s:text> /g</td>
  	      <td><input  type="text" name="g3" /></td>
  	      </tr>
  	    <tr>
  	      <td><s:text name="n<sub>D</sub><sup>30</sup>"></s:text></td>
  	      <td><input type="text" name="ngas" /></td>
  	      </tr>
  	    <tr>
  	      <td><s:text name="y<sub>1</sub><sup>'</sup>"></s:text> /%</td>
  	      <td><input type="text" name="yy" /></td>
  	      </tr>
  	    
  	    <tr>
  	      <td rowspan="2"><h3><s:text name="liquidPhase"></s:text></h3></td>
  	      <td><s:text name="n<sub>D</sub><sup>30</sup>"></s:text></td>
  	      <td><input type="text" name="nliqude" /></td>
  	      </tr>
  	    <tr>
  	       <td><s:text name="x<sub>1</sub>"></s:text> /%</td>
  	      <td><input type="text" name="x" /></td>
  	      </tr>
  	    <tr>
  	      <td colspan="3">
  	      <s:hidden name="enid" value="1"></s:hidden>
  	     <h4 align="right"> <input type="submit" value="<s:text name='submit'></s:text>"/></h4>
  	      </td>
  	      </tr>
  	    
	    </table>
	</form>

</div>
</div>
  <!--end of contener -->
</div>
<s:include value="bottom.jsp"></s:include>
</div>
</body>
</html>
