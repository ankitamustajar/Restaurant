package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.Mydao;
import dto.Customer;
//This is to map the action url to this class(Should be same as action - case sensitive)
@WebServlet("/signup")
//to receive image we need to use
@MultipartConfig
//this is to make servlevt class
public class signup extends HttpServlet{
	

@Override
//when there is a form and we want the data to be secured so do post
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	logic to receive value from front end 
	String fullname=req.getParameter("name");
	String password=req.getParameter("password");
	long mobile=Long.parseLong(req.getParameter("number"));
	String email=req.getParameter("email");
	String gender=req.getParameter("gender");
	String country=req.getParameter("Country");
	LocalDate dob=LocalDate.parse(req.getParameter("dob"));
	int age=Period.between(dob, LocalDate.now()).getYears();
	
//	logic to receive image and convert to byte[]
	Part pic=req.getPart("picture");
	byte[] picture=null;
	picture=new byte[pic.getInputStream().available()];
	pic.getInputStream().read(picture);
	
	Mydao dao=new Mydao();
	
	


	if(dao.featchByEmail(email)==null && dao.featchByMobile(mobile)==null)
	{
  Customer c=new Customer();

	c.setEmail(email);
	c.setFullname(fullname);
	c.setGender(gender);
	c.setMobile(mobile);
	c.setPicture(picture);
	c.setPassword(password);
	c.setCountry(country);
	
	dao.save(c);
	
	resp.getWriter().print("<h1 style='color green'>Account Created Successfully</h1>");
	req.getRequestDispatcher("Homepage.html").include(req, resp);
}
else {

	resp.getWriter().print("<h1 style='color green'>email and mobile should be unique</h1>");
	req.getRequestDispatcher("SIGNUP.html").include(req, resp);
}
}
}	

	
	
