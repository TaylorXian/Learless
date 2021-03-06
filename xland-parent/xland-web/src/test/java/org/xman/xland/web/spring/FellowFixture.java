package org.xman.xland.web.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.xman.xland.core.domain.Fellow;
import org.xman.xland.web.config.DataConfig;
import org.xman.xland.web.config.ServiceConfig;
import org.xman.xland.web.service.FellowService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DataConfig.class, ServiceConfig.class })
public class FellowFixture {

	@Autowired
	private FellowService fellowService;

	@Test
	public void getFellow() {
		Fellow f = fellowService.findByName("leo");
		System.out.println(f.getName());
	}
}