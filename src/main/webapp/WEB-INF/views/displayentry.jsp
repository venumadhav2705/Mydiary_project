<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<h1>VIEW ENTRY</h1><br><br>
<TABLE>
<tr><td>Date:</td><td>${entry.entrydate}</td></tr> <!-- controller nunchi ikkadadiki entry date ostadi display chestam controllr ki DB nunchi ostadi -->
<tr><td>Description:</td><td>${entry.description}</td></tr>
</TABLE>


<br/><br><br>
<a href="userhome"><button type="button">BACK TO HOME</button></a>
</div>

</div>


</body>
</html>