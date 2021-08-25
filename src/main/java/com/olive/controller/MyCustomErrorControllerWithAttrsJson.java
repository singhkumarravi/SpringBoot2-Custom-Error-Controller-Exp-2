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
//@Controller
public class MyCustomErrorControllerWithAttrsJson implements ErrorController {
	@Autowired
	private ErrorAttributes errorAttr;

	@SuppressWarnings("deprecation")
	@RequestMapping("/error")
	@ResponseBody
	public Map<String,Object> handleProblem(HttpServletRequest req){
		ServletWebRequest wt=new ServletWebRequest(req);
		Map<String, Object> errorAttributes = errorAttr.getErrorAttributes(wt, true);

		return errorAttributes;
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/error";
	}



}
