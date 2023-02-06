<#macro layout title>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

 	<title>${title}</title>
 
  	<!-- UIkit CSS -->
	<link rel="stylesheet" type="text/css" href="/webjars/uikit/3.15.18/dist/css/uikit.min.css" />

	
</head>

<body>
    
     <div class="uk-background-primary uk-light">
		<nav class="uk-navbar-container uk-navbar-transparent">
			
		        <ul class="uk-navbar-nav">
		        	<li><a href="/register"></a>Register</li> 
		            <li><a href="/login"></a>Login</li>
		            <li><a href="/greet"></a>Greet</li>	            		            
		            <div></div>
		        </ul>
		</nav>
	</div>

    <div class="uk-container">
        <!-- <h1>Example</h1> -->
        <#nested>
    </div>
    
    <!-- UIkit JS -->
	<script src="/webjars/uikit/3.15.18/dist/js/uikit.min.js"></script>
	<script src="/webjars/uikit/3.15.18/dist/js/uikit-icons.min.js"></script>
   
    <!-- htmx JS -->
    <script src="/webjars/htmx.org/1.8.5/dist/htmx.min.js"></script>

</body>
</html>
</#macro>