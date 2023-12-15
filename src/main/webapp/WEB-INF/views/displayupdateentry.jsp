<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MyDairy App Homepage</title>
<link rel="stylesheet" href="<c:url value='/resources/styles/style.css' />">
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
<a href="./signout" style="color:red;float:right">signout</a> 
<!-- now below we are writing body part -->
<div class="bodypart">
<div class="bodypart1"><img src="<c:url value='/resources/images/Dairy.jpg' />"></div>

<div class="bodypart2">
<h1>UPDATE ENTRY</h1><br><br>
<form action="./processentryupdate" method="post">
<label>Date</label> <input type="text" name="entrydate" class="formcontrol" value=" <fmt:formatDate value="${entry.entrydate}" pattern="dd/MM/yyy"/>" readonly><br/><br>
<label>Description ${entry.userid}</label> 
<textarea rows="10" cols="30" name="description"> 
 ${entry.description}
</textarea>

<input type="hidden" name="userid" value="${entry.userid}">
<input type="hidden" name="id" value="${entry.id}">

<br/><br><br>
<button type="submit" class="buttoncontrol">UPDATE ENTRY</button>
</form>
</div>

</div>


</body>
</html>