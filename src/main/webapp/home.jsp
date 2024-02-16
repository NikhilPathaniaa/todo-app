<%@page import="dto.TodoTask"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	List<TodoTask> tasks = (List<TodoTask>) request.getAttribute("tasks");
	%>
	<h1>Home Page</h1>
	<%if(!tasks.isEmpty()) {%>
	<div>
		<table>
			<tr>
				<th>task name</th>
				<th>task name</th>
				<th>task name</th>
				<th>task name</th>
				<th>task name</th>
				<th>task name</th>
			</tr>
			
			<%for(TodoTask task :tasks) {%>
			<tr>
				<th>task name</th>
				<th>task name</th>
				<th>task name</th>
				<th>task name</th>
				<th>task name</th>
				<th>task name</th>
			</tr>
			<%} %>
		</table>
	</div>
	<%} %>
	<button><a href="add-task.html">add tasks</a></button>
</body>
</html>