package org.xman.xland.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.xman.xland.core.domain.Article;
import org.xman.xland.web.service.ArticleService;

@Controller
public class HomeController {

	@Autowired
	private ArticleService articleService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String index(ModelMap model) {
		List<Article> articles = articleService.findAllDesc();
		for (Article article : articles) {
			article.setContent(article.getContent().replaceAll("</?.+?>", ""));
		}
		model.addAttribute("articles", articles);
		return "home";
	}

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about(ModelMap model) {
		return "about";
	}
}
