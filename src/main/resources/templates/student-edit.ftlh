<#import "/spring.ftl" as spring />

<html>
   <head>
      <title><#if add>Create a Student:<#else>Edit a Student:</#if></title>
      <link rel="stylesheet"
           type="text/css" href="/css/style.css/">      
   </head>
   <body>
   
       <a href="/students/list">Back to Student List</a>
       <br/><br/>
     
    <#if student?? && noErrors??> 
 
  	<#else>
      
	     <#if add>
	          <#assign urlAction>/students/add</#assign>
	          <#assign submitTitle>Create</#assign>
	     <#else>
	           <#assign urlAction>${'/students/' + student.id + '/edit'}</#assign>
	           <#assign submitTitle>Update</#assign>
	     </#if>
     
	      <div>
	         <fieldset>
	            <legend><#if add>Create <#else>Edit </#if>Student</legend>
	            
	            <form action="${urlAction}" name="student" method="POST">
	 				Name: 
	 				<@spring.bind "student.name"/>
	               	<input type="text" name="${spring.status.expression}" value="${spring.status.value!''}"/> <@spring.showErrors "<br>"/>
	               
	               	Email: <input type="text" name="email" value="${(student.email)!''}" /> <br/>
	               
	               	<input type="submit" value="${submitTitle}" />
	            </form>
	         </fieldset>
	      </div>
	      
      </#if>
    </body>
   
</html>