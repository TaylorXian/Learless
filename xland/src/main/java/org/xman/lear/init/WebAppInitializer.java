package org.xman.lear.init;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.xman.lear.config.DataConfig;
import org.xman.lear.config.MvcConfig;
import org.xman.lear.config.SecurityConfig;
import org.xman.lear.config.ServiceConfig;

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