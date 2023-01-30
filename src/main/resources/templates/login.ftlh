<#import "/spring.ftl" as spring />

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

<form  
  	method="post"
    action="/login"
    class="uk-form-stacked" 
>

  <fieldset class="uk-fieldset">
 
  <legend class="uk-legend">Login</legend>
 
  <#if user?? && noErrors??> 
 
  <#else>
 
  <div class="uk-margin">
        <@spring.bind "user.email"/>
        <input type="text"
        	class="uk-input uk-form-width-medium"
        	placeholder="Enter email address"
            name="${spring.status.expression}"
            value="${spring.status.value!''}"/>
        <@spring.showErrors "<br>"/>
  </div>
  
  <div class="uk-margin">
       <@spring.bind "user.password"/>
        <input type="text"
        	class="uk-input uk-form-width-medium"
        	placeholder="Enter password"
            name="${spring.status.expression}"
            value="${spring.status.value!''}"/> 
             <#list spring.status.errorMessages as error>
      			<span class="error">${error}</span>
      			<br>
    		</#list>
  </div>
  
  <p uk-margin>
   <button class="uk-button uk-button-primary" type="submit">Submit</button>
   <span> Not registered ? <a href="/register">Register/Signup here</a></span>
  </p>
  
 </#if>
  
  </fieldset>
<form>

</div>

</body>
</html>