package com.teko.commercial.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.teko.commercial.repositories.UserRepository;

@EnableWebSecurity
@Configuration
@EnableJpaRepositories(basePackageClasses = {UserRepository.class})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

}
