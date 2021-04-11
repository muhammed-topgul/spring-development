package com.muhammedtopgul.petclinic.security;

/*
 * created by Muhammed Topgul
 * on 11/04/2021
 * at 19:39
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@Order(value = 1)
public class RestSecurityConfiguration extends AbstractSecurityConfiguration {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/api/**"); // sadece api ile baslayan isteklerde devreye gir demek
        http.authorizeRequests().antMatchers("/api/**").access("hasRole('EDITOR')");
        http.csrf().disable();
        // basic auth devrede
        http.httpBasic();
    }
}
