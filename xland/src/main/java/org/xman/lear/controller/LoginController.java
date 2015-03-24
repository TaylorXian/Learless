package org.xman.lear.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.xman.lear.domain.Article;
import org.xman.lear.domain.Fellow;
import org.xman.lear.service.ArticleService;

@Controller
public class LoginController {

	@Autowired
	private ArticleService articleService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String view(ModelMap model) {
		Fellow fellow = new Fellow();
		model.addAttribute("usr", fellow);
		return "login";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String index(ModelMap model) {
		List<Article> articles = articleService.findAllDesc();
		model.addAttribute("articles", articles);
		System.out.println("home");
		return "home";
	}
}
