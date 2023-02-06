<@layout title="Login">

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
</form>

</@layout>
