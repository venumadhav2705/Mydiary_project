<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MyDairy App Homepage</title>
<link rel="stylesheet" href="<c:url value='/resources/styles/style.css' />">
</head>
<body>

<!-- below total header part tarvata body part ratsamu -->
<div class="header">
<div class="first"><img src="<c:url value="/resources/images/Dairy.jpg"/>" width="40" height="40"/>
</div>
<div class="second">MyDairy App</div>

</div>

<br/><br/>

<hr/>  <!-- hr for horizontal line -->

<!-- now below we are writing body part -->
<div class="bodypart">
<div class="bodypart1"><img src="<c:url value="/resources/images/Dairy.jpg"/>"></div>

<div class="bodypart2">
<h1>LOGIN Here</h1><br><br>
<form action="authenticate" method="post">
<label>username</label> <input type="text" name="username" class="formcontrol"><br/><br>
<label>password</label> <input type="password" name="password" class="formcontrol"><br/><br><br>
<button type="submit" class="buttoncontrol">LOGIN</button>
</form>
<br><br>

New User? <a href="./register">Register</a>here
</div>

</div>


</body>
</html>