<%@ page import="com.lesson.orderentry.service.CategoryManager" %>
<%@ page import="com.lesson.orderentry.model.Category" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	CategoryManager categoryManager = (CategoryManager)session.getAttribute("categoryManager");
	String currentCid = request.getParameter("cid");
%>

<html>
<head>
	<title>主菜单</title>
</head>

<body>
	<h2>当前菜单</h2>
	<form action = "/order/showMenus" method = "get">
		<b>查询：</b>
		<select name="cid">
			<option value="all"
				<% if(currentCid == null){ out.println("selected"); }%>
			>全部</option>
			<%
				List<Category> categories = categoryManager.getAllCategories();
				for(Category category:categories){
			%>
					<option value="<%=category.getCid()%>"
						<%
							if(currentCid != null && currentCid.equalsIgnoreCase(new Integer(category.getCid()).toString())){
								out.println("selected");
							}
						%>
					>
						<%=category.getCname()%>
					</option>
			<%
				}
			%>
		</select>
		<input type = "submit", value = "提交查询"/>
		&nbsp;|&nbsp;
		<input type = "button" value = "添加菜品" onclick="window.location.href='/order/addMenu'">
		&nbsp;|&nbsp;
		<input type = "button" value = "管理分类" onclick="window.location.href='/order/showCategories'">
	</form>

	<table border="1" cellspacing="0" cellpadding="5">
		<tr>
			<th>点菜</th>
			<th>菜品编号</th>
			<th>菜品名称</th>
			<th>分类ID</th>
			<th>价钱</th>
			<th>相关操作</th>
		</tr>
		<c:forEach items="${menus}" var="menu">
			<tr>
				<td align="center"><input type="checkbox"/></td>
				<td align="center">${menu.mid}</td>
				<td>${menu.mname}</td>
				<td>
					<c:set var="cid" scope="request" value="${menu.cid}" />
					<%=categoryManager.getCategoryById(((Integer)request.getAttribute("cid")).intValue()).getCname()%>
				</td>
				<td align="center">${menu.price}</td>
				<td>
					<input type = "button" value = "删除" onclick="javascript:if(confirm('确认删除${menu.mname}'))window.location.href='/order/delete/${menu.mid}'">
					<input type = "button" value = "更新" onclick="window.location.href='/order/editMenu/${menu.mid}'">
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>