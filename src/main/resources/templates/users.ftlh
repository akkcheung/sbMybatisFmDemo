<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    
    <!-- UIkit CSS -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/uikit@3.15.22/dist/css/uikit.min.css" />

	<!-- UIkit JS -->
	<script src="https://cdn.jsdelivr.net/npm/uikit@3.15.22/dist/js/uikit.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/uikit@3.15.22/dist/js/uikit-icons.min.js"></script>
    
    <title>FreeMarker Spring Boot Example</title>
    
</head>
<body>

<div class="uk-padding uk-panel">

	<div class="uk-background-primary uk-light">
		<nav class="uk-navbar-container uk-navbar-transparent">
			
		        <ul class="uk-navbar-nav">
		            <!--<li class="uk-active"><a href=""></a>Login</li> -->
		             <!-- <li class="uk-parent"><a href=""></a></li>  -->
		           <li><a href="/logout"></a>Logout</li>
		            <div></div>
		        </ul>
		    
		</nav>
	</div>

<div class="uk-background-default">
<table border="1">
<tr>
	<th>Name</th>
	<th>Email</th>
</tr>
<#list users as user>
<tr>
	<td><a href="${user.id}">${user.username!''}</td>
	<td>${user.email!''}</td>
</tr>
</#list>
</table>
</div>

</div>
</body>
</html>