<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html >
<head>
<title><s:text name="ben"></s:text></title>
<link href="css.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="all">
<s:include value="head.jsp"></s:include>
  <div id="contener">
   <s:include value="index-2.jsp"/>
<div id="content">
<br />
		<h2 align="center"><s:text name="ben"></s:text></h2>
		<br />
		<h3><s:text name="temper"></s:text><s:text name="affectToAbsorb"></s:text></h3>
        <form id="form1" name="ben" method="post" action="benT.action">
          <table width="800" border="0">
            <tr>
              <td colspan="2" rowspan="2"><s:text name="lightAbsorb"></s:text></td>
              <td colspan="5"><s:text name="experimentTemper"></s:text></td>
              <td width="64" rowspan="8"></td>
            </tr>
            <tr>
              <td width="119"><input type="text" name="temper1" size="8"  />
                ℃ </td>
              <td width="113"><input type="text" name="temper1" size="8"  />
                ℃ </td>
              <td width="118"><input type="text" name="temper1" size="8"  />
                ℃ </td>
              <td width="113"><input type="text" name="temper1" size="8"  />
                ℃ </td>
              <td width="111"><input type="text" name="temper1" size="8"  />
                ℃ </td>
            </tr>
            <tr>
              <td width="4" rowspan="6"><s:text name="time"></s:text></td>
              <td width="123"><input type="text" name="time1" size="8"  /> 
              min</td>
              <td><input type="text" name="ab1" size="8"  /></td>
              <td><input type="text" name="ab1" size="8"  /></td>
              <td><input type="text" name="ab1" size="8"  /></td>
              <td><input type="text" name="ab1" size="8"  /></td>
              <td><input type="text" name="ab1" size="8"  /></td>
            </tr>
            <tr>
              <td><input type="text" name="time2" size="8"  />
              min</td>
              <td><input type="text" name="ab2" size="8"  /></td>
              <td><input type="text" name="ab2" size="8"  /></td>
              <td><input type="text" name="ab2" size="8"  /></td>
              <td><input type="text" name="ab2" size="8"  /></td>
              <td><input type="text" name="ab2" size="8"  /></td>
            </tr>
            <tr>
              <td><input type="text" name="time3" size="8"  />
              min</td>
              <td><input type="text" name="ab3" size="8"  /></td>
              <td><input type="text" name="ab3" size="8"  /></td>
              <td><input type="text" name="ab3" size="8"  /></td>
              <td><input type="text" name="ab3" size="8"  /></td>
              <td><input type="text" name="ab3" size="8"  /></td>
            </tr>
            <tr>
              <td><input type="text" name="time4" size="8"  />
              min</td>
              <td><input type="text" name="ab4" size="8"  /></td>
              <td><input type="text" name="ab4" size="8"  /></td>
              <td><input type="text" name="ab4" size="8"  /></td>
              <td><input type="text" name="ab4" size="8"  /></td>
              <td><input type="text" name="ab4" size="8"  /></td>
            </tr>
            <tr>
              <td><input type="text" name="time5" size="8"  />
              min</td>
              <td><input type="text" name="ab5" size="8"  /></td>
              <td><input type="text" name="ab5" size="8"  /></td>
              <td><input type="text" name="ab5" size="8"  /></td>
              <td><input type="text" name="ab5" size="8"  /></td>
              <td><input type="text" name="ab5" size="8"  /></td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
              <td>
              <s:hidden name="enid" value="4" ></s:hidden>
            <input type="submit" value="<s:text name='submit'></s:text>"></input>  </td>
            </tr>
          </table>
        </form>
        <br />
        <h3><s:text name="numOfBen"></s:text><s:text name="affectToAbsorb"></s:text></h3>
     <form id="form1" name="form1" method="post" action="benQ.action">
          <table width="800" border="0">
            <tr>
              <td colspan="2" rowspan="2"><s:text name="lightAbsorb"></s:text></td>
              <td colspan="5"><s:text name="numOfBen"></s:text></td>
              <td width="64" rowspan="8"></td>
            </tr>
            <tr>
              <td width="119"><input type="text" name="g" size="8"  />
                g </td>
              <td width="113"><input type="text" name="g" size="8"  />
                g </td>
              <td width="118"><input type="text" name="g" size="8"  />
                g </td>
              <td width="113"><input type="text" name="g" size="8"  />
                g </td>
              <td width="111"><input type="text" name="g" size="8"  />
                g </td>
            </tr>
            <tr>
              <td width="4" rowspan="6"><s:text name="time"></s:text></td>
              <td width="123"><input type="text" name="time1" size="8"  /> 
              min</td>
              <td><input type="text" name="ab1" size="8"  /></td>
              <td><input type="text" name="ab1" size="8"  /></td>
              <td><input type="text" name="ab1" size="8"  /></td>
              <td><input type="text" name="ab1" size="8"  /></td>
              <td><input type="text" name="ab1" size="8"  /></td>
            </tr>
            <tr>
              <td><input type="text" name="time2" size="8"  />
              min</td>
              <td><input type="text" name="ab2" size="8"  /></td>
              <td><input type="text" name="ab2" size="8"  /></td>
              <td><input type="text" name="ab2" size="8"  /></td>
              <td><input type="text" name="ab2" size="8"  /></td>
              <td><input type="text" name="ab2" size="8"  /></td>
            </tr>
            <tr>
              <td><input type="text" name="time3" size="8"  />
              min</td>
              <td><input type="text" name="ab3" size="8"  /></td>
              <td><input type="text" name="ab3" size="8"  /></td>
              <td><input type="text" name="ab3" size="8"  /></td>
              <td><input type="text" name="ab3" size="8"  /></td>
              <td><input type="text" name="ab3" size="8"  /></td>
            </tr>
            <tr>
              <td><input type="text" name="time4" size="8"  />
              min</td>
              <td><input type="text" name="ab4" size="8"  /></td>
              <td><input type="text" name="ab4" size="8"  /></td>
              <td><input type="text" name="ab4" size="8"  /></td>
              <td><input type="text" name="ab4" size="8"  /></td>
              <td><input type="text" name="ab4" size="8"  /></td>
            </tr>
            <tr>
              <td><input type="text" name="time5" size="8"  />
              min</td>
              <td><input type="text" name="ab5" size="8"  /></td>
              <td><input type="text" name="ab5" size="8"  /></td>
              <td><input type="text" name="ab5" size="8"  /></td>
              <td><input type="text" name="ab5" size="8"  /></td>
              <td><input type="text" name="ab5" size="8"  /></td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
              <td>
              <s:hidden name="enid" value="4" ></s:hidden>
            <input type="submit" value="<s:text name='submit'></s:text>"></input>  </td>
            </tr>
          </table>
        </form>

</div>
</div>
 <!--end of contener -->
<s:include value="bottom.jsp"></s:include>
</div>
</body>
</html>