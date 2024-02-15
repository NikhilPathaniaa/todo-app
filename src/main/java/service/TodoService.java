package service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TodoDao;
import dto.TodoTask;
import dto.TodoUser;

public class TodoService {
	TodoDao dao = new TodoDao();
	
	public void signup(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		TodoUser user = new TodoUser();

		user.setName(req.getParameter("name"));
		user.setEmail(req.getParameter("email"));
		user.setPassword(req.getParameter("password"));
		user.setMobile(Long.parseLong(req.getParameter("mobile")));
		user.setDob(LocalDate.parse(req.getParameter("dob")));
		user.setGender(req.getParameter("gender"));

		

		List<TodoUser> list = dao.findByEmail(user.getEmail());

		if (list.isEmpty()) {
			dao.saveUser(user);
			resp.getWriter().print("<h1 align='center' style='color:green'>Account Created  Successfully</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
		} 
		else 
		{
			resp.getWriter().print("<h1 align='center' style='color:red'>Email already exists</h1>");
			req.getRequestDispatcher("signup.html").include(req, resp);
		}
	}

	public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		List<TodoUser> list = dao.findByEmail(email);
		
		if(list.isEmpty())
		{
			resp.getWriter().print("<h1 align='center' style='color:red'>Icorrect Email</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
		}
		else
		{
			TodoUser user = list.get(0);
			if(user.getPassword().equals(password))
			{
				req.getSession().setAttribute("user", user);
				resp.getWriter().print("<h1 align='center' style='color:green'>Login Success</h1>");
				req.getRequestDispatcher("home.jsp").include(req, resp);
			}
			else
			{
				resp.getWriter().print("<h1 align='center' style='color:red'>Icorrect Password</h1>");
				req.getRequestDispatcher("login.html").include(req, resp);
			}
		}
		
	}

	public void addTask(HttpServletRequest req, HttpServletResponse resp) {
		String tname=req.getParameter("tname");
		String tdescription=req.getParameter("tdescription");
		
		TodoTask task = new TodoTask();
		task.setName(tname);
		task.setDescription(tdescription);
		task.setStatus(false);
		task.setCreatedTime(LocalDateTime.now());
		
		TodoUser user = (TodoUser) req.getSession().getAttribute("user");
		task.setUser(user);
		
	}
}
