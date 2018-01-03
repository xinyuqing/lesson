<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
	<title>Employee Update</title>
</head>

<body>
	<h2>Employee Update</h2>

	<form action="/empl/saveUpdate" method = "post">
		<table border="1">
			<tr>
				<th>Employee Id</th>
				<th>First Name</th>
				<th>Last Name</th>
			</tr>
			<c:forEach items="${employees}" var="employee">
				<tr>
					<td><input type="text" name="id" value = "${employee.id}" readonly = "readonly"/></td>
					<td><input type="text" name="firstName" value = "${employee.firstName}"/></td>
					<td><input type="text" name="lastName" value = "${employee.lastName}"/></td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<input type = "submit" value = "Submit"/>
		&nbsp;
		<input type = "button" value = "cancel" onclick="window.location.href='/empl/getAll'"/>
	</form>

</body>
</html>