package controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.TodoUser;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		Long mobile=Long.parseLong(req.getParameter("mobile"));
		String dob=req.getParameter("dob");
		String gender=req.getParameter("gender");
		
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("abc");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		
		TodoUser user=new TodoUser();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setMobile(mobile);
		user.setDob(dob);
		user.setGender(gender);
		
		transaction.begin();
		manager.persist(user);
		transaction.commit();
		
		resp.getWriter().print("<h1 align='center' style='color:green'>Account Created  Successfully</h1>");
		req.getRequestDispatcher("login.html").include(req, resp);
	}
	
}
