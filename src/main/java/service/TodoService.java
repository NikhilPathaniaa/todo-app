package service;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TodoDao;
import dto.TodoUser;

public class TodoService {
	public void signup(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		TodoUser user = new TodoUser();
		
		user.setName(req.getParameter("name"));
		user.setEmail(req.getParameter("email"));
		user.setPassword(req.getParameter("password"));
		user.setMobile(Long.parseLong(req.getParameter("mobile")));
		user.setDob(LocalDate.parse(req.getParameter("dob")));
		user.setGender(req.getParameter("gender"));

		TodoDao dao = new TodoDao();
		dao.saveUser(user);

		resp.getWriter().print("<h1 align='center' style='color:green'>Account Created  Successfully</h1>");
		req.getRequestDispatcher("login.html").include(req, resp);
	}
}
