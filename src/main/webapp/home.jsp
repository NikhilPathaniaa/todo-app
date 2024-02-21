<%@page import="dto.TodoTask"%>
<%@page import="dto.TodoUser"%>
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
<style>
	*
	{
		margin: 0;
		padding: 0;
	}
	nav
	{
		width: 100%;
		height: 60px;
		border: 2px solid black;
		display: flex;
		justify-content: end;
		align-items: center;
	}
	nav a
	{
		border: 2px solid black;
		height: 60px;
		width: 60px;
		border-radius: 50%;
		padding-left: -100px;
		display: flex;
		justify-content: center;
		align-items: center;
	}
</style>
</head>
<body>
	<%
	List<TodoTask> tasks = (List<TodoTask>) request.getAttribute("tasks");
	%>
	<nav>
		<a href="logout"><button class="">Logout</button></a>
	</nav>
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
			
			<%for(TodoTask task :tasks) {%>
			<tr>
				<th><%=task.getName() %></th>
				<th><%=task.getDescription() %></th>
				<th><%=task.getCreatedTime() %></th>
				<th><% if(task.isStatus()) {%>
				Completed<%
					}else{
					%><a href="complete?id=<%= task.getId()%>"><button>Complete</button></a></th>
					<%} %>
				<th><a href="delete?id=<%= task.getId()%>"><button>delete</button></a></th>
				<th><a href="edit-task.jsp?id<%= task.getId()%>&name=<%=task.getName()%>&description<%= task.getDescription()%>"><button>Edit</button></a></th>
			</tr>
			<%} %>
		</table>
	</div>
	<%} %>
	<a href="add-task.html"><button class="extra">add tasks</a>
	
</body>
</html>