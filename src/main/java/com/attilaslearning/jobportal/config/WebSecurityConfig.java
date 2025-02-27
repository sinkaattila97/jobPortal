package com.attilaslearning.jobportal.config;

import com.attilaslearning.jobportal.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    private final CustomUserDetailsService customUserDetailService;
    private final CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    private final String[] publicUrl = {"/",
            "/global-search/**",
            "/register",
            "/register/**",
            "/webjars/**",
            "/resources/**",
            "/assets/**",
            "/css/**",
            "/summernote/**",
            "/js/**",
            "/*.css",
            "/*.js",
            "/*.js.map",
            "/fonts**", "/favicon.ico", "/resources/**", "/error"};

    @Autowired
    public WebSecurityConfig(CustomUserDetailsService userDetailService, CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler) {
        this.customUserDetailService = userDetailService;
        this.customAuthenticationSuccessHandler = customAuthenticationSuccessHandler;
    }

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> {        //a list of public URLs which does not require for the user to login
            auth.requestMatchers(publicUrl).permitAll();                          //so anyone can have access to these URLs without logging in
            auth.anyRequest().authenticated();                                    //all other URLs require the user to be logged in

        });

        http.authenticationProvider(authenticationProvider());

        http.formLogin(form -> form.loginPage("/login").permitAll() //we are telling Spring to use our custom login page
                .successHandler(customAuthenticationSuccessHandler)) //we are telling Spring to use our custom login page
                .logout( logout -> {
                        logout.logoutUrl("/logout");
                        logout.logoutSuccessUrl("/");
                        logout.invalidateHttpSession(true);
                        logout.deleteCookies("JSESSIONID");}).
                cors(Customizer.withDefaults()).csrf(csrf -> csrf.disable());




        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() { //we use this to tell Spring how to find the users and how to authenticate passwords
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(customUserDetailService); //how we get the users

        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() { //this tells Spring how we want to encode our passwords
        return new BCryptPasswordEncoder();

    }
}
