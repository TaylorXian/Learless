package org.xman.xland.web.spring;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.xman.xland.core.domain.Fellow;
import org.xman.xland.web.config.DataConfig;
import org.xman.xland.web.config.ServiceConfig;
import org.xman.xland.web.service.FellowService;

/**
 * 
 * @see <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/beans.html#beans-java">5.12 Java-based container configuration</a>
 * @author xiandeb
 *
 */
public class SpringTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataConfig.class, ServiceConfig.class);
		FellowService service = context.getBean(FellowService.class);
		Fellow fellow = new Fellow();
		fellow.setName("spring");
		fellow.setEmail("spring@spring.com");
		service.save(fellow);
		List<Fellow> fs = service.findAll();
		for (Fellow f : fs) {
			System.out.println(String.format("name=%s email=%s", f.getName(), f.getEmail()));
		}
	}
}
