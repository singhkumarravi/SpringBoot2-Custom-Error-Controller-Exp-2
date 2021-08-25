package com.olive.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
public class EmpController implements ErrorController{
	
   
	
	@RequestMapping("/error")
	public @ResponseBody String handleProblem(HttpServletRequest req)
	{
		int code = (Integer)req.getAttribute("javax.servlet.error.status_code");
		Exception excp = (Exception)req.getAttribute("javax.servlet.error.exception");
		
		StringBuilder builder = new StringBuilder();
		builder.append("<html><body>");
		builder.append("<h2>ERROR DETAILS</h2>");
		builder.append("<p>Status code :").append(code).append("</p>");
		builder.append("<p>Exception :").append(excp==null?"NONE":excp.getMessage()).append("</p>");
		builder.append("</body></html>");
		return builder.toString();
	}
	
	@Override
	public String getErrorPath() {
	
		return "/error";
	}
	
	
}
