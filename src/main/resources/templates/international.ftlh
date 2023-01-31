<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1" />
<title>Home</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="/internationalization.js"></script>
</head>
<body>
<h1>${greeting}</h1>

<br /><br />
<span>${lang_change}</span>:
<select id="locales">
    <option value=""></option>
    <option value="en">${lang_eng}</option>
    <option value="fr">${lang_fr}</option>
</select>
</body>
</html>