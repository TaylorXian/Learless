package org.xman.xland.web.controller;

import org.springframework.ui.ModelMap;

public abstract class AbstractController {

	protected void setTitle(ModelMap model, String title) {
		model.addAttribute("title", title);
	}
}
