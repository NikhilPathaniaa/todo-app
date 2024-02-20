package controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


@WebFilter({"/add-task","/complete","/delete","/update-task","/logout","/home.jsp","/edit-task"})
public class MyLoginfilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		if(req.getSession().getAttribute("user")==null)
		{
			response.getWriter().print("<h1 align='center' style='color:red'>Invalid session</h1>");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		else
		{
			chain.doFilter(request, response);
		}
	}
}
