package org.xman.xland.web.spring.mvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class)
public class FellowTests {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setUp() throws ServletException {
		if (this.wac instanceof AnnotationConfigWebApplicationContext) {
			AnnotationConfigWebApplicationContext ctx = (AnnotationConfigWebApplicationContext) wac;
			System.out.println(ctx.getClass().getName());
		} else {
			System.out.println(wac.getClass().getName());
			wac = new AnnotationConfigWebApplicationContext();
			System.out.println(wac.getClass().getName());
		}
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void getFellow() throws Exception {
		this.mockMvc.perform(get("/fellow?name=leo"));
	}
}
