package com.muhammedtopgul.petclinic.security;

/*
 * created by Muhammed Topgul
 * on 10/04/2021
 * at 23:35
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**/favicon.ico", "/css/**", "/js/**", "/images/**", "/webjars/**", "/mvc/login.html")
                .permitAll();

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
}
