package com.example.dplanner.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.example.dplanner.domain.services.UserDetailsServiceImpl;

//ESTA CLASSE DE SEGURANÇA É TEMPORARIA
//ESTA CLASSE DE SEGURANÇA É TEMPORARIA
//ESTA CLASSE DE SEGURANÇA É TEMPORARIA
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // @Autowired
    // private Environment env;

    // @Override
    // protected void configure(HttpSecurity http) throws Exception {
    // if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
    // http.headers().frameOptions().disable();
    // }

    // http.cors().and().csrf().disable();
    // http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    // http.authorizeRequests().anyRequest().permitAll();
    // }

    // @Bean
    // CorsConfigurationSource corsConfigurationSource() {
    // CorsConfiguration configuration = new
    // CorsConfiguration().applyPermitDefaultValues();
    // configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE",
    // "OPTIONS"));
    // final UrlBasedCorsConfigurationSource source = new
    // UrlBasedCorsConfigurationSource();
    // source.registerCorsConfiguration("/**", configuration);
    // return source;
    // }

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());

    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().and().authorizeHttpRequests()
                .antMatchers(HttpMethod.POST, "/login", "/user/new").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(new LoginFilter("/login", authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new AuthenticationFilter(),
                        UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.addExposedHeader("*");
        configuration.setAllowCredentials(true);
        configuration.applyPermitDefaultValues();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}