package com.spring.app.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@Value("${welcome.message:test}")
	private String message = "Hello World";

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "index";
	}
	@RequestMapping("/my-article")
	public String myarticle(Map<String, Object> model) {
		model.put("message", "my-article");
		return "my-article";
	}
	@RequestMapping("/category")
	public String category(Map<String, Object> model) {
		model.put("message", "my-category");
		return "category";
	}
	@RequestMapping("/login")
	public String login(Map<String, Object> model) {
		model.put("message", "login");
		return "login";
	}
	@RequestMapping("/my-account")
	public String myaccount(Map<String, Object> model) {
		model.put("message", "my-account");
		return "my-account";
	}
	
	@RequestMapping("/index")
	public String index(Map<String, Object> model) {
		return this.welcome(model);
	}
}