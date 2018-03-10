package com.spring.app.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@Value("${welcome.message:test}")
	private String message = "Hello World";

	@RequestMapping("/")
	public String welcome(Map<String, Object> model,HttpServletRequest req,HttpServletResponse res) {
		model.put("message", this.message);
		return "index";
	}
	@RequestMapping("/my-article")
	public String myarticle(Map<String, Object> model,HttpServletRequest req,HttpServletResponse res) {
		model.put("message", "my-article");
		return "my-article";
	}
	@RequestMapping("/category")
	public String category(Map<String, Object> model,HttpServletRequest req,HttpServletResponse res) {
		model.put("message", "my-category");
		return "category";
	}
	@RequestMapping("/login")
	public String login(Map<String, Object> model,HttpServletRequest req,HttpServletResponse res) {
		model.put("message", "login");
		return "login";
	}
	@RequestMapping("/my-account")
	public String myaccount(Map<String, Object> model,HttpServletRequest req,HttpServletResponse res) {
		model.put("message", "my-account");
		return "my-account";
	}
	@RequestMapping("/index")
	public String index(Map<String, Object> model,HttpServletRequest req,HttpServletResponse res) {
		return this.welcome(model,req,res);
	}
	@RequestMapping("/my-earnings")
	public String myEarnings(Map<String, Object> model,HttpServletRequest req,HttpServletResponse res) {
		return "my-earnings";
	}
	@RequestMapping("/my-report")
	public String myReport(Map<String, Object> model,HttpServletRequest req,HttpServletResponse res) {
		return "my-report";
	}
	@RequestMapping("/new-article")
	public String newArticle(Map<String, Object> model,HttpServletRequest req,HttpServletResponse res) {
		return "new-article";
	}
	@RequestMapping("/change-password")
	public String changePassword(Map<String, Object> model,HttpServletRequest req,HttpServletResponse res) {
		return "change-password";
	}
}