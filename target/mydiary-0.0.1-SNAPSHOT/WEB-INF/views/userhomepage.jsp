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

<br/>

<hr/>  <!-- hr for horizontal line -->
<br><br>

<!-- now below we are writing body part -->
<div class="userhome">
Welcome <span style="color:steelblue">${user}</span>
<a href="" style="color:red;float:right">signout</a> <!-- here we used float right to send sign out button to right side --> 

<br><br><br>
<span class="heading">List of past Entries</span>
<a href="./addentry"><button type="button" class="addbtn">Add Entry</button></a>

<br><br>

<table border="1">
<tr>
<th>Date</th>
<th colspan="3">Actions</th> <!-- here colspan=3 is written for view,update,delete in actions  -->
</tr>

<c:if test="${entrieslist.size()==0}">     <!-- if user not added any entreis idi print avtundi so ee line rayali  -->
<tr><td style="font-size:15px;color:green;text-align:center">user not added any entries</td></tr>
</c:if>

<c:forEach items="${entrieslist}" var="e"> <!--  manaki list of objects controller nunchi vastai vatini ikkada loop run chesi display
                                              cheydam kosam idi vadutam -->
 <tr>
 <td> ${e.entrydate} </td>
 <td><a href="#">View</a></td>
 <td><a href="#">Update</a></td>
 <td><a href="#">Delete</a></td>
 </tr>
 
</c:forEach>

</table>
</div>


</body>
</html>