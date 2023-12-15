<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MyDairy App Homepage</title>
<link rel="styLesheet" href="<c:url value='/resources/styles/style.css' />">
</head>
<body>

<!-- below total header part tarvata body part ratsamu -->
<div class="header">
<div class="first"><img src="<c:url value='/resources/images/Dairy.jpg' />" width="40" height="40">
</div>
<div class="second">MyDairy App</div>

</div>

<br/><br/>

<hr/>  <!-- hr for horizontal line -->

<!-- now below we are writing body part -->
<div class="bodypart">
<div class="bodypart1"><img src="<c:url value='/resources/images/Dairy.jpg' />"></div>

<div class="bodypart2">
<h1>REGISTRATION FORM</h1><br><br>
<form action="./saveuser" method="POST">  <!-- When user clicked on register in form then it comes to this saveuser and it takes to controller  -->
<label>username</label> <input type="text" name="username" class="formcontrol"><br/><br>
<label>password</label> <input type="password" name="password" class="formcontrol"><br/><br><br>
<button type="submit">REGISTER</button>
</form>
<br><br>

Existing User? <a href="./home">Login</a>here
</div>

</div>


</body>
</html>