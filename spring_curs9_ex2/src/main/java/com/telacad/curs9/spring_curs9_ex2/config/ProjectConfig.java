package com.telacad.curs9.spring_curs9_ex2.config;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;



@Configuration
public class ProjectConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectConfig.class);
    @Bean
    public UserDetailsService userDetailsService(){

        var inMemoryUserDetailsManager= new InMemoryUserDetailsManager();

        final UserDetails u1= User.withUsername("Gica").password(bCryptPasswordEncoder().encode("password1")).roles("Analyst").authorities("read").build();

        final UserDetails u2=User.withUsername("Dora")
                .password(bCryptPasswordEncoder().encode("password2"))
                .roles("Admin")
                .authorities("write")
                .build();


        inMemoryUserDetailsManager.createUser(u1);
        inMemoryUserDetailsManager.createUser(u2);

        LOGGER.info( u1 + "Pass " + u1.getPassword()) ;
        LOGGER.info( u2 + "Pass " + u2.getPassword()) ;


        return inMemoryUserDetailsManager;
    }

    @Bean
    public PasswordEncoder bCryptPasswordEncoder(){

        return  new BCryptPasswordEncoder();


    }



}
