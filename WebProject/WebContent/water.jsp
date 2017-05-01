<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Water</title>
<meta name="generator"
	content="WYSIWYG Web Builder 12 Trial Version - http://www.wysiwygwebbuilder.com">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
body {
	background-color: #FFFFFF;
	color: #000000;
	font-family: Arial;
	font-weight: normal;
	font-size: 13px;
	line-height: 1.1875;
	margin: 0;
	padding: 0;
}

a {
	color: #0000FF;
	text-decoration: underline;
}

a:visited {
	color: #800080;
}

a:active {
	color: #FF0000;
}

a:hover {
	color: #0000FF;
	text-decoration: underline;
}

#wb_LayoutGrid1 {
	clear: both;
	position: relative;
	table-layout: fixed;
	display: table;
	text-align: center;
	width: 100%;
	background-color: transparent;
	background-image: none;
	border: 0px #CCCCCC solid;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

#LayoutGrid1 {
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	padding: 0px 15px 0px 15px;
	margin-right: auto;
	margin-left: auto;
}

#LayoutGrid1 .row {
	margin-right: -15px;
	margin-left: -15px;
}

#LayoutGrid1 .col-1 {
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	font-size: 0px;
	min-height: 1px;
	padding-right: 15px;
	padding-left: 15px;
	position: relative;
}

#LayoutGrid1 .col-1 {
	float: left;
}

#LayoutGrid1 .col-1 {
	background-color: transparent;
	background-image: none;
	width: 100%;
	text-align: left;
}

#LayoutGrid1:before, #LayoutGrid1:after, #LayoutGrid1 .row:before,
	#LayoutGrid1 .row:after {
	display: table;
	content: " ";
}

#LayoutGrid1:after, #LayoutGrid1 .row:after {
	clear: both;
}

@media ( max-width : 480px) {
	#LayoutGrid1 .col-1 {
		float: none;
		width: 100%;
	}
}

#wb_LayoutGrid2 {
	clear: both;
	position: relative;
	table-layout: fixed;
	display: table;
	text-align: center;
	width: 100%;
	background-color: transparent;
	background-image: none;
	border: 0px #CCCCCC solid;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

#LayoutGrid2 {
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	padding: 0px 15px 0px 15px;
	margin-right: auto;
	margin-left: auto;
}

#LayoutGrid2 .row {
	margin-right: -15px;
	margin-left: -15px;
}

#LayoutGrid2 .col-1, #LayoutGrid2 .col-2 {
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	font-size: 0px;
	min-height: 1px;
	padding-right: 15px;
	padding-left: 15px;
	position: relative;
}

#LayoutGrid2 .col-1, #LayoutGrid2 .col-2 {
	float: left;
}

#LayoutGrid2 .col-1 {
	background-color: transparent;
	background-image: none;
	width: 25%;
	text-align: left;
}

#LayoutGrid2 .col-2 {
	background-color: transparent;
	background-image: none;
	width: 75%;
	text-align: left;
}

#LayoutGrid2:before, #LayoutGrid2:after, #LayoutGrid2 .row:before,
	#LayoutGrid2 .row:after {
	display: table;
	content: " ";
}

#LayoutGrid2:after, #LayoutGrid2 .row:after {
	clear: both;
}

@media ( max-width : 480px) {
	#LayoutGrid2 .col-1, #LayoutGrid2 .col-2 {
		float: none;
		width: 100%;
	}
}

#wb_LayoutGrid3 {
	clear: both;
	position: relative;
	table-layout: fixed;
	display: table;
	text-align: center;
	width: 100%;
	background-color: transparent;
	background-image: none;
	border: 0px #CCCCCC solid;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

#LayoutGrid3 {
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	padding: 0px 15px 0px 15px;
	margin-right: auto;
	margin-left: auto;
}

#LayoutGrid3 .row {
	margin-right: -15px;
	margin-left: -15px;
}

#LayoutGrid3 .col-1 {
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	font-size: 0px;
	min-height: 1px;
	padding-right: 15px;
	padding-left: 15px;
	position: relative;
}

#LayoutGrid3 .col-1 {
	float: left;
}

#LayoutGrid3 .col-1 {
	background-color: transparent;
	background-image: none;
	width: 100%;
	text-align: left;
}

#LayoutGrid3:before, #LayoutGrid3:after, #LayoutGrid3 .row:before,
	#LayoutGrid3 .row:after {
	display: table;
	content: " ";
}

#LayoutGrid3:after, #LayoutGrid3 .row:after {
	clear: both;
}

@media ( max-width : 480px) {
	#LayoutGrid3 .col-1 {
		float: none;
		width: 100%;
	}
}

#Table1 {
	border: 1px #000000 solid;
	background-color: transparent;
	background-image: none;
	border-collapse: separate;
	border-spacing: 2px;
}

#Table1 td {
	padding: 2px 2px 2px 2px;
}

#Table1 td div {
	white-space: nowrap;
}

#Table1 .cell0 {
	background-color: transparent;
	background-image: none;
	border: 1px #C0C0C0 solid;
	text-align: left;
	vertical-align: top;
}

#wb_Heading1 {
	background-color: transparent;
	background-image: none;
	border: 0px #FFFFFF solid;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	padding: 0px 0px 0px 0px;
}

#Heading1 {
	color: #000000;
	font-family: Arial;
	font-weight: bold;
	font-size: 32px;
	margin: 0;
	text-align: center;
}

#wb_Text1 {
	background-color: transparent;
	background-image: none;
	border: 0px #000000 solid;
	padding: 0;
	margin: 0;
	text-align: left;
}

#wb_Text1 div {
	text-align: left;
}
</style>
</head>
<body>
	<a href="http://www.wysiwygwebbuilder.com" target="_blank"><img
		src="images/builtwithwwb12.png" alt="WYSIWYG Web Builder"
		style="position: absolute; left: 441px; top: 967px; border-width: 0; z-index: 250"></a>
	<div id="wb_LayoutGrid1">
		<div id="LayoutGrid1">
			<div class="row">
				<div class="col-1">
					<div id="wb_Heading1"
						style="display: inline-block; width: 100%; text-align: center; z-index: 0;">
						<h3 id="Heading1">Home Bills System</h3>
						<br /> <span
							style="color: #000000; font-family: Arial; font-size: 13px;">
							<c:out value="User name: ${PRINCIPAL.firstName} ${PRINCIPAL.lastName}" /></span>

					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="wb_LayoutGrid2">
		<div id="LayoutGrid2">
			<div class="row">
				<div class="col-1">
					<table
						style="display: table; width: 100%; height: 106px; z-index: 1;"
						id="Table1">
						<tr>
							<td class="cell0"><form action="ServletController"
									method="get">

									<input type="hidden" name="command" value="show-electricity" />
									<input type="submit" value="Show Electricity Balance" />
								</form>
								<span
								style="color: #000000; font-family: Arial; font-size: 13px; line-height: 16px;">

							</span></td>
							
						</tr>
						<tr>
							<td class="cell0"><form action="ServletController"
									method="get">

									<input type="hidden" name="command" value="show-water" />
									<input type="submit" value="Show Water Balance" />
								</form>
								<span
								style="color: #000000; font-family: Arial; font-size: 13px; line-height: 16px;">

							</span></td>
						</tr>
						<tr>
							<td class="cell0"><form action="ServletController"
									method="get">

									<input type="hidden" name="command" value="show-all-users" />
									<input type="submit" value="Show All Users" />
								</form>
								<span
								style="color: #000000; font-family: Arial; font-size: 13px; line-height: 16px;">

							</span></td>
						</tr>
						<tr>
							<td class="cell0"><form action="ServletController"
									method="get">

									<input type="hidden" name="command" value="logout" /> <input
										type="submit" value="Log out" />
								</form>
								<span
								style="color: #000000; font-family: Arial; font-size: 13px; line-height: 16px;">
							</span></td>
						</tr>
					</table>
				</div>
				<div class="col-2">
					<br /> <span
							style="color: #000000; font-family: Arial; font-size: 13px;">
							<br />
							<c:out value="Account ID: ${account.account_ID}" />
							<br />
							<c:out value="Hot Water: ${water.balanceHotWater}" />
							<br />
							<c:out value="Cold Water: ${water.balanceColdWater}" />
							</span>
				</div>
			</div>
		</div>
	</div>
	<div id="wb_LayoutGrid3">
		<div id="LayoutGrid3">
			<div class="row">
				<div class="col-1">
					<div id="wb_Text1">
						<span style="color: #000000; font-family: Arial; font-size: 13px;">Created
							by K. Miatlitski</span>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>








