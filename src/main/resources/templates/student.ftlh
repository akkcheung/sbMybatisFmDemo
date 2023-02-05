<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>FreeMarker Spring Boot Example</title>
</head>
<body>
        <h1>View Student</h1>
        <a href="/students/list">Back to Student List</a>

        <br/><br/>
        <#if student??>
           <table border="0">
                <tr>
                    <td>ID</td>
                    <td>:</td>
                    <td>${student.id}</td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td>:</td>
                    <td>${student.name}</td>
                </tr>
             </table>
             <br></br>
             
             <#if allowDelete>
                <form action="${'/students/' + student.id + '/delete'}" method="POST">
                    Delete this note? <input type="submit" value="Yes" />
                </form>
            <#else>
	             <div>
	                <a href="${'/students/' + student.id + '/edit'}">Edit</a> |
	                <a href="${'/students/' + student.id + '/delete'}">Delete</a>
	             </div>
             </#if>
         </#if>

        <#if errorMessage?has_content>
            <div class="error">${errorMessage}</div>
        </#if>
</body>
</html>