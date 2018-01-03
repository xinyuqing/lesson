<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
	<title>Hello Spring</title>
</head>

<body>
	<h2>All Employees in System</h2>

	<a href="/empl/getAll">Show All</a> &nbsp;
	<a href="/empl/addOne">Add One</a> &nbsp;
	<a href="/empl/removeLast">Remove Last One</a> &nbsp;
	<a href="/empl/removerandom">Random remove one</a> &nbsp;
	<a href="/empl/removeAll">Remove All</a>

	<br/>
	<br/>

	<table border="1">
		<tr>
			<th>Employee Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Operation</th>
		</tr>
		<c:forEach items="${employees}" var="employee">
			<tr>
				<td>${employee.id}</td>
				<td>${employee.firstName}</td>
				<td>${employee.lastName}</td>
				<td>
					&nbsp; <a href="/empl/delete/${employee.id}">Delete Me</a> &nbsp;
					&nbsp; <a href="/empl/update/${employee.id}">Random Update</a> &nbsp;
					&nbsp; <a href="/empl/display/${employee.id}">Update</a> &nbsp;
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>