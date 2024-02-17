<%@page import="dto.TodoTask"%>
<%@page import="dto.TodoUser"%>
<%@page import="dto.TodoTask"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>

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
	<h1 align="center">Home Page</h1>
	<%if(!tasks.isEmpty()) {%>
	<div>
		<table>
			<tr>
				<th>task Name</th>
				<th>task Descripton</th>
				<th>Created Time</th>
				<th>Status</th>
				<th>Delete</th>
				<th>Edit</th>
			</tr>
			cool
			<%for(TodoTask task :tasks) {%>
			<tr>
				<th><%=task.getName() %></th>
				<th><%=task.getDescription() %></th>
				<th><%=task.getCreatedTime() %></th>
				<th><%=task.isStatus() %></th>
				<th><button>Delete</button></th>
				<th><button>Edit</button></th>
			</tr>
			<%} %>
		</table>
	</div>
	<%} %>
	<button><a href="add-task.html">add tasks</a></button>
</body>
</html>