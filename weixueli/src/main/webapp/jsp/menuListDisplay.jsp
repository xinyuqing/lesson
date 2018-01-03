<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
	<title>Hello Spring---Menu</title>
</head>

<body>
    <h2>All MenuList in System</h2>

    	<a href="/menu/getAllMenu">Show Menu All</a> &nbsp;
    	<a href = "/menu/addOneFood">Add food</a>&nbsp;
    	<a href="/menu/removeLastFood">Remove Last Food</a> &nbsp;
    	<br/>
    	<br/>

    	<table border = "1">
    	    <tr>
    	        <th>id</th>
    	        <th>MenuName</th>
    	        <th>price</th>
    	        <th>category</th>
    	        <th>operator</th>
    	    </tr>
    	    <c:forEach items="${menus}" var="menu">
    	    <tr>
    	        <td>${menu.id}</td>
    	        <td>${menu.menuName}</td>
    	        <td>${menu.price}</td>
    	        <td>${menu.category}</td>
    	        <td>&nbsp; <a href="/menu/update/${menu.id}">Update</a> &nbsp;</td>
    	    </tr>
    	    </c:forEach>
    	</table>
</body>
</html>
