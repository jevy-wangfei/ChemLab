<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html >
<head>
<title><s:text name="co2"></s:text></title>
<link href="css.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="all">
<s:include value="head.jsp"></s:include>
  <div id="contener">
   <s:include value="index-2.jsp"/>
<div id="content">
<div id="co2">
<h2 align="center"><s:text name="waterSalt"></s:text></h2>
  <form id="form1" name="form1" method="post" action="salt.action">
  	<h4>C(NaOH):<input type="text" name="coh"/>mol/L &nbsp;&nbsp;C(AgNO<sub>3</sub>):<input type="text" name="cag"/>mol/L</h4>
    <table width="800" border="0">
      <tr>
        <td width="25" rowspan="2">&nbsp;</td>
        <td height="40" colspan="2"><s:text name="composition"></s:text></td>
        <td colspan="2"><s:text name="trueWeight"></s:text>g/50gH<sub>2</sub>O</td>
        <td width="127" rowspan="2"><s:text name="costLiquid"></s:text>W(g)</td>
        <td colspan="2"><s:text name="contribution"></s:text>(ml)</td>
        
      </tr>
      <tr>
        <td width="93">NaCl</td>
        <td width="91">NH<sub>4</sub>Cl</td>
        <td width="106">NaCl</td>
        <td width="107">NH<sub>4</sub>Cl</td>
        <td width="114">AgNO<sub>3</sub></td>
        <td width="102">NaOH</td>
      </tr>
      <tr>
        <td>1</td>
        <td>100%</td>
        <td>0%</td>
        <td><label>
          <input name="na" type="text" id="textfield" size="8" />
        </label></td>
        <td><input name="nh" type="text" id="textfield2" size="8" /></td>
        <td><input name="w" type="text" id="textfield3" size="8" /></td>
        <td><input name="ag" type="text" id="textfield4" size="8" /></td>
        <td><input name="oh" type="text" id="textfield5" size="8" /></td>
      </tr>
      <tr>
        <td>2</td>
        <td>100%</td>
        <td>10%</td>
        <td><label>
          <input name="na" type="text" id="textfield" size="8" />
        </label></td>
        <td><input name="nh" type="text" id="textfield2" size="8" /></td>
        <td><input name="w" type="text" id="textfield3" size="8" /></td>
        <td><input name="ag" type="text" id="textfield4" size="8" /></td>
        <td><input name="oh" type="text" id="textfield5" size="8" /></td>
        </tr>
      <tr>
        <td>3</td>
        <td>100%</td>
        <td>20%</td>
        <td><label>
          <input name="na" type="text" id="textfield" size="8" />
        </label></td>
        <td><input name="nh" type="text" id="textfield2" size="8" /></td>
        <td><input name="w" type="text" id="textfield3" size="8" /></td>
        <td><input name="ag" type="text" id="textfield4" size="8" /></td>
        <td><input name="oh" type="text" id="textfield5" size="8" /></td>
        </tr>
      <tr>
        <td>4</td>
        <td>100%</td>
        <td>30%</td>
        <td><label>
          <input name="na" type="text" id="textfield" size="8" />
        </label></td>
        <td><input name="nh" type="text" id="textfield2" size="8" /></td>
        <td><input name="w" type="text" id="textfield3" size="8" /></td>
        <td><input name="ag" type="text" id="textfield4" size="8" /></td>
        <td><input name="oh" type="text" id="textfield5" size="8" /></td>
        </tr>
      <tr>
        <td>5</td>
        <td>100%</td>
        <td>40%</td>
        <td><label>
          <input name="na" type="text" id="textfield" size="8" />
        </label></td>
        <td><input name="nh" type="text" id="textfield2" size="8" /></td>
        <td><input name="w" type="text" id="textfield3" size="8" /></td>
        <td><input name="ag" type="text" id="textfield4" size="8" /></td>
        <td><input name="oh" type="text" id="textfield5" size="8" /></td>
        </tr>
      <tr>
        <td>6</td>
        <td>100%</td>
        <td>100%</td>
        <td><label>
          <input name="na" type="text" id="textfield" size="8" />
        </label></td>
        <td><input name="nh" type="text" id="textfield2" size="8" /></td>
        <td><input name="w" type="text" id="textfield3" size="8" /></td>
        <td><input name="ag" type="text" id="textfield4" size="8" /></td>
        <td><input name="oh" type="text" id="textfield5" size="8" /></td>
        </tr>
      <tr>
        <td>7</td>
        <td>100%</td>
        <td>100%</td>
        <td><label>
          <input name="na" type="text" id="textfield" size="8" />
        </label></td>
        <td><input name="nh" type="text" id="textfield2" size="8" /></td>
        <td><input name="w" type="text" id="textfield3" size="8" /></td>
        <td><input name="ag" type="text" id="textfield4" size="8" /></td>
        <td><input name="oh" type="text" id="textfield5" size="8" /></td>
        </tr>
      <tr>
        <td>8</td>
        <td>40%</td>
        <td>100%</td>
        <td><label>
          <input name="na" type="text" id="textfield" size="8" />
        </label></td>
        <td><input name="nh" type="text" id="textfield2" size="8" /></td>
        <td><input name="w" type="text" id="textfield3" size="8" /></td>
        <td><input name="ag" type="text" id="textfield4" size="8" /></td>
        <td><input name="oh" type="text" id="textfield5" size="8" /></td>
        </tr>
      <tr>
        <td>9</td>
        <td>30%</td>
        <td>100%</td>
        <td><label>
          <input name="na" type="text" id="textfield" size="8" />
        </label></td>
        <td><input name="nh" type="text" id="textfield2" size="8" /></td>
        <td><input name="w" type="text" id="textfield3" size="8" /></td>
        <td><input name="ag" type="text" id="textfield4" size="8" /></td>
        <td><input name="oh" type="text" id="textfield5" size="8" /></td>
        </tr>
      <tr>
        <td>10</td>
        <td>20%</td>
        <td>100%</td>
        <td><label>
          <input name="na" type="text" id="textfield" size="8" />
        </label></td>
        <td><input name="nh" type="text" id="textfield2" size="8" /></td>
        <td><input name="w" type="text" id="textfield3" size="8" /></td>
        <td><input name="ag" type="text" id="textfield4" size="8" /></td>
        <td><input name="oh" type="text" id="textfield5" size="8" /></td>
        </tr>
      <tr>
        <td>11</td>
        <td>10%</td>
        <td>100%</td>
        <td><label>
          <input name="na" type="text" id="textfield" size="8" />
        </label></td>
        <td><input name="nh" type="text" id="textfield2" size="8" /></td>
        <td><input name="w" type="text" id="textfield3" size="8" /></td>
        <td><input name="ag" type="text" id="textfield4" size="8" /></td>
        <td><input name="oh" type="text" id="textfield5" size="8" /></td>
        </tr>
      <tr>
        <td>12</td>
        <td>0%</td>
        <td>100%</td>
        <td><label>
          <input name="na" type="text" id="textfield" size="8" />
        </label></td>
        <td><input name="nh" type="text" id="textfield2" size="8" /></td>
        <td><input name="w" type="text" id="textfield3" size="8" /></td>
        <td><input name="ag" type="text" id="textfield4" size="8" /></td>
        <td><input name="oh" type="text" id="textfield5" size="8" /></td>
        </tr>
    </table>
    <p align="right">
      <label><input type="hidden" name="enid" value="2"/>
        <input type="submit" name="button" id="button" value="<s:text name='submit'></s:text>" />
      </label>
    </p>
  </form>
  <br />
		<table width="800" border="0" align="center">
  <tr>
    <td><s:text name="notice"></s:text><s:text name="saltNotice"></s:text></td>
  </tr>
</table>
<br/>

</div>
</div>
  <!--end of contener -->
</div>
<s:include value="bottom.jsp"></s:include>
</div>
</body>
</html>