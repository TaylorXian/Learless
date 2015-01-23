package org.xman.lear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FellowController {
	String message = "Welcome to Spring MVC!";

	@RequestMapping("/fellow")
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		System.out.println("in controller.");

		ModelAndView mv = new ModelAndView("fellow");
		mv.addObject("message", message);
		mv.addObject("name", name);
		return mv;
	}
}
