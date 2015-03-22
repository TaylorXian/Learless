package org.xman.lear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.xman.lear.domain.Fellow;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String view(ModelMap model) {
		Fellow fellow = new Fellow();
		model.addAttribute("usr", fellow);
		return "/login";
	}
}
