<@layout title="index">
	
	 	<#if SPRING_SECURITY_CONTEXT??>
	 	
	 		<#assign 
	 			user = SPRING_SECURITY_CONTEXT.authentication.principal
	 			username = user.getUsername()
	 		>
	 		logged in / 已登入 ${username} 
	 	</#if>
	    
	    <h3> Welcome to Registration and Login System</h3>
	
	
</@layout>