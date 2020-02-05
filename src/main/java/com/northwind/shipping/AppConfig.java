package com.northwind.shipping;

import com.northwind.shipping.repository.RepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableWebMvc
@ComponentScan(basePackages = "com/northwind/shipping")
public class AppConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

    private Environment env;

    public AppConfig(Environment env) {
        this.env = env;
    }


    @Bean
    public DataSource datasource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/shipping-db");
        dataSource.setUsername("root");
        dataSource.setPassword("password");

        return dataSource;
    }



    @Bean
    public RepositoryImpl repository(DataSource dataSource, SqlStatements sqlStatements){
        return new RepositoryImpl(dataSource,sqlStatements);
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("efudd")
                .password(passwordEncoder().encode("password")).roles("USER")
                .and()
                .withUser("hsimpson")
                .password(passwordEncoder().encode("password")).roles("USER", "ADMIN");

    }
    // Secure the endpoins with HTTP Basic authentication
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                //HTTP Basic authentication
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/**/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/test/getbyId/**").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



}
