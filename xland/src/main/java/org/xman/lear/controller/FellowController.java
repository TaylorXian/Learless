package org.xman.lear.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.xman.lear.domain.Fellow;
import org.xman.lear.service.FellowService;

@Controller
@RequestMapping("/usr")
public class FellowController {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private FellowService fellowService;

	String message = "Welcome to Spring MVC!";

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView create(@ModelAttribute(value = "fellow") Fellow fellow) {
		ModelAndView mv = new ModelAndView("login");
		fellowService.save(fellow);
		mv.addObject("usr", fellow);
		return mv;
	}

	@RequestMapping(value = "/me", method = RequestMethod.GET)
	public ModelAndView view() {
		String name = StringUtils.EMPTY;
		Fellow fellow = fellowService.findByName(name);
		ModelAndView mv = new ModelAndView("fellow");
		mv.addObject("fellow", fellow);
		return mv;
	}
}
