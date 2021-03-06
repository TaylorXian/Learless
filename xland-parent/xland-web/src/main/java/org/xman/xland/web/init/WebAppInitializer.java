package org.xman.xland.web.init;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.xman.xland.web.config.DataConfig;
import org.xman.xland.web.config.MvcConfig;
import org.xman.xland.web.config.SecurityConfig;
import org.xman.xland.web.config.ServiceConfig;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { DataConfig.class, ServiceConfig.class, SecurityConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { MvcConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingfilter = new CharacterEncodingFilter();
		encodingfilter.setEncoding("UTF-8");
		return new Filter[] { encodingfilter, new SiteMeshFilter() };
	}
}