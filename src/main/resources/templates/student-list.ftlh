<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>FreeMarker Spring Boot Example</title>
</head>
<body>
   
<table border="1">
	<tr>
		<th>Name</th>
		<th>Email</th>
	</tr>
	<#list students as user>
		<tr>
			<td><a href="${user.id()}">${user.name()}</td>
			<td>${user.email()}</td>
		</tr>
	</#list>
</table>

</body>
</html>