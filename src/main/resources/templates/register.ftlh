<@layout title="Register">

<form  
	method="post"
    action="/register"
	class="uk-form-stacked">
	
 <fieldset class="uk-fieldset">
 
  <legend class="uk-legend">Registration</legend>
  
  <#if user?? && noErrors??> 
 
  <#else>
   
  <div class="uk-margin">
  	  <label class="uk-form-label" for="form-stacked-text">User Name</label>
  	  <div class="uk-form-controls">      	
      	<@spring.bind "user.username"/>
        <input type="text"
        	class="uk-input uk-form-width-medium uk-form-danger"
        	placeholder="Enter username"
            name="${spring.status.expression}"
            value="${spring.status.value!''}"/><@spring.showErrors "<br>"/>
      </div>
     
  </div>
  
  <div class="uk-margin">
   	<label class="uk-form-label" for="form-stacked-text">Email</label>
        <@spring.bind "user.email"/>
        <input type="text"
        	class="uk-input uk-form-width-medium"
        	placeholder="Enter email address"
            name="${spring.status.expression}"
            value="${spring.status.value!''}"/>
        <@spring.showErrors "<br>"/>
  </div>
  
  
  
  <div class="uk-margin">
   	<label class="uk-form-label" for="form-stacked-text">Password</label>
     <@spring.bind "user.password"/>
        <input type="text"
        	class="uk-input uk-form-width-medium"
        	placeholder="Enter password"
            name="${spring.status.expression}"
            value="${spring.status.value!''}"/> <@spring.showErrors "<br>"/>
  </div>
  
  <p uk-margin>
   <button class="uk-button uk-button-primary" type="submit">Submit</button>
   <span>Already registered? <a href="/login">Login here</a></span>
  </p>
  
  </#if>
  
  </fieldset>
</form>

</@layout>
