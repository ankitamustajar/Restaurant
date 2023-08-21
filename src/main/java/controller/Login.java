package controller;

import java.io.IOException;

import dao.Mydao;
import dto.Customer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String mail=req.getParameter("mail");
	String password=req.getParameter("password");
	
	
	Mydao dao=new Mydao();
	if(email.equals("admin@jsp*"))
	Customer c=dao.featchByEmail(mail);
	if(c==null)
	{
		resp.getWriter().print("<h1 style='color:red'>Invalid password</h1>");
		req.getRequestDispatcher("Homepage.html").include(req, resp);
	}else {
		if(password.equals(c.getPassword())) {
		resp.getWriter().print("<h1 style='color:green'>Login Success</h1>");
		}else {
			resp.getWriter().print("<h1 style='red'>Invalid Password</h1>");
			req.getRequestDispatcher("Homepage.html").include(req, resp);
		}
	
	
		
	}
	
	

}
}