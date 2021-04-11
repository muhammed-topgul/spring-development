package com.muhammedtopgul.petclinic.security;

/*
 * created by Muhammed Topgul
 * on 10/04/2021
 * at 23:35
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.sql.DataSource;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**/favicon.ico", "/css/**", "/js/**", "/images/**", "/webjars/**", "/mvc/login.html")
                .permitAll();

        http.authorizeRequests().antMatchers("/api/**").access("hasRole('EDITOR')");
        http.authorizeRequests().antMatchers("/actuator/**").access("hasRole('ADMIN')");

        http.authorizeRequests()
                .anyRequest()
                .authenticated();

        http.formLogin()
                .loginPage("/mvc/login.html")
                .loginProcessingUrl("/login")
                .failureUrl("/mvc/login.html?loginFailed=true");

        http.rememberMe()
                .userDetailsService(userDetailsService);

        // basic auth artik devrede
        http.httpBasic();
    }

    // username ve password bilgilerinin veritabanindan alinmasini saglar
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
    }
}
