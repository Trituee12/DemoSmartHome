package baithi.tuentpd01983;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import baithi.tuentpd01983.services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity 
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource data;
	
	@Autowired
	private UserDetailsServiceImpl detailsServiceImpl;
	
	@Autowired
	private SimpleAuthenticationSuccessHandler simple;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder () {
		
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	@Autowired
	public void configGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(detailsServiceImpl).passwordEncoder(passwordEncoder());
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		 
        http.authorizeRequests().antMatchers("/register","/login", "/logout" ).permitAll();
        http.authorizeRequests().antMatchers("redirect:/homepage/admin").hasRole("ADMIN");
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/login"); 
        http.authorizeRequests().and().formLogin().loginProcessingUrl("/checklogin") 
                .loginPage("/login")
                .successHandler(simple)
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .and().logout()
                .logoutUrl("/logout").logoutSuccessUrl("/login")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID").permitAll();
        http.rememberMe().key("uniqueAndSecret").tokenValiditySeconds(1296000); // 24h
        http.csrf().disable();
       
    }
	
	 @Bean
	    public PersistentTokenRepository persistentTokenRepository() {
	        JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
	        db.setDataSource(data);
	        return db;
	    }
	

}
