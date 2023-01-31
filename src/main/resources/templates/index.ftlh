
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
        <!-- UIkit CSS -->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/uikit@3.15.22/dist/css/uikit.min.css" />

		<!-- UIkit JS -->
		<script src="https://cdn.jsdelivr.net/npm/uikit@3.15.22/dist/js/uikit.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/uikit@3.15.22/dist/js/uikit-icons.min.js"></script>
    
    <title>Registration and Login System</title>
    
</head>
<body>

<div class="uk-padding uk-panel">

	<div class="uk-background-primary uk-light">
		<nav class="uk-navbar-container uk-navbar-transparent">
			
		        <ul class="uk-navbar-nav">
		        	<li><a href="/register"></a>Register</li> 
		            <li><a href="/login"></a>Login</li>	           		            
		            <div></div>
		        </ul>
		</nav>
	</div>

	<div class="uk-background-default">
	
	
	 	<#if SPRING_SECURITY_CONTEXT??>
	 	
	 		<#assign 
	 			user = SPRING_SECURITY_CONTEXT.authentication.principal
	 			username = user.getUsername()
	 		>
	 		logged in / 已登入 ${username} 
	 	</#if>
	    
	    <h3> Welcome to Registration and Login System</h3>
	    
	    
	    </div>  
	</div>
	
</div>	


</body>
</html>