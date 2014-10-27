package com.ppla.security.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.baldy.commons.security.services.BaldyCommonsSecurityServicesMarker;
import com.baldy.commons.security.services.BaseBaldyUserDetailsService;

import static com.ppla.security.reference.Roles.*;

/**
 * Do not autoformat this class.
 * @author mbmartinez
 */
@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "com.ppla.security",
    basePackageClasses = BaldyCommonsSecurityServicesMarker.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private BaseBaldyUserDetailsService userDetailsService;

    @Autowired
    private Environment env;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public TextEncryptor textEncryptor() {
        return Encryptors.noOpText();
    }

    @Override
    public void configure(WebSecurity builder) throws Exception {
        builder
            .ignoring()
                .antMatchers("/css/**","/images/**","/javascript/**","/libs/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeUrls()
                .antMatchers("/manage**").hasRole(ADMIN)
                .antMatchers("/operations**").hasAnyAuthority(OPERATOR, WAREHOUSE, MIXER, EXTRUDER, PRINTER, CUTTER)
                .antMatchers("/webservices**").permitAll()
//              .antMatchers("/**").permitAll()
                .antMatchers("/**").authenticated()
                .and()
            .logout()
                .deleteCookies("JSESSIONID")
                .logoutUrl("/logout")
                .logoutSuccessUrl("/auth/login?msg=signout_success")
                .permitAll()
                .and()
            .formLogin()
                .loginPage("/auth/login")
                .loginProcessingUrl("/login/authenticate")
                .defaultSuccessUrl("/auth/redirect", true)
                .failureUrl("/auth/login?msg=bad_credentials")
                .permitAll();
//                .and()
//            .rememberMe()
//                .key(env.getProperty("remember.me.key"));
    }

    @Override
    protected void registerAuthentication(AuthenticationManagerBuilder  builder) throws Exception {
        builder.userDetailsService(userDetailsService);
    }
}