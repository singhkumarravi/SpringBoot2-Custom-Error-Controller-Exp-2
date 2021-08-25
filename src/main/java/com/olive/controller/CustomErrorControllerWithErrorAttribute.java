package com.olive.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;

@Controller
public class CustomErrorControllerWithErrorAttribute implements ErrorController{
	
	
	@Autowired
	private ErrorAttributes errorAttributes;
	
	@RequestMapping("/error")
	public @ResponseBody String handleProblem(HttpServletRequest req)
	{
		ServletWebRequest webRequest = new ServletWebRequest(req);
		
		@SuppressWarnings("deprecation")
		Map<String, Object> errors = errorAttributes.getErrorAttributes(webRequest, true);
		
		errors.put("msg", "custom error Attribut");
		StringBuilder builder = new StringBuilder();
		builder.append("<html><body>");
		builder.append("<h2>ERROR DETAILS</h2>");
	
		builder.append("<table border='1'>");
		errors.forEach((k,v)->{
			builder.append("<tr>")
			.append("<td>").append(k).append("</td>")
			.append("<td>").append(v).append("</td>")
			.append("</tr>");
		});
		builder.append("</table>");
		builder.append("</body></html>");
		return builder.toString();
	}


	@Override
	public String getErrorPath() {
	
		return "/error";
	}
	
	
}
