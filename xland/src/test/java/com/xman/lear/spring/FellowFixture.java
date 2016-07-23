package com.xman.lear.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.xman.lear.config.DataConfig;
import org.xman.lear.config.ServiceConfig;
import org.xman.lear.domain.Fellow;
import org.xman.lear.service.FellowService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DataConfig.class, ServiceConfig.class })
public class FellowFixture {

	@Autowired
	private FellowService fellowService;

	@Test
	public void getFellow() {
		Fellow f = fellowService.findByName("debxian");
		System.out.println(f.getName());
	}
}