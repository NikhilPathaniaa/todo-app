package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TodoService;

@WebServlet("/logout")
public class LogoutServlett extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().getAttribute("user");
		resp.getWriter().print("<h1 align='center' style='color:green'>Logout success</h1>");
		req.getRequestDispatcher("login.html").include(req, resp);
	}

}
