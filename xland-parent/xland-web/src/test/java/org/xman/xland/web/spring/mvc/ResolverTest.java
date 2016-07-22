package org.xman.xland.web.spring.mvc;

import org.springframework.util.ClassUtils;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class ResolverTest {

	public static void main(String[] args) {
		System.out.println(ClassUtils.isPresent(
				"javax.servlet.jsp.jstl.core.Config",
				InternalResourceViewResolver.class.getClassLoader()));
	}
}
