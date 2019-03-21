package com.security.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.security.repository.UsersRepository;

@EnableGlobalMethodSecurity(prePostEnabled=true) // allows us to define global role checks
@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses=UsersRepository.class)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	
	// look at other methods that can be overridden
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable(); // disable cross side reference
		
		// WORKING as standalone without view resolver:
		http.authorizeRequests()
		.antMatchers("**/admin/**").authenticated()
		.anyRequest().permitAll()
		.and().formLogin().permitAll();
		
		// .and().formLogin().loginPage("/login").permitAll();   ==> add default login page with spring MVC   
	}
		
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// look at auth.inMemoryAuthentication()
		
		auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());
	}


	private PasswordEncoder getPasswordEncoder() {
		return new PasswordEncoder() {
			
			@Override
			public String encode(CharSequence charSequence) {
				return charSequence.toString();
			}
			
			@Override
			public boolean matches(CharSequence charSequence, String s) {
				return true;
			}
		};
	}
	
}
