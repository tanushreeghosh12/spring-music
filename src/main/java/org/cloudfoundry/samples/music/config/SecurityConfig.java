package org.cloudfoundry.samples.music.config;

/**
 * Created by 721672 on 9/14/2018.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration

public class SecurityConfig extends WebSecurityConfigurerAdapter{


    @Autowired
    protected void configureUser(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("sunil").password("pass123").roles("USER")
                .and()
                .withUser("admin").password("admin123").roles("ADMIN");
    }

    // We do not want the default behavior of form authentication
    // before HTTP Basic authentication we get
    // from WebSecurityConfigurerAdapter.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().fullyAuthenticated()
                .and()
                .httpBasic();
    }

}
