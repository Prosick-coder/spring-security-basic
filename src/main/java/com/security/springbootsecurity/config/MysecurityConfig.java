package com.security.springbootsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MysecurityConfig  {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()

            // This is not a smart way of giving pattern 
            // .requestMatchers("/home", "/login", "/register")

            // Below is the smart way 

             .requestMatchers("/public/**") /*All urls starting with "/public"*/
            .permitAll()

            // the above two line is used to make "/home" url with out password protection 
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic();
        return http.build();
    }
   
    @Bean
    public UserDetailsService uDS(){
        UserDetails user = User.builder()
        .username("Rohit")
        .password("{bcrypt}$2a$12$MQnwhvwj67DIgGwRaKW20ezxD9CfHaUTGGcOYYRHtqlb.zBQPhAXS")
        // .password("1234")
        .roles("User")
        .build();

        UserDetails admin = User.builder()
        .username("admin")
        .password("{bcrypt}$2a$12$n/Fu05uADZkewJqvyhcDYOyShcsfOvXGPFH7IXcJhyFzwC5l79ffO")
        .roles("User", "admin")
        .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    // If donot want to encrypt password use following step 
   
    // @Bean
    // public PasswordEncoder passwordEncoder(){
    //     return NoOpPasswordEncoder.getInstance();
    // }

}
