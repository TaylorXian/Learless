package org.xman.xland.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.xman.xland.web.service.WordService;

@Controller
@RequestMapping("word")
public class WordController {

	@Autowired
	private WordService wordService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String all() {
		return "mobile/data/phones";
	}

	@RequestMapping(value = "/{page}.html", method = RequestMethod.GET)
	public String about(@PathVariable String page) {
		return "mobile/angular/blk/" + page;
	}

}
