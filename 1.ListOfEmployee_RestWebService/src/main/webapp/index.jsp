
<html>
<body>
<h3> Employee Form</h3>



<form action="saveAction" method="post">
<table>
	<tr>
		<td>Emp ID:</td><td>	<input type="text" name="id"/></td>
		
	</tr>
	<tr>
		<td>Emp Name:</td><td>	<input type="text" name="name"/></td>
	</tr>
	
	 <tr>
		<td>Emp DOB:</td><td>	<input type="text" name="dateDob"/></td>
	</tr>
	
	<table>
	<tr><td>Student Address:</td></tr>
	<tr>
		<td>Country: <input type="text" name="empAddress.country"/></td>
		<td>City: <input type="text" name="empAddress.city"/></td>
	</tr>
	</table>
	
	<tr>
		<td><input type="submit"></td>
	</tr>
</table>
</form>
</body>
</html>