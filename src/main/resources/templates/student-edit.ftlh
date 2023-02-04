<html>
   <head>
      <title><#if add>Create a Student:<#else>Edit a Student:</#if></title>
      <link rel="stylesheet"
           type="text/css" href="/css/style.css/">      
   </head>
   <body>
   
       <a href="/students/list">Back to Student List</a>
       <br/><br/>
     
      
     <#if add>
          <#assign urlAction>/students/add</#assign>
          <#assign submitTitle>Create</#assign>
     <#else>
           <#assign urlAction>${'/students/' + student.id() + '/edit'}</#assign>
           <#assign submitTitle>Update</#assign>
     </#if>
     
      <div>
         <fieldset>
            <legend><#if add>Create <#else>Edit </#if>Student</legend>
            
            <form action="${urlAction}" name="student" method="POST">
            
               Name: <input type="text" name="name" value="${(student.name())!''}" />  <br/>
               Email: <input type="text" name="email" value="${(student.email())!''}" /> <br/>
               
               <input type="submit" value="${submitTitle}" />
            </form>
         </fieldset>
      </div>
    </body>
   
</html>