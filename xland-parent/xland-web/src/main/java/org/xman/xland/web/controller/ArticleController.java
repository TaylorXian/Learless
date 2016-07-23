package org.xman.xland.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.xman.xland.core.domain.Article;
import org.xman.xland.web.service.ArticleService;

@Controller
@RequestMapping("/article")
public class ArticleController {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private ArticleService articleService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView create(@PathVariable(value = "id") Integer id) {
		ModelAndView mv = new ModelAndView("article");
		Article article = articleService.findById(id);
		mv.addObject("article", article);
		return mv;
	}

	@RequestMapping(value = "write", method = RequestMethod.POST)
	public ModelAndView showMessage(@ModelAttribute(value="article") Article article) {
		articleService.save(article);
		return null;
	}

}
