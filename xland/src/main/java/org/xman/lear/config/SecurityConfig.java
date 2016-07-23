package org.xman.lear.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		String userQuery = "select name as username, '123456' as password, '1' as enabled from x_fellow where name = ?";
		String authQuery = "select username, role from user_roles where username = ?";
		authQuery = "select name as username, 'ROLE_USER' as role from x_fellow where name = ?";
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery(userQuery).authoritiesByUsernameQuery(authQuery);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		String defaultSuccessUrl = "/usr/me";
		http.authorizeRequests().antMatchers("/usr/**")
				.access("hasRole('ROLE_USER')").and().formLogin()
				.loginPage("/login").defaultSuccessUrl(defaultSuccessUrl).failureUrl("/login?error")
				.usernameParameter("username").passwordParameter("password")
				.and().logout().logoutSuccessUrl("/login?logout").and().csrf();
	}
}
