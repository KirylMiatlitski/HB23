<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Account Creating</title>
</head>
<body>
	
	
	<form name="registrationform" method="post" accept-charset="UTF-8"
		action="ServletController" id="registrationform">
		<input type="hidden" name="command" value="registration">
		<table id="registration">
			<tr>
				<td class="header">Registration</td>
			</tr>
			<tr>
				<td class="label"><label for="loginname">Login</label></td>
			</tr>
			<tr>
				<td class="row"><input class="input" name="loginname"
					type="text" id="loginname" value=""></td>
			</tr>
			<tr>
				<td class="label"><label for="password">Password</label></td>
			</tr>
			<tr>
				<td class="row"><input class="input" name="password"
					type="password" id="password" value=""></td>
			</tr>
			
			<tr>
				<td class="label"><label for="firstname">First Name</label></td>
			</tr>
			<tr>
				<td class="row"><input class="input" name="firstname"
					type="text" id="firstname" value=""></td>
			</tr>
			
			<tr>
				<td class="label"><label for="lastname">Last Name</label></td>
			</tr>
			<tr>
				<td class="row"><input class="input" name="lastname"
					type="text" id="lastname" value=""></td>
			</tr>
			
			<tr>
				<td class="label"><label for="address">Address</label></td>
			</tr>
			<tr>
				<td class="row"><input class="input" name="address"
					type="text" id="address" value=""></td>
			</tr>
			<tr>
				<td style="text-align: center; vertical-align: bottom"><input
					class="button" type="submit" name="registration" value="Create account" id="login"></td>
			</tr>
		</table>
	</form>
</body>
</html>