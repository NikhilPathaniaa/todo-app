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
			
			<%for(TodoTask task :tasks) {%>
			<tr>
				<th><%=task.getName() %></th>
				<th><%=task.getDescription() %></th>
				<th><%=task.getCreatedTime() %></th>
				<th><% if(task.isStatus()) {%>
				Completed<%
					}else{
					%><a href="complete?id=<%=task.getId()%>"><button>Complete</button></a></th>
					<%} %>
				<th><a href="delete?id=<%=task.getId()%>"><button>delete</button></a></th>
				<th><a href="edit-task.jsp?name=<%=task.getName()%>&description<%= task.getDescription()%>&id<%= task.getId()%>"><button>Edit</button></a></th>
			</tr>
			<%} %>
		</table>
	</div>
	<%} %>
	<button><a href="add-task.html"><button class="extra">add tasks</button></a>
	<a href="Logout"><button class="">Logout</button></a>
</body>
</html>